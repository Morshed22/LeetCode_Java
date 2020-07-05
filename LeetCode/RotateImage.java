import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
     int [][] matrxiArr = {{1,2,3}, {4,5,6}, {7,8,9}};
     RotateImage ri = new RotateImage();
     ri.rotate(matrxiArr);
    }

    public void rotate(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n ; i++ ){
            for (int j = i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
       for (int i = 0; i < n; i++){
           for (int j = 0; j < n/2; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][n-1-j];
               matrix[i][n-1-j] = temp;
           }
       }
      System.out.println(Arrays.deepToString(matrix).replace("],","\n").replace(",","\t| ")
              .replaceAll("[\\[\\]]", " "));
    }
    public static void swap(int [][] matrix, int i, int j, int k, int l){
         int temp = matrix[i][j];
         matrix[i][j] = matrix[k][l];
         matrix[k][l] = temp;
    }
    public void rotate2(int [][] matrix){
        if (matrix.length == 0){
            return;
        }
        int n = matrix.length;
        int low = 0;
        int high = matrix.length-1;
        while (low < high){
            int length = high - low;
            for(int i = 0; i < length; i++){
                int index = low+i;
                swap(matrix, low+i, high, low, index);
                swap(matrix, high,high-i, low, index);
                swap(matrix, high-i,low, low, index);
            }
            low++;
            high--;
        }

    }

}
