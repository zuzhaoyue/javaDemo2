package MutiThread;

class A extends Thread{

    @Override
    public void run(){
        for(int i = 0;i<20;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边听歌");
        }
    }
}
class B extends Thread{
    @Override
    public void run(){
        for(int i = 0;i<20;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边coding");
        }
    }
}
public class ThreadTest {

    public static void main(String args[]){
        new A().start();//由cpu调用，不保证立即执行
//        new B().start();
        for(int i = 0;i<20;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边coding");
        }
    }
}

