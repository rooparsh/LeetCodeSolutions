package random;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        final Stack<Integer> stack = new Stack<>();
        final String[] directories = input.split("\n");
        int maxLength = 0;

        stack.push(0);

        for (final String directory : directories) {
            final int level = directory.lastIndexOf("\t") + 1;

            while (stack.size() > level + 1) {
                stack.pop();
            }

            stack.push(stack.peek() + directory.length() - level + 1);

            if (directory.contains(".")) {
                maxLength = Math.max(stack.peek() - 1, maxLength);
            }
        }
        return maxLength;

    }
}
