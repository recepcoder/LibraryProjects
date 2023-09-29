package io.recepkara.project.library.menu.login;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.user.AdminUser;
import io.recepkara.project.library.repo.user.SystemUser;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.Optional;

public class AdminLoginMenu extends Menu {


    public AdminLoginMenu(UserService userService) {
        super("Admin Login", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String username= printAndGet("User name: ");
        String password=printAndGet("Password: ");
        Optional<SystemUser>user=getUserService().getByUserNameAndPassword(username,password);
        if (user.isPresent()){

            if (user.get() instanceof AdminUser)
            {
            println("Login Success, redirecting to main menu . . .");
                SystemContext.logInUser(user.get());
                return MenuName.ADMIN_MAIN_MENU;
            }
            else
            {
                println("User must be  an admin user, please try again");
                return execute();
            }
        }
        else
        {
            error("Invalid credentials please try again");
            return execute();
        }
    }
}
