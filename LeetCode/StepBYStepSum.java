public class StepBYStepSum {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{1, 2}));
    }

    public static int minStartValue(int[] nums) {
        int sum = 0, min_sum = 0;
        for (var n : nums) {
            sum += n;
            System.out.println(sum);
            System.out.println(min_sum);
            min_sum = Math.min(min_sum, sum);
        }
        return -min_sum + 1;
    }
}
