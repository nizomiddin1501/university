package uz.developers.university.service;

import uz.developers.university.model.Address;
import uz.developers.university.payload.Result;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();

    Address getAddress(Integer id);

    Result addAddress(Address address);

    Result editAddress(Integer id, Address address);

    Result deleteAddress(Integer id);
}
