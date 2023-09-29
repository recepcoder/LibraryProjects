package io.recepkara.project.library.menu.login;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.user.SystemUser;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.Optional;

public class UserLoginMenu extends Menu {


    public UserLoginMenu(UserService userService) {
        super("User Login", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String username= printAndGet("User name: ");
        String password=printAndGet("Password: ");
        Optional<SystemUser>user=getUserService().getByUserNameAndPassword(username,password);
        if (user.isPresent()){
            SystemContext.logInUser(user.get());
            println("Login Success, redirecting to main menu . . .");
            return MenuName.USER_MAIN_MENU;
        }else {
            print("Invalid credentials please try again");
            return execute();
        }
    }
}
