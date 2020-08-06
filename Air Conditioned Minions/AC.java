import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class AC{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minions = sc.nextInt();
        ArrayList<FromTo> list = new ArrayList<>();
        for(int i = 0; i<minions; i++){
            list.add(new FromTo(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        int room = list.get(0).to;
        int count = 1;

        for(FromTo ft : list){
            if(ft.from <= room){
                if(ft.to < room){
                    room = ft.to;
                }
            }else{
                room = ft.to;
                count++;
            }
        }
        System.out.println(count);
    }


    static class FromTo implements Comparable<FromTo> {
    
        int from;
        int to;
        
        public FromTo(int a , int b) {
            from = a;
            to = b;
        }
        
        public int compareTo(FromTo ft) {
            if (this.from == ft.from)
                return this.to - ft.to;
            
            return this.from - ft.from;
        }
    }
}