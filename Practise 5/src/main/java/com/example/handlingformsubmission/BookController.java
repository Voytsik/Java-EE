package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private List<Book> books = new ArrayList<>();

    @GetMapping("/add-book")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        for (Book elem: books) {
            System.out.println(elem);
        }
        return "add-book";
    }

    @PostMapping("/add-book")
    public String bookSubmit(@ModelAttribute Book book, Model model) {
        books.add(book);
        model.addAttribute("books", books);
        return "redirect:/books-list";
    }

    @GetMapping("/books-list")
    public String booksList(Model model) {
        model.addAttribute("books", books);
        return "books-list";
    }
}