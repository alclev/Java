import java.util.ArrayList;
import java.util.Scanner;

public class Primary {
    public static boolean isPrime(int candidate, ArrayList<Integer> knownPrimes){
        for (Integer knownPrime : knownPrimes){
            //for every known primes in the list of known primes
            if (knownPrime * knownPrime > candidate){
                return true;
        }
            if (candidate % knownPrime == 0){
                return false;
            }
            ///end of loop
            }
        return false;
    }

  public static void main(String[] args) {
        Scanner input = new Scanner (System.in); 
        System.out.println("Which prime?");
        int nbrOFPrimes = input.nextInt();
        
        ArrayList<Integer> knownPrimes = new ArrayList(); 
        knownPrimes.add(2); 
        
        int candidate = 3; 
        //find number of primes
        while(knownPrimes.size() < nbrOFPrimes) {
            if (isPrime(candidate, knownPrimes)){
                knownPrimes.add(candidate);
            }
            candidate += 2;
        }
        
        System.out.println("Prime " + nbrOFPrimes + " is " + 
                knownPrimes.get(knownPrimes.size()-1));
        }
}
        
