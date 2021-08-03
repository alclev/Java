
public class Time implements Comparable<Time> {

    private int seconds;

    public Time() {
        this.seconds = 0;  //constructor that initializes seconds as zero
    }

    public Time(int hours, int minutes, int seconds) {  //constructor that takes minutes and seconds
        this.seconds += hours *3600;
        this.seconds += minutes * 60;  //converts minutes to seconds and adds it to seconds
        this.seconds += seconds;  
    }

    public Time(double hours) {  //constructor that takes fractional hours
        this.seconds += hours * 3600;   //converts fractional hours to seconds 
    }  //and adds it to seconds

    /**
     *
     */
    public void increase(int hours, int minutes, int seconds) {
        this.seconds += (hours * 3600) + (minutes * 60) + seconds;
    } //converts each arguement to seconds and adds it to the value of seconds

    public void increase(double hours) {
        this.seconds += hours * 3600;
    }  //converts arguement hours to seconds and adds it to the value of seconds

    /**
     *
     */
    public Time timeUntil(Time other) {
        Time elapsed = new Time(other.getTime() - this.getTime());
        return elapsed;
    } //makes reference to an instance of time where seconds equals the difference of the other and this *3600

    /**
     *
     *
     */
    public boolean isEarlierThan(Time other) {
        return this.getTime() < other.getTime();
    }  //if the time in Object "this" is less than the time in object "other"- return true -else false

    public boolean isLaterThan(Time other) {
        return this.getTime() > other.getTime();
    }  //if the time in object "this" is greater than the time in object "other" -return true -else return false

    public boolean equals(Time other) {
        return this.getTime() == other.getTime();
            
    }

    /**
     *
     *
     */
    @Override
    public int compareTo(Time other) {
        if (this.getTime() < other.getTime()) {  //-1 if time value of this is less than other
            return -1;
        }
        if (this.getTime() > other.getTime()) { //1 if time value of this is greater than other
            return 1;
        }
        return 0;  //0 if they are equal
    }  

    /**
     *
     *
     */
    public int getHours() {
        return seconds / 3600;  //conversion from seconds to hours component
    }

    public int getMins() {
        return (seconds % 3600) / 60;  //conversion from seconds to minutes component
    }

    public int getSecs() {
        return seconds % 60;  //conversion from seconds to seconds component
    }

    public double getTime() {
        return seconds / (double) 3600;  //conversion from seconds to fractional hours
    }

    /**
     *
     */
    public String toString() {
        return String.format("%02d:%02d:%02d", getHours(), getMins(), getSecs());
    }
}//converts each component of the time to a string that can be easily interpreted by the user
