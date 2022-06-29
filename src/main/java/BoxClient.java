public class BoxClient {
    private volatile boolean tumbler = false;
    private final int SLEEP_TIME = 1000;
    private int iteration = 10;

    public void check() {
        try {
            while (iteration != 0) {
                System.out.printf("Поток %s ВКлючил тумблер...\n", Thread.currentThread().getName());
                tumbler = true;
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
            if (tumbler) {
                System.out.printf("=^.^= Поток %s ВЫключил тумблер!\n", Thread.currentThread().getName());
                tumbler = false;
            }
        }
    }
}
