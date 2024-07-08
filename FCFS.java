package Main;
import java.util.Scanner;
public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = sc.nextInt();
		int[] PId = new int[n];
		int[] At = new int[n];
		int[] Bt = new int[n];
		int[] Ct = new int[n];
		int Tat[] = new int[n];
		int Wt[] = new int[n];
		int temp;
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter the values for PId");
			PId[i] = sc.nextInt();
			System.out.println("Enter the values for At");
			At[i] = sc.nextInt();
			System.out.println("Enter the values for Bt");
			Bt[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(At[j] > At[j+1]) {
				temp = At[j];
				At[j] = At[j+1];
				At[j+1] = At[j];
				
				temp = PId[j];
				PId[j] = PId[j+1];
				PId[j+1] = PId[j];
				
				temp = Bt[j];
				Bt[j] = Bt[j+1];
				Bt[j+1] = Bt[j];
				}
			}
		}
		
		for(int i = 0; i < n ; i++) {
			if(i == 0) {
				Ct[i] = At[i] + Bt[i];
			}
			else {
				if(At[i] > Ct[i-1]) {
					Ct[i] = At[i] + Bt[i];
				}
				else {
					Ct[i] = Ct[i-1] + Bt[i];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			Tat[i] = Ct[i] - At[i];
		}
		
		for(int i = 0; i < n; i++) {
			Wt[i] = Tat[i] - Bt[i];
		}
		

	}

}
