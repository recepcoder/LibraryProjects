package io.recepkara.project.library.menu.admin.user;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class ViewUserMenu extends Menu {

    public static final String USER_ID="USER_ID";

    public ViewUserMenu(UserService userService)
    {
        super("View user", userService);
        setOptions(List.of(
                new MenuOption("E","Edit user",MenuName.ADMIN_EDIT_USER),
                new MenuOption("D","Delete user",MenuName.ADMIN_DELETE_USER),
                new MenuOption("M","Back to main menu",MenuName.ADMIN_MAIN_MENU)));

    }


    @Override
    public MenuName execute() {
       printTitle();
       String userId = SystemContext.getProperty(USER_ID);

        Optional<Customer> customerOptional= getUserService().getById(Integer.valueOf(userId));
        Customer customer = customerOptional.orElseThrow();
        printItem("ID",customer.getId().toString());
        printItem("Username:",customer.getUserName());
        printItem("First Name:", customer.getFirstName());
        printItem("Last Name:",customer.getLastName());
        printItem("Address:",customer.getAddress());
        printItem("Postcode",customer.getPostcode());
        printItem("City",customer.getCity());
        //printItem("Borrowed books:",customer.);
        printItem("Email",customer.getEmail());
        println("");
        printOptions();
        return  run();



        }
    private  void  printItem(String label,String value)
    {
        System.out.printf("%-13s: %s %n",label,value);
    }

}
