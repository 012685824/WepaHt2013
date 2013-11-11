/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import org.springframework.web.client.RestTemplate;
import wad.template.domain.BookItems;

import org.springframework.stereotype.Service;

/**
 *
 * @author trantane
 */
@Service
public class RestBookItemsService implements BookItemsService {

    private RestTemplate rest;

    /*
     @PostConstruct
     private void init() {
     restTemplate = new RestTemplate();
     restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
     }

     @Override
     public BookItems listBook() {
     return restTemplate.getForObject("https://openlibrary.org/api/books?bibkeys=ISBN:0385472579&format=json", BookItems.class);
     }*/
    @Override
    public BookItems listBook(String isbn) {


        rest = new RestTemplate();
        BookItems bookItems = null;
        String parseJson = "";
        String apu = "";
        String apu2 = "";
        String name = "\"Ei nimeä\"";
        String authors = "\"\"";
        String publishers = "\"\"";
        String publish_date = "\"\"";
        String cover = "\"\"";
        int laskuri = 0;
        String apuJono = "";


 
        String json = rest.getForObject("http://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=data&format=json", String.class);
        //String json =  ""; 
        
        
        System.out.println("json" + json + "pituus:" + json.length());
        if (json.length() < 5) {
        } else {

            apu = json.substring(json.lastIndexOf("{\"publishers\": [{\"name\": "));
            System.out.println("apu:" + apu);
            for (int i = 0; i < apu.length(); i++) {
                char merkki = apu.charAt(i);
                if (merkki == '{') {
                    laskuri++;
                }

                if (laskuri == 1) {
                    apuJono += merkki;
                }
                if (merkki == '}') {
                    laskuri--;
                }
            }
            System.out.println("apuJono:" + apuJono);



            publishers = json.substring((json.lastIndexOf("{\"publishers\": [{\"name\": ") + 25), json.indexOf("\"}],") + 1);
            System.out.println("pub:" + publishers);


            apu2 = apuJono.substring(apuJono.indexOf("title") + 8);
            name = apu2.substring(0, (apu2.indexOf("\", \"")) + 1);

            apu = json.substring((json.indexOf("publish_date") + 14));
            publish_date = apu.substring(0, (apu.indexOf("key") - 3));



            if (json.indexOf("authors") == -1) {
            } else {
                apu = json.substring((json.indexOf("authors")));
                authors = apu.substring((apu.indexOf("name") + 6), (apu.indexOf("by_statement") - 5));
            }
                        if (json.indexOf("\"medium\":") == -1) {
            } else {
                apu = json.substring((json.indexOf("\"medium\":") + 10));
                cover = apu.substring(0,(apu.indexOf("\"subjects\":") - 3));
            }
            
        }
        parseJson = "{\"publishers\": " + publishers + " , \"name\": " + name + " , \"publish_date\":" + publish_date +
                ", \"authors\": " + authors + ",\"cover\": "+cover+ "}";
        System.out.println("par" + parseJson);

        ObjectMapper mapper = new ObjectMapper();
        try {
            bookItems = mapper.readValue(parseJson, BookItems.class);


        } catch (IOException ex) {
            Logger.getLogger(RestBookItemsService.class.getName()).log(Level.SEVERE, null, ex);
        }


        return bookItems;

    }
}
