import java.util.Scanner;
import java.math.BigInteger;
public class Wizard{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        int guess = sc.nextInt();
        BigInteger big = new BigInteger(line);

        if(new BigInteger("2").pow(guess).compareTo(big) >=0 ){
            System.out.println("Your wish is granted!");
        }else{
            System.out.println("You will become a flying monkey!");
        }
    }
}