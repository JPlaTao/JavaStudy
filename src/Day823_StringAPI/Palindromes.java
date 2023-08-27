package Day823_StringAPI;

import java.util.Objects;

public class Palindromes {

    public static void main(String[] args) {
        System.out.println(isPalindromes("上海自来水来自海上"));
    }

    public static boolean isPalindromes(String string){

        for (int i = 0; i < string.length()/2; i++) {
            if (!Objects.equals(string.charAt(i),string.charAt(string.length()-1-i))){
                return false;
            }
        }
        return true;
    }
}
        //笨b办法 还是错的
//        for (int i = 0; i < (string.length()/2); i++) {
//            String start = string.substring(0,1);
//            String end = string.substring(string.length()-1,string.length());
//            string = string.substring(1);
//            string = string.substring(0,string.length()-1);
//            if (!start.equals(end)) return false;
//        }
//        return true;
////        System.out.println(string);
////        System.out.println(start);
////        System.out.println(end);


