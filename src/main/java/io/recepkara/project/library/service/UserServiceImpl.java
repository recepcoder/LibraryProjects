package io.recepkara.project.library.service;

import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.repo.user.SystemUser;
import io.recepkara.project.library.repo.user.UserRepository;
import io.recepkara.project.library.system.SystemContext;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private  final MailService mailService;

    @Override
    public Optional<SystemUser> getByUserNameAndPassword(String username, String password) {
        return  userRepository.getByUserNameAndPassword(username,password);
    }

    @Override
    public void createUser(SystemUser user) {
        if (SystemContext.isLoggedInUserAdmin()){
            userRepository.createUser(user);
        }else {
            throw new RuntimeException("Only admin roles can create a user");
        }

    }

    @Override
    public void deleteUserById(Integer id) {
        if (SystemContext.isLoggedInUserAdmin())
        {
            userRepository.deleteUser(id);
        }else
        {
            throw new RuntimeException("Only admin roles can delete a user");
        }

    }

    @Override
    public List<Customer> searchUsers(String searchTerm) {
        if (SystemContext.isLoggedInUserAdmin()){
            return
                    userRepository.searchUsers(searchTerm).stream()
                            .filter(u->u instanceof Customer)
                            .map(u->(Customer)u)
                            .toList();
        }else {
            throw new RuntimeException("Only admin roles can create a user");
        }

    }

    @Override
    public Optional<Customer> getById(Integer userId) {
        return userRepository.getById(userId)
                .map(systemUser->(Customer) systemUser);
    }

    @Override
    public void updateUser(Customer updatedCustomer) {
    userRepository.updateUser(updatedCustomer);
    mailService.sendUserUpdatedMail(updatedCustomer);

    }
}

