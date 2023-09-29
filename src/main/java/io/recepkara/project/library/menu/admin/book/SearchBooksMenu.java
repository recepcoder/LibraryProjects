package io.recepkara.project.library.menu.admin.book;

import io.recepkara.project.library.menu.generic.BookMenu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;
import io.recepkara.project.library.system.SystemContext;
import static io.recepkara.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;
import java.util.List;

public class SearchBooksMenu extends BookMenu {

    public SearchBooksMenu(BookService bookService) {
        super("Search books", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String searchTerm = printAndGet("Enter search term:");

        List<Book> books = getBookService().searchBooks(searchTerm);

        if (books.isEmpty()) {
            println("No books found, please try again");
            return execute();
        } else {
            showBooks(books);

            String choice = printAndGet("Enter book ID to see or 'X' to go back to main menu:");

            if ("X".equalsIgnoreCase(choice)) {
                return MenuName.ADMIN_MAIN_MENU;
            } else {
                boolean idExists = books.stream().anyMatch(c -> c.getId().toString().equals(choice));

                if (idExists) {
                    SystemContext.addProperty(BOOK_ID, choice);
                    return MenuName.ADMIN_VIEW_BOOK;
                } else {
                    return execute();
                }
            }
        }
    }


}
