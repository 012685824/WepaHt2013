/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import wad.template.domain.Books;

/**
 *
 * @author trantane
 */
public interface BooksController {
 
    //String create(String name,String authors,String publishers,String isbn,int publishingYear);
    String editR (Model model, Long id);
    String edit(Model model, Books book, BindingResult result, Long id);
    String add(Books book);
    String create(Model model, Books book, BindingResult result);
    String del(Model model, Long id);
    String read(Model model, Long id);
    String delete(Long id/*,Principal principal*/);
    String list(HttpServletRequest request,Model model);
    
    
    
}
