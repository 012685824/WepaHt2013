/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import wad.template.domain.BookItems;
import wad.template.domain.Books;
import wad.template.repository.BooksRepository;

/**
 *
 * @author trantane
 */
@Service
public class JpaBooksService  implements BooksService{

    
    
    @Autowired
    private BooksRepository booksRepository;
    
   
 

    
    @Override
    @Transactional(readOnly = false)
    public Books create(Books books) {
        return booksRepository.save(books);
    }

    
    @Override
    @Transactional(readOnly = true)
    public Books read(Long id) {
        return booksRepository.findOne(id);
    }

    
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        booksRepository.delete(id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Books> list() {
        return (List<Books>) booksRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Books edit(Books book) {
        
    return booksRepository.save(book);
                 
                 
    }
    

    
}
