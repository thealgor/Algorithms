public class QuickSort{
    //cannot use shuffle for primitive like int[], you might have to use Integer[]
	public static void sort(Comparable[] arr){
		 //too much overhead for tiny subarrays cutoff ~ 10, java uses around 7
		 if (hi <= lo + CUTOFF - 1){
      		Insertion.sort(a, lo, hi);
			return; 
		}
		Collections.shuffle(Arrays.asList(arr));//verify 
		sort(arr,lo,arr.length-1);
	}

	public static void sort(Comparable[] arr, int lo, int hi){
		if(hi<=lo) return;
         //improvement to quick sort
   		 int m = medianOf3(arr, lo, lo + (hi - lo)/2, hi);
  		 swap(arr, lo, m);
		 
		 int j = parition(arr,lo,hi);
		 sort(arr,lo,m-1);
		 sort(arr,m+1,hi);
	}

	public static int partition(Comparable[] arr, int lo, int hi){
		int i=lo, j=h+1;

		while(true){
			while((arr[lo].compareTo(arr[++i])>0))
              if(i==hi) break;
            while(arr[lo].compareTo(arr[--j]<0))
              if(j==lo) break;
            if(i<=j) break;
            swap(arr,i,j);
		}
		swap(arr,lo,j);
		return j;
	}

	public static int quickSelect(Comparable[] arr, int k){
		Collections.shuffle(Arrays.asList(arr));
		int lo=0, hi=arr.length-1;
		while(lo<hi){
		  int j = partition(arr,lo,hi);	
		  if(k<j)lo=j+1;
		  else if(k>j)hi=j-1;
		  else return arr[k];
		}
 	}
    
    //Let v be partitioning item a[lo]. ・Scan i from left to right.
    //– (a[i] < v): exchange a[lt] with a[i]; increment both lt and i – (a[i] > v): exchange a[gt] with a[i]; decrement gt
    //– (a[i] == v): increment i
    //refer prof.sedgewick's slides
    
    //dutch national flag problem ~ for lot of applications reduces the linearthmic time complexity to linear
    //move equal values AAAAAAAA ~ O(n2), dont move equal values ~O(nlogn), dutch national flag ~ O(n) ~ Salute Edsger Dijkstra
 	public static int threeWayQuicksort(Comparable[] arr, int lo, int hi){
       if(hi<=lo)return;
       int lt = lo, gt=hi, i=lo;
       Comparable v = arr[lo];
       while(i<gt){
         int cmp = arr[i].compareTo(v);
         if(comp<0) swap(arr,lt++,i++);
         else if(cmp<0) swap(arr,gt--,i);
         else i++;
       }
       threeWayQuicksort(arr,lo,lt-1);
       threeWayQuicksort(arr,gt+1,hi);
 	}


  public int medianOf3(int[] arr,int lo, int center, int hi) {
    int[] temp = new int[3];
    temp[0]=lo, temp[1]=center, temp[2]=hi;
    // order left & center
    if (arr[temp[0]) > arr[temp[1]])
      swap(temp,0,1);
    // order left & right
    if (arr[temp[0]] > arr[temp[2]])
      swap(temp,0, 2);
    // order center & right
    if (arr[temp[1]] > arr[temp[2]])
      swap(temp,1, 2);
    return temp[2];
  }
  

}

//worst case O(n2) average case O(nlogn)
// equal values? Still not sure -You are proposing something smarter, which is sensible, but keep in mind that this takes more effort to determine that everything in a particular segment is equal to the pivot, which surely requires communicating between multiple threads (and this is more complicated to do). 
// random shuffle - 1) probabilistic gaurantee against worst case - already sorted, 2) Basis for math model, but can be validated with experiments.
//39% more compares than mergesort, but faster than mergesort because of less data movement(on large datasets).