package MutiThread;

public class DaemonTest {
    public static  void main(String args[]){
        God god = new God();
        Me me = new Me();
        Thread godT= new Thread(god);
        godT.setDaemon(true);
        godT.start();

        new Thread(me).start();
    }

}
class God implements Runnable{

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
        System.out.println("我出生了");
        for(int i = 0;i<60;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我活了" + i + "年");
        }

        System.out.println("我挂了----");
    }
}

class Me implements Runnable{

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
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println("god活着");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
