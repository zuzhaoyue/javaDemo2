package MutiThread;

class MyWeb12306 {
    int avaible = 100;

    public int getAvaible() {
        return avaible;
    }

    public void setAvaible(int avaible) {
        this.avaible = avaible;
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

}
class Passenger implements Runnable{
    private MyWeb12306 myWeb12306 = new MyWeb12306();
    private int seats;//要买几张票

    public Passenger( int seats) {
        this.myWeb12306 = myWeb12306;
        this.seats = seats;
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
        getSeats(this.seats);
    }
    public synchronized boolean getSeats(int seats){
        if(myWeb12306.getAvaible() < seats) return false;
        else {
            myWeb12306.setAvaible(myWeb12306.getAvaible() - seats);
            System.out.println(Thread.currentThread().getName() + "买了" + seats + "张票，还剩" + myWeb12306.getAvaible() +"张");
            return true;
        }
    }
}
public class Happy12306 {
    public static void main(String []args){
        Passenger passenger = new Passenger(3);
        new Thread(passenger,"aa").start();
        new Thread(passenger,"bb").start();
        new Thread(passenger,"cc").start();
    }
}
