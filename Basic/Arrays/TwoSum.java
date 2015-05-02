import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        set.put(numbers[0],0);
        for(int i=1;i<=numbers.length;i++){
            int n = numbers[i];//got arrayindex out of bounds exception
            int res1 = target-n;
            if(set.containsKey(res1)){
                res[0]=set.get(res1);
                res[1]=i;
                return res;
            }
            set.put(n, i);

        }
        return null;
    }

    public void test(){
        int[] arr = {0,-1,21,12,15,24};
        int[] res = twoSum(arr,20);
        for(int i:res){
            System.out.println(i);
        }

    }

    public static void main(String[] args){
        TwoSum t = new TwoSum();
        t.test();
    }
}