package com.examplepointofsale.possystem.controller;

import com.examplepointofsale.possystem.dto.CustomerDTO;
import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseItemDTO;
import com.examplepointofsale.possystem.dto.request.ItemSaveRequestDTO;
import com.examplepointofsale.possystem.dto.response.ItemGetDTO;
import com.examplepointofsale.possystem.service.ItemService;
import com.examplepointofsale.possystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping("/save")
    //using @RequestBody annotation you can convert Json data to DTO
    public String saveCustomer(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){

        String name = itemService.saveItem(itemSaveRequestDTO);
        return name;
    }

    @GetMapping(path="/get-Item-by-name/{name}")
    public List<ItemGetDTO> getItemsByNameAndStatus(@RequestParam (value = "name") String ItemName){

        List<ItemGetDTO> ItemGetDTO = itemService.getItemByNameAndStatus(ItemName);

        return ItemGetDTO ;
    }

    @GetMapping(path="/get-Item-by-name-using-mapstruct/{name}")
    public List<ItemGetDTO> getItemsByNameAndStatusUsingMapstruct(@RequestParam (value = "name") String ItemName){

        List<ItemGetDTO> ItemGetDTO = itemService.getItemByNameAndStatusUsingMapstruct(ItemName);

        return ItemGetDTO ;
    }


    @GetMapping(
            path="/get-all-items-by-statues",
            params = {"activeStatues","page","size"}
    )
    public ResponseEntity<StandardResponse> getAllItemsByActiveStatues(
            @RequestParam (value = "activeStatues") boolean activeStatues,
            @RequestParam (value = "page") int page,
            @RequestParam (value = "size") int size
    ){

        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByStatusAndPageAndSize(activeStatues,page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",paginatedResponseItemDTO),
                HttpStatus.OK);
    }

}
