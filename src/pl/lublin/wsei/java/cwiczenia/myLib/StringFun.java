package pl.lublin.wsei.java.cwiczenia.myLib;

public class StringFun {
  public static String anarchize(String word){
      String result = "";
      if(Character.isLowerCase(word.charAt(0))){
          for (int i = 0; i<word.length(); i++){
              if (i%2 == 0){
                  result+=Character.toUpperCase(word.charAt(i));
              }
              else {
                  result += Character.toLowerCase(word.charAt(i));
              }
          }
      }
      if(Character.isUpperCase(word.charAt(0))){
          for (int i = 0; i<word.length(); i++){
              if (i%2 == 0){
                  result += Character.toLowerCase(word.charAt(i));
              }
              else {
                  result+=Character.toUpperCase(word.charAt(i));
              }
          }
      }
      return result;
  }


}
