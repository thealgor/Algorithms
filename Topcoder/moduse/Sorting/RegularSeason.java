/*
  SRM 207 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=2866
*/

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RegularSeason {

	public class Team{
		String teamName="";
		Integer winprobability=0;

		public Team(String teamName, Integer winprobability){
			this.teamName=teamName;
			this.winprobability=winprobability;
		}
	}

	class MyComparator implements Comparator{
		public int compare(Object o1, Object o2){
			Team t1 =(Team)o1;
			Team t2 = (Team) o2;
			int cmp = t1.winprobability.compareTo(t2.winprobability);
			if(cmp==0)
				return (t1.teamName.compareTo(t2.teamName));
			return -cmp;
		}
	}


	public String[] finalStandings(String[] teams, int rounds) {
       List<Team> list = new ArrayList<Team>();
       int rows=teams.length; int cols =teams.length;
	   int[][] probs = new int[rows][cols];

       for(int i=0;i<rows;i++){
       	String[] items = teams[i].split(" ");
        for(int j=0;j<cols;j++){
           	probs[i][j]=Integer.parseInt(items[j+1]);
		}
	   }

       for(int i=0;i<rows;i++){
		   String[] items = teams[i].split(" ");
		   String teamName = items[0];
		   double prob = 0;
		   for(int j=0;j<cols;j++){
		   	if(i==j) continue;
		   	prob += probs[i][j]*rounds;
		   	prob += (100-probs[j][i])*rounds;
		   }
		   prob = Math.round(prob/100);
		   Team t = new Team(teamName,(int)prob);
		   list.add(t);
	   }

       Collections.sort(list, new MyComparator());
       String[] results = new String[list.size()];
       for(int i=0;i<results.length;i++){
       	results[i]= list.get(i).teamName +" "+ list.get(i).winprobability;
	   }

		return results;
	}
}












/*
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

class RegularSeason
{
	public String[] finalStandings(String[] teams, int rounds)
	{  
	   List<String> list = new ArrayList<String>();
	   for(String team: teams){
         list.add(team.split(" ")[0]);	   
	   }
	   Map<String, Double> map = new TreeMap<String, Double>();
	   for(int i=0;i<teams.length;i++){
	     String[] sc = teams[i].split(" ");
	     String ct = sc[0];
	     for(int j=1;j<sc.length;j++){
	       if(i+1==j)
	         continue;
	       double curr = (Double.parseDouble(sc[j])*rounds);       
	       String opp = list.get(j-1);
	       double oppv= ((100-Double.parseDouble(sc[j]))*rounds);
	       if(map.containsKey(ct)){
	         map.put(ct, map.get(ct)+curr);
	       }
	       else{
	        map.put(ct,curr);
	       }
	       
	       if(map.containsKey(opp)){
	         map.put(opp,map.get(opp)+oppv);
	       }
	       else{
	         map.put(opp,oppv);
	       }
	     
	     }
	   
	   }
	   List<Map.Entry<String,Double>> slist= new ArrayList<Map.Entry<String,Double>>();
	   
	   for(Map.Entry<String,Double> entry: map.entrySet()){
	   slist.add(entry);
	   }
	   
	   Collections.sort(slist, new Comparator(){
	   
	   public int compare(Object o1, Object o2){
	   
	   Map.Entry<String,Double> m1 =(Map.Entry<String,Double>)o1;
	   Map.Entry<String,Double> m2 =(Map.Entry<String,Double>)o2;
	   Double d1 = m1.getValue();
	   Double d2 = m2.getValue();
	   
	   if(d1==d2){
	     return m1.getKey().compareTo(m2.getKey());
	   }
	   else{
	     return -d1.compareTo(d2);
	   }
	   
	   
	   }
	   
	   });
	   
	   String[] res = new String[slist.size()];
	   int i=0;
	   for(Map.Entry<String,Double> entry: slist){
	     double val=entry.getValue()/100;
	     double v2 =entry.getValue()/100;
	     int v1 =(int) v2;
	     double dec = val-v1;
	     System.out.println("dec"+dec);
	     if(dec>=0.5){
	      v1=v1+1; 
	     }
	    
	     res[i]=entry.getKey()+" "+v1;
	     System.out.println(res[i]+" "+entry.getValue());
	     i++;
	   
	   }
	   
		return res;
	}
	
	
	
}

*/
//Powered by [KawigiEdit] 2.0!
