package fi.haagahelia.course.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.bookstore.domain.Category;
import fi.haagahelia.course.bookstore.domain.Book;
import fi.haagahelia.course.bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = (List<Book>)repository.findAll();
        
        assertThat(books).hasSize(2);
        assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("War and Peace", "Lev Tolstoy", "1867", "26486", "20", new Category("Classic"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}