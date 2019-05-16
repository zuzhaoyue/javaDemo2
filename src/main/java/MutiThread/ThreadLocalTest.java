package MutiThread;

import java.util.function.Supplier;

public class ThreadLocalTest {
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(new Supplier() {
        /**
         * Gets a result.
         *
         * @return a result
         */
        public Object get() {
            return 10;
        }
    });

    public static void main(String args[]){
        threadLocal.set(2);
        System.out.println("当前线程" + Thread.currentThread().getName() + "值为" + threadLocal.get());

        new Thread(new thread1()).start();

    }

    public static class thread1 implements Runnable{

        public thread1(){
            threadLocal.set(3);
        }
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {
            threadLocal.set(4);
            System.out.println("当前线程" + Thread.currentThread().getName() + "值为" + threadLocal.get());

        }
    }

}
