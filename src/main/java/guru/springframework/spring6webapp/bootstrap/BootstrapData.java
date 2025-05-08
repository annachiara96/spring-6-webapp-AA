package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author luca= new Author();
        luca.setFirstName("Luca");
        luca.setLastName("Mazzucchelli");

        Author inv= new Author();
        inv.setFirstName("Scrittore");
        inv.setLastName("Inventato");

        Book fatt= new Book();
        fatt.setTitle("Fattore 1%");
        fatt.setIsbn("123");

        Book era= new Book();
        era.setTitle("Era del cuore");
        era.setIsbn("456");

        Publisher monda= new Publisher();
        monda.setPubName("Mondadori");
        monda.setAddress("Via Inventata");

        Author lucaSaved= authorRepository.save(luca);
        Author invSaved= authorRepository.save(inv);

        Book fattSaved= bookRepository.save(fatt);
        Book eraSaved= bookRepository.save(era);
        Publisher mondaSaved= publisherRepository.save(monda);

        lucaSaved.getBooks().add(fattSaved);
        invSaved.getBooks().add(fattSaved);
        lucaSaved.getBooks().add(eraSaved);

        fattSaved.getAuthors().add(lucaSaved);
        fattSaved.getAuthors().add(invSaved);
        eraSaved.getAuthors().add(lucaSaved);

        fattSaved.setPublisher(mondaSaved);
        eraSaved.setPublisher(mondaSaved);

        /*mondaSaved.getBooks().add(fattSaved);
        mondaSaved.getBooks().add(eraSaved);*/

        authorRepository.save(lucaSaved);
        authorRepository.save(invSaved);
        publisherRepository.save(mondaSaved);
        bookRepository.save(eraSaved);
        bookRepository.save(fattSaved);

        System.out.println("In Bootstrap:");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count " + bookRepository.count());
        System.out.println("Publisher count " + publisherRepository.count());

    }
}
