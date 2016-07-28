package generics;

import javafx.scene.chart.NumberAxis;

import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Created by iranna.patil on 18-07-2016.
 */
public abstract class AbstractAddition {

    public <T extends Number> Supplier add(T number1, T number2) {
        return specificAdd(number1,number2);
    }

    public abstract <T extends Number> Supplier  specificAdd(T number1,T number2);


}
