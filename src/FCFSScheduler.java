/**
 * <p>Title: FCFSScheduler</p>
 * <p>Description: Component of the simulate operating system that encapsulates FCFS job scheduling.</p>
 * <p>Copyright: Copyright (c) 2015, 2004</p>
 * <p>Company: </p>
 * @author Matt Evett
 * @version 2.0
 */

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;

public class FCFSScheduler extends Scheduler 
{
    ArrayList<Job> readyq = new ArrayList<Job>();
    /*
     * TO_DO: your data structure to support a FCFS scheduler
     * and the abstract methods of Scheduler
     */
    public void add( Job J )
    {
        readyq.add(J);        
        //System.out.println("FCFSS add "+J.getNameOf());
    }

    /**
     * Remove job from readyQ.  No need to synchronize, as no thread blocks on "full" buffer
     */
    public void remove( Job J )
    {
        int i = 0;
        Job temp = readyq.get(i);
        while(temp!=J)
        {
            i++;
        }
        readyq.remove(i);
        //System.out.println("FCFSS remove "+J.getNameOf());
    }

    /**
     * return true if the scheduler has jobs in any queues (ready, or IO queues 
     * [in later version of project]
     */
    public boolean hasJobsQueued()
    {
        if(readyq.isEmpty())
            return false;
        else
            return true;
    }

 
    /**
     * If the ready queue is empty, return false.
     * Otherwise, start the next job in the queue, returning true.  If the queue is empty
     * return false.
     * Make the next job in the ready queue run. You should probably
     * invoke Thread.start() on it.
     */
    public boolean makeRun()
    {
        //System.out.println("FCFSS MakeRun");
        //Place code here that gets the next Job from the ready queue and invokes start() on it
        if(!hasJobsQueued())
            return false;
        else
        {
            remove(currentlyRunningJob);
            currentlyRunningJob.start();//Thread.currentThread().dumpStack();
            return true; // TO_DO ***SHOULDN'T ALWAYS RETURN TRUE***
        }
    }
  
    /**
     * blockTilThereIsAJob()  Invoked by OS simulator when it wants to get a new Job to
     * run.  Will block if the ready queue is empty until a Job is added to the queue.
     */
    public  void  blockTilThereIsAJob() 
    {
        if (hasRunningJob()) 
            return;
        //System.out.println("TO_DO: blockTilThereIsAJob not yet implemented");
        //Place code here that will cause the calling thread to block until the ready queue contains a Job
        while(readyq.size()==0)
        {
            try
            {
                Thread.currentThread().sleep(100);
                //System.out.println("FCFSS Wait");
            }
            catch (Exception e)
            {
                System.out.println("FCFSS "+e);
            }
        }
        currentlyRunningJob = readyq.get(0);
        //System.out.println("evidently there is now a job on readyQ "+currentlyRunningJob.getNameOf());
    }
}