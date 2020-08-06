import java.util.*;



public class PhoneList {

    public static class TrieNode {
        private HashMap<Integer, TrieNode> children;
        private boolean isnumber;

        public TrieNode(){
            children = new HashMap<>();
            isnumber = false;
        }
        
        public boolean exists(int input){
            return children.containsKey(input);
        }

        public void create(int input){
            children.put(input, new TrieNode());
        }

        public boolean isNumber(){
            return isnumber;
        }

        public TrieNode getChild(int input){
            return children.get(input);
        }

        public boolean hasChildren(){
            return (children.size() != 0);
        }
        
        public void makeNumber(){
            isnumber = true;
        }
        
        public void clear(){
            children = new HashMap<>();
            isnumber = false;
        }
    }

    static TrieNode root;
	public static void main(String[] args) {
        ArrayList<String> toPrint = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        root = new TrieNode();
        int rounds = sc.nextInt();
        boolean works = true;
        for(int i = 0; i<rounds; i++){
            int inputs = sc.nextInt();
            for(int k = 0; k<inputs; k++){
                String in = sc.next();
                if(!works){
                    continue;
                }
                if(!intoTrie(in)){
                    works = false;
                    continue;
                }
            }
            if(works){
                toPrint.add("YES");
            }else{
                toPrint.add("NO");
            }
            works = true;
            root.clear();
        }
        for(String t : toPrint){
            System.out.println(t);
        }
    }

    public static boolean intoTrie(String input){
        TrieNode currentLevel = root;
        for(int i = 0; i<input.length(); i++){
            
            if(currentLevel.isNumber()){
                return false;
            }
            int number = Character.getNumericValue(input.charAt(i));
            //System.out.println("looking at int : "+number+" at index"+i);
            if(currentLevel.exists(number)){
                //System.out.println("Have seen a "+number+" on index: "+i+" before, going in");
                currentLevel = currentLevel.getChild(number);
            }else{
                //System.out.println("nothing ends with "+number+" on index: "+i+" creating and going in");
                currentLevel.create(number);
                currentLevel = currentLevel.getChild(number);
            }
            
            
        }
        if(currentLevel.hasChildren()){
            //System.out.println("came to the end, but there are more children, this number is suffix");
            return false;
        }else{
            //System.out.println("Came to the end, with no children, make this a number");
            currentLevel.makeNumber();
            return true;
        }
    }
        


}