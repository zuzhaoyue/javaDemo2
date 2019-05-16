package MutiThread;

public class COTest {
    public static void main(String args[]) {
        SyncBuffer buffer = new SyncBuffer();
        new Thread(new Cusumer(buffer)).start();
        new Thread(new Factory(buffer)).start();
    }
}

class Factory implements Runnable {

    SyncBuffer buffer ;

    public Factory(SyncBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("生产第" + i + "个冰淇淋");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.push(new IceCream(i));
        }


    }
}

class Cusumer implements Runnable {

    SyncBuffer buffer ;

    public Cusumer(SyncBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            IceCream iceCream = buffer.pop();
            System.out.println("消费第" + iceCream.id + "个冰淇淋");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SyncBuffer {
    IceCream[] iceCreams = new IceCream[100];
    int count = 0;

    public synchronized void push(IceCream iceCream) {
        //满了，则不能生产
        if(count == iceCreams.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        iceCreams[count++] = iceCream;
        this.notify();//只要生产了就可以通知消费线程了
    }

    public synchronized IceCream pop() {
        //没有内容了，不能消费
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notify();//只要消费了就可以通知生产线程了
        return iceCreams[count];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class IceCream {
    int id;

    public IceCream(int id) {
        this.id = id;
    }
}
