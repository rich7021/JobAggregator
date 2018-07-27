package rifu.demo.jobaggregator;

import rifu.demo.jobaggregator.entity.TransactionEntity;
import rifu.demo.jobaggregator.service.TxServiceE;
import rifu.demo.jobaggregator.service.TxServiceF;
import rifu.demo.jobaggregator.util.CalculateUtil;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Application {
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new Application().run();
    }

    public void run() throws ExecutionException, InterruptedException {
        TxServiceE serviceE = new TxServiceE();
        FutureTask<List<TransactionEntity>> futureTaskE =
                new FutureTask<List<TransactionEntity>>(serviceE);
        TxServiceF serviceF = new TxServiceF();
        FutureTask<List<TransactionEntity>> futureTaskF =
                new FutureTask<List<TransactionEntity>>(serviceF);

        executorService.submit(futureTaskE);
        executorService.submit(futureTaskF);

        System.out.println("=========E=========");
        List<TransactionEntity> resultE = futureTaskE.get();
        resultE.sort((o1, o2) -> CalculateUtil.compare(o1, o2));
        resultE.forEach(o -> System.out.println(o));
        System.out.println("=========F=========");
        List<TransactionEntity> resultF = futureTaskF.get();
        resultF.sort((o1, o2) -> CalculateUtil.compare(o1, o2));
        resultF.forEach(o -> System.out.println(o));


        executorService.shutdown();
    }
}
