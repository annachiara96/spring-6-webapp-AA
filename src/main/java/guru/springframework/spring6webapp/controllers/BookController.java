package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.services.BookService;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    // private final + costruttore esplicito
    /*private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService;}*/

    // private annotati con autowired
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }

}
