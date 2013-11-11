/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.service;

import java.util.List;

import wad.template.domain.BookItems;

/**
 *
 * @author trantane
 */

public interface BookItemsService{
    BookItems listBook(String isbn);
}
