package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.developers.university.model.Address;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        return null;
    }

    @Override
    public Result addAddress(Address address) {
        addressRepository.save(address);
        return new Result("New address is saved",true);
    }


    @Override
    public Result editAddress(Integer id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            return new Result("Such address is not found",false);
        }
        Address address1 = optionalAddress.get();
        address1.setCity(address.getCity());
        address1.setDistrict(address.getDistrict());
        address1.setStreet(address.getStreet());
        addressRepository.save(address1);
        return new Result("Address is edited",true);
    }

    @Override
    public Result deleteAddress(Integer id) {
        return null;
    }
}
