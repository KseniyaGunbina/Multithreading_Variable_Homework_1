import java.util.concurrent.atomic.AtomicBoolean;

public class BoxClient {
    private AtomicBoolean tumbler = new AtomicBoolean(false);
    private final int SLEEP_TIME = 1000;
    private int iteration = 10;

    public void check() {
        try {
            while (iteration != 0) {
                System.out.printf("Поток %s ВКлючил тумблер...\n", Thread.currentThread().getName());
                tumbler.set(true);
                iteration--;
                System.out.println(iteration);
                Thread.sleep(SLEEP_TIME);
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unCheck() {
        while (true) {
            if (tumbler.get()) {
                System.out.printf("=^.^= Поток %s ВЫлючил тумблер!\n", Thread.currentThread().getName());
                tumbler.set(false);
            } else
                continue;
        }

    }


}
