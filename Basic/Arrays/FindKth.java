public class FindKth {

    public int findKthSmallest(int[] arr, int k){
        if(arr==null||arr.length<k)
            return -1;
        int res = findKth(arr,0,arr.length-1,k-1);//k-1 because of index starting from zero.
        System.out.println(res);
        return res;
    }

    public int findMedian(int[] arr){
        if(arr==null)
            return -1;
        if(arr.length==1){
            System.out.println(arr[0]);
            return arr[0];
        }
        int lo = 0, hi = arr.length-1;
        int mid = (lo+hi)>>>1;
        int res = findKth(arr,0,arr.length-1,mid);
        System.out.println(res);
        return res;
    }

    public int findKth(int[] arr,int low, int high, int k){
        int pivot = partition(arr, low, high);
        int res = -1;
        if(pivot<k) {
           res = findKth(arr,pivot+1,high,k);
        }
        else if(pivot > k){
            res = findKth(arr,low,pivot-1,k);
        }
        else{
            return arr[pivot];
        }

        return res;
    }
    public int partition(int[] arr, int low, int high){
        int i = low, j = high+1;//low and high+1's are confusing
        int pivot = arr[i];
        while(true){
            while(arr[++i]<pivot){//skipping the pivot element
                if(i==high)
                    break;
            }
            while(arr[--j]>pivot){
                if(j==low)
                    break;
            }
            if(i>=j)
                break;
            int temp = arr[i];   //swapping the elements that are found be less than the pivot and greater than the pivot
            arr[i]=arr[j];
            arr[j]=temp;
        }
        int temp = arr[low]; //put pivot in its rightful place
        arr[low]=arr[j];
        arr[j]= temp;
        return j; //return the position
    }

    public void test(){
        int[] arr= {7,2,1,3,5,4,6};
        int[] arr1 = {0,1,2};//median failed for just only one element
        findKthSmallest(arr, 6);
        //find median
        System.out.println("median");
        findMedian(arr1);
    }

    public static void main(String[] args){
        FindKth f = new FindKth();
        f.test();

    }


}
