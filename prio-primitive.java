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
		int[] BTT = new int [n];
		int[] prio = new int[n];
		int[] CT = new int[n];
		int[] TAT = new int[n];
		int[] WT = new int[n];
		for(int i = 0; i < n; i++) {
			Pid[i] = sc.nextInt();
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			prio[i] = sc.nextInt();
			BTT[i] = BT[i];
		}
		
		//non-primitive
		
//		while(true) {
//			if(total == n) {
//				break;
//			}
//			int c = n;
//			int min = 99;
//			for(int i = 0; i < n; i++) {
//				if(AT[i] <= st && F[i] == 0 && prio[i] < min) {
//					c = i;
//					min = prio[i];
//				}
//			}
//			if( c == n) {
//				st += 1;
//			}
//			else {
//				CT[c] = st + BT[c];
//				F[c] = 1;
//				st = CT[c];
//				total++;
//			}
//		}
		
		//primitive 
		while(true) {
			if(total == n) {
				break;
			}
			int c = n;
			int min = 99;
			
			for(int i = 0; i < n; i++) {
				if(AT[i] <= st && F[i]== 0 && min > prio[i]) {
					min = prio[i];
					c= i;
				}
			}
			if(c == n) {
				st += 1;
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
			WT[i] = TAT[i] - BTT[i];
		}
		System.out.println("Pid[i]"+ "\t" + "AT[i]"+ "\t" + "BT[i]"+ "\t"  + "prio[i]" + "\t" + "CT[i" + "\t" + "TAT[i]"  + "\t" + "WT[i]");
		for(int i = 0; i < n; i++) {
			System.out.println(Pid[i]+ "\t" + AT[i]+ "\t" + BT[i]+ "\t"  + prio[i]+ "\t"+ CT[i]+ "\t" + TAT[i]  + "\t" + WT[i]);
		}
	}
}
