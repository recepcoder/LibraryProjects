package io.recepkara.project.library.menu.customer.profile;

import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;
import io.recepkara.project.library.menu.generic.UserMenu;
import io.recepkara.project.library.service.UserService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;

public class SeeMyProfileMenu extends UserMenu {

    public SeeMyProfileMenu(UserService userService) {
        super("Update My Profile", userService);
        setOptions(List.of(
                new MenuOption("U", "Update my Profile", MenuName.UPDATE_MY_PROFILE),
                new MenuOption("R", "Return to My Profile", MenuName.MY_PROFILE)));
    }

    @Override
    public MenuName execute() {
        printTitle();
        Integer userId = SystemContext.getLoggedInUserId();
        viewUser(userId);
        return run();
    }

}
