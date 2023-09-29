package io.recepkara.project.library.menu.login;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;

import java.util.List;

public class MainLoginMenu extends Menu {

    public MainLoginMenu(UserLoginMenu userLoginMenu) {
        super("Login Menu");
        setOptions(List.of(
                new MenuOption("U","User Login",MenuName.USER_LOGIN),
                new MenuOption("A","Admin Login",MenuName.ADMIN_LOGIN),
                new MenuOption("X","Exit",this::exit  )
        ));
    }

    private MenuName exit(){
        System.exit(1);
        return  null;
    }
}
