//https://www.hackerrank.com/contests/w12/challenges/priyanka-and-toys/submissions/code/2580193

//greedy
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ip = new int[n];
         int i=0;
         while(i<n){
             ip[i++]=in.nextInt();
             //System.out.println(ip[i-1]);
         }
        Arrays.sort(ip);
         int count = 0;
         int x=Integer.MIN_VALUE, y=Integer.MIN_VALUE;
         int v;
         for(i=0;i<n;){
             v = ip[i];
             if(x==Integer.MIN_VALUE){
                x = v;
                y = v+4;
                count++;
                i++;
             }
             else{
                 if(v>=x&&v<=y){
                     i++;
                     continue;
                 }
                 else{
                     x=Integer.MIN_VALUE;
                     y=Integer.MIN_VALUE;
        
                 }
             }
            
         }
        System.out.println(count);
         
    }
  
}