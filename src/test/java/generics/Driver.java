package generics;

/**
 * Created by iranna.patil on 18-07-2016.
 */
public class Driver {

    public static void main(String[] args) {
        IntegreAdd add = new IntegreAdd();
        System.out.println(add.add(1,1).get());
    }
}
