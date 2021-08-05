import java.util.ArrayList;

public class Figuring {
	public int decipher(int i) {
		return (i * 21) % 26;
	}

	public int prime(int mult, int n) {
		int answer = 0;
		for (int i = 1; i < n; i++) {
			if ((mult * i) % n == 1) {
				answer = i;
			}
		}
		return answer;
	}

	public String toBinary(int k) {
		ArrayList<String> str = new ArrayList<String>();

		while (k >= 1) {
			str.add(Integer.toString(k % 2));
			k /= 2;
		}
		String bin = "";
		for (int j = str.size() - 1; j >= 0; j--) {
			bin += str.get(j);
		}
		return bin;
	}

	/*
	 * public int highEx(int base, int power) {
	 * 
	 * }
	 */

	public ArrayList<String> exAlg(int base, int power, int mod) {
		ArrayList<String> str = new ArrayList<String>();
		String bin = toBinary(power);
		int maxPow = bin.length() - 1;
		int prog;
		str.add("(" + base + ")" + "^2^0----> " + base + " (mod " + mod + ")");
		for (int i = 0; i < maxPow; i++) {
			prog = (int) (Math.pow(base, 2) % mod);

			str.add("(" + base + ")" + "^2^" + (i + 1) + "----> " + prog + " (mod " + mod + ")");
			base = prog;
		}
		return str;
	}
	public double fact(double n) {
		int tot=1;
		if (n==0) {
			return 1;
		}
		else {
			while(n>0) {
				tot*=n;
				n-=1;
			}
			return tot;
		}
	}
	public double series() {
		int x=0;
		double sum= new Double(0);
		while (x<2) {
			sum += Math.pow((1/16),x);
			x++;
		}
		return sum;
	}
	
	

	public static void main(String[] args) {
		Figuring pro = new Figuring();
		
		System.out.println(pro.series());
		
	}

}
