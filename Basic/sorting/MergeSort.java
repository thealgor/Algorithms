/* 
    mistakes:
             1) missed base condition for recursion
             2) confused about copying aux to arr or arr to aux(stupid!)
             3) wrote compareTo method on integer variables

 */



public class Arrays{
   
  public static void sort(Comparable[] arr){
	Comparable[] aux = new Comparable[arr.length];
  	sort(arr,aux,0,arr.length-1);
  }

  public static void sort(Comparable[] arr. Comparable[] aux, int lo, int hi){
     if(hi<=lo) return;
     int mid = lo+(hi-lo)/2;
     sort(arr,aux,lo,mid);
     sort(arr,aux,mid+1,hi);
     if(arr[mid]>arr[mid+1])
     	merge(arr,aux,lo,mid,hi);
  }
  
  //Use CompareTo instead of lt and gt
  public void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
     int i = lo, j=mid+1;
     for(int k=lo;k<=hi;k++)
       aux[k]=arr[k];

     for(int k=lo;k<=hi;k++){
         if(i>mid) arr[k]=aux[j++];
         else if(j>hi) arr[k]=aux[i++];
         else if(aux[j]<aux[i]) arr[k]=aux[j++];
         else arr[k]=aux[i++];
	} 

  }

  //without one extra copy

   public static void sort(Comparable[] arr. Comparable[] aux, int lo, int hi){
     if(hi<=lo) return;
     int mid = lo+(hi-lo)/2;
     sort(aux,arr,lo,mid);
     sort(aux,arr,mid+1,hi);
     if(arr[mid]>arr[mid+1])
     	merge(aux,arr,lo,mid,hi);
  }
  

  public void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
     int i = lo, j=mid+1;
   
     for(int k=lo;k<=hi;k++){
         if(i>mid) aux[k]=arr[j++];
         else if(j>hi) aux[k]=arr[i++];
         else if(aux[j]<aux[i]) aux[k]=arr[j++];
         else arr[k]=aux[i++];
	} 

  }


}
