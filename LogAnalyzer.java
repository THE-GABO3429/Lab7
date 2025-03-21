import java.util.ArrayList;

/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 *
 *
 *1)18
 *2)done
 *3)done
 *4) 1 in LogAnylayzer, 1 in analyzeData and 2 in PrintHourly
 *5)int[] counts; occupied = new boolean[5000];
 *6) reading = new double[60]; urls = new String[90] ; machines = new TicketMachine[5];
 *7) 20
 *8) prices = new double[50]
 *9) done
 *10)done
 *11)Done
 *12)done
 *13)done
 *14)
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    //private Person[] people;
    
    private int[] vacant;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    
    
    
    public void printGreater(double mean) {
       double marks[] = {1,3,6,4,6};
       for (int index =0; index < marks.length; index++){
           if(marks[index] > mean){
               System.out.println(marks[index]);
            }
        }
    }
    
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /** 
    * Return the number of accesses recorded in the log file. 
    */
    public int numberOfAccesses() {
        int total = 0;
        for(int count : hourCounts){ 
            total += count;
        }
        // Add the value in each element of hourCounts to // total. ...
        return total;
    
    }     
    
    /**
     * A dupe of printHourlCounts()
     */
    public void printHourlyCounts2(){
        System.out.println("Hr: Count");
        int hour = 0;
        while(hourCounts.length > hour ){
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
