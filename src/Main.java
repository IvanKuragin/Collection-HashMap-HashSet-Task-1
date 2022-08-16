import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static String text = "Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et " +
            "dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex " +
            "ea commodo consequat. Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore " +
            "eu fugiat nulla pariatur. Excepteur sint occaecat " +
            "cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    protected static Map<Character, Integer> checker = new HashMap<>();

    public static void main(String[] args) {
        String text1 = text.toLowerCase();

        for (int i = 0; i < text1.length(); i++) {
            char c = text1.charAt(i);
            if (checker.containsKey(c)) {
                int index = checker.get(c);
                checker.put(c, index + 1);
            } else {
                checker.put(c, 1);
            }
        }
        checker.remove(' ');
        checker.remove('.');
        checker.remove(',');
        System.out.println(checker);
        System.out.println((Max()));
        System.out.println((Min()));
    }

    public static char Max() {
        char maxChar = ' ';
        int max = 0;
        for (int value : checker.values()) {
            if (value > max) {
                max = value;
                for (char character : checker.keySet()) {
                    int values = checker.get(character);
                    if (values == value) {
                        maxChar = character;
                    }
                }
            }
        }
        return maxChar;
    }

    public static char Min() {
        char minChar = ' ';
        int min = Integer.MAX_VALUE;
        for (int value : checker.values()) {
            if (value < min) {
                min = value;
                for (char character : checker.keySet()) {
                    int values = checker.get(character);
                    if (values == value) {
                        minChar = character;
                    }
                }
            }
        }
        return minChar;
    }
}
