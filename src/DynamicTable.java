import java.util.Scanner;

public class DynamicTable {
    public static void main(String[] args) {
        PinaryNumber();
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


}
