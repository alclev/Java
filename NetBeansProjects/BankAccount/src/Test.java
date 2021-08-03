


public class Test {
        public static void main (String[] args) {
 Bank bok = new Bank();
 System.out.println (bok.getTotalAssets());
 bok.openAccount ("Felix");
 bok.deposit ("Felix", 100);
 bok.withdraw ("Felix", 40);
 System.out.println (bok.getTotalAssets());
 bok.openAccount ("Kathy");
 bok.transfer ("Felix", "Kathy",60.0);
 System.out.println (bok.getBalance ("Kathy"));
 System.out.println (bok.getTotalAssets());
 System.out.println (bok.closeAccount ("Felix"));
 System.out.println (bok.getTotalAssets());
 }
}