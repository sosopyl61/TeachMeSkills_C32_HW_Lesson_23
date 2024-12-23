import exception.ParserException;
import parser.DomParser;
import parser.JacksonParser;
import parser.JaxbParser;
import model.Book;

import java.util.List;

/**
 * This is an application runner class.
 * Task:
 * 1. Using the Jackson library, write a Java program that parses a JSON file (books.json)
 *    and saves the data to a Java collection.
 * 2. Convert the data from this collection to XML using the JAXB library.
 *    Save the resulting XML to a file.
 * 3. Using any parser (DOM, SAX, StAX), parse the data in a Java application and output to the console
 *    information about the book with the largest number of pages.
 */

public class Runner {
    public static void main(String[] args) {
        try {
            List<Book> books = JacksonParser.createCollectionFromJson();
            JaxbParser.saveCollectionToXml(books);
            DomParser.parseXMLAndOutputBookWithMostPages();
        }
        catch (ParserException e) {
            System.out.println(e.getMessage());
        }
    }
}
