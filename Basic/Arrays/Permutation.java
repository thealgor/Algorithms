/**
 * Created by sunil.kksubramanyam on 5/3/15.
 */
import java.util.*;
public class Permutation {
    public void printPermutation(Comparable[] arr){
        while(true){
            Comparable[] temp=nextPermutation(arr);
            if(temp==null)
                break;
            else{
                System.out.println(Arrays.toString(temp));
            }
        }

    }

    public Comparable[] nextPermutation(Comparable[] arr){
         //find largest k for which c[k]<c[k+1]
        int first = findFirst(arr);
        if(first == -1) // no greater permutation
            return null;
        int toSwap = arr.length-1;
        // 2. find last index toSwap, that c[k] < c[toSwap]
        while(arr[first].compareTo(arr[toSwap])>=0)
            --toSwap;
        // 3. swap elements with indexes first and last   --toSwap;
       swap(arr,first++,toSwap);
        // 4. reverse sequence from k+1 to n (inclusive)
        while(first<toSwap){
            swap(arr,first++,toSwap--);
        }
        return arr;
    }

    public void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public int findFirst(Comparable[] arr){
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i].compareTo(arr[i+1])<0){
                return i;
            }
        }
        return -1;
    }





    public void test(){
        Integer[] arr = {1,2,3,4};
        printPermutation(arr);
    }
    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.test();
    }
}
