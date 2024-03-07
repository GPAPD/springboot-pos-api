package com.examplepointofsale.possystem.service.impl;

import com.examplepointofsale.possystem.dto.customquarydata.OrderDetailInterface;
import com.examplepointofsale.possystem.dto.pagineted.PaginatedResponseOrderDetailsDTO;
import com.examplepointofsale.possystem.dto.request.RequestOrderSaveDTO;
import com.examplepointofsale.possystem.dto.response.ResponseOrderDetailsDTO;
import com.examplepointofsale.possystem.entity.Customer;
import com.examplepointofsale.possystem.entity.OrderDetails;
import com.examplepointofsale.possystem.entity.Orders;
import com.examplepointofsale.possystem.exception.NotFoundException;
import com.examplepointofsale.possystem.repo.CustomerRepo;
import com.examplepointofsale.possystem.repo.ItemRepo;
import com.examplepointofsale.possystem.repo.OrderDetailsRepo;
import com.examplepointofsale.possystem.repo.OrderRepo;
import com.examplepointofsale.possystem.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders = new Orders();

        try {
            Customer customer = customerRepo.getById(requestOrderSaveDTO.getCustomer());

            orders.setCustomer(customer);
            orders.setDate(requestOrderSaveDTO.getDate());
            orders.setTotal(requestOrderSaveDTO.getTotal());

            orderRepo.save(orders);
            if (orderRepo.existsById(orders.getOrderId())) {

//            List<OrderDetails>  model = modelMapper.map(requestOrderSaveDTO.getOrderDetails(),
//                    new TypeToken<List<OrderDetails>>(){}
//                    .getType());

                List<OrderDetails> model = new ArrayList<>();
                for (int i = 0; i < requestOrderSaveDTO.getOrderDetails().size(); i++) {

                    OrderDetails orderDetails = new OrderDetails();

                    orderDetails.setOrders(orders);
                    orderDetails.setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
                    orderDetails.setAmount(requestOrderSaveDTO.getOrderDetails().get(i).getAmount());
                    orderDetails.setQty(requestOrderSaveDTO.getOrderDetails().get(i).getQty());

                    model.add(orderDetails);
                }

                if (model.size() > 0) {
                    orderDetailsRepo.saveAll(model);
                }
                else{
                    throw new NotFoundException("details are empty");
                }
                return "saved";
            }
        } catch (Exception e) {
            // Log the exception for debugging and re-throw it to trigger a rollback
            System.out.println("Error while adding order: " + e);
            throw e;
        }


        return null;
    }

    @Override
    public PaginatedResponseOrderDetailsDTO getAllOrdersByPageAndSize(int page, int size) {

        List<OrderDetailInterface> orderDetails = orderRepo.getAllOrderDetails(PageRequest.of(page, size));

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();

        for(OrderDetailInterface obj : orderDetails ){
            ResponseOrderDetailsDTO model = new ResponseOrderDetailsDTO(
                    obj.getCustomerName(),
                    obj.getCustomerAddress(),
                    obj.getCustomerNumber(),
                    obj.getDate(),
                    obj.getTotal()
            );
            list.add(model);

        }

        PaginatedResponseOrderDetailsDTO paginatedList = new PaginatedResponseOrderDetailsDTO(list,orderRepo.count());

        return paginatedList;
    }
}
