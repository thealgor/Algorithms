import java.io.*;
import java.util.*;

public class EightQueens {

    static int[] row = new int[9];
    static int TC, a, b, lineCounter;
    private static boolean place(int c, int r){//col, row
        for(int prev=1;prev<c;prev++){
            if(row[prev]==r|| (Math.abs(row[prev]-r)==Math.abs(prev-c))){
                return false;
            }

        }
        return true;
    }

    private static void backtrack(int c){
        for(int tryRow=1;tryRow<=8;tryRow++) {
            if (place(c, tryRow)) {
                row[c] = tryRow;
                //check for termination condition
                if (c == 8 && row[b] == a) {
                    System.out.printf("%2d   %d", ++lineCounter, row[1]);
                    for (int j = 2; j <= 8; j++)
                        System.out.printf(" %d", row[j]);
                    System.out.printf("\n");
                } else {
                    backtrack(c + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        InputReader in = new InputReader(System.in);
        TC = in.nextInt();
        while (TC-- > 0) {
            a = in.nextInt();
            b= in.nextInt();
            lineCounter=0;
            for (int i = 0; i < 9; i++) row[i] = 0;
            System.out.printf("SOLN       COLUMN\n");
            System.out.printf(" #      1 2 3 4 5 6 7 8\n\n");
            backtrack(1);
            if (TC > 0) System.out.printf("\n");
        }
        }

      static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public InputReader(File f) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(f));
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }


        public char[] nextChar() {
            try {
                return reader.readLine().toCharArray();
            } catch (IOException e) {
                e.printStackTrace();
                //TODO: optimise return value for error case
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}


/*


import java.util.*;

class EightQueens {
    private static int[] row = new int[9];
    private static int TC, a, b, lineCounter; // it is ok to use global variables in competitive programming

    private static boolean place(int col, int tryrow) {
        for (int prev = 1; prev < col; prev++) // check previously placed queens
            if (row[prev] == tryrow || (Math.abs(row[prev] - tryrow) == Math.abs(prev - col)))
                return false; // an infeasible solution if share same row or same diagonal
        return true;
    }

    private static void backtrack(int col) {
        for (int tryrow = 1; tryrow <= 8; tryrow++) // try all possible row
            if (place(col, tryrow)) { // if can place a queen at this col and row...
                row[col] = tryrow; // put this queen in this col and row
                if (col == 8 && row[b] == a) { // a candidate solution & (a, b) has 1 queen
                    System.out.printf("%2d      %d", ++lineCounter, row[1]);
                    for (int j = 2; j <= 8; j++) System.out.printf(" %d", row[j]);
                    System.out.printf("\n");
                }
                else
                    backtrack(col + 1); // recursively try next column
            }   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
        while (TC-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (int i = 0; i < 9; i++) row[i] = 0;
            lineCounter = 0;
            System.out.printf("SOLN       COLUMN\n");
            System.out.printf(" #      1 2 3 4 5 6 7 8\n\n");
            backtrack(1); // generate all possible 8! candidate solutions
            if (TC > 0) System.out.printf("\n");
        }
    }
}
*/
