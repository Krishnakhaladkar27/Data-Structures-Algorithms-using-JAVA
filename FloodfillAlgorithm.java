import java.util.Arrays;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor != newColor) {
            fill(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    private static void fill(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != originalColor) return;

        image[r][c] = newColor;

        // Move in 4 directions: up, down, left, right
        fill(image, r + 1, c, originalColor, newColor);
        fill(image, r - 1, c, originalColor, newColor);
        fill(image, r, c + 1, originalColor, newColor);
        fill(image, r, c - 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image1 = { {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1} };
        int[][] result1 = floodFill(image1, 1, 2, 2);
        System.out.println(Arrays.deepToString(result1));
        // Output: [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]]

        int[][] image2 = { {0, 1, 0}, {0, 1, 0} };
        int[][] result2 = floodFill(image2, 0, 1, 0);
        System.out.println(Arrays.deepToString(result2));
        // Output: [[0, 0, 0], [0, 0, 0]]
    }
}
