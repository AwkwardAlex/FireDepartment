import util.ScannerUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FireDepartment {

    private Message msg = new Message("");

    private Administrator admin = new Administrator(msg);

    private Firefighter firefighter = new Firefighter(msg);

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Runnable firefighterTask = () -> {
        firefighter.run();
    };

    private Runnable adminTask = () -> {
        admin.run();
    };

    private Runnable ringFireAlert = () -> {
        System.out.println("Is there a fire alert? Press 1 if there is a fire alert.");
        String choice = ScannerUtil.getString();
        if ("1".equals(choice)) {
            System.out.println("Fire alert!");
            msg.setMsg("alert");
        }
    };

    public void ringFireAlert() {
        executorService.submit(adminTask);
        executorService.submit(firefighterTask);
        executorService.submit(ringFireAlert);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
