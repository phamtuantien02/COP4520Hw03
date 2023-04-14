import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.IOException;

public class TemperatureReading extends Thread {
    
    
    public static void main(String args[]) {
        Thread p1 = new Thread(new Sensor());
        Thread p2 = new Thread(new Sensor());
        Thread p3 = new Thread(new Sensor());
        Thread p4 = new Thread(new Sensor());
        Thread p5 = new Thread(new Sensor());
        Thread p6 = new Thread(new Sensor());
        Thread p7 = new Thread(new Sensor());
        Thread p8 = new Thread(new Sensor());
        
     

        try
        {
            p1.start();
            p2.start();
            p3.start();
            p4.start();
            p5.start();
            p6.start();
            p7.start();
            p8.start();
    
            p1.join();
            p2.join();
            p3.join();
            p4.join();
            p5.join();
            p6.join();
            p7.join();
            p8.join();
        }
        catch(InterruptedException e)
        {
          System.out.println("** RuntimeException from main");
        }
        p1.run();
        p2.run();
        p3.run();
        p4.run();

        p5.run();
        p6.run();
        p7.run();
        p8.run();

    }

    
}

class RandomNumberGenerator implements Callable
{
    Random random = new Random();

    @Override
    public String call() throws Exception
    {
        return "Didn't work";
    }
    public int run() {
        
        
        int number = random.nextInt(100);
        
        if(number > 70)
        {
            number *= -1;
        }

        return number;
    }
   
}

class Sensor implements Runnable
{
    RandomNumberGenerator generate = new RandomNumberGenerator();
    List<Integer> list = new ArrayList<Integer>();

    public void run()
    {
        

        for(int i = 0; i < 60 ;i++)
        {
            list.add(generate.run());
        }

        Collections.sort(list);
        for(int j = 0; j < 5; j++)
        {
            System.out.println(list.get(j));
        }


        Collections.sort(list);
        Collections.reverse(list);
        for(int j = 0; j < 5; j++)
        {
            System.out.println(list.get(j));
        }
    }
    


}