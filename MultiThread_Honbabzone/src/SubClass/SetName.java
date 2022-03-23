package SubClass;

public class SetName {
    public static void main(String args[]){
        Thread subThread1 = new CustomThread();
        Thread subThread2 = new Thread(){
            public void run(){
                int sum = 0;
                for(int index = 0; index < 10;index++){
                    sum+=index;
                    System.out.println(sum);
                }
                System.out.println(Thread.currentThread().getName() + " Final Sum Value : "+sum);
            }
        };

        subThread1.setName("Thread No 1 : ");
        subThread2.setName("Thread No 2 : ");
        subThread1.start();
        subThread2.start();
    }
}
