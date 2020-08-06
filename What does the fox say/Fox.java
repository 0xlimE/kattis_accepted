import java.util.*;

public class Fox {
    public static Set<String> set;
    public static Scanner sc;
	public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        set = new HashSet<String>();
        for(int i = 0; i<cases; i++){
            String s = sc.nextLine();
            //System.out.println(s);
            String[] sounds = s.split(" ");
            parseSounds();
            for(int k = 0; k<sounds.length; k++){
                //System.out.println(sounds[k]);
                if(set.contains(sounds[k])){
                    //System.out.println(" I know "+ sounds[k]);
                    continue;
                }else{
                    if(k == sounds.length){
                        System.out.println(sounds[k]);
                    }else{
                        System.out.print(sounds[k]+" ");
                    }
                    
                }
            }
            set.clear();

        }
    }
    
    public static void parseSounds(){
        String[] lines = sc.nextLine().split(" ");
        while(true){
            if(lines[0].equals("what")){
                break;
            }else{
                set.add(lines[2]);
            }
            lines = sc.nextLine().split(" ");
        }
    }
        


}