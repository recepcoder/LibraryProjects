package io.recepkara.project.library.repo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Customer extends SystemUser{


    private  final  String firstName;
    private  final  String lastName;
    private  final  String address;
    private  final  String postcode;
    private  final  String city;
    private  final  String email;

    public Customer(Integer id, String userName, String password, String firstName, String lastName, String address, String postcode, String city, String email) {
        super(id, userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
    }
}
