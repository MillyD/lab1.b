package pl.lublin.wsei.java.cwiczenia.myLib;

import org.apache.commons.lang3.StringUtils;

public class StringFun {
    public static String anarchize(String word) {
        String result = "";
        if (Character.isLowerCase(word.charAt(0))) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    result += Character.toUpperCase(word.charAt(i));
                } else {
                    result += Character.toLowerCase(word.charAt(i));
                }
            }
        }
        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    result += Character.toLowerCase(word.charAt(i));
                } else {
                    result += Character.toUpperCase(word.charAt(i));
                }
            }
        }
        return result;
    }

    public static String camelize(String word) {
        String text = word.toLowerCase();
        String[] arr = StringUtils.split(text);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = StringUtils.capitalize(arr[i]);
        }
        return StringUtils.join(arr);
    }

    public static String decamelize(String word) {
        String[] strings = StringUtils.splitByCharacterTypeCamelCase(word);
        return StringUtils.join(strings, " ");
    }

    public static boolean isPalindrome(String word) {
        String a,b;
        if(StringUtils.containsWhitespace(word)) {
            word = StringUtils.deleteWhitespace(word);
        }
        for (int i = 0; i < word.length() / 2; i++) {
            a = String.valueOf(word.charAt(i));
            b = String.valueOf(word.charAt(word.length() - 1 - i));
            if (StringUtils.compareIgnoreCase(a, b) != 0) {
                return false;
            }
        }
        return true;

    }

}
