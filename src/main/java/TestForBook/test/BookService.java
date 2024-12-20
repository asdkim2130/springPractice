package TestForBook.test;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    //Repository는 Service에 만든다 + 생성자
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    void create(){
        bookRepository.save(new Book("title", "author", "isbn", 10000, 2024));
    }


}
