package fi.haagahelia.course.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fi.haagahelia.course.bookstore.domain.Book;
import fi.haagahelia.course.bookstore.domain.Category;

@Entity
public class Category {
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		
	    private Long id;
	    private String name;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		private List<Book> book;
		public Category (){}
		
		public Category (String name) {
			super();
			this.name = name;
		}
	   

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
			public List<Book> getBook() {
				return book;
			}

			public void setBook(List<Book> book) {
				this.book = book;
			}

			@Override
			public String toString() {
				return "Category [id=" + id + ", name=" + name + ", book=" + book + "]";
			}

		}


