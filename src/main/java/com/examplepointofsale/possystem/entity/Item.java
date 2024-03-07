package com.examplepointofsale.possystem.entity;

import com.examplepointofsale.possystem.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity//hibernate
@Table(name = "Item")

@NoArgsConstructor //lombok
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data

public class Item {
    @Id
    @Column(name = "Item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "Item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQTY;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ")
    private  boolean activeState;


}
