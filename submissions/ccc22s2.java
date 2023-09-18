import java.io.*;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class GoodGroups {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


    private static class Group {
        private final String[] people = new String[3];
        private final TreeSet<String> peopleSet = new TreeSet<>();

        private Group(String person1, String person2, String person3) {
            people[0] = person1;
            people[1] = person2;
            people[2] = person3;
            peopleSet.add(person1);
            peopleSet.add(person2);
            peopleSet.add(person3);
        }

        @Override
        public String toString() {
            return "Group{" +
                    "people=" + Arrays.toString(people) +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfSameGroupings = Integer.parseInt(next());
        TreeMap<String, TreeSet<String>> same = new TreeMap<>();
        for (int i = 0; i < numberOfSameGroupings; i++) {
            String person1 = next(), person2 = next();
            same.putIfAbsent(person1, new TreeSet<>());
            same.get(person1).add(person2);
        }
        int numberOfDiffGroupings = Integer.parseInt(next());
        TreeMap<String, TreeSet<String>> diff = new TreeMap<>();
        for (int i = 0; i < numberOfDiffGroupings; i++) {
            String person1 = next(), person2 = next();
            diff.putIfAbsent(person1, new TreeSet<>());
            diff.get(person1).add(person2);
        }
        int numberOfGroups = Integer.parseInt(next());
        Group[] groups = new Group[numberOfGroups];
        for (int i = 0; i < numberOfGroups; i++) {
            groups[i] = new Group(next(), next(), next());
        }
        int answer = 0;
        for (Group group : groups) {
            for (int i = 0; i < 3; i++) {
                TreeSet<String> mustBeWith = same.get(group.people[i]);
                TreeSet<String> mustAvoid = diff.get(group.people[i]);
                if (mustBeWith != null) {
                    for (String person : mustBeWith) {
                        if (!group.peopleSet.contains(person)) {
                            answer++;
                        }
                    }
                }
                if (mustAvoid != null) {
                    for (int j = 0; j < 3; j++) {
                        if (mustAvoid.contains(group.people[j])) {
                            answer++;
                        }
                    }
                }
            }
        }
        pr.println(answer);
        pr.close();

    }


    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }
}