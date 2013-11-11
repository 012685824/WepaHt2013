/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author trantane
 */
@Entity
@Table(name = "books")
public class Books implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Pakko")
    @Column(name = "isbn")
    private String isbn;
    
    
    @Column(name = "authors")
    private String authors;
    
    @Column(name = "publishers")
    private String publishers;
    
    @Column(name = "publish_date")
    private String publish_date;
    
    @Column(name = "cover")
    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String  publish_date) {
        this.publish_date = publish_date;
        
    }
}
