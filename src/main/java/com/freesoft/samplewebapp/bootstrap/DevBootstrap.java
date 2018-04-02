package com.freesoft.samplewebapp.bootstrap;

import com.freesoft.samplewebapp.entity.Author;
import com.freesoft.samplewebapp.entity.Book;
import com.freesoft.samplewebapp.entity.Publisher;
import com.freesoft.samplewebapp.repository.AuthorRepository;
import com.freesoft.samplewebapp.repository.BookRepository;
import com.freesoft.samplewebapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    private DevBootstrap(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher harper = new Publisher();
        harper.setName("Harper Collins");

        Publisher worx = new Publisher();
        worx.setName("Worx");

        publisherRepository.save(harper);
        publisherRepository.save(worx);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
