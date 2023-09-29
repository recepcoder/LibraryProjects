package io.recepkara.project.library.menu.customer.book;

import io.recepkara.project.library.menu.generic.BookMenu;
import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;
import io.recepkara.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class BorrowBooksMenu extends BookMenu {

    public BorrowBooksMenu(BookService bookService) {
        super("Borrow books", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String searchTerm = printAndGet("Enter search term:");

        List<Book> books =
                getBookService().searchBooks(searchTerm)
                        .stream().filter(b -> !b.isBorrowed())
                        .toList();

        if (books.isEmpty()) {
            println("No books found, please try again");
            return execute();
        } else {
            showBooks(books);
            String choice = printAndGet("Enter book ID to borrow or 'X' to go back to main menu:");

            if ("X".equalsIgnoreCase(choice)) {
                return MenuName.USER_MAIN_MENU;
            } else {
                Optional<Book> optionalBook = books.stream()
                        .filter(c -> c.getId().toString().equals(choice))
                        .findFirst();

                if (optionalBook.isPresent()) {
                    Book book = optionalBook.get();
                    book.borrowBook(SystemContext.getLoggedInUserId());
                    getBookService().updateBook(book);
                    System.out.println();
                    System.out.printf("Book: %s is borrowed. Press enter to go back to main menu", book.getTitle());
                    ConsoleReader.readerConsole();
                    return MenuName.USER_MAIN_MENU;
                } else {
                    return execute();
                }
            }
        }
    }
}
