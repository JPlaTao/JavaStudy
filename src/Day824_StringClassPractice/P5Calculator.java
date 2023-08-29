package Day824_StringClassPractice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P5Calculator {
    static String patternMutDiv = "(\\d+\\s*[*/]\\s*\\d+)"; // 正则表达式模式匹配乘法和除法算式
    static String patternPluSub = "(\\d+\\s*[+-]\\s*\\d+)";
    static Pattern regexMD = Pattern.compile(patternMutDiv);
    static Pattern regexPS = Pattern.compile(patternPluSub);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入算式：");
        String str = scanner.nextLine();
        System.out.println(calculator(str));
//        System.out.println(calculatorRegex(str));
    }


    public static String result(String str) {
        str.replace(" ", "");
        while (str.contains("*") || str.contains("/")) {
            int index = str.indexOf('*');
            int index2 = str.indexOf('/');
            if (index == -1) {
                index = index2;
            } else if (index > index2) {
                index = index2;
            }
            int leftIndex = index - 1, rightIndex = index + 1;
            while (leftIndex >= 0 && Character.isDigit(str.charAt(leftIndex))) {
                leftIndex--;
            }
            while (rightIndex < str.length() && Character.isDigit(str.charAt(rightIndex))) {
                rightIndex++;
            }
            int leftNum = Integer.parseInt(str.substring(leftIndex + 1, index));
            int rightNum = Integer.parseInt(str.substring(index + 1, rightIndex));
            int result = 0;
            if (str.charAt(index) == '*') {
                result = leftNum * rightNum;
            } else {
                result = leftNum / rightNum;
            }
            str = str.substring(0, leftIndex + 1) + result + str.substring(rightIndex);
        }
        return str;
    }

    public static String calculator(String str) {
        str.replace(" ", "");
        while (str.contains("*") || str.contains("/")) {
            int index = str.indexOf('*');
            int index2 = str.indexOf('/');
            if (index == -1) {
                index = index2;
            } else if (index != -1 && index > index2) {
                index = index2;
            }
            int leftIndex = index - 1, rightIndex = index + 1;
            while (leftIndex >= 0 && Character.isDigit(str.charAt(leftIndex))) {
                leftIndex--;
            }
            while (rightIndex < str.length() && Character.isDigit(str.charAt(rightIndex))) {
                rightIndex++;
            }
            int leftNum = Integer.parseInt(str.substring(leftIndex + 1, index));
            int rightNum = Integer.parseInt(str.substring(index + 1, rightIndex));
            int result = 0;
            if (str.charAt(index) == '*') {
                result = leftNum * rightNum;
            } else {
                result = leftNum / rightNum;
            }
            str = str.substring(0, leftIndex + 1) + result + str.substring(rightIndex);
        }
        while (str.contains("+") || str.contains("-")) {
            int index = str.indexOf('+');
            int index2 = str.indexOf('-', 1);
            if (index == -1) {
                index = index2;
            } else if (index != -1 && index > index2) {
                index = index2;
            }
            if (index == -1) break;
            int leftIndex = index - 1, rightIndex = index + 1;
            while (leftIndex >= 0 && (Character.isDigit(str.charAt(leftIndex)) || str.charAt(leftIndex) == '-')) {
                leftIndex--;
            }
            while (rightIndex < str.length() && Character.isDigit(str.charAt(rightIndex))) {
                rightIndex++;
            }
            int leftNum = Integer.parseInt(str.substring(leftIndex + 1, index));
            int rightNum = Integer.parseInt(str.substring(index + 1, rightIndex));
            int result = 0;
            if (str.charAt(index) == '+') {
                result = leftNum + rightNum;
            } else {
                result = leftNum - rightNum;
            }
            str = str.substring(0, leftIndex + 1) + result + str.substring(rightIndex);
        }
        return str;
    }

    public static StringBuilder calculatorRegex(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        Matcher matcherMD = regexMD.matcher(stringBuilder);
        while (matcherMD.find()) {
            String expression = matcherMD.group(1); // 获取匹配到的算式
            int result = evaluateExpressionMutDiv(expression); // 计算算式结果
            stringBuilder.replace(matcherMD.start(), matcherMD.end(), Integer.toString(result)); // 替换为结果
            matcherMD = regexMD.matcher(stringBuilder);
        }
        Matcher matcherPS = regexPS.matcher(stringBuilder);
        while (matcherPS.find()) {
            String expression = matcherPS.group(1); // 获取匹配到的算式
            int result = evaluateExpressionPluSub(expression); // 计算算式结果
            stringBuilder.replace(matcherPS.start(), matcherPS.end(), Integer.toString(result)); // 替换为结果
            matcherPS = regexPS.matcher(stringBuilder);
        }
        return stringBuilder;
    }

    public static int evaluateExpressionMutDiv(String expression) {
        String[] parts = expression.split("[*/]");
        int operand1 = Integer.parseInt(parts[0].trim());
        int operand2 = Integer.parseInt(parts[1].trim());
        if (expression.contains("*")) {
            return operand1 * operand2;
        } else if (expression.contains("/")) {
            return operand1 / operand2;
        }
        return 0;
    }

    public static int evaluateExpressionPluSub(String expression) {
        String[] parts = expression.split("[+-]");
        int operand1 = Integer.parseInt(parts[0].trim());
        int operand2 = Integer.parseInt(parts[1].trim());
        if (expression.contains("+")) {
            return operand1 + operand2;
        } else if (expression.contains("-")) {
            return operand1 - operand2;
        }
        return 0;
    }

}
