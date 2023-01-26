
/**
 * Time creates an object with hours and minutes for the other classes
 *
 * @author Roman Gofman
 * @version 2/21/20
 */
public class Time
{
    //Constants
    public static final int MIN_IN_HOUR = 60;
    public static final int HOURS_IN_DAY = 24;
    
    // instance variables - replace the example below with your own
    private int hour;
    private int minute;

    /**
     * Constructor for objects of class Time
     * @param hour - integer representing the hours
     * @param minute - integer representing the minutes
     */
    public Time(int hour, int minute)
    {
        // initialise instance variables and validate
        setHour(hour);
        setMinute(minute);
    }

    /**
     * gets the hour value
     * 
     */
    public int getHour(){ return(hour);}

    /**
     * gets the minute value
     * 
     */
    public int getMinute(){return(minute);}

    /**
     * This method validates then sets the variable hour to the value.
     * @param hour - variable to be validated 
     */
    public void setHour(int hour)
    {
        if(hour >= 0 && hour < HOURS_IN_DAY){
            this.hour = hour;
        }else{
            throw new IllegalArgumentException("Please make sure thet your hour" 
                + " value is between 0 and 24.");
        }
    }

    /**
     * This method validates then sets the variable minute to the value.
     * @param minute - variable to be validated 
     */
    public void setMinute(int minute)
    {
        if(minute >= 0 && minute < MIN_IN_HOUR){
            this.minute = minute;
        }else{
            throw new IllegalArgumentException("Please make sure thet your minute" 
                + " value is between 0 and 59.");
        }

    }

    /**
     * This method takes in a time object and returns the difference
     * @param newTime - a time object that is used for the calculations
     */
    public Time timeBetween(Time newTime)
    {
        boolean hourCarryOver = false;
        int minuteDiff = newTime.minute - this.minute;
        //minute calculation
        if (minuteDiff < 0) {
            minuteDiff += MIN_IN_HOUR;
            hourCarryOver = true;
        }
        //hour calculation
        int hourDiff = newTime.hour - this.hour;
        if (hourDiff < 0) {
            hourDiff += HOURS_IN_DAY;
        }
        if (hourCarryOver) {
            hourDiff--;
        }
        return new Time(hourDiff, minuteDiff);
    }
    
    /**
     * This calculates the minute value of the above method
     *  @param newTime - a time object that is used for the calculations
     */
    public int minBetween(Time newTime){
        Time diff = timeBetween(newTime);
        return diff.getHour() * 60 + diff.getMinute();
    }
    
    /**
     * This method formats the time correctly
     * @param hour - integer representing the hours
     * @param minute - integer representing the minutes
     */
    public String zeroTime(int hour, int minute){
        String hourString = "" + hour;
        String minuteString = "" + minute;
        if(hour <= 9){
            hourString = "0" + hour;
        }
        if(minute <= 9){
            minuteString = "0" + minute;
        }
        return hourString + ":" + minuteString;
    }
    
    /**
     * This is a method that returns the result as a string
     */
    public String toString(){
        return zeroTime(hour, minute);
    }
}
