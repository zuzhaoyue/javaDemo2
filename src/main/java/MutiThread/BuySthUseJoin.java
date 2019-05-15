package MutiThread;

import static java.lang.Thread.sleep;

public class BuySthUseJoin {
    public static void main(String args[]){
        new Thread(new Father()).start();
    }
}

class Father implements Runnable{

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

        System.out.println("想抽烟，叫儿子去买烟");
        Thread thread = new Thread(new Son());
        thread.start();
        try {
            thread.join();
            System.out.println("老爸接过烟，给儿子零钱");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("儿子走丢了，找儿子中。。。");
        }


    }
}

class Son implements Runnable{

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
        System.out.println("儿子出门去买烟");
        System.out.println("看到一个游戏机,开始玩游戏。。。");
        for(int i = 0;i<10;i++){
            System.out.println(i+"秒过去了。。。");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("不玩游戏了，去买好了烟");

    }
}
