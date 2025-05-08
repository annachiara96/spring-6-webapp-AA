package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    /*private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        //Optional<Book> book = bookRepository.findById(1L);
        return bookRepository.findAll();
    }
}
