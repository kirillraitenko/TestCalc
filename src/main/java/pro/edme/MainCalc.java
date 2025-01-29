package pro.edme;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input:");
        String input = in.nextLine();
        String result = calc(input);
        System.out.println("Output:" + result);
    }

    /**
     * Вычислить результат математического выражения
     * @param input
     * @return
     */
    public static String calc(String input) {
        String expression = input.replaceAll(" ", "");
        String[] digits = expression.split("[\\+|\\-|\\*|\\/]");
        if (digits.length != 2) {
            throw new IllegalArgumentException("Input is not correct");
        }

        String signStr = sign(expression);
        EnumCulcOperations operation = EnumCulcOperations.valueOfBySign(signStr);
        int a = Integer.parseInt(digits[0]);
        int b = Integer.parseInt(digits[1]);
        if (a > 10 || b > 10 && a * b != 0) {
            throw new IllegalArgumentException("Input is not correct");
        }
        int res = Objects.requireNonNull(operation).calculate(a, b);
        return "" + res;
    }

    /**
     * Знак выражения
     *
     * @param input
     * @return
     */
    private static String sign(String input) {
        Pattern pattern = Pattern.compile("[\\+|\\-|\\*|\\/]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}