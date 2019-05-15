package MutiThread;

class Machine implements Runnable{

    private int ticket = 100;

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
        while(ticket > 0){
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket <=0)
                return;
            getTicket();
        }

    }

    public synchronized void getTicket() {
        System.out.println(Thread.currentThread().getName()+"-->" + ticket--);
    }

}
public class Web12306 {

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

    public static void main(String args[]){
        Machine machine = new Machine();
        new Thread(machine,"张三").start();
        new Thread(machine,"李四").start();
        new Thread(machine,"王二").start();
    }
}
