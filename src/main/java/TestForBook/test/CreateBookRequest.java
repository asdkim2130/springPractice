package TestForBook.test;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record CreateBookRequest(
        Long id,
        @Size(min = 2, max = 50)String title,
        @Size(min = 2, max = 30)String author,
        @Size(min = 13, max = 13)String isbn,
        @Positive int price,
        @Range(min = 1900, max = 2024)int year) {
}
