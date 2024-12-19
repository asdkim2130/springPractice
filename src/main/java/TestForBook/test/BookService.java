package TestForBook.test;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    void create(){
        bookRepository.save(new Book("title", "author", "isbn", 10000, 2024));
    }


}
