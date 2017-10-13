package fi.haagahelia.course.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.bookstore.BookstoreApplication;
import fi.haagahelia.course.bookstore.domain.Book;
import fi.haagahelia.course.bookstore.domain.BookRepository;
import fi.haagahelia.course.bookstore.domain.Category;
import fi.haagahelia.course.bookstore.domain.CategoryRepository;
import fi.haagahelia.course.bookstore.domain.User;
import fi.haagahelia.course.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository drepository, UserRepository urepository) {
		return (args) -> {
			log.info("save new books");
			drepository.save(new Category("SciFi"));
			drepository.save(new Category("Fantasy"));
			drepository.save(new Category("Classic"));
			
			repository.save(new Book("George Orwell", "Animal Farm", "235421", "1945", "30", drepository.findByName("Classic").get(0)));		
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "2323121", "1929", "35", drepository.findByName("Classic").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("nadia", "$2a$04$b0QocNfcQjnAKRmqywNmuOi.3GhcYM.Om2o3DxbP8hUYykI9pXLci", "NADIA");
			User user4 = new User("anna", "$2a$04$WMBc/QcLR1LxWcFXRC6k3.kIm603W8eqr.CChC0pVA6dv9d3Jf2mS", "ANNA");
			
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

