package com.examplepointofsale.possystem.dto.customquarydata;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {

    String getCustomerName();

    String getCustomerAddress();

    ArrayList getCustomerNumber();

    Date getDate();

    double getTotal();

}
