package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StrongPasswordGenerator;


public class StrongPasswordGeneratorTest {
    public static void main(String[] args) {
        String password = new StrongPasswordGenerator(
                10
                ,true,
                false,
                true
                ,false,
                "&!#").generate();
        System.out.println(password);

    }
}
