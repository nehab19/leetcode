package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {

        // Directions array representing the 8 possible knight moves
        private final int[][] directions = {
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };


        // Memoization map to store computed probabilities for specific states
        private Map<String, Double> memo = new HashMap<>();

        // Helper function that recursively calculates the probability of the knight staying on the board
        private double helper(int N, int K, int row, int col) {
            // If the knight is out of bounds, return 0 (impossible to stay on board)
            if (row < 0 || row >= N || col < 0 || col >= N) {
                return 0;
            }

            // If no more moves left, the knight is still on the board, so return 1
            if (K == 0) {
                return 1;
            }

            // Generate a unique key for the current state (K, row, col)
            String key = K + "_" + row + "_" + col;

            // Check if the result is already memoized
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            double probabilitySum = 0;
            // Explore all 8 possible moves for the knight
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                // Recursively calculate the probability for the next move
                probabilitySum += helper(N, K - 1, newRow, newCol);
            }

            // Store the computed probability in the memoization map
            double probability = probabilitySum / 8.0;
            memo.put(key, probability);

            return probability;
        }

        // Main function to calculate the knight's probability of staying on the board after K moves
        public double knightProbability(int N, int K, int row, int column) {
            return helper(N, K, row, column);
        }

        // Test case
        public static void main(String[] args) {
            KnightProbability solution = new KnightProbability();
            int N = 8;      // Chessboard size NxN
            int K = 3;      // Number of moves
            int row = 0;    // Starting row
            int col = 0;    // Starting column
            double result = solution.knightProbability(N, K, row, col);
            System.out.println("Knight Probability: " + result);
        }
    }

