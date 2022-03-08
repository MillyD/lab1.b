package pl.lublin.wsei.java.cwiczenia;

import org.apache.commons.lang3.StringUtils;
import pl.lublin.wsei.java.cwiczenia.myLib.StringFun;

import java.util.Scanner;

public class CamelizeTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text;
        while(true){
            System.out.println("Podaj tekst do przekształcenia albo zakończ (Q): ");
            text = scan.nextLine();
            if(text.equals("Q")) break;
            System.out.println("Twój tekst to: " + text);
            System.out.println("W notacji camel: " + StringFun.camelize(text));
        }
    }
}
