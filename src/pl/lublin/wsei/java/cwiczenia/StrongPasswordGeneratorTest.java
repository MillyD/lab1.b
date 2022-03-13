package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.myLib.StrongPasswordGenerator;

import java.util.Scanner;


public class StrongPasswordGeneratorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length;
        String choice;
        boolean lower,upper,digits,chars;
        String allowedChars="";
        System.out.println("Skonfiguruj swoje hasło");
        System.out.println("podaj długość: ");
        length = scan.nextInt();
        System.out.println("czy ma się składać z małych liter? t/n");
        scan.nextLine();
        choice = scan.nextLine();
        lower = choice.equals("t");
        System.out.println("czy ma się składać z dużych liter? t/n");
        choice = scan.nextLine();
        upper = choice.equals("t");
        System.out.println("czy ma mieć liczby? t/n");
        choice = scan.nextLine();
        digits = choice.equals("t");
        System.out.println("czy ma posiadać symbole? t/n");
        choice = scan.nextLine();
        chars = choice.equals("t");
        if(chars){
            System.out.println("Podaj dozwolone znaki: ");
            allowedChars = scan.nextLine();
        }
        System.out.println("Twoje hasło: " + new StrongPasswordGenerator(length,lower, upper, digits,chars, allowedChars).generate());

    }
}
