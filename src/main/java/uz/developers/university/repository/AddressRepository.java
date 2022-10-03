package uz.developers.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.university.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {



}
