package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.payload.Result;
import uz.developers.university.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }
    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Integer id){
        return addressService.getAddress(id);
    }

    @PostMapping
    public Result addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("/{id}")
    public Result editAddress(@PathVariable Integer id, @RequestBody Address address){
        return addressService.editAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public Result deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }





}
