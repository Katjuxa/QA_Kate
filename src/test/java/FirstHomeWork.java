import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstHomeWork {

    private double percent (double a, Integer b) {
//        a is number, b is percent
        return a * b / 100;
    }

    private double fuel(double l, double km) {
//      l is liter, km is kilometer
        return l * 100 / km;
    }

    private Integer count(String str, char y) {
        int length = str.length(); //длина строки
        char searchChar = y; //поиск заданного символа
        boolean isFound = false;
        Integer w = 0;
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) == searchChar) {
                isFound = true;
                w = ++w;
            }
        }

        return w;

    }



    @Test
    public void showResult() {
        double p;
        double f;
        Integer z;
        p = percent(7, 20);
        f = fuel(50, 750);
        z = count("Happy New Year, Yeeeah",'e');

        System.out.println("20% from 7 is:" + p);
        System.out.println("Fuel consumption is:" + f);
        System.out.println("In text is " + z + " symbols");

        Assertions.assertEquals(1.4, p, "Houston, we have a problem");
        Assertions.assertEquals(6.666666666666667, f, "Something is going wrong");
        Assertions.assertEquals(5, z, "Oh no, result is wrong");
    }
}
