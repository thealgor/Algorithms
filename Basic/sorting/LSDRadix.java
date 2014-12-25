//LSD Sorting. same length words
//Apply counting sort for each character from the end
//stable sort. 
public class LSDSort{
	public class sort(String[] arr, int W){
		int[] count = new int[R];
		int[] aux = new int[arr.length];
		for(int d=W-1;d>=0;d--){
			//starting point is always zero. Trick here. Think about it.
			for(int i=0;i<arr.length;i++)
				count[a[i].charAt(d)+1]++;
			for(int i=0;i<R;i++)
				count[i+1]+=count[i];
			for(int i=0;i<arr.length;i++)
				aux[count[a[i].charAt(d)]++]=a[i];
			for(int i=0;i<arr.length;i++)
				a[i]=aux[i];
		}

	}
}