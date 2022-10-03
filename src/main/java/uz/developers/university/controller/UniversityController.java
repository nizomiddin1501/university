package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.model.University;
import uz.developers.university.payload.UniversityDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<University> getUniversities(){
        List<University> universityList = universityRepository.findAll();
        return universityList;
    }

    @PostMapping
    public String addUniversity(@RequestBody UniversityDto universityDto){
        boolean existsByName = universityRepository.existsByName(universityDto.getName());
        if (existsByName){
            return "This university is allready exist";
        }
        Address address = new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        University university = new University();
        university.setName(universityDto.getName());
        university.setAddress(savedAddress);
        universityRepository.save(university);
        return "University added";
    }

    @PutMapping("/{id}")
    public String editUniversity(@PathVariable  Integer id, @RequestBody UniversityDto universityDto){
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();

            Address address = university.getAddress();
            address.setCity(universityDto.getCity());
            address.setDistrict(universityDto.getDistrict());
            address.setStreet(universityDto.getStreet());
            Address savedAddress = addressRepository.save(address);

            university.setName(universityDto.getName());
            university.setAddress(savedAddress);
            universityRepository.save(university);
            return "University is edited";
        }
        return "University is not found";
    }

    @DeleteMapping("/{id}")
    public String deleteUniversity(@PathVariable Integer id){
        universityRepository.deleteById(id);
        return "University is deleted";
    }


}
