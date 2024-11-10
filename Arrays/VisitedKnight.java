package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class VisitedKnight {
    private static final int[][] DIRECTIONS = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, // moves for the knight
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public static int minKnightMoves(int N, int startX, int startY, int targetX, int targetY) {

        if (startX == targetX && startY == targetY) {
            return 0;
        }

        //queue to store row column and index
        Queue<int[]> queue = new LinkedList<>();
        //to track if that row and column is already visited
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{startX, startX, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int distance = current[2];

            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                if (newX == targetX && newY == targetY) {
                    return distance + 1;
                }
                if (isValidMove(newX, newY, N) && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, distance});
                    visited[newX][newY] = true;
                }

            }
        }
        return -1;


    }

    private static boolean isValidMove(int newX, int newY, int n) {
        return newX >= 0 && newX < n && newY >= 0 && newY < n;
    }
}
