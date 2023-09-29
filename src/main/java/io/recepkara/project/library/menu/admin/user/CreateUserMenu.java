package io.recepkara.project.library.menu.admin.user;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

public class CreateUserMenu extends Menu {

    public static final String USER_ID="USER_ID";

    public CreateUserMenu(UserService userService)
    {
        super("Create user", userService);


    }


    @Override
    public MenuName execute() {
        printTitle();

        String userName= printAndGet("Username: ");
        String password= printAndGet("Password: ");
        String firstName= printAndGet("First Name: ");
        String lastName= printAndGet("Last Name: ");
        String address= printAndGet("Address: ");
        String postcode= printAndGet("Postcode: ");
        String city= printAndGet("City: ");
        //printItem("Borrowed books:",customer.);
        String email=printAndGet("Email: ");

        Customer newCustomer =new Customer(null,
                userName,password,firstName,
                lastName,
                address,postcode,city,email);
        getUserService().createUser(newCustomer);
        println("");
        println("User is successfully created");
        SystemContext.removeProperty(USER_ID);
        return  MenuName.ADMIN_MAIN_MENU;



        }
    private  void  printItem(String label,String value)
    {
        System.out.printf("%-13s: %s %n",label,value);
    }

}
