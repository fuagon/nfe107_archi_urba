package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.DeleteUserRequest;
import net.cnam.nfe107.controller.dto.SignUpRequest;
import net.cnam.nfe107.domain.CustomerService;
import net.cnam.nfe107.domain.UserService;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    //Inscrire un nouvel utilisateur
    @RequestMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest)
    {
        CustomerToCreate customerToCreate = new CustomerToCreate(signUpRequest);
        AddressToCreate addressToCreate = new AddressToCreate(signUpRequest);

        userService.signUpUser(customerToCreate, addressToCreate);

        return ResponseEntity.status(200).build();
    }

    //Supprimer un utilisateur
    @RequestMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserRequest deleteUserRequest)
    {
        Customer customer = customerService.getById(deleteUserRequest.getIdCustomer());
        userService.deleteUser(customer);

        return ResponseEntity.status(200).build();
    }
}