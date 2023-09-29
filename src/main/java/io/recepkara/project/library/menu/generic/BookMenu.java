package io.recepkara.project.library.menu.generic;

import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.service.BookService;

import java.util.List;

public class BookMenu extends Menu {

    public BookMenu(String title, BookService bookService) {
        super(title, bookService);
    }

    protected void showBooks(List<Book> books) {
        System.out.printf("%-5s|%-20s|%-5s|%-20s %n", "ID", "Title", "Year", "Author");
        println("-----------------------------------------------------------------------");
        for (Book c : books) {
            System.out.printf("%-5.5s|%-20.20s|%-5.5s|%-20.20s %n",
                    c.getId(), c.getTitle(), c.getYear(), c.getAuthor());
        }
    }
}
