import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class GStack<T> {
    List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() == 0) return null;
        return list.remove(list.size() - 1);
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}


public class Main {
    static GStack<String> stringStack = new GStack<>();
    static GStack<Double> doubleGStack = new GStack<>();

    public static void main(String[] args) {
        String exp = "2.0*3.0-((4.0+5.0)*2.0)-4.0=";
        String postfix = getPostfix(exp);
        double evaluation = getEvaluation(postfix);
        System.out.println("postfix = " + postfix);
        System.out.println("evaluation = " + evaluation);
    }

    private static double getEvaluation(String exp) {
        List<Character> operations = Arrays.asList('+', '-', '*', '/');

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (!operations.contains(c)) {
                int cnt = 0;
                StringBuilder buffer = new StringBuilder();
                while (cnt < 3) {
                    buffer.append(exp.charAt(i + cnt));
                    cnt++;
                }
                doubleGStack.push(Double.parseDouble(buffer.toString()));
                i += 2;
                continue;
            }

            switch (c) {
                case '+':
                    doubleGStack.push(doubleGStack.pop() + doubleGStack.pop());
                    break;
                case '-':
                    double a = doubleGStack.pop();
                    double b = doubleGStack.pop();
                    doubleGStack.push(b - a);
                    break;
                case '*':
                    doubleGStack.push(doubleGStack.pop() * doubleGStack.pop());
                    break;
                case '/':
                    doubleGStack.push(doubleGStack.pop() / doubleGStack.pop());
                    break;
            }
        }
        return doubleGStack.pop();
    }

    private static String getPostfix(String exp) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(exp, "+-*/()=", true);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("=")) break;
            int priority = getPriority(s);

            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stringStack.isEmpty() && getPriority(stringStack.peek()) >= priority) {
                        answer.append(stringStack.pop());
                    }
                    stringStack.push(s);
                    break;
                case "(":
                    stringStack.push(s);
                    break;
                case ")":
                    while (!stringStack.isEmpty() && !stringStack.peek().equals("(")) {
                        answer.append(stringStack.pop());
                    }
                    stringStack.pop();  // '(' 제거
                    break;
                default:  // operand
                    answer.append(s);
                    doubleGStack.push(Double.parseDouble(s));
            }
        }
        while (!stringStack.isEmpty()) {
            answer.append(stringStack.pop());
        }
        return answer.toString();
    }

    public static int getPriority(String s) {
        switch (s) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }
}