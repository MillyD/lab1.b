package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StringFun;

import java.util.Scanner;

public class DecamelizeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true){
            System.out.println("Podaj ciąg znaków w notacji camel, lub Q aby zakończyć");
            str = scanner.nextLine();
            if(str.equals("Q")) break;
            System.out.println("Podany ciąg: " + str);
            System.out.println("Rezultat decamelize(): " + StringFun.decamelize(str));
        }

    }
}
