package generics;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Created by iranna.patil on 18-07-2016.
 */
public class IntegreAdd extends AbstractAddition {


    @Override
    public <T extends Number> Supplier specificAdd(T number1, T number2) {
        return () -> Integer.valueOf(number1.intValue() + number2.intValue());
    }
}
