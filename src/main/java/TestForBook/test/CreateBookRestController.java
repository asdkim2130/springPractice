package TestForBook.test;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookRestController {
    private BookService bookService;

    public CreateBookRestController(BookService bookService) {
        this.bookService = bookService;
    }
//    @PostMapping("/books")
//    public void createBook (@Valid @RequestBody CreateBookRequest request){
//        System.out.println(request.title());
//        System.out.println(request.author());
//        System.out.println(request.isbn());
//        System.out.println(request.price());
//        System.out.println(request.year());
//    }

    @PostMapping("/books")
    public void create(@Valid @RequestBody CreateBookRequest request){
        bookService.create();
    }

}


