import java.util.Scanner;
public class Apax{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String out = "";
        char lastSeen = '.';
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==lastSeen){
                continue;
            }else{
                out = out + s.charAt(i);
                lastSeen = s.charAt(i);
            }
        }
        System.out.println(out);
    }
}