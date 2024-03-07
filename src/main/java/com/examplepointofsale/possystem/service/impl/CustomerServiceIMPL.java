package com.examplepointofsale.possystem.service.impl;

import com.examplepointofsale.possystem.dto.CustomerDTO;
import com.examplepointofsale.possystem.dto.request.CustomerUpdateDTO;
import com.examplepointofsale.possystem.entity.Customer;
import com.examplepointofsale.possystem.repo.CustomerRepo;
import com.examplepointofsale.possystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customerEntity = new Customer();

        customerEntity.setCustomerId(customerDTO.getCustomerId());
        customerEntity.setCustomerName(customerDTO.getCustomerName());
        customerEntity.setCustomerAddress(customerDTO.getCustomerAddress());
        customerEntity.setCustomerSalary(customerDTO.getCustomerSalary());
        customerEntity.setCustomerNumber(customerDTO.getCustomerNumber());
        customerEntity.setNic(customerDTO.getNic());
        customerEntity.setActive(customerDTO.getActive());

        customerRepo.save(customerEntity);

        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "updated Successful";

        }else{ throw new RuntimeException("data not found");}


    }

    @Override
    public CustomerDTO getCustomerDetails(int id) {

        if(customerRepo.existsById(id)){

            Customer customer = customerRepo.getReferenceById(id);

            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerSalary(),customer.getCustomerNumber(),customer.getNic(),customer.isActive());
            return customerDTO;
        }
        else{throw new RuntimeException("data not found");}


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return addCustomersToList(customers);
    }

    @Override
    public String deleteCustomer(int id) {

        if(customerRepo.existsById(id)){
           customerRepo.deleteById(id);
            return "Deleted successfully " +id;
        }else{throw new RuntimeException("data not found");}

    }

    @Override
    public List<CustomerDTO> getCustomersByStatues(boolean status) {
        List<Customer> customers = customerRepo.findAllByActiveEquals(status);
        return addCustomersToList(customers);
    }



    public List<CustomerDTO> addCustomersToList(List<Customer> customers)
    {
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customersList: customers){
            CustomerDTO s = new CustomerDTO(
                    customersList.getCustomerId(),
                    customersList.getCustomerName(),
                    customersList.getCustomerAddress(),
                    customersList.getCustomerSalary(),
                    customersList.getCustomerNumber(),
                    customersList.getNic(),
                    customersList.isActive()
            );

            customerDTOList.add(s);

        }

        return customerDTOList;
    }

}
