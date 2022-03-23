package ShareThread;

public class ShareThread {
    private int value = 0;
    // 동기화 이전
    public void setValue(int value){
        this.value=value;
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " has a value of "+this.value);
    }

    // 동기화 이후
    public synchronized void setSynchronizedValue(int value){
        this.value=value;
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " has a value of "+this.value);
    }

    // 동기화 블록
    public void setValueSynchronizing(int value){
        synchronized (this){
            this.value = value;
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " has a value of "+this.value);
        }
    }

    public int getValue(){
        return value;
    }

    public static void main(String args[]){
        ShareThread shareThread = new ShareThread();
        Thread thread1 = new Thread(()->{
           //shareThread.setValue(100);
           //shareThread.setSynchronizedValue(100);
           shareThread.setValueSynchronizing(100);
        });
        Thread thread2 = new Thread(()->{
            //shareThread.setValue(200);
            //shareThread.setSynchronizedValue(200);
            shareThread.setValueSynchronizing(200);
        });
        thread1.setName("No : 100");
        thread2.setName("No : 200");
        thread1.start();
        thread2.start();
    }
}
