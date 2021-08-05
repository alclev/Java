
public class TestMatrix {
	private static boolean act = true;

	public static void main(String [] args) {
		//I forgot how to prompt the user in java. I did not know we would be tested on that. 
		
		//prompt
		char input;
		Matrix mat= new Matrix(2);
		
		
		while(act) {
			
			if(input == 'd') {
				mat.display();
			}
			if(input == 'm') {
				mat.mult((int) (10*Math.random()));
			}
			if(input == 't') {
				mat.transpose();
			}
			if(input == 'i') {
				mat.inverse();
			}
			if(input == 'q') {
				act = false;
			}
			
		}
	}
}
