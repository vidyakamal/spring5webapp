package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub1 = new Publisher();
        pub1.setName("Some Publishing");
        pub1.setAddressLine1("3362 Norwood Ave");
        pub1.setCity("SJ");
        pub1.setZip("noZip");
        publisherRepository.save(pub1);

     Author eric = new Author("eric","gloger");
     Book book1 = new Book("myBook","1234");
     eric.getBooks().add(book1);
     book1.getAuthors().add(eric);
     book1.setPublisher(pub1);
     pub1.getBooks().add(book1);
     authorRepository.save(eric);
     bookRepository.save(book1);
     publisherRepository.save(pub1);

        Author jeff = new Author("jeff","Mat");
        Book book2 = new Book("hisBook","5678");
        jeff.getBooks().add(book2);
        book2.getAuthors().add(jeff);
        book2.setPublisher(pub1);
        pub1.getBooks().add(book2);

        authorRepository.save(jeff);
        bookRepository.save(book2);
        publisherRepository.save(pub1);
        System.out.println("Started BootStrapData");
        System.out.println("Number of books" + bookRepository.count());
        System.out.println("Number of Publishers" + publisherRepository.count());




    }
}
