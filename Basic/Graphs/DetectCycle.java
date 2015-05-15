import java.util.*;
public class DetectCycle {
    public void test(){
        String[] edges = {"1 2","3","4","5","5",""};
        boolean res = detectCycle(edges);
        if(res)
            System.out.println("Cycle exists!");
        else
            System.out.println("Cycle Doesnt exisit!!");
    }

    boolean[][] adj = new boolean[64][64];
    int[] color = new int[64];
    boolean hasCycle = false;
    public boolean detectCycle(String[] edges){
        for(int i=0;i<edges.length;i++){
            if(edges[i].length()<=0)
                continue;
            String[] eds= edges[i].split(" ");
            for(int j=0;j<eds.length;j++){
                int k = Integer.parseInt(eds[j]);
                adj[i][k]=adj[k][i]=true;
            }
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length();j++){
                if(color[i]==0&&adj[i][j]){
                    dfs(i,j);
                }
            }
        }
        return hasCycle;
    }

    public void dfs(int u, int v){
        if(color[u]==0){
            color[u]=1;
            for(int w=0;w<64;w++){
                //w!=u dont go back from where you came. just find another node.
                if(adj[v][w]&&w!=u){
                    dfs(v,w);
                }
            }
        }
        //once you are coming out and you dont have anywhere else to go, mark the current node as 2.
        if(color[u]==1){
            color[u]=2;
            return;
        }
        if(hasCycle)
            return;
        if(color[u]==2){
            hasCycle = true;
        }
    }

    public static void main(String[] args){
        DetectCycle d = new DetectCycle();
        d.test();
    }
}
