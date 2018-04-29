public class Administrator implements Runnable {

    private final Message msg;

    public Administrator(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Administrator is on standby duty.");
        try {
            Thread.sleep(8000);
            synchronized (msg) {
                if (msg.getMsg().equals("alert")) {
                    msg.notifyAll();
                } else {
                    System.out.println("Fire department is on standby duty.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
