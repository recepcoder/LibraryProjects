package io.recepkara.project.library.menu.generic;

public record MenuOption(String choice, String title, IMenuOptionHandler handler,MenuName menuName) {
    public MenuOption(String choice,String title,MenuName menuName){
        this(choice,title,null,menuName);
    }
    public  MenuOption(String choice,String title,IMenuOptionHandler handler){
        this(choice,title,handler,
                null);

    }



}
