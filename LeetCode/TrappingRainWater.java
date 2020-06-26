import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater tapWater = new TrappingRainWater();
        System.out.println(tapWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {

        //Using Dynamic programing

//        if (height.length < 2) return 0;
//        int count = 0;
//        int [] leftArr = new int[height.length];
//        int [] rightArr= new int[height.length];
//
//        for (int i = 1; i < height.length; i++){
//            leftArr[i] = Math.max( height[i-1],  leftArr[i-1]);
//        }
//        for(int i = height.length-2; i >=0 ; i--){
//            rightArr[i] = Math.max( height[i+1],  rightArr[i+1]);
//        }
//        for (int i = 1; i < height.length; i++){
//            int min = Math.min(leftArr[i], rightArr[i]);
//            int val = min-height[i];
//            if (val >0){
//                count += val;
//            }
//        }
//        return count;


        //Using two pointer solution


//        int low = 0, high = height.length - 1, total = 0;
//        int leftMax = 0, rightMax = 0;
//
//        while (low < high) {
//            if (height[low] < height[high]) {
//                leftMax = Math.max(leftMax, height[low]);
//                total += leftMax - height[low++];
//            } else {
//                rightMax = Math.max(rightMax, height[high]);
//                total += rightMax - height[high --];
//            }
//        }
//        return total;

        //Using Stack Solution
        Stack<Integer> stack = new Stack<Integer>();
        int total = 0;
        int i = 0;
        while (i < height.length){
           if (!stack.isEmpty() &&  height[i] > height[stack.peek()]){
              int top = stack.pop();
              if(!stack.isEmpty()){
                  int distance = i - stack.peek() -1;
                  int minVal = Math.min(height[i], height[stack.peek()]) - height[top];
                  total += minVal*distance;
              }
           }else {
               stack.push(i);
               i++;
           }
       }
      return total;

    }
}
