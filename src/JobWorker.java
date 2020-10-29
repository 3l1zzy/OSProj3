/**
 *
 * @author sarahyaw
 */
public class JobWorker implements JobWorkable
{
    private String name;
    JobWorker(String n)
    {
        this.name = n;
    }
    public String getName()
    {
        return name;
    }
    public void doWork()
    {
        System.out.println(Thread.currentThread().getName()+" JobWorker "+name+" doingWork");
    }
}
