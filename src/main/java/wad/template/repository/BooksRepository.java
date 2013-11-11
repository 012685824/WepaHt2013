/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.repository;

import org.springframework.data.repository.CrudRepository;
import wad.template.domain.Books;

/**
 *
 * @author trantane
 */
public interface BooksRepository extends CrudRepository<Books, Long>{
    
}
