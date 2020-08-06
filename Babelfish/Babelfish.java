import java.util.*;



public class Babelfish {
	public static void main(String[] args) {
        ArrayList<String> toprint = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<String,String>();
        boolean translating = false;
        while(sc.hasNext()){
            String nextline = sc.nextLine();
            if(nextline == null){
                return;
            }else if(nextline.isEmpty()){
                translating = true;
            }else if(translating){
                if(map.containsKey(nextline)){
                    toprint.add(map.get(nextline));
                }else{
                    toprint.add("eh");
                }
            }else{
                String[] strings = nextline.split(" ");
                map.put(strings[1], strings[0]);
            }
            

        }
        for(String t : toprint){
            System.out.println(t);  
        }
    }
        


}