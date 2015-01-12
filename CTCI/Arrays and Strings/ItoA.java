public class ItoA{

    public static String itoa(int v){
        boolean isNeg=false;
        int len = 0;
        if(v<0){
            isNeg=true;
            v = v*-1;
            len = (int)(Math.log10(v))+2;
        }
        else{
            len = (int)(Math.log10(v)+1);
        }
        final int MAX_DIGITS = (int)Math.log10(Integer.MAX_VALUE)+1;
        char[] res = new char[MAX_DIGITS];
        for(int i=len-1;i>=0;i--){
            res[i]=(char)(v%10+'0');
            v = v/10;
        }
        if(isNeg)
            res[0]='-';
        return new String(res);
    }

    public static void main(String[] args){
        int v = -123456;
        System.out.println(itoa(v));
    }

}