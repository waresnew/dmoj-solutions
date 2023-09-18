import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// 5/1/2022

@SuppressWarnings("DuplicatedCode")
public class Alchemy {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int inventory[];
    private static HashMap<Integer, ArrayList<Integer>> recipes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int target = readInt();
        inventory = new int[target];
        for (int i = 0; i < target; i++) {
            inventory[i] = readInt();
        }
        int numberOfRecipes = readInt();
        for (int i = 0; i < numberOfRecipes; i++) {
            int key = readInt() - 1, numberOfMaterials = readInt();
            recipes.put(key, new ArrayList<>());
            for (int j = 0; j < numberOfMaterials; j++) {
                recipes.get(key).add(readInt() - 1);
            }
        }

        int ans = 0;
        while (canMake(target - 1)) {
            ans++;
        }
        pr.println(ans);
        pr.close();

    }

    private static boolean canMake(int type) {
        if (inventory[type] > 0) {
            inventory[type]--;
            return true;
        }
        if (inventory[type] == 0 && !recipes.containsKey(type)) {
            return false;
        }
        for (int material : recipes.get(type)) {
            if (!canMake(material)) {
                return false;
            }
        }
        return true;
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        return stringTokenizer.nextToken();
    }

    @SuppressWarnings("unused")
    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    @SuppressWarnings("unused")
    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    @SuppressWarnings("unused")
    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /*
    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    */

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}