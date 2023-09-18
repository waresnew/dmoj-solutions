import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Template generated on 2022-01-21

public class OnlineShopping {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class ItemStack implements Comparable<ItemStack> {
        private final String item;
        private final int price;
        private int amount;

        private ItemStack(String item, int price, int amount) {
            this.item = item;
            this.price = price;
            this.amount = amount;
        }

        @Override
        public int compareTo(ItemStack o) {
            if (item.equals(o.item)) {
                return Integer.compare(price, o.price);
            }
            return item.compareTo(o.item);
        }

        @Override
        public String toString() {
            return "ItemStack{" +
                    "item='" + item + '\'' +
                    ", price=" + price +
                    ", amount=" + amount +
                    '}';
        }
    }

    private static class Instruction {
        private final String item;
        private int amount;

        private Instruction(String item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Instruction{" +
                    "item='" + item + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfCases = readInt();
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfStores = readInt();
            ArrayList<ItemStack> itemStacks = new ArrayList<>();
            for (int j = 0; j < numberOfStores; j++) {
                int numberOfItems = readInt();
                for (int k = 0; k < numberOfItems; k++) {
                    itemStacks.add(new ItemStack(next(), readInt(), readInt()));
                }
            }
            int numberOfDesiredItems = readInt();
            Instruction[] instructions = new Instruction[numberOfDesiredItems];
            for (int j = 0; j < numberOfDesiredItems; j++) {
                instructions[j] = new Instruction(next(), readInt());
            }
            Collections.sort(itemStacks);
            int moneySpent = 0;
            label:
            for (Instruction instruction : instructions) {
                for (ItemStack itemStack : itemStacks) {
                    if (itemStack.item.equals(instruction.item)) {
                        if (itemStack.amount >= instruction.amount) {
                            itemStack.amount -= instruction.amount;
                            moneySpent += instruction.amount * itemStack.price;
                            continue label;
                        } else {
                            instruction.amount -= itemStack.amount;
                            moneySpent += itemStack.amount * itemStack.price;
                            itemStack.amount = 0;
                            if (instruction.amount == 0) {
                                continue label;
                            }
                        }
                    }
                }
            }
            pr.println(moneySpent);
        }
        pr.close();
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
        return bufferedReader.readLine().trim();
    }
}