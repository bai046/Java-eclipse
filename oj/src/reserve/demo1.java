package reserve;

import java.util.Random;
import java.util.Scanner;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.print("please give me your number:");int t=sc.nextInt();
		sc.close();
		
		Random ra=new Random();
		System.out.print("hello,"+t+",your lucky number is:");int h=ra.nextInt(10)+1;
		System.out.println(h);
	}

}
