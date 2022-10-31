package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.Address;
import uz.developers.university.model.University;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.UniversityDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.UniversityRepository;
import uz.developers.university.service.UniversityService;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversity(Integer id) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isPresent()) {
            return optionalUniversity.get();
        }
        return null;
    }

    @Override
    public Result addUniversity(UniversityDto universityDto) {
        boolean existsByName = universityRepository.existsByName(universityDto.getName());
        if (existsByName){
            return new Result("This university is allready exist",false);
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
        return new Result("University added",true);
    }

    @Override
    public Result editUniversity(Integer id, UniversityDto universityDto) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isEmpty()) {
            return new Result("University is not found",false);
        }
        University university = optionalUniversity.get();
        Address address = university.getAddress();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        university.setName(universityDto.getName());
        university.setAddress(savedAddress);
        universityRepository.save(university);
        return new Result("University is not found",true);
    }

    @Override
    public Result deleteUniversity(Integer id) {
        universityRepository.deleteById(id);
        return new Result("University is deleted",true);
    }
}
