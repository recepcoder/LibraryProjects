package io.recepkara.project.library.menu.admin.user;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.Optional;

public class DeleteUserMenu extends Menu {

    public static final String USER_ID="USER_ID";

    public DeleteUserMenu(UserService userService)
    {
        super("Delete user", userService);


    }


    @Override
    public MenuName execute() {
       printTitle();
       String userId = SystemContext.getProperty(USER_ID);

        Optional<Customer> customerOptional= getUserService().getById(Integer.valueOf(userId));
        Customer customer = customerOptional.orElseThrow();

        getUserService().deleteUserById(customer.getId());
        System.out.printf("User %s is deleted. %n",customer.getId());
        SystemContext.removeProperty(USER_ID);
        return  MenuName.ADMIN_MAIN_MENU;



        }
    private  void  printItem(String label,String value)
    {
        System.out.printf("%-13s: %s %n",label,value);
    }

}
