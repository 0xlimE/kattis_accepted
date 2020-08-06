import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
public class Knapsack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        do{
            int d = (int) sc.nextDouble();
            int lines = sc.nextInt();
            int[] weights = new int[lines+1];
            int[] values = new int[lines+1];
            for(int i = 1; i<=lines; i++){

                values[i] = sc.nextInt();
                weights[i] = sc.nextInt();
            }
            
            optimal(d,values,weights,lines);

        }while(sc.hasNext());
    }

    public static void optimal(int W,int[] values,int[] weights,int N){
        
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weights[n] <= w) option2 = values[n] + opt[n-1][w-weights[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);

                // CREDITS TO SEDGEWICK AND WAYNE
                
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        int upcounter = 0;
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w = w - weights[n];
                upcounter++;
            }
            else {
                take[n] = false;
            }
        }

        // print results
        System.out.println(upcounter);
        for (int n = 1; n <= N; n++) {
            if(take[n]){
                System.out.print(n-1+" ");
            }
        }

        /*
        int[][] grid = new int[numItems+1][capacity+1];
        for(int i = 0; i<=capacity; i++){
            grid[0][i] = 0;
        }
        for(int i = 0; i<=numItems; i++){
            grid[i][0] = 0;
        }

        for(int i = 1; i<=numItems; i++){
            for(int k = 1; k<=capacity; k++){
                if(weights[i-1]<=k){
                    grid[i][k] = max(values[i-1]+grid[i-1][k-weights[i-1]], grid[i-1][k]);
                }else{
                    grid[i][k] = grid[i-1][k];
                }

                System.out.println("Step "+i+k);
                for(int ii = 0; ii<=numItems; ii++){
                    for(int kk = 0; kk<=capacity; kk++){
                        System.out.print(grid[ii][kk]+" ");
                    }
                    System.out.println();
                }
            }
        }
        ArrayList<Integer> sol = new ArrayList<>();
        int res = grid[numItems][capacity]; 
        int w = capacity;
        
        System.out.println("max value is : "+res);
        for (int i = numItems; i > 0  &&  res > 0; i--) {
            if (res != grid[i-1][w]) {
              sol.add(i-1);
              // we remove items value and weight
              res = res - values[i-1];
              w = w - weights[i-1];
            }
          }
        System.out.println(sol.size());
        for(int i : sol){
            System.out.println(i);
        }

     */   
    }
    static int max(int a, int b) { return (a > b)? a : b; }
    
}