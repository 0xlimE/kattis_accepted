import java.util.*;
public class Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = sc.nextInt();

		int[] vals = new int[T];
		for(int i = 0; i<T; i++){
			vals[i] = 0;
		}
		
		for(int i = 0; i<N; i++){
			int value = sc.nextInt();
			int time = sc.nextInt();
			for(int k = time; k>= 0; k--){
				if(vals[k] == 0){
					vals[k] = value;
					break;
				}else if(vals[k] < value){
					int temp = vals[k];
					vals[k] = value;
					value = temp;
				}
			}
		}
		int sum = 0;
		for(Integer i : vals){
			sum = sum+i;
		}
		System.out.println(sum);
	}
}