package io.recepkara.project.library.service;

import io.recepkara.project.library.repo.book.Book;
import io.recepkara.project.library.repo.book.BookRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.createBook(book);
    }

    @Override
    public void deleteBookByBookId(Integer bookId) {
        bookRepository.deleteBookById(bookId);
    }

    @Override
    public List<Book> searchBooks(String searchTerm) {
        return bookRepository.searchBooks(searchTerm);
    }

    @Override
    public Optional<Book> getById(Integer bookId) {
        return bookRepository.getById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    @Override
    public List<Book> searchBooksBorrowedByUserId(Integer userId) {
        return bookRepository.searchBooksBorrowedByUserId(userId);
    }
}
