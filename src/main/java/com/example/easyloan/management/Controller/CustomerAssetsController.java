package com.example.easyloan.management.Controller;


import com.example.easyloan.management.Model.CustomerAssets;
import com.example.easyloan.management.Model.LoanApplication;
import com.example.easyloan.management.Service.CustomerAssetsService;
import com.example.easyloan.management.Service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customerassets")
public class CustomerAssetsController {

    private CustomerAssetsService customerAssetsService;

    @Autowired
    public CustomerAssetsController(CustomerAssetsService customerAssetsService){
        this.customerAssetsService = customerAssetsService;
    }


    @RequestMapping("/add")
    public CustomerAssets addCustomerAssets(@RequestBody CustomerAssets customerAssets) throws Exception {
        return customerAssetsService.addCustomerAssets(customerAssets);
    }

    @RequestMapping("/list/{id}")
    public Optional<CustomerAssets> findById(@PathVariable Integer id){
        return customerAssetsService.findById(id);
    }

    @RequestMapping("/list")
    public List<CustomerAssets> customerAssetsList(){
        return customerAssetsService.customerAssetsList();

    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomerAssets(@PathVariable Integer id) {
        return customerAssetsService.deleteCustomerAssets(id);
    }
}