package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @PostMapping
    public String addAddress(@RequestBody Address address){
      addressRepository.save(address);
      return "Address is added";
    }

    @PutMapping("/{id}")
    public String editAddress(@PathVariable  Integer id, @RequestBody Address address){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            return "Such address is not found";
        }
        Address address1 = optionalAddress.get();
        address1.setCity(address.getCity());
        address1.setDistrict(address.getDistrict());
        address1.setStreet(address.getStreet());
        addressRepository.save(address1);
        return "Address is edited";
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Integer id){
        addressRepository.deleteById(id);
        return "Address is deleted";
    }
}
