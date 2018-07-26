import entity.TransactionEntity;
import service.TxServiceE;

import java.util.List;
import java.util.concurrent.*;

public class Application {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        new Application().run();
    }

    public void run() {
        TxServiceE serviceE = new TxServiceE(DataOM.generateMockData());
        FutureTask<List<TransactionEntity>> futureTask = new FutureTask<List<TransactionEntity>>(serviceE);

        try {
            executorService.submit(futureTask);
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
