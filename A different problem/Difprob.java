import java.math.BigInteger;
import java.util.*;

public class Difprob {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            BigInteger first = new BigInteger(sc.next());
            BigInteger second = new BigInteger(sc.next());
            BigInteger result = first.subtract(second);
            String toPrint = result.toString();
            if(toPrint.charAt(0)=='-'){
                System.out.println(toPrint.substring(1));
            }else{
                System.out.println(toPrint);
            }

        }
    }
        


}