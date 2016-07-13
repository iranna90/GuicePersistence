package guice;

import javax.persistence.AttributeConverter;
import javax.swing.text.StringContent;

/**
 * Created by iranna.patil on 03-07-2016.
 */
@javax.persistence.Converter
public class Converter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        return s + "|helo";
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s.split("|")[0];
    }
}
