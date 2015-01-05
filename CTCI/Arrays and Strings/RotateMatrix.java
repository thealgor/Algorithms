/*
  (i,j)        (j,n-i-1)
   1  2  3  4  5
   6  7  8  9  10
   11 12 13 14 15
   16 17 18 19 20
   21 22 23 24 25
  (n-i-j ,i)   (n-i-1,n-i-j)




*/

public class RotateMatrix{
	public static void rotateMatrix(int[][] matrix){
         int n = matrix.length;
         for(int i=0;i<n/2;i++){
         	for(int j=i;j<n;j++){
         		//save top
         		int top = matrix[i][j];

         		//left to top
                matrix[i][j]=matrix[n-i-j][i];

                //bottom to left
                matrix[n-i-j][i]=matrix[n-i-1][n-i-j];

                //right to bottom
                matrix[n-i-1][n-i-j]=matrix[j][n-i-1];

                //top to right
                matrix[j][n-i-1]=top;


         	}
         }
	}
}