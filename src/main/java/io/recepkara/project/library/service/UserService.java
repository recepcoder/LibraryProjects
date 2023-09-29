package io.recepkara.project.library.service;

import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.repo.user.SystemUser;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    Optional<SystemUser> getByUserNameAndPassword(String username,String password);
    void createUser(SystemUser user);

    void deleteUserById(Integer id);
    List<Customer> searchUsers(String searchTerm);

    public  Optional<Customer> getById(Integer integer);

    void updateUser(Customer updatedCustomer);
}
