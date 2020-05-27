package com.ns.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ns.spring5webapp.domain.Address;
import com.ns.spring5webapp.domain.Author;
import com.ns.spring5webapp.domain.Book;
import com.ns.spring5webapp.domain.Publisher;
import com.ns.spring5webapp.repositories.AddressRepository;
import com.ns.spring5webapp.repositories.AuthorRepository;
import com.ns.spring5webapp.repositories.BookRepository;
import com.ns.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final AddressRepository addressRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			AddressRepository addressRepository,PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository	= bookRepository;
		this.addressRepository = addressRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Address adr = new Address("Geeta Press main road", "Gorakhpur", "UP", "123456");
		addressRepository.save(adr);
		
		Publisher gpk = new Publisher("Geeta Press Gurakhpur", adr);
		
		Author td = new Author("Tulsi", "Dal");
		Book ram = new Book("Shri Ramcharitmanas", "12121212442");
		
		td.getBooks().add(ram);
		ram.getAuthors().add(td);
		gpk.getBooks().add(ram);
		
		authorRepository.save(td);
		bookRepository.save(ram);

		Author v = new Author("Valmiki", "");
		Book r = new Book("Ramayan", "3434434341112");
		
		v.getBooks().add(r);
		r.getAuthors().add(v);
		gpk.getBooks().add(r);
		
		authorRepository.save(v);
		bookRepository.save(r);
		
		publisherRepository.save(gpk);
		
		System.out.println("Started in BootStrap...");
		System.out.println("Number of book(s) in repository " + bookRepository.count());
		System.out.println("Number of publisher(s) in repository " + publisherRepository.count());
		System.out.println("Number of books publisher has " + gpk.getBooks().size());
	}

}
