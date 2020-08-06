import java.util.Scanner;
public class Polish{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int intersectionA = 0;
        int intersectionB = 0;
        boolean breaking = false;
        for(int i = 0; i<A.length(); i++){
            for(int k = 0; k<B.length(); k++){
                if(A.charAt(i) == B.charAt(k)){
                    intersectionA = i;
                    intersectionB = k;
                    breaking = true;
                    break;
                }
                 
            
            }
            if(breaking){
                break;
            }
        }
        for(int i = 0; i<B.length(); i++){
            for(int k = 0; k<A.length(); k++){
                if(i == intersectionB){
                    System.out.print(A);
                    break;
                }
                if(k == intersectionA){
                    System.out.print(B.charAt(i));
                }else{
                    System.out.print(".");
                }

            }
            System.out.println();
        }

    }
}