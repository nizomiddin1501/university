package uz.developers.university.payload;

import lombok.Data;

@Data
public class StudentDto {


    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Integer addressId;

    private Integer groupId;
}
