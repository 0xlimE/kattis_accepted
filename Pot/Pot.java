import java.util.Scanner;
public class Pot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        int result = 0;
        for(int i = 0; i<lines; i++){
            String line = sc.next();
            result += Math.pow(Integer.parseInt(line.substring(0, line.length()-1)),Integer.parseInt(line.substring(line.length()-1)));
        }
        System.out.println(result);
    }
}