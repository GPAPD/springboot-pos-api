package com.examplepointofsale.possystem.dto.request;

import com.examplepointofsale.possystem.entity.Customer;
import com.examplepointofsale.possystem.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer;

    private Date date;

    private double total;

    private List<RequestOrderDetailsSave> orderDetails;
}
