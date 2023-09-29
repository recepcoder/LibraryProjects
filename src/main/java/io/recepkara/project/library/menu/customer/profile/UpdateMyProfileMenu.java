package io.recepkara.project.library.menu.customer.profile;

import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.UserMenu;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

public class UpdateMyProfileMenu extends UserMenu {

    public UpdateMyProfileMenu(UserService userService) {
        super("Update My Profile", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        Integer userId = SystemContext.getLoggedInUserId();
        editUser(userId);
        return MenuName.USER_MAIN_MENU;
    }

}
