package TestForBook.test;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    //Repository는 오브젝트로 존재하고 동작
    //static이 붙지 않음
    //Repository 오브젝트가 필요
    //controller에서는 생성자가 필요하나, Test에서는 @Autowired를 넣으면 된다.
    //@SpringBootTest를 넣어준다.(또는 @DataJpaTest 보통은 이걸 달아놓음)


  @Autowired
    BookRepository bookRepository;

  @Autowired
    EntityManager entityManager;

        @Test
        @DisplayName("책 저장 테스트")
        void createBookTest() {
            // [미완성된 코드]
            // given

            //entity 오브젝트
            Book book = new Book("클린 코드", "로버트 마틴", "30000", 30000, 2024);

            // when
            // TODO: bookRepository를 사용하여 책을 저장하세요
            Book 저장된Book = bookRepository.save(book);
            //save 하고 저장된Book으로 오브젝트를 만들면 id가 생긴다


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
            Book book = new Book("작별하지 않는다", "한강", "1234567890987", 15000, 2023);
            bookRepository.save(book);  //repository에 저장
            entityManager.clear();

            // when
            // TODO: bookRepository의 findById를 사용하여 책을 조회하세요
            // 저장된 책의 ID로 책을 조회하세요
            Book 저장된book = bookRepository.findById(book.getId()).orElseThrow();


            // then
            // TODO: assertThat을 사용하여 결과를 검증하세요
            // 조회된 책의 정보가 저장한 데이터와 일치하는지 확인하세요
            assertThat(저장된book.getId()).isNotNull();
            assertThat(book == 저장된book).isTrue();

            Book foundBook = bookRepository.findById(book.getId()).orElseThrow();
//            Book foundBook2 = bookRepository.findById(book.getId()).orElseThrow(null);
//            if(foundBook2 == null){
//                throw new NoSuchElementException("못찾았어요 ID" + book.getId());
//            }
        }

        @Test
        @DisplayName("책 정보 수정 테스트")
        void updateBookTest() {
            // [미완성된 코드]
            // given
            // TODO: 테스트용 책 데이터를 생성하고 저장하세요

            Book book = new Book("작별하지 않는다", "한강", "1234567890987", 15000, 2023);
            bookRepository.save(book);
//            entityManager.clear();


            // when
            // TODO: 책의 가격을 수정하고 저장하세요
            book.setPrice(16000);  //setter를 이용해서 오브젝트의 price값을 수정
            Book 수정된book = bookRepository.save(book);  //수정된 값이 들어간 오브젝트를 다시 데이터베이스에 저장
//            entityManager.flush();;

            // then
            // TODO: assertThat을 사용하여 수정된 가격을 검증하세요
            // 수정된 책 정보를 조회하여 가격이 정상적으로 변경되었는지 확인하세요
            assertThat(수정된book.getPrice()).isEqualTo(16000);
        }

        @Test
        @DisplayName("책 삭제 테스트")
        void deleteBookTest() {
            // [미완성된 코드]
            // given
            // TODO: 테스트용 책 데이터를 생성하고 저장하세요
            Book book = new Book("작별하지 않는다", "한강", "1234567890987", 15000, 2023);
            Book book2 = new Book("소년이온다", "한강", "0987654321234", 15000, 2023);


            bookRepository.save(book);
            bookRepository.save(book2);
            entityManager.flush();

            // when
            // TODO: bookRepository의 delete 메서드를 사용하여 책을 삭제하세요
            bookRepository.deleteById(book.getId());
            entityManager.flush();


            // then
            // TODO: assertions를 사용하여 책이 정상적으로 삭제되었는지 검증하세요
            // 삭제된 책의 ID로 조회했을 때 데이터가 존재하지 않는지 확인하세요
            bookRepository.findById(book.getId()).orElse(null);

            assertThat(book).isEqualTo(null);
        }

}
