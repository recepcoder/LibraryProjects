package io.recepkara.project.library.repo.user;

import java.security.PublicKey;
import java.util.*;

public class UserRepository
{
    private final Map<Integer,SystemUser> users= new HashMap<>();

    public  void createUser(SystemUser user)
    {
    Integer maxId=users.keySet().stream().max(Comparator.naturalOrder()).orElse(0);
    Integer newId=maxId+1;
    SystemUser newUser= switch (user)
    {
        case AdminUser adminUser-> new AdminUser(newId, adminUser.getUserName(), adminUser.getPassword());
        case Customer customer->new Customer(newId,
                customer.getUserName(),
                customer.getPassword(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress(),
                customer.getPostcode(),
                customer.getCity(),
                customer.getEmail()
                 );
        default -> throw new RuntimeException("Only Customer and Admin users may be created");
    };
    users.put(newId,newUser);

    }

    public void deleteUser(Integer id){
    users.remove(id);
    }
    public Optional<SystemUser> getById(Integer userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public Optional<SystemUser> getByUserNameAndPassword(String username, String password) {
        return users.values()
                .stream()
                .filter(u->u.getUserName().equals(username)&&u.getPassword().equals(password))
                .findFirst();

    }
    public List<SystemUser> searchUsers(String searchTerm)
    {
        return  users.values().stream()
                .filter(u->searchUser(u,searchTerm))
                .toList();
    }

    private boolean searchUser(SystemUser user, String searchTerm) {
        boolean found=findIn(searchTerm,user.getId().toString(),user.getUserName());
        if (user instanceof  Customer customer)
        {
            return  found || findIn(searchTerm,
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getPostcode(),
                    customer.getEmail(),
                    customer.getFirstName(),
                    customer.getLastName());
        }
        else
        {
            return  false;
        }
    }
    private boolean findIn(String searchTerm,String... values)
    {
        return Arrays.stream(values)
                .anyMatch(s->s.contains(searchTerm));
    }


    public void updateUser(Customer updatedCustomer) {
        users.put(updatedCustomer.getId(),updatedCustomer);
    }
}
