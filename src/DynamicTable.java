import java.util.Scanner;

public class DynamicTable {
    public static void main(String[] args) {
//        PinaryNumber();
        StairWayNumber();
    }

    public static void PinaryNumber() {

//  Pinary number int bottom up can be defined as d[n] = d[n-1] + d[n-2] in dynamic array
//  or d[n-1][0] + d[n-2][1] in dynamic table.
//  each right term stands for when the number ends with 1 or 0 at the final digit.
//  If digit ends with 1, the last one cannot be 1 by definition, thus same as d[n-2]


//  d[1] = 1, d[2] = 1 by definition

//        d[1][0] = 0
//        d[1][1] = 1
//        d[2][1]= 0
//        d[2][0]= 1

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][2];
        d[1][1] = 1;

        for (int i=2; i<= n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        System.out.println(d[n][0] + d[n][1]);
    }

    public static void StairWayNumber () {
        //define stair way number as number with each digits increments or decrements by one
        //0 cannot be located at the front digit.
        //Count only positive integer


        // Case down
        //if past digit was bigger than 0, it can decrease
        //if past digit was less than 0, it can increase

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //don't forget to check input, for appropriate data type, for dt and answer as well.
        long[][] d = new long[n+1][11];
        //given by problem, to reduce space complexity
        int mod = 1000000000;

        for (int j=1; j<=9; j++) d[1][j] = 1;

        for (int i=2; i<= n; i++) {
            for (int j=0; j<=9; j++) {
                d[i][j] = 0;
                if (j>0) d[i][j] += d[i-1][j-1];
                if (j<9) d[i][j] += d[i-1][j+1];
                d[i][j] %= mod;
            }
        }

        long answer = 0;
        for (int j=0; j<=9; j++){
            answer += d[n][j];
        }

        System.out.println(answer%mod);
    }



}
