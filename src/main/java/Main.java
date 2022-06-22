public class Main {
    public static void main(String[] args) {
        BoxClient boxClient = new BoxClient();
        Thread man = new Thread(null, boxClient::check, "Настойчивый человек");
        Thread toy = new Thread(null, boxClient::unCheck, "Кот Василий");
        toy.setDaemon(true);
        man.start();
        toy.start();

    }
}
