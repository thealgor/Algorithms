/*
sz = 1
     merge(a, aux,  0,  0,  1)
     merge(a, aux,  2,  2,  3)
     merge(a, aux,  4,  4,  5)
     merge(a, aux,  6,  6,  7)
     merge(a, aux,  8,  8,  9)
     merge(a, aux, 10, 10, 11)
     merge(a, aux, 12, 12, 13)
     merge(a, aux, 14, 14, 15)
sz = 2
   merge(a, aux,  0,  1,  3)
   merge(a, aux,  4,  5,  7)
   merge(a, aux,  8,  9, 11)
   merge(a, aux, 12, 13, 15)
sz = 4
 merge(a, aux,  0,  3,  7)
 merge(a, aux,  8, 11, 15)
sz = 8
a[i]
0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
MERGESORTEXAMPLE EMRGESORTEXAMPLE
EMGRESORTEXAMPLE EMGRESORTEXAMPLE EMGRESORTEXAMPLE EMGRESORETXAMPLE EMGRESORETAXMPLE EMGRESORETAXMPLE EMGRESORETAXMPEL
EGMRESORETAXMPEL EGMREORSETAXMPEL EGMREORSAETXMPEL EGMREORSAETXELMP
EEGMORRSAETXELMP EEGMORRSAEELMPTX
merge(a, aux, 0, 7, 15)
Trace of merge results for bottom-up mergesort
AEEEEGLMMOPRRSTX
*/

public void sort(Comparable[] arr){

	for(int sz=1;sz<n;sz=sz+sz){
		for(int l=0;lo<N-sz;lo+=sz+sz){
			Comparable[] aux = new Comparable[arr.length];
			merge(arr,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
		}
	}

	public void merge(....){
		//same routine
	}
}