package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author luca= new Author();
        luca.setFirstName("Luca");
        luca.setLastName("Mazzucchelli");

        Book fatt= new Book();
        fatt.setTitle("Fattore 1%");
        fatt.setIsbn("123");

        Author lucaSaved= authorRepository.save(luca);
        Book fattSaved= bookRepository.save(fatt);

        lucaSaved.getBooks().add(fattSaved);

        //perché non risalva lucaSaved?
        authorRepository.save(lucaSaved);

        System.out.println("In Bootstrap:");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count " + bookRepository.count());

    }
}
