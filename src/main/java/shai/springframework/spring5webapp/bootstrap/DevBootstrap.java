package shai.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import shai.springframework.spring5webapp.model.Author;
import shai.springframework.spring5webapp.model.Book;
import shai.springframework.spring5webapp.repositories.AuthorRepository;
import shai.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
	}
	
	public void initData(){
		
		Author Cal = new Author("Cal","Newport");
		Book dw = new Book("Deep Work","1234","Penguins");
		Cal.getBooks().add(dw);
		dw.getAuthors().add(Cal);
		
		authorRepository.save(Cal);
		bookRepository.save(dw);
		
		Author PeterThiel = new Author("Peter","Theil");
		Book zerotoone = new Book("Zero to One","12345","Penguins");
		PeterThiel.getBooks().add(zerotoone);
		zerotoone.getAuthors().add(PeterThiel);
		
		authorRepository.save(PeterThiel);
		bookRepository.save(zerotoone);
	}


}
