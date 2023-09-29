package io.recepkara.project.library.menu.generic;

import io.recepkara.project.library.service.BookService;
import io.recepkara.project.library.service.UserService;


import java.util.List;
import java.util.Optional;

public class Menu {
    private  final String title;
    private List<MenuOption> options;
    private   UserService userService;
    private BookService bookService;

    public Menu(String title,UserService userService) {
        this.title = title;
        this.userService = userService;
    }
    public Menu(String title,BookService    bookService) {
        this.title = title;
        this.bookService = bookService;
    }
    public Menu(String title) {
        this.title = title;

    }
    protected  void  printTitle(){
        println("");
        println("===== "+title+" =====");
    }

    public void printOptions(){

        for (MenuOption option:options){
            //System.out.println("("+option.choice()+") - "+option.title());
            System.out.printf(" (%s) - %s %n",option.choice(),option.title());
        }
        println("-------------------------");
        System.out.print("Enter your choice: ");
    }

    public MenuOption getOption() {
        String choice = ConsoleReader.readerConsole();

        Optional<MenuOption> option = options.stream()
                .filter(o -> o.choice().equalsIgnoreCase(choice))
                .findFirst();
        if (option.isEmpty()) {
            System.out.print("Invalid option, please try again: ");
            return getOption();
        } else {
           return option.get();
        }

    }

    public MenuName execute() {
        printTitle();
        printOptions();

        return
                run();

    }
    protected  MenuName run(){
        MenuOption option=getOption();
        if (option.handler()!=null){
            return option.handler().handle();
        }
        else
        {
            return  option.menuName();
        }
    }


    protected UserService getUserService() {
        return userService;
    }

    protected BookService getBookService() {
        return bookService;
    }

    protected void setOptions(List<MenuOption> options) {
        this.options = options;
    }
    protected void print(String text){
        System.out.printf(text);
    }
    protected void println(String text){
        System.out.println(text);
    }
    protected void error(String text)
    {
        System.err.println(text);
    }
    protected String printAndGet(String text){
        print(text);
        return ConsoleReader.readerConsole();

    }
    protected String printfAndGet(String label, String value) {
        System.out.printf("%-12s: %s -> New value: ", label, value);
        String input = ConsoleReader.readerConsole();

        if (input == null || input.trim().equals("")) {
            return value;
        } else {
            return input;
        }
    }
    protected void printfItem(String label, String value) {
        System.out.printf("%-12s: %s %n", label, value);
    }
}

