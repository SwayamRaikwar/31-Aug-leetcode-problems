import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Treat the area past the last bar as height 0 to pop remaining bars
            int currentHeight = (i == n) ? 0 : heights[i];

            // Maintain a monotonic increasing stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // Calculate width: if stack is empty, width extends from 0 to i
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
