package com.examplepointofsale.possystem.service.impl;


import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseItemDTO;
import com.examplepointofsale.possystem.dto.request.ItemSaveRequestDTO;
import com.examplepointofsale.possystem.dto.response.ItemGetDTO;
import com.examplepointofsale.possystem.entity.Item;
import com.examplepointofsale.possystem.exception.NotFoundException;
import com.examplepointofsale.possystem.repo.ItemRepo;
import com.examplepointofsale.possystem.service.ItemService;
import com.examplepointofsale.possystem.utill.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
        itemRepo.save(item);
        return item.getItemId()+" Saved";

        }
        else{
            throw new NotFoundException("All ready have this item");
        }
    }

    @Override
    // Exception handling
    public List<ItemGetDTO> getItemByNameAndStatus(String itemName) {
        boolean ActiveStates = true;
        List<Item> items = itemRepo.getAllByItemNameEqualsAndActiveStateEquals(itemName,ActiveStates);

        if(items.size()>0){
            List<ItemGetDTO>  itemGetDTO = modelMapper.map(items,new TypeToken<List<ItemGetDTO>>(){}.getType());
            return itemGetDTO;
        }
        else{
            throw new NotFoundException("No Item Found");
        }

    }

    @Override
    public List<ItemGetDTO> getItemByNameAndStatusUsingMapstruct(String itemName) {
        boolean ActiveStates = true;
        List<Item> items = itemRepo.getAllByItemNameEqualsAndActiveStateEquals(itemName,ActiveStates);

        if(items.size()>0){
            List<ItemGetDTO>  itemGetDTO = itemMapper.entityListToDtoList(items);
            return itemGetDTO;
        }
        else{throw new NotFoundException("item is not active");}
    }

    @Override
    public PaginatedResponseItemDTO getItemByStatusAndPageAndSize(boolean activeStatues, int page, int size) {

        Page<Item> items = itemRepo.getAllByActiveStateEquals(activeStatues, PageRequest.of(page, size));
        int count = itemRepo.countAllByActiveStateEquals(activeStatues, PageRequest.of(page, size));

        if(items.getSize()<1){
           throw new NotFoundException("No Data Found");
        }
        return new PaginatedResponseItemDTO(itemMapper.listDTOToPage(items),count);
    }


}
