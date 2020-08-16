import java.util.Arrays;

public class Weekly202 {
    public static  boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3){
            return false;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++){

            if (arr[i] % 2 == 0){
                res = 0;
            }else {
                res++;
            }
            if (res == 3){
                return  true;
            }
        }
        return false;
    }
    public static int minOperations(int n) {
        int [] arr = new int[n/2];
        for(int i = 0; i < n/2; i++){
            arr[i] = (2*i) + 1;
        }
        int opn = 0;
        for(int i = 0; i < arr.length; i++){
            opn += n-arr[i];
        }
        return opn;
    }
    public static  int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0;
        int hi = position[position.length-1];
        int optimal = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            System.out.println(mid);
            if (canPut(position, m, mid)) {
                optimal = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return optimal;
    }

    /*
     * Returns whether we can put m balls so that maximum distance between any two balls not exceed max
     */
    private static  boolean canPut(int[] positions, int m, int max) {
        int count = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= max) {
                last = positions[i];
                count++;
            }
        }
        return count >= m;
    }
}
