//3-way quick sort
/*
public class ThreeWayStringSort{

private static int charAt(String s, int d)
{
   if (d < s.length()) return s.charAt(d);
   else return -1;
}

public void sort(String[] arr, int lo, int hi, int d){
  if(hi<=lo) return;
  int lt =lo, gt=hi,i=lo+1;
  int v = charAt(arr[lo],d);
  while(i<=gt){
    int t = charAt(a[i],d);
    if(t>v) swap(arr,i,gt--);
    else if(t<v) swap(arr,lt++,i++);
    else i++;
  } 

  sort(arr,lo,lt-1,d);
  if(v>=0) sort(arr,lt,gt,d+1);
  sort(arr,gt+1,hi,d);
}

}
*/