import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class PigLatin{
    public static void main(String args[]){
        HashSet<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        vowels.add("y");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String toPrint = "";
        while(line != null){

            String[] words = line.split(" ");
            for(String s : words){
                if(vowels.contains( Character.toString(s.charAt(0)))){
                    toPrint = toPrint +s+"yay ";
                }
                else{
                    int nextVowel;
                    for(int i =0; i<s.length(); i++){
                        if(vowels.contains( Character.toString(s.charAt(i)))){
                            toPrint = toPrint + s.substring(i,s.length()) + s.substring(0,i) + "ay ";
                            break;
                        }else{
                            continue;
                        }
                    }
                }
            }
            System.out.println(toPrint.substring(0,toPrint.length()-1));
            toPrint = "";
            if(sc.hasNext()){
                line = sc.nextLine();
            }else{
                line = null;
            }
        }
    }
}