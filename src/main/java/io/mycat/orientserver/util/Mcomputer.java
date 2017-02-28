package io.mycat.orientserver.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiang on 2017/2/28 0028.
 */
public class Mcomputer {
    private static List<Character> op1 = Arrays.asList('+', '-');
    private static List<Character> op2 = Arrays.asList('*', '/', '%');
    private static List<Character> opnnn = Arrays.asList('(', ')');

    /**
     * Compute double.计算器，比如，3，3+4，等
     *
     * @param exp the exp
     * @return the double
     */
    public static double compute(String exp) {
        if (exp.contains("(")) {
            exp = dimissc(exp);//消除括号
        }
        return computeno(exp);
    }

    private static double computeno(String exp) {//没有括号
        boolean error = false;
        double re = 0;
        try {
            re = Double.parseDouble(exp);
        } catch (Exception e) {
            error = true;
        }
        if (!error) {
            return re;
        }
        int index = exp.indexOf("+");
        if (index != -1) {
            return computeno(exp.substring(0, index)) + computeno(exp.substring(index + 1));
        }
        index = exp.indexOf("-");
        if (index != -1) {
            return computeno(exp.substring(0, index)) - computeno(exp.substring(index + 1));
        }
        index = exp.indexOf("*");
        if (index != -1) {
            return computeno(exp.substring(0, index)) * computeno(exp.substring(index + 1));
        }
        index = exp.indexOf("/");
        if (index != -1) {
            return computeno(exp.substring(0, index)) / computeno(exp.substring(index + 1));
        }
        return 0;
    }

    private static String dimissc(String exp) {//去掉括号 (1+(1+2)+2)+((1+2))
        int start = exp.lastIndexOf("(");
        int end = -1;
        while (start != -1) {
            end = exp.indexOf(")", start);
            exp = exp.substring(0, start) + computeno(exp.substring(start + 1, end)) + exp.substring(end + 1);
            start = exp.lastIndexOf("(");
        }
        return exp;
    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(dimissc("(1+(1+2)+2)+((1+2))"));
        System.out.println(compute("(1+(1+2)+2)+((1+2))"));
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            System.out.println(compute(input));
        }
    }
}
