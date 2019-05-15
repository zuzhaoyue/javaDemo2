package MutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args){
       ExecutorService threadPool =  Executors.newCachedThreadPool();
//       ExecutorService threadPool =  Executors.newFixedThreadPool(3);
       for(int task = 0;task < 5;task++) {
           final int  tmp = task;
           threadPool.execute(new Runnable() {
               public void run() {
                   for (int i = 0; i < 10; i++) {
                       System.out.println("执行第"+tmp +"个任务，第" + i + "秒") ;
                       try {
                           Thread.sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           });
       }
       threadPool.shutdown();

    }
}
