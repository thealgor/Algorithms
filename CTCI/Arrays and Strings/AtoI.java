public class AtoI{
    public static int atoi(String str){
        if(str==null)
            return 0;
        boolean isNeg = false;
        if(str.charAt(0)=='-')
            isNeg = true;
        int len = str.length()-1;
        double res = 0;
        for(int i=0;i<str.length();i++){
            if(i==0&&isNeg){
                len = len-1;
                continue;
            }
            char c = str.charAt(i);
            if(c>='0'&&c<=57){
                int v = c-'0';
                res += v*Math.pow(10,len--);
            }
            else{
                throw new IllegalArgumentException("String had non-numeric characters in it");
            }
        }
        if(isNeg){
            res = res*-1;
        }

        // handle max and min
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)res;
    }

    public static void main(String[] args){
        String str = "1234";
        System.out.println(atoi(str));
    }
}


//str.length()<1) //missed str.length()<1