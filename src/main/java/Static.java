/**
 * Created by iranna.patil on 06-07-2016.
 */
public class Static {

    private int a = 10;

    private static int b = 20;

    static {
        System.out.println("a is  b is " + b);
        try {
            try {
                System.out.println(Static.class.getDeclaredField("b").getInt(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public Static(){

        System.out.println("inside constructor a is " +a + " b is " + b);
    }
    public void print() {
        System.out.println("a is " + a + " b is " + b);
    }
}
