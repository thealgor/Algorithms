public class MultiplyEverythingExceptCurrent {
   /*
      {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
      { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }

    */
    public int[] multiplyEverything(int[] arr){
        int[] up = new int[arr.length];
        int[] low = new int[arr.length];
        int product = 1;
        up[0]=product;
        for(int i=0;i<arr.length-1;i++){
            product = product*arr[i];
            up[i+1] = product;
        }
        low[arr.length-1]=1;
        product=1;
        for(int j=arr.length-1;j>0;j--){
            product = product*arr[j];
            low[j-1] = product;
        }
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=up[i]*low[i];
        }
        return res;
    }

    public void test(){
        int[] arr = {1,2,3,4,5,6,0};
        int[] res = multiplyEverything(arr);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        MultiplyEverythingExceptCurrent m = new MultiplyEverythingExceptCurrent();
        m.test();
    }
}
