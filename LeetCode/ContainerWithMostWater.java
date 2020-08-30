public class ContainerWithMostWater {

    public static void main(String[] args) {
        int heights[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(heights);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        if (height.length < 2) {
            return maxArea;
        }
        int i = 0;
        int j = height.length - 1;

        while (i != j) {
            int minheight = Integer.min(height[i], height[j]);
            int area = minheight * (j - i);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
