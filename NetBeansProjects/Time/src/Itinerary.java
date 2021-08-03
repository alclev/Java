
import java.util.ArrayList;
import java.util.List;

public class Itinerary {

    private List<Flight> flights;

    /**
     * creates an arrayList of flights
     */
    public Itinerary() {
        flights = new ArrayList<>();
    }

    public boolean addFlight(Flight segment) {
        if (flights.isEmpty()) {
            return flights.add(segment); //case 1- list is empty
        } else if (segment.arrivesBefore(flights.get(0))) {
            flights.add(0, segment);
            return true;  //case 2- goes in the very beginning of list
        } else if (flights.get(flights.size() - 1).arrivesBefore(segment)) {
            return flights.add(segment); //case 3- goes in the very last slot of the list
        } else {
            for (int i = 1; i < flights.size(); i++) {
                if (flights.get(i - 1).arrivesBefore(segment) && flights.get(i).departsAfter(segment)) {
                    flights.add(i, segment);
                    return true; //case 4- goes in between two of the other flights already in the list
                } //addFlight puts flights in order without conflicts of departure/arrival times
            }
        }
        return false; //flight could not be addded because of conflict
    }

    public boolean removeFlight(Flight segment) {
        return flights.remove(segment);  //if segment is in the list- removes and returns true
    }//if segment is not in the list- returns false

    public void clearFlights(Time from, Time to) {
        for (int i = 0; i < flights.size(); i++) {
            if ((flights.get(i).getDeparture().getTime() >= from.getTime() || flights.get(i).getArrival().getTime() >= from.getTime()) && (flights.get(i).getDeparture().getTime() <= to.getTime() || flights.get(i).getArrival().getTime() <= to.getTime())) {
                flights.remove(i);
                i--;
            }//clears all flights with departure or arrival times within the from or to interval of time
        }  //isLaterThan and isEarlierThan was not used because they did not include the from and to times (<= vs <)
    }

    public Time itineraryLength() {
        double total = flights.get(flights.size() - 1).getArrival().getTime() - flights.get(0).getDeparture().getTime();
        return new Time(total);
    } //finds difference of departure of first flight and arrival of last

    public Time longestLayover() {
        double layover;
        double largest = 0;
        for (int i = 1; i < flights.size(); i++) {
            layover = flights.get(i).getDeparture().getTime() - flights.get(i - 1).getArrival().getTime(); //time inbetween flights using difference
            if (layover > largest) {
                largest = layover;
            }
        }
        return new Time(largest);// creates new instance of Time with the largest layover time
    }

    @Override
    public String toString() {
        String result = new String();
        for (int i = 0; i < flights.size(); i++) {
            result += "Flight: " + flights.get(i) + "\n";
        }
        return result;//returns string that is a representation of the accumulation of flights in the arrayList
    }
}
