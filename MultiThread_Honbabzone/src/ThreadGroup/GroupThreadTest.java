package ThreadGroup;

public class GroupThreadTest {
    public static void main(String args[]) {
        ThreadGroup root = new ThreadGroup("RootGroup");
        ThreadGroup childGroup = new ThreadGroup(root, "myGroup");

        // Root Group Setting
        Thread rootGroup = new Thread(root, () -> {
            while (true) {
                System.out.println("Root Group Thread Running");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Root Group Thread Terminated");
                    break;
                }
            }
        });

        rootGroup.start();
        for(int i = 1; i < 10; i++) {
            setChildGroup(childGroup, i).start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Terminate Child Group
        System.out.println("Terminate all groupChild");
        childGroup.interrupt();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Terminate Root Group
        System.out.println("Terminate all root");
        root.interrupt();
    }

    // Child Group Setting
    public static Thread setChildGroup(ThreadGroup _childGroup, int _index){
        Thread child = new Thread(_childGroup, ()->{
            while(true){
                System.out.println("Child" + _index + " Created at Child Group");
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    System.out.println("Child" + _index + " Thread Terminated");
                    break;
                }
            }
        });

        return child;
    }
}
