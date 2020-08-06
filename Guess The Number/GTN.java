import java.util.Scanner;
public class GTN{
    public static void main(String args[]){
        int max = 1001;
        int min = 1;
        int number = 501;
        String lastInput;
        System.out.println(number);
        Scanner sc = new Scanner(System.in); 
        lastInput = sc.nextLine();
        while(!lastInput.equals("correct")){
            if(lastInput.equals("lower")){
                max = number;
                number = (min+number)/2;
                System.out.println(number);
                lastInput = sc.nextLine();
            }else if(lastInput.equals("higher")){
                min = number;
                number = (max+number)/2;
                System.out.println(number);
                lastInput = sc.nextLine();
            }
        }
    }
}