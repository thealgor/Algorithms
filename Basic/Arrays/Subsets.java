/**
 * Created by sunil.kksubramanyam on 6/8/15.
 */
public class Subsets {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        for(int i=0;i<Math.pow(2,arr.length);i++){
            for(int j=0;j<arr.length;j++){
                int a = (i & (1<<j));
                if(a!=0){
                    System.out.print(arr[j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
