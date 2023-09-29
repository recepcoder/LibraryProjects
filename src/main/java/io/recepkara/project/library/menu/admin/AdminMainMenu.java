package io.recepkara.project.library.menu.admin;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;

import java.util.List;

public class AdminMainMenu extends Menu {
        public AdminMainMenu() {
        super("Admin Main Menu");
        setOptions(List.of(
                new MenuOption("U","Search Users", MenuName.ADMIN_SEARCH_USERS),
                new MenuOption("C","Create User", MenuName.ADMIN_CREATE_USER),
                new MenuOption("B","Search Books", MenuName.ADMIN_SEARCH_BOOKS),
                new MenuOption("K","Create Books", MenuName.ADMIN_CREATE_BOOK),
                //new MenuOption("A","Delete Books", this::handleAdminLogin),
                new MenuOption("O","Log Off", MenuName.LOG_OFF)
        ));
    }
}
