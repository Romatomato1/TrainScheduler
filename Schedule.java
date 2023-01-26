//Import statements
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

/**
 * formats information from train class to be printed in schedule app
 *
 * @author Roman Gofman
 * @version 2/21/20
 */
public class Schedule
{
    // variables
    private Train[] trains;
    private int distance;

    /**
     * Constructor for objects of class Schedule
     * @param fileName - string thet is the name of the file
     * @throws FileNotFoundException
     */
    public Schedule(String fileName) throws FileNotFoundException
    {
        fillArray(fileName);
    }

    /**
     * Fills the array with the contents of the file that is read
     * @param filename - String that allows to read and take in information
     * 
     */
    public void fillArray(String fileName) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(fileName));//create object
        distance = fileReader.nextInt();//first two numbers
        int numTrains = fileReader.nextInt();
        trains = new Train[numTrains];
        for (int i = 0; i < numTrains; i++) {//reads file
            fileReader.nextLine();
            String trainName = fileReader.nextLine();
            int hourDepart = fileReader.nextInt();
            int minuteDepart = fileReader.nextInt();
            int hourArrive = fileReader.nextInt();
            int minuteArrive = fileReader.nextInt();
            Time depart = new Time(hourDepart, minuteDepart);
            Time arrive = new Time(hourArrive, minuteArrive);
            trains[i] = new Train(trainName, depart, arrive, distance);
        }
    }

    /**
     * It finds the fastest train 
     */
    public Train fastestTrain() {
        Train fastest = null;
        int maxSpeed = 0;
        for (int i = 0; i < trains.length; i++) {
            int trainSpeed = trains[i].averageSpeed();
            if (trainSpeed > maxSpeed) {
                maxSpeed = trainSpeed;
                fastest = trains[i];
            }
        }
        return fastest;
    }

    /**
     * This sorts the departure times
     */
    public void sortDeparture() {
        int n = trains.length;
        Train temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (trains[j].getDeparture().getHour() < trains[j-1].getDeparture().getHour() || (trains[j].getDeparture().getHour() == trains[j-1].getDeparture().getHour() && trains[j].getDeparture().getMinute() < trains[j-1].getDeparture().getMinute())) {
                    temp = trains[j-1];
                    trains[j-1] = trains[j];
                    trains[j] = temp;
                }
            }
        }
    }

    /**
     * This is a method that returns the result as a string
     */
    public String toString(){
        String result = "";
        for(int i = 0; i < trains.length; i++){
            result += trains[i].toString();
        }
        return result;
    }

}
