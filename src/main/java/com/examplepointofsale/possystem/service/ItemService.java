package com.examplepointofsale.possystem.service;

import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseItemDTO;
import com.examplepointofsale.possystem.dto.request.ItemSaveRequestDTO;
import com.examplepointofsale.possystem.dto.response.ItemGetDTO;

import java.util.List;

public interface ItemService {

    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    public List<ItemGetDTO> getItemByNameAndStatus(String itemName);

    public List<ItemGetDTO> getItemByNameAndStatusUsingMapstruct(String itemName);

    public PaginatedResponseItemDTO getItemByStatusAndPageAndSize(boolean activeStatues, int page, int size);
}
