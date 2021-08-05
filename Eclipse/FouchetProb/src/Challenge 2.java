
public class Challenge {
	private float sum;
	private float n;
	private float temp;
	private float score;
	private float div;

	public float solve() {
		div= 1;
		n=1;
		score= (int) (Math.random() * 10);
		for (int i = 0; i < 10000000; i++) {
			temp = (int) (Math.random() * 10);
			if(temp <= Float.parseFloat((String.valueOf(score).substring(String.valueOf(score).length()-1)))){
				div *=10;
				temp/=div;
				
				score += temp;
				n++;
			}
			sum+= score/10;
		}
		
		
		return sum/n;

	}

	public static void main(String[] args) {
		Challenge t = new Challenge();
		System.out.println(t.solve());
	}
}