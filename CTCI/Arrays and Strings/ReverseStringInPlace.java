package Search;

/*
    given a character array and space represents the end of word. Without extra space

    problem 1:
    i/p: Once upon a time in
    o/p: in time a upon once.

    Problem 2:
    i/p: Once upon a time in
    o/P: ecnO nopu a emit ni

    problem: 3:
    i/p: Once upon a time in
    o/p: ni emit a nopu ecnO
*/

//For string reversal kind of questions, always question yourself, what happens when we reach to end.

public class ReverseString{

    public static String reverseString1(char[] str){
        int start = 0, end = str.length-1;
        reverseString3(str,start,end);
        int i= 0;
        for(i=0;i<str.length;i++){
            if(str[i]==' '&&(i-1)>=0){
                reverseString3(str,start,i-1);
                if((i+1)<=str.length-1)
                  start = i+1; //missed changing the start value too.
            }

        }
        //missed this part in my first solution - be careful about this
        System.out.println("last part");
        if(str[str.length-1]!=' ') //missed this condition too.
            reverseString3(str,start,i-1);

        return new String(str);
    }

    public static void reverseString3(char[] str, int start, int end){
        int i=start, j= end;
        while(i<=((start+end)/2)){
            char temp = str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
        System.out.println(str);
    }


    public static void main(String[] args){
        String str = "Once upon a time in   ";
        char[] o = str.toCharArray();
        String res = reverseString1(o);
        System.out.println(res);
    }

 }
