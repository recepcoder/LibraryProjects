package io.recepkara.project.library.menu.generic;

import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;

import java.util.Optional;

public class UserMenu extends Menu {

    public UserMenu(String title, UserService userService) {
        super(title, userService);
    }

    protected void editUser(Integer userId) {
        Optional<Customer> customerOptional = getUserService().getById(Integer.valueOf(userId));
        Customer customer = customerOptional.orElseThrow();

        String username = printfAndGet("Username", customer.getUserName());
        String password = printfAndGet("Password", customer.getPassword());
        String firstName = printfAndGet("FirstName", customer.getFirstName());
        String lastName = printfAndGet("LastName", customer.getLastName());
        String address = printfAndGet("Address", customer.getAddress());
        String postcode = printfAndGet("Postcode", customer.getPostcode());
        String city = printfAndGet("City", customer.getCity());
        String email = printfAndGet("Email", customer.getEmail());

        Customer updatedCustomer = new Customer(customer.getId(),
                username, password, firstName,
                lastName,
                address,
                postcode,
                city,
                email);

        getUserService().updateUser(updatedCustomer);
        System.out.println();
        println("User is successfully updated");
        println("Press ENTER to continue");
        ConsoleReader.readerConsole();
    }
    protected void viewUser(Integer userId) {
        Optional<Customer> customerOptional = getUserService().getById(userId);
        Customer customer = customerOptional.orElseThrow();

        printfItem("ID", customer.getId().toString());
        printfItem("Username", customer.getUserName());
        printfItem("FirstName", customer.getFirstName());
        printfItem("LastName", customer.getLastName());
        printfItem("Address", customer.getAddress());
        printfItem("Postcode", customer.getPostcode());
        printfItem("City", customer.getCity());
        printfItem("Email", customer.getEmail());

        System.out.println();
        printOptions();
    }
}
