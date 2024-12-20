package TestForBook.test;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest2 {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("책 저장 테스트")
    void createBookTest() {
        // [미완성된 코드]
        // given
        Book book = new Book("클린 코드", "로버트 마틴", "30000", 15000, 2024);
        assertThat(book.getId()).isNull();

        // when
        // TODO: bookRepository를 사용하여 책을 저장하세요
        Book 저장된Book = bookRepository.save(book);

        // then
        // TODO: assertThat을 사용하여 결과를 검증하세요
        // 저장된 책의 ID가 null이 아닌지 확인하세요
        assertThat(저장된Book.getId()).isNotNull();
    }

    @Test
    @DisplayName("ID로 책 조회 테스트")
    void findBookByIdTest() {
        // [미완성된 코드]
        // given
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book book1 = new Book("클린 코드", "로버트 마틴", "30000", 15000, 2024);
        Book book2 = new Book("오브젝트", "김", "111", 15000, 2024);
        bookRepository.save(book1);
        bookRepository.save(book2);
        entityManager.clear();

        // when
        // TODO: bookRepository의 findById를 사용하여 책을 조회하세요
        // 저장된 책의 ID로 책을 조회하세요
        Book 찾은Book = bookRepository.findById(book2.getId())
                .orElseThrow();

        // then
        // TODO: assertThat을 사용하여 결과를 검증하세요
        // 조회된 책의 정보가 저장한 데이터와 일치하는지 확인하세요
        assertThat(찾은Book.getId()).isEqualTo(book2.getId());
        assertThat(찾은Book.getTitle()).isEqualTo(book2.getTitle());
    }

    @Test
    @DisplayName("책 정보 수정 테스트")
    void updateBookTest() {
        // [미완성된 코드]
        // given
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book book1 = new Book("클린 코드", "로버트 마틴", "30000", 15000, 2024);
        Book book2 = new Book("오브젝트", "김", "111", 15000, 2024);
        bookRepository.save(book1);
        bookRepository.save(book2);
        entityManager.clear();

        // when
        // TODO: 책의 가격을 수정하고 저장하세요
        Book 찾은Book = bookRepository.findById(book2.getId())
                .orElseThrow();
        찾은Book.setPrice(0);

        entityManager.flush();

        // then
        // TODO: assertThat을 사용하여 수정된 가격을 검증하세요
        // 수정된 책 정보를 조회하여 가격이 정상적으로 변경되었는지 확인하세요
        Book 찾은Book2 = bookRepository.findById(book2.getId())
                .orElseThrow();
        assertThat(찾은Book.getPrice()).isEqualTo(0);
    }

    @Test
    @DisplayName("책 삭제 테스트")
    void deleteBookTest() {
        // [미완성된 코드]
        // given
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book book1 = new Book("클린 코드", "로버트 마틴", "30000", 15000, 2024);
        Book book2 = new Book("오브젝트", "김", "111", 15000, 2024);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // when
        // TODO: bookRepository의 deleteById() 메서드를 사용하여 책을 삭제하세요
        bookRepository.deleteById(book2.getId());
        entityManager.flush();

        // then
        // TODO: assertions를 사용하여 책이 정상적으로 삭제되었는지 검증하세요
        // 삭제된 책의 ID로 조회했을 때 데이터가 존재하지 않는지 확인하세요
        Book book = bookRepository.findById(book2.getId()).orElse(null);
        assertThat(book).isNull();
    }
}
