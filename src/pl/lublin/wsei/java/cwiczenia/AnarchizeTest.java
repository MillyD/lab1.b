package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StringFun;

import java.util.Scanner;

public class AnarchizeTest {

    public static void main(String[] args) {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj słowo do do zmiany: ");
            String word = scan.nextLine();
            if (word.equals("0")) break;
            System.out.println("Wprowadzone słowo: " + word);
            System.out.println("Słowo po zmianie wielkości liter: " + StringFun.anarchize(word));
        }
    }
}
