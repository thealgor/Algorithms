package Search;

public class Compress{
    public static String compress(String str){
        if(str==null)
            return null;
        if(str.length()==0)
            return str;
        if(isSmallerWithoutCompress(str)) //sometimes good if we dont have more space in memory to verify it upfront.
            return str;
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char curr=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(curr==str.charAt(i))
                count++;
            else{
                sb.append(curr);
                sb.append(count);
                curr=str.charAt(i);
                count=1;
            }
        }
        sb.append(curr);
        sb.append(count);
        if(sb.length()>str.length())
            return str;
        return new String(sb);
    }

    public static boolean isSmallerWithoutCompress(String str){
         char curr = str.charAt(0);
         int count = 1;
         int totalCount=0;
         for(int i=1;i<str.length();i++){
             if(str.charAt(i)==curr)
                 count++;
             else{
                 totalCount += 1 + (Math.log10(count)+1);
                 curr = str.charAt(i);
                 count = 1;
             }
         }
        totalCount += 1+(Math.log10(count)+1);
        System.out.println(totalCount);
        if(totalCount>str.length())
            return true;
        return false;
    }

    public static void main(String[] args){
        String str = "aabccccaaa";
        System.out.println(compress(str));
        str = "a";
        System.out.println(compress(str));
        System.out.println(isSmallerWithoutCompress(str));
        str="aaaaaaaaaaa"; //length greater than 10, just verifying if it works
        System.out.println(isSmallerWithoutCompress(str));
    }
}