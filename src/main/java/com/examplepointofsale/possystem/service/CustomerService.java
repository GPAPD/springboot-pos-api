package com.examplepointofsale.possystem.service;

import com.examplepointofsale.possystem.dto.CustomerDTO;
import com.examplepointofsale.possystem.dto.request.CustomerUpdateDTO;

import java.util.List;

// The reason why we create this interface is to loosely coupled.
public interface CustomerService {

    public String saveCustomer (CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerDetails(int id);

    public List<CustomerDTO> getAllCustomers();

    public String deleteCustomer(int id);

    public List<CustomerDTO> getCustomersByStatues(boolean status);
}
