/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.template.domain.BookItems;
import wad.template.domain.Books;
import wad.template.service.BookItemsService;
import wad.template.service.BooksService;

/**
 *
 * @author trantane
 */
@Controller
public class RESTBooksController implements BooksController {

    @Autowired
    private BooksService booksService;
    @Autowired
    private BookItemsService bookItemsService;

    /*  
     @Override
     @RequestMapping(value = "books", method = RequestMethod.POST)
     public String create(@RequestParam String name,@RequestParam String authors,@RequestParam String publishers,@RequestParam String isbn,@RequestParam int publishingYear) {
     Books book = new Books();
     book.setName(name);
     book.setAuthors(authors);
     book.setPublishers(publishers);
     book.setIsbn(isbn);
     book.setPublishingYear(publishingYear);
        
     booksService.create(book);
 
     return "redirect:/app/books";
     }
     */
    @Override
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(@ModelAttribute("book") Books book) {

        return "add";
    }

    @Override
    @RequestMapping(value = {"del/{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("book", booksService.read(id));

        return "del";
    }

    
    
    
    @Override
    //@PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("book") Books book, BindingResult result) {


        if (result.hasErrors()) {

            model.addAttribute("book", book);
            return "index";
        }

        BookItems bookItems = bookItemsService.listBook(book.getIsbn());

        if (book.getPublishers().isEmpty()) {
            book.setPublishers(bookItems.getPublishers());
        }

        if (book.getName().isEmpty()) {
            book.setName(bookItems.getName());
        }
        if (book.getPublish_date().isEmpty()) {
            book.setPublish_date(bookItems.getPublish_date());
        }
        if (book.getAuthors().isEmpty()) {
            book.setAuthors(bookItems.getAuthors());
        }
        book.setCover(bookItems.getCover());

        booksService.create(book);

        return "redirect:/app/books?search=";
    }

    @Override
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id/*,Principal principal*/) {

//        if(principal.getName() == "Matti" && booksService.read(id).getIsbn() == "" ){
//            return "redirect:/app/books?search=";
//        }
        booksService.delete(id);

        return "redirect:/app/books?search=";
    }

    @Override
    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public String read(Model model, @PathVariable(value = "id") Long id) {
        

        model.addAttribute("book", booksService.read(id));

        return "book";
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    @Override
    public String list(HttpServletRequest request, Model model) {

        List<Books> kaikki = booksService.list();
        List<Books> lista = new ArrayList();
        String etsi = request.getParameter("search");
        String mista = request.getParameter("mista");
        System.out.println("mika"+mista);
        System.out.println("haku"+etsi);
        /*
         if(request.getParameter("etsi") == null){
         etsi = request.getParameter("etsi");
         }*/

        if (etsi == "") {
            model.addAttribute("books", kaikki);
            return "books";
        }
//        }else{
//            etsi = request.getParameter("search");
//        }
        if (mista.contentEquals("nimi")) {
            for (Books books : kaikki) {
                if (books.getName().contains(etsi)) {
                    lista.add(books);
                }

            }
            model.addAttribute("books", lista);

            return "books";
        }
        if (mista.contentEquals("tekija")) {
            for (Books books : kaikki) {
                if (books.getAuthors().contains(etsi)) {
                    lista.add(books);
                }

            }
            model.addAttribute("books", lista);

            return "books";
        }
        return "books";

    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editR(Model model, @PathVariable(value = "id") Long id) {
       
        
        model.addAttribute("book", booksService.read(id));
        
        return "edit";
    }

    @Override
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String edit(Model model, Books book, BindingResult result,@PathVariable(value = "id") Long id) {
        
        if (result.hasErrors()) {

            model.addAttribute("book", book);
            return "books";
        }
        
        booksService.edit(book);
        
        return "redirect:/app/books/"+id;
    }
    

}
