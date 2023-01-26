/**
 * Train is the connecting class that does the calculations for the schedule class
 *
 * @author Roman Gofman
 * @version 2/21/20
 */
public class Train
{
    //Constants
    public static final int MIN_IN_HOUR = 60;
    public static final int HOURS_IN_DAY = 24;

    // instance variables - replace the example below with your own
    private String name;
    private Time departure;
    private Time arrival;
    private int distance; 

    /**
     * Constructor for objects of class Train
     * @param name - a string that is the name of the train
     * @param depatrure - a time object that is the departure time
     * @param arrival - a time object reperesenting the arrival time
     * @param distance - an integer representing the distance in km
     */
    public Train(String name, Time departure, Time arrival, int distance)
    {
        //Name validation
        if(name.matches("[A-Za-z]+[\\sA-Za-z]*")){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Your name must have only letters");
        }
        setDeparture(departure);
        setArrival(arrival);
        setDistance(distance);
    }

    /**
     * This gets departure
     * @return departure
     */
    public Time getDeparture(){return(departure);}

    /**
     * This gets arrival
     * @return arrival
     */
    public Time getArrival(){return(arrival);}

    /**
     * This gets distance
     * @return distance
     */
    public int getDistance(){return(distance);}

    /**
     * sets departure equal to the parameter
     * @param newTime - a time object
     */
    public void setDeparture(Time newTime){this.departure = newTime;}

    /**
     * sets arri equal to the parameter
     * @param newTime - a time object
     */
    public void setArrival(Time newTime){this.arrival = newTime;}

    /**
     * validates distance then sets it equal to distance
     * @param distance - integer in km
     * 
     */
    public void setDistance(int distance){
        //validates distance
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0");
        }
        this.distance = distance;
    }

    /**
     * calculates average speed in km/h
     * 
     */
    public int averageSpeed(){
        return (int) Math.round(((double) this.distance / departure.minBetween(arrival) * MIN_IN_HOUR));
    }

    /**
     * Calculates travel time between arrival and departure
     * 
     */
    public Time travelTime() {
        return departure.timeBetween(arrival);
    }

     /**
     * This is a method that returns the result as a string
     */
    public String toString(){
        return name +"\nDeparture       "+ departure.toString() + "\nArrival          " + arrival.toString() +
        "\nTravel Time    " + travelTime().toString() + "\nAverage  speed " + averageSpeed() + "km/h\n\n";

    }
}
