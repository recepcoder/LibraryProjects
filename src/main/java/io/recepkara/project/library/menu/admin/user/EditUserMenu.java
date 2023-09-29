package io.recepkara.project.library.menu.admin.user;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class EditUserMenu extends Menu {

    public static final String USER_ID="USER_ID";

    public EditUserMenu(UserService userService)
    {
        super("Edit user", userService);


    }


    @Override
    public MenuName execute() {
       printTitle();
       String userId = SystemContext.getProperty(USER_ID);

        Optional<Customer> customerOptional= getUserService().getById(Integer.valueOf(userId));
        Customer customer = customerOptional.orElseThrow();
        String id= printfAndGet("ID",customer.getId().toString());
        String userName= printfAndGet("Username:",customer.getUserName());
        String firstName= printfAndGet("First Name:", customer.getFirstName());
        String lastName= printfAndGet("Last Name:",customer.getLastName());
        String address= printfAndGet("Address:",customer.getAddress());
        String postcode= printfAndGet("Postcode",customer.getPostcode());
        String city= printfAndGet("City",customer.getCity());
        //printItem("Borrowed books:",customer.);
        String email=printfAndGet("Email",customer.getEmail());

        Customer updatedCustomer=new Customer(customer.getId(),
                userName,customer.getPassword(),firstName,
                lastName,
                address,postcode,city,email);
        getUserService().updateUser(updatedCustomer);
        println("");
        println("User is successfully updated");
        SystemContext.removeProperty(USER_ID);
        return  MenuName.ADMIN_MAIN_MENU;



        }
    private  void  printItem(String label,String value)
    {
        System.out.printf("%-13s: %s %n",label,value);
    }
    protected   String  printfAndGet(String label,String value)
    {
        System.out.printf("%-12s: %s -> New value: ",label,value);
        String input= ConsoleReader.readerConsole();
        if (input==null||input.trim().equals(""))
        {
            return  value;
        }else
        {
            return  input;
        }
    }

}
