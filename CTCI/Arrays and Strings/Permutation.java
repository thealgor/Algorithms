class Permutation{

    public static boolean isPermutation(String a, String b){
        if(a.length()!=b.length())
            return false;
        int[] res = new int[256];
        for(int i=0;i<a.length();i++){
            char c = a.charAt(i);
            res[c]++;
        }
        for(int i=0;i<b.length();i++){
            char c = b.charAt(i);
            res[c]--;
        }
        boolean result = true;
        for(int i=0;i<256;i++){
            if(res[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        String a = "abcdaaa", b="aaacdba";
        System.out.println(isPermutation(a,b));
        a = "abc"; b ="";
        System.out.println(isPermutation(a,b));
    }

}}