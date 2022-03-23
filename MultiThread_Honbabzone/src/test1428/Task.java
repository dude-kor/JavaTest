package test1428;

import java.lang.Runnable;

public class Task implements Runnable{
    @Override
    public void run(){
        int sum = 0;
        String id = java.time.LocalTime.now().toString();
        for(int index = 0; index < 1000; index++){
            sum += index;
            System.out.println(id+": "+sum);
/*
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
*/
        }
        System.out.println(Thread.currentThread() + "Final Sum : " + sum);
    }
}
