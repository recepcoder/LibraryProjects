package io.recepkara.project.library.menu.admin.book;

import io.recepkara.project.library.menu.generic.ConsoleReader;
import io.recepkara.project.library.menu.generic.Menu;
import io.recepkara.project.library.menu.generic.MenuName;
import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;
import io.recepkara.project.library.system.SystemContext;

import java.util.Optional;

import static io.recepkara.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;
public class EditBookMenu extends Menu {

    public EditBookMenu(BookService bookService) {
        super("Edit book", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String bookId = SystemContext.getProperty(BOOK_ID);
        Optional<Book> bookOptional = getBookService().getById(Integer.valueOf(bookId));
        Book book = bookOptional.orElseThrow();

        String title = printfAndGet("Title", book.getTitle());
        Integer year = Integer.valueOf(printfAndGet("Year", book.getYear().toString()));
        String author = printfAndGet("Author", book.getAuthor());

        Book updatedBook = new Book(book.getId(),
                title, year, author);

        getBookService().updateBook(updatedBook);
        System.out.println();
        println("Book is successfully updated");
        println("Press ENTER to continue");
        SystemContext.removeProperty(BOOK_ID);
        ConsoleReader.readerConsole();
        return MenuName.ADMIN_MAIN_MENU;
    }

}
