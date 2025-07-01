package found_load;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution
{
    static boolean [] visited;
    static ArrayList<Integer>[] graph;
    static boolean found;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt();
            int edgeCount = sc.nextInt();

            graph = new ArrayList[100];
            visited = new boolean[100];
            found = false;

            for (int i=0 ; i< 100 ; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<edgeCount ; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from].add(to);
            }

            dfs(0);

            System.out.printf("#%d %d\n", test_case, found ? 1 : 0);

        } //test_case
    }// psvm

    static void dfs (int cur) {
        if(cur == 99) {
            found = true;
            return;
        }

        visited[cur] = true;

        for(int next : graph[cur]){
            if ( !visited[next]) {
                dfs(next);
            }
        }


    }

}