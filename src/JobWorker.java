/**
 *
 * @author sarahyaw
 */
public class JobWorker implements JobWorkable
{
    public void doWork()
    {
        System.out.println(Thread.currentThread().getName()+" JobWorker doWork");
    }
}
