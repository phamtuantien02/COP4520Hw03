import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class MinotaurParty implements Runnable {
    private final List<String> queue;

    MinotaurParty(List<String> q) {
        queue = q;
    }

    public void run() {
        
        for(int i = 0; i<500000; i++)
        {
            queue.add(Integer.toString(i));
            queue.add("done");
        }
    }
}

class DoProduction implements Runnable {
    private final List<String> queue;

    DoProduction(List<String> q) {
        queue = q;
    }

    public void run() {
        String value = queue.remove(0);
        while (!value.equals("*")) {
            System.out.println(value);
            value = queue.remove(0);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        List q = Collections.synchronizedList(new LinkedList<String>());
        Thread p1 = new Thread(new MinotaurParty(q));
        Thread c1 = new Thread(new DoProduction(q));
        Thread c2 = new Thread(new DoProduction(q));
        Thread c3 = new Thread(new DoProduction(q));
        p1.start();
        c1.start();
        c2.start();
        c3.start();
        p1.join();
        c1.join();
        c2.join();
        c3.join();
        p1.run();
    }
}