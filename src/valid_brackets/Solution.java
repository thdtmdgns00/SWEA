package valid_brackets;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            boolean isValid = check(str);
            System.out.printf("#%d %d\n", test_case, isValid ? 1: 0) ;
        }
    }

    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            //여는 괄호
            if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                stack.push(ch);
            }
            //닫는 괄호
            else if (ch == ')' || ch == '}' || ch == ']' || ch == '>') {
                if (stack.isEmpty()) return false;

                char top =stack.pop();
                if (!isMatching(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}') ||
                (open == '<' && close == '>');
    }

}