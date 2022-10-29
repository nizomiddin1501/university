package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.Address;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAddresses() {
        return null;
    }

    @Override
    public Address getAddress(Integer id) {
        return null;
    }

    @Override
    public Result addAddress(Address address) {
        return null;
    }

    @Override
    public Result editAddress(Integer id, Address address) {
        return null;
    }

    @Override
    public Result deleteAddress(Integer id) {
        return null;
    }
}
