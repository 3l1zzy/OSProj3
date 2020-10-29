/**
 *
 * @author sarahyaw
 */
public class JobWorker implements JobWorkable
{
    private String name, output;
    private int x, y;
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
        x = (int)(Math.random()*100);
        y = (int)(Math.random()*100);
        output = x+" * "+y+" = "+(x*y)+"\t";
        output += x+" + "+y+" = "+(x+y)+"\n";
        output += x+" - "+y+" = "+(x-y)+"\t";
        if(y!=0)
        {
            output += x+" / "+y+" = "+(double)(x/y)+"\n";
            output += x+" % "+y+" = "+(x%y)+"\t";
        }
        output += x+"^"+y+" = "+Math.pow(x,y)+"\n";
        for(int i = 65;i<91;i++)
        {  
            output+=(char)i+" ";
        }
        output += "\n";
        for(int i = 97;i<123;i++)
        {  
            output+=(char)i+" ";
        }
        //System.out.println(Thread.currentThread().getName()+" JobWorker "+name+" doingWork\n"+output);
        //uncomment to see the output (it's messy)
    }
}
