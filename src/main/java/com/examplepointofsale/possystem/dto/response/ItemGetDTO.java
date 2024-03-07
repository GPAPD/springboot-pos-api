package com.examplepointofsale.possystem.dto.response;

import com.examplepointofsale.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //lombok
@AllArgsConstructor
@Data
public class ItemGetDTO {

        private int itemId;

        private String itemName;

        private double balanceQTY;

        private double supplierPrice;

        private double sellingPrice;

        private  boolean activeState;
}
