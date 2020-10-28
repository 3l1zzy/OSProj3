import java.util.ArrayList;

/**
 * <p>Title: GanntChart</p>
 * <p>Description: Maintain data necessary to render a Gannt chart.</p>
 * <p>Copyright: Copyright (c) 2015, 2004 by Matt Evett</p>
 * @author Matt Evett
 * @student Sarah Yaw
 * @version 2.0
 * simulates the scheduler
 */

public class GanntChart 
{
    private long systemStartTime; 
    // wall time when the Gannt chart starts.  Is used to display all timings as relative to this time
    private ArrayList<GanntRecord> events = new ArrayList<GanntRecord>();

    public GanntChart()
    {
        
    }
	
    public void start()
    {
	systemStartTime = System.currentTimeMillis(); // set os start time
    }
	
    public void recordEvent(long startTime, long endTime, String eventDescriptor) 
    {
	events.add(new GanntRecord(startTime, endTime, eventDescriptor));
    }
	
    public void end() 
    {
	long endTime = System.currentTimeMillis();
	events.add(new GanntRecord(endTime, endTime, "FINISHED"));
        //print();
    }
	
    public void print() 
    {
        GanntRecord temp;
        int count = 0;
	System.out.println("------------------Gannt Chart:---------------------");
        System.out.println("Burst Start       Burst End         Job");
        while (!events.isEmpty()&&count<events.size())
        {
            temp = events.get(count);
            System.out.println(temp.display());
            count++;
        }
	System.out.println("---------------------------------------------------");
    }
	
    /**
     * Inner class to record the data of one Gannt chart event
     * @author matt
     * @student Sarah Yaw
     *
     */
    private class GanntRecord
    {
	long startTime;
	long endTime;
	String eventDescriptor;
		
	GanntRecord(long start, long end, String descrip)
        {
            startTime = start;
            endTime = end;
            eventDescriptor = descrip;
	}
        public String display()
        {
            return (startTime)+"ms   "+(endTime)+"ms   "+eventDescriptor;
        }
    }

}
