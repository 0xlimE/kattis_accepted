import java.util.Scanner;
import java.util.HashSet;;
public class ND{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        String line = sc.nextLine();
        String[] words = line.split(" ");
        for(String t : words){
            set.add(t);
        }
        if(set.size() == words.length){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}