//Counting sort does the sorting of elements in linear time O(n). Generally any sorting which can be accomplished in linear time makes some assumption on the data provided. In case of counting sort, 
//The assumption made is that the max value in a given set of “n” items is “k”, (where k = O(n)) then the sort runs in linear time.
//stable sort

public class CountingSort{
    //max or radix
	public static void sort(Comparable[] arr,int max){
      int[] count = new int[r+1]; //for characters radix is 256 ASCII, Or instead of R use max for integers.
      int[] aux = new int[arr.length];
      //Count frequencies of each letter using key as index
      for(int i=0;i<arr.length;i++)
      	 count[a[i]+1]++;
      //Compute frequency cumulates which specify destinations.
      for(int i=0;i<R;i++)
      	 count[i+1]+=count[i];
      //Access cumulates using key as index to move items
      for(int i=0;i<arr.length;i++)
      	aux[count[arr[i]]++]=arr[i];
      //Copy back into original array.
      for(int i=0;i<arr.length;i++)
      	arr[i]=aux[i];
	}
}