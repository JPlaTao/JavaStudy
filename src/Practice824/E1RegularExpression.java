package Practice824;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1RegularExpression {

    private static Matcher matcher;

    public static void main(String[] args) {
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        String text = "hello 123 world";
        Matcher matcher = pattern.matcher(text);
        System.out.print(text + "匹配结果是：");
        while(matcher.find())
        {
            System.out.print(matcher.group());
        }
    }
}
