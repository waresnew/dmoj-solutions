import java.io.*;
import java.util.*;

// 5/30/2022

@SuppressWarnings("DuplicatedCode")
public class Cameras {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfHouses = readInt(), numberOfCameras = readInt(), interval = readInt();
        boolean[] houses = new boolean[numberOfHouses];
        ArrayList<Integer> cameras = new ArrayList<>(numberOfCameras);
        for (int i = 0; i < numberOfCameras; i++) {
            int index = readInt() - 1;
            houses[index] = true;
            cameras.add(index);
        }

        Collections.sort(cameras);
        int ans = 0;
        for (int i = 0; i <= houses.length - interval; i++) {
            int currentCameras = floorBinarySearch(cameras, i+interval-1)-ceilBinarySearch(cameras, i) +1;
            if (numberOfCameras == 0) {
                currentCameras = 0;
            }
            if (currentCameras ==1) {
                if (!houses[i + interval - 1]) {
                    houses[i + interval - 1] = true;
                    cameras.add(-Collections.binarySearch(cameras, i+interval-1)-1, i+interval-1);
                    ans++;
                    numberOfCameras++;
                } else {
                    houses[i + interval - 2] = true;
                    cameras.add(-Collections.binarySearch(cameras, i+interval-2)-1, i+interval-2);
                    ans++;
                    numberOfCameras++;
                }
            } else if (currentCameras == 0) {
                houses[i + interval - 1] = true;
                houses[i + interval - 2] = true;
                cameras.add(-Collections.binarySearch(cameras, i+interval-1)-1, i+interval-1);
                cameras.add(-Collections.binarySearch(cameras, i+interval-2)-1, i+interval-2);
                ans+=2;
                numberOfCameras+=2;

            }
        }
        pr.println(ans);
        pr.close();
    }
    private static int floorBinarySearch(ArrayList<Integer> a, int key) {
        int low = 0, high = a.size()-1, ans = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (a.get(mid) > key) {
                high = mid-1;
            } else if (a.get(mid) < key) {
                low = mid+1;
                ans = mid;
            } else {
                return mid;
            }
        }
        return ans;
    }

    private static int ceilBinarySearch(ArrayList<Integer> a, int key) {
        int low = 0, high = a.size()-1, ans = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (a.get(mid) > key) {
                high = mid-1;
                ans = mid;
            } else if (a.get(mid) < key) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return ans;
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