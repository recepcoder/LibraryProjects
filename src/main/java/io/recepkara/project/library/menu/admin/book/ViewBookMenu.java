package io.recepkara.project.library.menu.admin.book;

import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.menu.generic.MenuOption;
import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class ViewBookMenu extends Menu {

    public static final String BOOK_ID = "BOOK_ID";

    public ViewBookMenu(BookService bookService) {
        super("View book", bookService);
        setOptions(List.of(
                new MenuOption("E", "Edit book", MenuName.ADMIN_EDIT_BOOK),
                new MenuOption("D", "Delete book", MenuName.ADMIN_DELETE_BOOK),
                new MenuOption("M", "Back to main menu", MenuName.ADMIN_MAIN_MENU)));
    }

    @Override
    public MenuName execute() {
        printTitle();
        String bookId = SystemContext.getProperty(BOOK_ID);
        Optional<Book> bookOptional = getBookService().getById(Integer.valueOf(bookId));
        Book book = bookOptional.orElseThrow();

        printfItem("ID", book.getId().toString());
        printfItem("Title", book.getTitle());
        printfItem("Year", book.getYear().toString());
        printfItem("Author", book.getAuthor());

        System.out.println();
        printOptions();

        return run();

    }

}
