import java.util.Scanner;
import java.util.ArrayList; 
import java.util.HashMap;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class FourThought{
    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            numbers.add(sc.nextInt());
        }
        map.put(256,"4 * 4 * 4 * 4");
map.put(32,"4 * 4 + 4 * 4");
map.put(0,"4 / 4 / 4 / 4");
map.put(-1,"4 - 4 / 4 - 4");
map.put(1,"4 / 4 - 4 + 4");
map.put(2,"4 / 4 + 4 / 4");
map.put(-4,"4 / 4 / 4 - 4");
map.put(68,"4 + 4 * 4 * 4");
map.put(4,"4 / 4 / 4 + 4");
map.put(-7,"4 / 4 - 4 - 4");
map.put(-8,"4 - 4 - 4 - 4");
map.put(7,"4 - 4 / 4 + 4");
map.put(8,"4 / 4 * 4 + 4");
map.put(9,"4 / 4 + 4 + 4");
map.put(-15,"4 / 4 - 4 * 4");
map.put(15,"4 * 4 - 4 / 4");
map.put(-16,"4 - 4 - 4 * 4");
map.put(16,"4 / 4 * 4 * 4");
map.put(17,"4 / 4 + 4 * 4");
map.put(24,"4 + 4 + 4 * 4");
map.put(-60,"4 - 4 * 4 * 4");
map.put(60,"4 * 4 * 4 - 4");
        /*
        for(int i = 0; i<4; i++){
            for(int k = 0; k<4; k++){
                for(int j = 0; j<4; j++){
                    String toEval = evalToString(i, k, j);
                    map.put(evalStringToInt(toEval), toEval);
                    System.out.println("map.put("+evalStringToInt(toEval)+","+"\""+toEval+"\""+");");
                }
            }
        }*/
        for(int k : numbers){
            if(map.get(k) == null){
                System.out.println("no solution");
            }else{
                System.out.println(map.get(k) + " = "+k);
            }

        }
    }
    
    public static int evalStringToInt(String input){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try{
            return (int) engine.eval(input);
        }catch(Exception e){
            return 0;
        }
    }
    public static String evalToString(int one, int two, int three){
        return "4 "+getString(one)+ " 4 "+ getString(two) + " 4 " + getString(three)+ " 4";
    }
    public static String getString(int i){
        if(i == 0){
            return "/";
        }else if(i == 1){
            return "*";
        }else if(i == 2){
            return "-";
        }else if(i == 3){
            return "+";
        }else return "fuck";
    }
}