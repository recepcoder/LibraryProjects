package io.recepkara.project.library.menu.admin.user;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;

import static io.recepkara.project.library.menu.admin.user.ViewUserMenu.USER_ID;

public class SearchUsersMenu extends Menu {


    public SearchUsersMenu(UserService userService) {
        super("Search users", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String searchTerm = printAndGet("Enter search term:");
        List<Customer> customers = getUserService().searchUsers(searchTerm);
        if (customers.isEmpty()) {
            println("No customers foundiplease try again");
            return execute();
        }
        else
        {
            System.out.printf("%-5s|%-20s|%-20s|%-10s|%-15s %n","ID","Name","Address","Postcode","City");
            for (Customer c:customers)
            {
                System.out.printf("%-5.5s|%-20.20s|%-20.20s|%-10.10s|%-15.15s %n",
                        c.getId(),c.getFirstName(),c.getAddress(),c.getPostcode(),c.getCity());
            }
        }
        String choice = printAndGet("Enter book ID to borrow or 'X' to go back to main menu:");
        if ("X".equalsIgnoreCase(choice))
        {
            return MenuName.ADMIN_MAIN_MENU;

        }
        else
        {
           boolean idExists = customers.stream()
                    .anyMatch(c->c.getId().toString().equals(choice));
           if (idExists)
           {    SystemContext.addProperty(USER_ID,choice);
                return  MenuName.ADMIN_VIEW_USER;
           }
           else
           {
               return  execute();
           }
        }


        }
//        if (customers.isPresent()){
//            SystemContext.logInUser(customers.get());
//            println("Login Success, redirecting to main menu . . .");
//            return MenuName.USER_MAIN_MENU;
//        }else {
//            print("Invalid credentials please try again");
//            return execute();
//        }

}
