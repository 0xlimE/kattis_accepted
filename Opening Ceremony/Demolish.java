import java.util.Arrays;
import java.util.Scanner;

public class Demolish{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int startTowers = sc.nextInt();

        int[] heights = new int[startTowers];
        for(int i = 0; i<startTowers; i++){
            heights[i] = sc.nextInt();
        }
        Arrays.sort(heights);
        int lowest = heights[heights.length-1];
        if(lowest > heights.length){
            lowest = heights.length;
        }
        for(int i = heights.length-1; i > -1; i--){
            int found = (heights.length-(i+1)) + heights[i];
            
            if(found<lowest){
                lowest = found;
            }
        }
        System.out.println(lowest);
    }
}