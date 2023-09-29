package io.recepkara.project.library.menu.customer.profile;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;

import java.util.List;

public class MyProfileMenu extends Menu {

    public MyProfileMenu() {
        super("My Profile Menu");
        setOptions(List.of(
                new MenuOption("U", "Update My Profile", MenuName.UPDATE_MY_PROFILE),
                new MenuOption("S", "See My Profile", MenuName.SEE_MY_PROFILE),
                new MenuOption("M", "Main Menu", MenuName.USER_MAIN_MENU)));
    }

}
