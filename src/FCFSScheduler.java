/**
 * <p>Title: FCFSScheduler</p>
 * <p>Description: Component of the simulate operating system that encapsulates FCFS job scheduling.</p>
 * <p>Copyright: Copyright (c) 2015, 2004</p>
 * <p>Company: </p>
 * @author Matt Evett
 * @student Sarah Yaw
 * @version 2.0
 */

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;

public class FCFSScheduler extends Scheduler 
{
    ArrayList<Job> readyq = new ArrayList<Job>();
    //abstract methods at bottom of class
    
    /**
    * If the ready queue is empty, return false.
    * Otherwise, start the next job in the queue, returning true.  If the queue is empty
    * return false.
    * Make the next job in the ready queue run. You should probably
    * invoke Thread.start() on it.
    */
    public boolean makeRun()
    {   /**
	 * If the ready queue is empty, return false.
	 * Otherwise, start the next job in the queue, returning true.  If the queue is empty
	 * return false.
	 * Make the next job in the ready queue run. You should probably
	 * invoke Thread.start() on it.
	 */
        if(!hasJobsQueued())
            return false;
        return true; // TO_DO ***SHOULDN'T ALWAYS RETURN TRUE***
    }
  
    /**
    * blockTilThereIsAJob()  Invoked by OS simulator when it wants to get a new Job to
    * run.  Will block if the ready queue is empty until a Job is added to the queue.
    */
    public void blockTilThereIsAJob() 
    {
        if (!readyq.isEmpty()) 
            return;
        else
        {
            while(readyq.isEmpty())
            {
                try
                {           
                    System.out.println("FCFSS WAITING");
                    Thread.currentThread().sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("FCFSS "+e);
                }
            }
            currentlyRunningJob = readyq.get(0);
            Thread runner = new Thread(currentlyRunningJob);
            runner.start();
            System.out.println("FCFSS evidently there is now a job on readyQ");
        }
    }

    public void add( Job J )
    {
        readyq.add(J);
        System.out.println("FCFSS .add() "+J.getNameOf());
    }
    public void remove( Job J )
    {
        int index = 0;
        Job temp = readyq.get(index);
        while(!readyq.isEmpty()&&J!=temp)
        {
            temp = readyq.get(index);
            index++;
        }
        readyq.remove(index);
    }
    public boolean hasJobsQueued()
    {
        if(!readyq.isEmpty())
            return true;
        else
            return false;
    }
    public synchronized boolean hasRunningJob(){ return( currentlyRunningJob != null);}
    public synchronized void clearRunningJob() {currentlyRunningJob = null;}
}
  

