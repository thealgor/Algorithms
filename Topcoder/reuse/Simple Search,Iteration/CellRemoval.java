//Amazing problem copied everything
//Src 435 
//First time code represented using adjacency matrix
//Run a graph traversal algorithm, before running it make sure you know which nodes are leaves. If a node matches deleted node, dont run any further. continue dfs excluding the node.


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CellRemoval
{
	public static boolean[] isLeaf;
	public static boolean[][] E;
	public static int count = 0;
	public static int deleted;
	public int cellsLeft(int[] parent, int deletedCell)
	{
	  int src=-1;
	  deleted = deletedCell;
	  isLeaf= new boolean[parent.length];
	  E= new boolean[parent.length][parent.length];
	  Arrays.fill(isLeaf,true);
	  for(int i=0;i<parent.length;i++){
	    if(parent[i]==-1)
	      src = i;
	    else{
	      E[parent[i]][i]=true;
	      isLeaf[parent[i]]=false;
	    }
	  }
	  dfs(src);
	  return count;	
	}
	
	public static void dfs(int src){
	  if(src==deleted)
	    return;
	    
	  if(isLeaf[src])
	    count++;
	  for(int i=0;i<E[0].length;i++){
	    if(E[src][i])
	      dfs(i);
	  }
	}
	
	<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!