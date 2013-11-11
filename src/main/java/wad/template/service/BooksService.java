/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import wad.template.domain.BookItems;
import wad.template.domain.Books;

/**
 *
 * @author trantane
 */
public interface BooksService {
    @PreAuthorize("hasAnyRole('nsa','admin')")
    Books create(Books book);
    Books read(Long id);
    @PreAuthorize("hasAnyRole('nsa','admin')")
    void delete(Long id);
    List<Books> list();
    @PreAuthorize("hasAnyRole('nsa','admin')")
     Books edit(Books book);

}
