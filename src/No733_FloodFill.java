public class No733_FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }


        if(sr < 0 || sr >= image.length){
            return image;
        }

        if(sc < 0 || sc >= image[sr].length){
            return image;
        }

        int originalColor = image[sr][sc];
        if(originalColor != newColor){
            helper(image, sr, sc, originalColor, newColor);
        }

        return image;
    }

    private void helper(int[][] image, int sr, int sc, int originalColor, int newColor){
        if(sr < 0 || sr >= image.length){
            return;
        }

        if(sc < 0 || sc >= image[sr].length){
            return;
        }

        if(image[sr][sc] == originalColor){
            image[sr][sc] = newColor;
            helper(image, sr + 1, sc, originalColor, newColor);
            helper(image, sr, sc + 1, originalColor, newColor);
            helper(image, sr - 1, sc, originalColor, newColor);
            helper(image, sr, sc - 1, originalColor, newColor);
        }

    }
}
