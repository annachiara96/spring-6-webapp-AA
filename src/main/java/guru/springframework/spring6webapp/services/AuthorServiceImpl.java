package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    // private final + costruttore esplicito
    /*private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) { this.authorRepository = authorRepository;}*/

    // private + Autowired
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
