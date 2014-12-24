public class Arrays{

	public void sort(Comparable[] arr, int lo, int hi){
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);
		merge(arr,lo,mid,hi);
	}
    
    //worst case time complexity
    //O(n2) time complexity
	public void merge(Comparalbe[] arr, int lo, int mid, int hi){
		int i=lo, j=mid+1;
		for(int k=0;k<arr.length;k++){
			if(arr[j].compareTo(arr[i])<=0{
				Comparable temp = arr[j];
				System.arraycopy(arr,i,arr,i+1,j-i);
				arr[i]=temp;
				i++;
			}
			else if(arr[i].compareTo(arr[j])<=0 i++;
		}
	}
}