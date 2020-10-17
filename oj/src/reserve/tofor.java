package reserve;

public class tofor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		for(x=1; x<=9; x++) {
			for(y=1; y<=x;y++ ) {
				System.out.print(x+"X"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
	}

}
