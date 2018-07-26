import service.TxServiceE;

public class Application {
    public static void main(String[] args) {

        new Application().run();
    }

    public void run() {
        TxServiceE serviceE = new TxServiceE();
        serviceE.start();
    }
}
