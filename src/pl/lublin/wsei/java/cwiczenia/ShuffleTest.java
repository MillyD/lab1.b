package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StringFun;

import java.util.Scanner;

public class ShuffleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("Podaj słowo lub Q aby zakończyć");
            str = scanner.nextLine();
            if (str.equals("Q")) break;
            System.out.println("Podany ciąg: " + str);
            System.out.println("Rezultat shuffle(): " + StringFun.shuffle(str));
        }
    }
}
