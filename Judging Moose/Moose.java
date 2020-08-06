import java.util.Scanner;
public class Moose{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        
        if(first == second){
            if(first == 0){
                System.out.println("Not a moose");
                return;
            }
            System.out.println("Even " + first*2);
        }else if(first > second){
            System.out.println("Odd "+ first*2);
        }else if(second > first){
            System.out.println("Odd "+ second*2);
        }
    }
}