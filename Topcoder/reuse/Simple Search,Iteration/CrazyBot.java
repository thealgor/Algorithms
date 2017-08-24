//amazing question - couldnt solve it. Looked at the solution and coded again
//cautious of the visited array size. If you begin from the start, 0,0 and move left, it will be array out of bounds exception
//dx and dy is a very good way of navigating a grid
//such a nice recursive problem
//In recursive problems if you want cummulative solution use void in your method. If you want to return as soon as you find the solution then return 
//the appropriate type.
// http://www.topcoder.com/stat?c=problem_statement&pm=10095


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CrazyBot
{
    double[] prob = new double[4];
    boolean[][] visited = new boolean[100][100];
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    double tempRes = 0;
    
    
	public double getProbability(int n, int east, int west, int south, int north)
	{
		prob[0]=east/100.0; prob[1]=west/100.0; prob[2]=south/100.0; prob[3]=north/100.;
		go(n,50,50,1);
		
		return tempRes;
	}
	
	public void go(int n, int x, int y,double prob1){
	    if(visited[x][y])
	       return;
	     if(n==0){
	       tempRes += prob1;
	       return;
	     }
	     //mark this point as visited and continue in all the four directions
	     visited[x][y]=true;
	     for(int i=0;i<4;i++)
	       go(n-1,x+dx[i],y+dy[i],prob[i]*prob1);
	     //Unmark the point when we checked all the paths. 
	     visited[x][y]=false; 
	}
	
	//<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!
