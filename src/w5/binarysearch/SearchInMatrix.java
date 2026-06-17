package w5.binarysearch;

public class SearchInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
          int i = 0;
          int j = matrix[0].length - 1;

          while (i < matrix.length && j >= 0){
              if(matrix[i][j] == target){
                  return true;
              }else if(matrix[i][j] > target){
                  j--;
              }else{
                  i++;
              }
          }

          return false;
    }

    public static void main(String[] args) {
        SearchInMatrix obj = new SearchInMatrix();

        System.out.println(obj.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(obj.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }
}
