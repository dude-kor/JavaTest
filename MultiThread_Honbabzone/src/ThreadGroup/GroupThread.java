package ThreadGroup;

public class GroupThread {
    public static void main(String args[]){
        ThreadGroup root = new ThreadGroup("Root_Group");
        ThreadGroup groupChild = new ThreadGroup(root, "myGroup");

        // root 그룹에 세팅
        Thread root_group = new Thread(root,()->{
            while(true){
                System.out.println("Root Group");
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    System.out.println("Root Group Thread terminated");
                    break;
                }
            }
        });

        // groupChild 그룹에 세팅
        Thread child_group1 = new Thread(groupChild, ()->{
            while(true){
                System.out.println("child_group1 from child_group Group");
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    System.out.println("child_group1 from child_group Group terminated");
                    break;
                }
            }
        });

        // groupChild 그룹에 세팅
        Thread child_group2 = new Thread(groupChild, ()->{
            while(true){
                System.out.println("child_group2 from child_group Group");
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    System.out.println("child_group2 from child_group Group terminated");
                    break;
                }
            }
        });

        root_group.start();
        child_group1.start();
        child_group2.start();

        try{
            Thread.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // groupChild 그룹 일괄 중지
        System.out.println("Terminate all groupChild");
        groupChild.interrupt();

        try{
            Thread.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // root 그룹 일괄 중지
        System.out.println("Terminate all root");
        root.interrupt();
    }
}
