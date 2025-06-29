import java.util.Scanner;

class Solution
{
    static int multiple (int a, int b) {
        if( b > 0) {
            return a * multiple(a, b - 1);
        } else {
            return 1;
        }

    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt();

            int a=sc.nextInt();
            int b=sc.nextInt();

            int result = multiple(a,b);

            System.out.printf("#%d %d\n" ,test_case,result);

        }
    }
}