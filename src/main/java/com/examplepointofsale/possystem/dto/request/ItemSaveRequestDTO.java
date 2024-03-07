package com.examplepointofsale.possystem.dto.request;
import com.examplepointofsale.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQTY;

    private double supplierPrice;

    private double sellingPrice;

}
