public class ReplaceSpace20{
    public static String replace(char[] str){
        int high = str.length-1;
        int maxi= -1;
        for(int i=0;i<str.length;i++){
            if(str[i]!=' ')
                maxi = Math.max(i,maxi);
        }
        int low = maxi;
        while(low!=-1){
            if(str[low]!=' '){
                str[high]=str[low];
                high--;
                low--;
            }
            else{
                str[high--]='0';
                str[high--]='2';
                str[high--]='%';
                low--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args){
        char[] str = {'m','r',' ','j','o','h','n',' ','s','m','i','t','h',' ',' ',' ',' '};
        System.out.println(replace(str));
    }
}