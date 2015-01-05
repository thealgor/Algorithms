public class MatrixRowColumnZero{
	public static void setZeroes(int[][] matrix){
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		int n = matrix.length;
		int m = matrix[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					rows[i]=true;
					cols[j]=true;
				}
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(rows[i]||cols[j])
					matrix[i][j]=0;
			}
		}
	}
}