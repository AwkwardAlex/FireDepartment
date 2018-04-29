public class Firefighter implements Runnable {

    private final Message msg;

    public Firefighter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (msg) {
            System.out.println("Firefighter is on standby duty, waiting for call.");
            try {
                msg.wait(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ("alert".equals(msg.getMsg())) {
                System.out.println("Accepting call from administrator.");
                System.out.println("Rolling out to extinguish the flame!");
            } else {
                System.out.println("Day is over, there were no fires today.");
            }
        }
    }
}
