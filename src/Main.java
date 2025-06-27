import java.util.Scanner;
import java.io.FileInputStream;

class Main
{
    static char [][] sentence = new char[100][100];

    static boolean isPalindromeRow (char[] row, int start, int len) {
        int end = start + len - 1;
        for (int i = 0; i < len / 2; i++) {
            if (row[start +i] != row[end -i]) return false;
        }
        return true;
    }

    static boolean isPalindromeCol (int col, int start, int len) {
        int end = start + len - 1;
        for (int i = 0; i < len / 2; i++) {
            if(sentence[start+i][col] != sentence[end -i][col]) return false;
        }
        return true;
    }

    static int findLongestPalindrome() {
        int maxLen =1;

        //행검사
        for(int row=0 ; row<100 ; row++) {
            for(int start=0 ; start <100; start++) {
                for(int end = 100-1 ; end >= start ; end --) {
                    int len =end-start +1;

                    if(len <= maxLen) break;

                    if(isPalindromeRow(sentence[row], start, len)) {
                        maxLen = len;
                        break;
                    }
                }
            }
        }

        //열검사
        for(int col=0; col<100 ; col++) {
            for(int start=0 ; start <100 ; start++) {
                for(int end=100-1 ; end >= start ; end --) {
                    int len =end-start +1;
                    if(len <= maxLen) break;

                    if(isPalindromeCol(col, start, len)) {
                        maxLen = len;
                        break;
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt();
            sc.nextLine();

            for(int i=0 ; i<sentence.length ; i++) {
                String line = sc.nextLine();
                sentence[i] = line.toCharArray();
            }

            int max = findLongestPalindrome();
            System.out.printf("#%d %d\n", tc, max);


        }//for testcase

    } //public method
}