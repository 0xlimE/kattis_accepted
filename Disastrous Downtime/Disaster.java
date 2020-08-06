import java.util.Scanner;


import java.util.PriorityQueue;
public class Disaster{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int incoming = sc.nextInt();
        int load = sc.nextInt();
        PriorityQueue<SThread> pq = new PriorityQueue<>(); 
        for(int i = 0; i<incoming; i++){
            int p = sc.nextInt();
            pq.add(new SThread(true,p));
            pq.add(new SThread(false,p+1000));
        }
        int max= 0;
        int actual= 0;
        SThread thread;
        while(!pq.isEmpty()){
            thread = pq.poll();
            if(thread.incoming){
                actual++;
                if(actual>max){
                    max = actual;
                }
            }else{
                actual--;
            }
        }
        double d = ((double)max)/((double)load);
        System.out.println((int) Math.ceil(d));

        
    }

    public static class SThread implements Comparable<SThread>{
        boolean incoming;
        int time;
        public SThread(boolean incoming, int time){
            this.incoming = incoming;
            this.time = time;
        }

        // Overriding the compareTo method
        @Override
        public int compareTo(SThread t) {
            if(this.time != t.time){
                return this.time - t.time;
            }else if(this.incoming && !t.incoming){
                return 1;
            }else if(!this.incoming && t.incoming){
                return -1;
            }
            else return 0;
            
        }
    }
}