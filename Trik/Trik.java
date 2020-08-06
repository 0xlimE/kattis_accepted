import java.util.Scanner;
public class Trik{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int[] lol = new int[4];
        lol[0] = 0;
        lol[1] = 1;
        lol[2] = 0;
        lol[3] = 0;
        for(int i = 0; i<in.length(); i++){
            if(in.charAt(i) == 'A'){
                int temp = lol[1];
                lol[1] = lol[2];
                lol[2] = temp;
            }else if(in.charAt(i) == 'B'){
                int temp = lol[2];
                lol[2] = lol[3];
                lol[3] = temp;
            }else{
                int temp = lol[1];
                lol[1] = lol[3];
                lol[3] = temp;
            }
        }
        for(int i = 0; i<4; i++){
            if(lol[i] == 1){
                System.out.println(i);
            }
        }
    }
}

