package Daemon;

public class Daemon {
    public static void main(String args[]){
        Thread daemon = new Thread(()->{
            int count = 0;
            while(true){
                System.out.println("Daemon Operating. Count Number : "+count);
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                count++;
            }
        });

        daemon.setDaemon(true);
        daemon.start();

        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
