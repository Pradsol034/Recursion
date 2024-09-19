import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args) {
        String str = "105";
        int target = 5;
        System.out.println(addOperators(str, target));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        // Start the recursive process by passing initial values
        Subsequence("", num, target, 0, 0, ans);
        return ans;
    }

    public static void Subsequence(String path, String num, int target, long calc, long tail, List<String> ans) {
        if (num.isEmpty()) {
            if (calc == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            long currNum = Long.parseLong(currStr);

            // Handle numbers with leading zeros (skip multi-digit numbers starting with zero)
            if (currStr.length() > 1 && currStr.charAt(0) == '0') {
                break;
            }

            String remainingStr = num.substring(i);

            if (path.isEmpty()) {
                // If it's the first number, we simply start the expression with it
                Subsequence(currStr, remainingStr, target, currNum, currNum, ans);
            } else {
                // Addition
                Subsequence(path + "+" + currStr, remainingStr, target, calc + currNum, currNum, ans);
                // Subtraction
                Subsequence(path + "-" + currStr, remainingStr, target, calc - currNum, -currNum, ans);
                // Multiplication
                Subsequence(path + "*" + currStr, remainingStr, target, calc - tail + tail * currNum, tail * currNum, ans);
            }
        }
    }
}
