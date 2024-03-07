package com.examplepointofsale.possystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor //lombok
@AllArgsConstructor
@Data

public class ResponseOrderDetailsDTO {

    private String customerName;

    private String customerAddress;

    private ArrayList customerNumber;

    private Date date;

    private double total;

}
