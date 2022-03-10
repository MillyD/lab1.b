package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StringFun;

import java.io.PrintStream;
import java.util.Scanner;

public class IsPalindromeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;

        do {
            System.out.println("Czy to palindrom? Jakie słowo sprawdzić?");
            word = scanner.nextLine();
            if (StringFun.isPalindrome(word)) {
                System.out.printf("Słowo \"%s\" JEST palindromem\n", word);
            } else {
                System.out.printf("Słowo \"%s\" NIE JEST palindromem\n", word);
            }
            System.out.println("Wciśnij [q] aby zamknąć lub [enter] aby kontynuować");
            word = scanner.nextLine();
        } while (!word.equals("q"));
    }
}
