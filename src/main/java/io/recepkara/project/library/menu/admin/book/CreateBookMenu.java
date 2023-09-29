package io.recepkara.project.library.menu.admin.book;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;

public class CreateBookMenu extends Menu {

    public CreateBookMenu(BookService bookService) {
        super("Create book", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();

        String title = printAndGet("Title: ");
        Integer year = Integer.valueOf(printAndGet("Year: "));
        String author = printAndGet("Author: ");

        Book newBook = new Book(null,
                title, year, author);

        getBookService().createBook(newBook);
        System.out.println();
        println("Book is successfully created");
        println("Press ENTER to continue");
        ConsoleReader.readerConsole();
        return MenuName.ADMIN_MAIN_MENU;
    }

}
