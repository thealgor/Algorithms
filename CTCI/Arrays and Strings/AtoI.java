public class AtoI{
	public static int atoi(String str){
       if(str==null||str.length()<1)
       	 return Integer.MAX_VALUE;
        boolean isNeg = false;
        if(str.charAt(0)=='-')
        	isNeg = true;
        int len = 0;
        int res = 0;
        for(int i=0&i<str.length();i++){
        	if(i==0&&isNeg=true){
        		count = str.length()-1;
        		continue;
        	}
            char c = str.charAt(i);
            if(c>=48&&c<=57){
                int v = c-'0';
                res += v*Math.pow(10,count--);
            }
            else{
            	throw new IllegalArgumentException("String had non-numeric characters in it");
            }
        }
        if(isNeg){
        	res = res*-1;
        }
	 return res;
	}

	public static void main(String[] args){
		String str = "-1234";
		System.out.println(atoi(str));
	}

}