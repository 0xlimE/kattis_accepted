import java.util.Scanner;
public class BabyBites{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] array = new String[number];
        for(int i = 0; i<number;i++){
            array[i] = sc.next();
        }
        int numberz = 1;
        for(int i = 1; i<number+1; i++){
            if(array[i-1].equals("mumble")){
                numberz++;
                continue;
            }else if(Integer.parseInt(array[i-1]) == numberz ){
                numberz++;
                continue;
            }else{
                System.out.println("something is fishy");
                return;
            }
        }
        System.out.println("makes sense");
    }
}

