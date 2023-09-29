package io.recepkara.project.library.repo.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Setter
@Getter
public class Book {
    private final Integer id;
    private final String title;
    private final Integer year;
    private final String author;
    private Integer borrowedBy;
    private LocalDateTime borrowDateTime;

    public void borrowBook(Integer userId) {
        this.borrowedBy = userId;
        this.borrowDateTime = LocalDateTime.now();
    }

    public void returnBook() {
        this.borrowedBy = null;
        this.borrowDateTime = null;
    }


    public boolean isBorrowed() {
        return borrowedBy != null;
    }
}
