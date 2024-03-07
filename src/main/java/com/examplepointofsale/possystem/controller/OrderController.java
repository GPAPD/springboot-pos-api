package com.examplepointofsale.possystem.controller;

import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseItemDTO;
import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseOrderDetailsDTO;
import com.examplepointofsale.possystem.dto.request.RequestOrderSaveDTO;
import com.examplepointofsale.possystem.service.OrderService;
import com.examplepointofsale.possystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> addOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){

        String Id = orderService.addOrder(requestOrderSaveDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,Id +"Success",Id),
                HttpStatus.CREATED);
    }


    @GetMapping(
            path="/get-order-details",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam (value = "page") int page,
            @RequestParam (value = "size") @Max(50)int size
    ){

        PaginatedResponseOrderDetailsDTO paginatedResponseOrderDetailsDTO = orderService.getAllOrdersByPageAndSize(page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseOrderDetailsDTO),
                HttpStatus.OK);
    }

}
