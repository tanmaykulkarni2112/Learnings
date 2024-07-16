package Main;
import java.util.*;

public class priority {

	public static void main(String[] args) {
		System.out.println("Enter the size of the array");
		int st = 0;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] F = new int[n];
		int[] Pid = new int[n];
		int[] AT = new int[n];
		int[] BT = new int[n];
		int[] prio = new int[n];
		int[] CT = new int[n];
		int[] TAT = new int[n];
		int[] WT = new int[n];
		for(int i = 0; i < n; i++) {
			Pid[i] = sc.nextInt();
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			prio[i] = sc.nextInt();
		}
		
		while(true) {
			int c = n;
			int min = 99;
			if(total == n) {
				break;
			}
			for(int i = 0; i < n; i++) {
				if(AT[i] <= st && F[i]== 0 && min > prio[i]) {
					min = prio[i];
					c= i;
				}
			}
			if(c == n) {
				st++;
			}
			else {
				BT[c] = BT[c] - 1;
				st = st + 1;
			
				if(BT[c] == 0) {
					CT[c] = st;
					F[c] = 1;
					total++;
				}
			}
			
		}
		
		for(int i = 0; i < n ; i++) {
			TAT[i] = CT[i] - AT[i];
			WT[i] = TAT[i] - BT[i];
		}
		for(int i = 0; i < n; i++) {
			System.out.println(Pid[i]+ "\t" + AT[i]+ "\t" + BT[i]+ "\t"  + prio[i]+ "\t" + TAT[i]  + "\t" +WT[i]);
		}
	}
}
