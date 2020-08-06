import java.util.Scanner;
public class QOL{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double total = 0.0;
        double years = 0.0;
        for(int i = 0; i<number; i++){
            double one = sc.nextDouble();
            double two = sc.nextDouble();
            years = years + two;
            total = total+(one*two);
        }
        System.out.println(total);
    }
}