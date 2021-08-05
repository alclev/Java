public class Testing {
 public static void main(String[] args) {
 Itinerary v = new Itinerary();
 v.addFlight(new Flight("one", new Time(2), new Time(1.5)));
 System.out.println(v);
 v.addFlight(new Flight("two", new Time(6), new Time(2)));
 v.addFlight(new Flight("three", new Time(1), new Time(0.75)));
 v.addFlight(new Flight("four", new Time(4), new Time(1)));
 System.out.println(v);

 v.addFlight(new Flight("five", new Time(0), new Time(2.5)));
 v.addFlight(new Flight("six", new Time(7), new Time(1)));
 v.addFlight(new Flight("seven", new Time(5), new Time(8)));
 System.out.println(v);

 System.out.println(v.longestLayover());
 System.out.println(v.itineraryLength());

 v.clearFlights(new Time(2.5), new Time(4.1));
 System.out.println(v);
 }
}