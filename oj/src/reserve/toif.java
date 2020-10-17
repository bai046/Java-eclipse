package reserve;

import java.util.Scanner;

public class toif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int year =sc.nextInt();
		if(year%4==0&&year%100!=0||year%400==0)
			System.out.println(year+"是闰年");
		else System.out.println(year+"不是闰年");
		
		int x=sc.nextInt(); int sgn;
		if(x==0)sgn=0;
		else if(x>0)sgn=1;
		else sgn=-1;
		System.out.println(sgn);
		sc.close();
	}

}
