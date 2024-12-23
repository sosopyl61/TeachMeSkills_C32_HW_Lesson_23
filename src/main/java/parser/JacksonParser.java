package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import constant.Constants;
import exception.ParserException;
import model.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class contains method to get the list of
 * books from json file, using Jackson library.
 */

public class JacksonParser implements Constants {

    public static List<Book> createCollectionFromJson() throws ParserException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Book> books;
        try {
            books = mapper.readValue(new File(Constants.JSON_PATHNAME), mapper.getTypeFactory()
                    .constructCollectionType(List.class, Book.class));
        } catch (IOException e) {
            throw new ParserException("Error: " + e.getMessage());
        }

        return books;
    }
}
