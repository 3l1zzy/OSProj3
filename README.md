I am excited to say that there are no errors in this project! at the bottom I have incluDed sample output (I added two more jobs for testing)
Eight files included:
- FCFSScheduler.java - First Come First Serve scheduler. I added the ArrayList<jobs> readyq data structure to this class to jeep track of things sent in by the submitter. I also added the abstract classes inherited from the Scheduler class, add, remove, and hasJobsQueued. add inserts a job into the readyq, remove removes the job from the readyq, and hasJobsQueued essentially checks if the readyq has any jobs waiting and returns a boolean based on that result.
- GanntChart.java - This class is what is called to actually output the Gannt chart as output on the terminal/console. I left the constructor for the GanntChart object empty, as I was able to accomplish everything elsewhere. The only method I really worked with was the print() method. I added in the header and footer (at the time they separated the chart from debugging output) the column titles, and a loop to go through all of the events saved and print them in neat columns. The start and end times get the systemStartTime subtracted from them so the timestamps are relative and not several digits long.
- Job.java - Job was a given file that was not changed. It is used to call the work to be done so there are variable times in the Gannt chart.
- JobWorkable.java - Job Workable was a given file that was not changed. It is used as a base to be inherited by my class JobWorker.
- JobWorker.java - Created class that inherits JobWorkable and lists work for the job thread to do. At the bottom of the doWork class is a commented-out print statement that can be put back into the code to see the work executing, although it will make the output look a bit messy since there's so much going on.
- RunScheduler.java - Given file that was not changed. This is the file with method main and starts off the entire program.
- Scheduler.java - Given file that was not changed. This is the abstract class inherited by FCFSScheduler.
- Submittor.java - This is the class that reads from the input file and sends all of the job components to the SystemSimulator to be created into jobs and executed. The run method was edited here to split the string of information read in from the file and disseminated to the ID, delay, and burstDescription variables.
- WorkFactory.java - In this file, I just created a JobWorker  object to be returned.
- SystemSimulator.java - This file is what has the kernel and job thread reentrant lock that is handed back and forth. The synchronization code based on the job condition was added here to make sure only one (kernel or job) runs at any given time.
The base code of this project was made by Professor Matt Evett. The assignment is to add/edit the existing code to make the program work according to the rubric.

`

    Sarahs-MBP:src sarahyaw$ javac *.java
    Sarahs-MBP:src sarahyaw$ java RunScheduler
    GANNT CHART:------------------------------
    BurstStart      BurstEnd        JOB 
    0               101             IDLE
    102             304             Job#1
    305             610             Job#2
    611             912             Job#3
    913             1216            Job#4
    1216            1728            Job#5
    1728            1728            FINISHED
    -------------------------------------------
    Sarahs-MBP:src sarahyaw$ 
    `
