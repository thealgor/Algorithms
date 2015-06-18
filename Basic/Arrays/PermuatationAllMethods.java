import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sunil.kksubramanyam on 6/9/15.
 */
public class PermuatationAllMethods {

    //method 1
    public void permute1(char[] arr, int n){
        if(n==1){

            System.out.println("permute:"+new String(arr));
            return;
        }
        else{
            for(int i=0;i<n;i++){
                swap(arr,i,n-1);
                System.out.println("swap1:"+new String(arr));
                permute1(arr, n - 1);
                swap(arr,i,n-1);
                System.out.println("swap2:"+new String(arr));
            }
        }
    }

    public void swap(char[] arr, int x, int y){
        char temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    //method 2

    public void permute(String prefix,String str){
        if(str.length()==0){
            System.out.println(prefix);
            return;
        }
        for(int i=0;i<str.length();i++){
            String c = str.charAt(i)+"";
            String remainingString = str.substring(0,i)+str.substring(i + 1);
            permute(prefix+c,remainingString);
        }
    }

    //method 3


    // simply prints all permutation - to see how it works
    public ArrayList<String> printPermutations( Comparable[] c ) {
        // System.out.println( Arrays.toString( c ) );
        ArrayList<String>  a = new ArrayList<String>();
        while ( ( c = nextPermutation( c ) ) != null ) {
            a.add(Arrays.toString(c));
        }
        return a;
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    public  Comparable[] nextPermutation( final Comparable[] c ) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst( c );
        if ( first == -1 ) return null; // no greater permutation
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.length - 1;
        while ( c[ first ].compareTo( c[ toSwap ] ) >= 0 )
            --toSwap;
        // 3. swap elements with indexes first and last
        swap( c, first++, toSwap );
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while ( first < toSwap )
            swap( c, first++, toSwap-- );
        return c;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    public  int getFirst( final Comparable[] c ) {
        for ( int i = c.length - 2; i >= 0; --i )
            if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
                return i;
        return -1;
    }

    // swaps two elements (with indexes i and j) in array
    private  void swap( final Comparable[] c, final int i, final int j ) {
        final Comparable tmp = c[ i ];
        c[ i ] = c[ j ];
        c[ j ] = tmp;
    }

    public void test(){
        String a="abcd";
        char[] arr = a.toCharArray();
        Character[] c = new Character[arr.length];
        int i=0;
        for(char c1: arr){
            c[i]=c1;
            i++;
        }
        int N = arr.length;
        printPermutations(c);
        //permute("",a);
    }





    public static void main(String[] args){
         PermuatationAllMethods p = new PermuatationAllMethods();
        p.test();
    }
}
