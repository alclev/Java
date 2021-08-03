public class Flight implements Comparable<Time> {  
private String id;
private Time departure;
private Time duration;
    public Flight(String id, Time departure, Time duration){
        this.id=id;
        this.departure= departure;  //constructor that takes the flight id, departure time, and duration time
        this.duration= duration;
    }
@Override
    public String toString(){
        String A= id;
        String B = "Departs "+String.format("%02d:%02d", departure.getHours(), departure.getMins());
        String C= "Arrives "+String.format("%02d:%02d", getArrival().getHours(),getArrival().getMins());
        return A+"\t"+B+"\t"+C;
    }
    /**
     * splitting up the string output into segments with just hours and minutes and then returning the combined
     * version with tabs
     * 
     */
    public Time getDeparture(){
        return departure;  //returns a time 
    }
    public Time getArrival(){
        return new Time(departure.getTime()+duration.getTime());
    }
    /**creates a new instance of time constructed by the sum of departure and duration fractional hours
     * 
     */
    public void delay(Time duration){
        departure.increase(duration.getTime()); //increases time of departure
    }
    public boolean arrivesBefore(Flight next){
        return this.getArrival().getTime() < next.getDeparture().getTime();
    } //returns true if this flight arrives earlier than the departure of the other flight and false otherwise 
    public boolean departsAfter(Flight previous){
        return this.getDeparture().getTime() > previous.getArrival().getTime();
    }  //returns true if this flight departs later than the arrival time of the other flight and false otherwise.  
    @Override
    public int compareTo(Time o) {
        if (this.getDeparture().getTime()< o.getTime()){
            return -1;  //outputs -1 if the time of departure is before time o
        }
        if (this.getDeparture().getTime() > o.getTime()){
            return 1;  ////outputs 1 if the time of departure is after time o
        }
        return 0;  ////outputs 0 if the time of departure is the same as time o
    }
   
}

