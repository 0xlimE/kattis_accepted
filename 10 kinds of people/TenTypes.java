import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
public class TenTypes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int[][] field = new int[height][width];
        int[][] ids = new int[height][width];
        ArrayList<Set<Position>> listPos = new ArrayList<>();

        //read input into grid
        for(int i = 0; i<height; i++){
            String read = sc.next();
            for(int k = 0; k<width; k++){
                field[i][k] = Character.getNumericValue(read.charAt(k));
            }
        }

        //give all placements a value
        int counter = 0;
        for(int i=0; i<height; i++){
            for(int k = 0; k<width; k++){
                ids[i][k] = counter;
                counter++;
            }
        }
        
        int roads = sc.nextInt() * 2;
        Queue<Position> queue = new LinkedList<>();
        for(int i = 0; i<roads; i++){
            queue.add(new Position(sc.nextInt(),sc.nextInt()));
        }

        UF uf = new UF(height*width);
            for(int i = 0; i<height;i++){
                for(int k = 0; k<width;k++){
                    if(i!=height-1){
                        if(field[i][k]==field[i+1][k]){
                            uf.union(ids[i][k], ids[i+1][k]);
                        }
                    }
                    if(k!=width-1){
                        if(field[i][k]==field[i][k+1]){
                            uf.union(ids[i][k], ids[i][k+1]);
                        }
                    }
                }
            }

        //System.out.println(queue.size());
        while(!queue.isEmpty()){
            Position p1 = queue.poll();    
            Position p2 = queue.poll();
            
            int type = field[p1.height-1][p1.width-1];
            int otherType = field[p2.height-1][p2.width-1];
            if(type != otherType){
                System.out.println("neither");
                continue;
            }
            
            //Using UF
            if(uf.connected(ids[p1.height-1][p1.width-1], ids[p2.height-1][p2.width-1])){
                if(type == 1){
                    System.out.println("decimal");
                }else{
                    System.out.println("binary");
                }
            }else{
                System.out.println("neither");
            }
            /* USING BFS
            if(seenBefore(p1, p2, listPos,type)){
                continue;
            }else{
                System.out.println(find(field,p1,p2,height,width,listPos));
            }
            */
            
        }



    }
    public static boolean seenBefore(Position p1, Position p2, ArrayList<Set<Position>> listPos,int type){
        for(Set<Position> s : listPos){
            if(s.contains(p1) && s.contains(p2)){
                if(type == 1){
                    System.out.println("decimal");
                    return true;
                }else{
                    System.out.println("binary");
                    return true;
                }
            }
        }
        return false;
    }
    public static String find(int[][] field, Position p1, Position p2, int height, int width,ArrayList<Set<Position>> listPos){
        int type = field[p1.height-1][p1.width-1];
        //System.out.println("type is :" + type);
        HashSet<Position> set = new HashSet<>();
        Queue<Position> stack = new LinkedList<>();
        set.add(p1);
        stack.add(p1);
        
        while(!stack.isEmpty()){
            Position next = stack.poll();
            //System.out.println("next is at "+next.height +" , "+next.width+" and dist is at "+ p2.height+" , "+p2.width);
            if(next.width == p2.width && next.height == p2.height){
                listPos.add(set);
                if(type == 1){
                    return "decimal";
                }else{
                    return "binary";
                }
                
            }
            int heightInArray = next.height-1;
            int widthInArray = next.width-1;
                if((heightInArray-1 >= 0)){
                    if((field[heightInArray-1][widthInArray] == type) && (!set.contains(new Position(next.height-1, next.width)))){
                        set.add(new Position(next.height-1, next.width,next));
                        stack.add(new Position(next.height-1, next.width,next));
                    }
                }
                
                if((widthInArray-1 >= 0)){
                    if((field[heightInArray][widthInArray-1] == type) && (!set.contains(new Position(next.height, next.width-1)))){
                        set.add(new Position(next.height, next.width-1,next));
                        stack.add(new Position(next.height, next.width-1,next));
                    }
                } 

                if((heightInArray+1 < height)){
                    if((field[heightInArray+1][widthInArray] == type) && (!set.contains(new Position(next.height+1, next.width)))){
                        set.add(new Position(next.height+1, next.width,next));
                        stack.add(new Position(next.height+1, next.width,next));
                    }
                }          
                
                if((widthInArray+1 < width)){
                    if((field[heightInArray][widthInArray+1] == type) && (!set.contains(new Position(next.height, next.width+1)))){
                        set.add(new Position(next.height, next.width+1,next));
                        stack.add(new Position(next.height, next.width+1,next));
                    }
                }
            
        }
        listPos.add(set);
        return "neither";
    }

    public static class Position{
        int height;
        int width;
        public Position pl;
        public Position(int height, int width){
            this.height = height;
            this.width = width;
        }
        public Position(int height, int width, Position pl){
            this.height = height;
            this.width = width;
            this.pl = pl;
        }
        @Override 
        public boolean equals(Object o){
            Position e = (Position) o;
            if((this.height == e.height)&&(this.width == e.width)){
                return true;
            }else return false;
        }
        @Override
        public int hashCode(){
            return (height*197)*(width*241);
        }
    }

    public static class UF {

        private int[] parent;  // parent[i] = parent of i
        private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
        private int count;     // number of components
    
        public UF(int n) {
            if (n < 0) throw new IllegalArgumentException();
            count = n;
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            validate(p);
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }
    
 
        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
      

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
    
            // make root of smaller rank point to root of larger rank
            if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }
    
        // validate that p is a valid index
        private void validate(int p) {
            int n = parent.length;
            if (p < 0 || p >= n) {
                throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
            }
        }
    

    
    }

    
    
}