package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    //private final + costruttore esplicito
    /*private final AuthorService authorService;
    public AuthorController(AuthorService authorService) { this.authorService = authorService; }*/

    // private + Autowired annotation
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }

}
