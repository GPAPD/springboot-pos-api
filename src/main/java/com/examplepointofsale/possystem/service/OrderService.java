package com.examplepointofsale.possystem.service;

import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseOrderDetailsDTO;
import com.examplepointofsale.possystem.dto.request.RequestOrderSaveDTO;

public interface OrderService {

    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    public PaginatedResponseOrderDetailsDTO getAllOrdersByPageAndSize(int page, int size);
}
