import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 5/30/2022

@SuppressWarnings("DuplicatedCode")
public class Eko {
    private static int trees[];
    private static int target;

    public static void main(String[] args) throws IOException {
        Scanner stupidScanner = new Scanner(System.in);
        int numberOfTrees = stupidScanner.nextInt();
        target = stupidScanner.nextInt();
        trees = new int[numberOfTrees];
        for (int i = 0; i < numberOfTrees; i++) {
            trees[i] = stupidScanner.nextInt();
        }
        int low = 1, high = (int) 1e9;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int height) {
        long wood = 0;
        for (int tree : trees) {
            if (tree > height) {
                wood += tree - height;
            }
        }
        return wood >= target;
    }
    
}