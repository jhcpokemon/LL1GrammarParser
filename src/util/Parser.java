package util;

import model.Rule;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jhcpokemon on 06/05/15.
 */
public class Parser {
    static Stack<Character> enterStack = new Stack<>();
    static Stack<Character> analyseStack = new Stack<>();
    static ArrayList<Rule> rules = Rule.getRules();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();
    static ArrayList<StringBuilder> sbs = new ArrayList<>();
    static Rule rule = new Rule("", "", "");
    static final int start = 0;
    static final int success = 1;
    static final int equal = 2;
    static final int pattern = 3;
    static final int error = 4;
    static int current_state;

    public static ArrayList<StringBuilder> startParse(String waitForParse) {
        sbs.add(0, sb1);
        sbs.add(1, sb2);
        sbs.add(2, sb3);
        current_state = start;
        for (StringBuilder sb : sbs) {
            sb.setLength(0);
        }
        enterStack.clear();
        analyseStack.clear();
        enterStack.push('#');
        analyseStack.push('#');
        analyseStack.push('E');
        waitForParse = new StringBuilder(waitForParse).reverse().toString();
        for (Character c : waitForParse.toCharArray()) {
            enterStack.push(c);
        }
        while ((enterStack.size() > 0) && (analyseStack.size() > 0)) {
            switch (current_state) {
                case start://0
                    if (judgePeekEqual()) {
                        peekEqual();
                        current_state = equal;//2
                    } else if (patternRule()) {
                        current_state = pattern;//3
                    } else if (judgeSuccess()) {
                        current_state = success;//1
                    } else {
                        current_state = error;//4
                    }
                    break;
                case equal://2
                    if (judgePeekEqual()) {
                        peekEqual();//2
                    } else if (patternRule()) {
                        showPattern();
                        current_state = pattern;//3
                    } else if (judgeSuccess()) {
                        current_state = success;//1
                    } else {
                        current_state = error;//4
                    }
                    break;
                case pattern://3
                    if (patternRule()) {
                        showPattern();
                        //2
                    } else if (judgePeekEqual()) {
                        peekEqual();
                        current_state = equal;//3
                    } else if (judgeSuccess()) {
                        current_state = success;
                    } else {
                        current_state = error;
                    }
                    break;
                case success://1
                    output();
                    sb3.append("成功");
                    clearStack();
                    break;
                case error://4
                    output();
                    sb3.append("失败");
                    clearStack();
                    break;
            }
        }
        return sbs;
    }


    public static void peekEqual() {
        output();
        sb3.append("\n");
        popStack();
    }

    public static void showPattern() {
        output();
        analyseStack.pop();
        String ruler = rule.getRuler();
        String[] strings = ruler.split("\u2192");
        String right = new StringBuilder(strings[1]).reverse().toString();
        if (!right.equals("\u03b5")) {
            for (Character c : right.toCharArray()) {
                analyseStack.push(c);
            }
        }
        sb3.append(ruler + "\n");
    }

    public static boolean judgePeekEqual() {
        return ((analyseStack.peek().equals(enterStack.peek())) && !(analyseStack.peek().equals('#')));
    }

    public static boolean judgeSuccess() {
        return ((enterStack.peek().equals('#')) && (analyseStack.peek().equals('#')));
    }

    public static boolean patternRule() {
        boolean result = false;
        for (Rule rule : rules) {
            if ((analyseStack.peek().toString().equals(rule.getTopInAnalyse())) && (enterStack.peek().toString().equals(rule.getTopInEnter()))) {
                Parser.rule = rule;
                result = true;
            }
        }
        return result;
    }

    public static String printStack(Stack<Character> stack) {
        return stack.toString().replaceAll("(?:,|\\[|\\]|)", "").replaceAll(" ", "");
    }

    public static String reverseStack(Stack<Character> stack) {
        return new StringBuilder(printStack(stack)).reverse().toString();
    }

    public static void output() {
        sb1.append(printStack(analyseStack) + "\n");
        sb2.append(reverseStack(enterStack) + "\n");
    }

    public static void clearStack() {
        enterStack.clear();
        analyseStack.clear();
    }

    public static void popStack() {
        enterStack.pop();
        analyseStack.pop();
    }
}
