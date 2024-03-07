package com.examplepointofsale.possystem.controller;

import com.examplepointofsale.possystem.dto.CustomerDTO;
import com.examplepointofsale.possystem.dto.request.CustomerUpdateDTO;
import com.examplepointofsale.possystem.service.CustomerService;
import com.examplepointofsale.possystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    //using @RequestBody annotation you can convert Json data to DTO
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.saveCustomer(customerDTO);
        String name = customerDTO.getCustomerName();
        return name;
    }

    @PutMapping("/update")
    public String Update(@RequestBody CustomerUpdateDTO customerUpdateDTO){

        //customerService.updateCustomer(customerUpdateDTO);
        String name = customerService.updateCustomer(customerUpdateDTO);;
        return name;
    }

    @GetMapping(path = "/select",params = "id")
    public CustomerDTO Select(int id){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO = customerService.getCustomerDetails(id);
        //String name = customerDTO.getCustomerName();
        return customerDTO;
    }

//    @GetMapping("/get-all-customers")
//    public List <CustomerDTO> getAllCustomers(){
//
//        List<CustomerDTO> customerDTO = customerService.getAllCustomers();
//
//        return customerDTO ;
//    }

    @GetMapping("/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers(){

        List<CustomerDTO> customerDTO = customerService.getAllCustomers();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",customerDTO),
                HttpStatus.OK);
    }


    @DeleteMapping(path="/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id ) {

        String deleted = customerService.deleteCustomer(id);
        return deleted;
    }

    @GetMapping(path="/get-all-customers-by-statues/{status}")
    public List <CustomerDTO> getAllCustomersActiveCustomers(boolean status){

        List<CustomerDTO> customerDTO = customerService.getCustomersByStatues(status);

        return customerDTO ;
    }





}
