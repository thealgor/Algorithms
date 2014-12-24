public class CountingInversions{

   public static void count(Comparable[] arr, Comparable[] aux, int lo, int hi){
      long inversions = 0;
      if(hi<=lo) return;
      int mid = lo + (hi-lo)/2;
      inversions += count(arr,aux,lo,mid);
      inversions += count(arr,aux,mid+1,hi);
      inversions += merge(arr,aux,lo,mid,hi);
      return inversions;
   }
   
   // | | | | | | | | i        mid  mid-i+1 elements are greater than arr[j] +1 is for including arr[i] also
   //use compareTo instead of less than or greater than symbols
   public void merge(Comaparable[] arr, Comparable[] aux, int lo, int mid, int hi){
     int i = lo, j=mid+1;
     long inversions = 0;
     for(int k=lo;k<=hi;k++)
     	aux[k]=arr[k];
     for(int k=lo;k<=hi;k++){
     	if(i>mid)arr[k]=aux[j++];
     	else if(j>hi) arr[k]=aux[i++];
     	else if(aux[j]<aux[i]){arr[k]=aux[j++]; inversions+=(mid-i)+1;}
     	else arr[k]=aux[i++];
     }

   }

}


