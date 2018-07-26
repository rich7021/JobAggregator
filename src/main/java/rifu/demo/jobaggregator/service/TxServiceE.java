package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.Application;
import rifu.demo.jobaggregator.entity.TransactionEntity;
import rifu.demo.jobaggregator.util.CalculateUtil;
import rifu.demo.jobaggregator.util.DataOM;

import java.util.List;
import java.util.concurrent.FutureTask;

public class TxServiceE extends TxService {

    public TxServiceE() {
        super(null);
    }

    @Override
    public List<TransactionEntity> call() throws Exception {
        TxServiceA serviceA = new TxServiceA(DataOM.generateMockData());
//        TxServiceB serviceB = new TxServiceB(DataOM.generateMockData());
        FutureTask<List<TransactionEntity>> futureTaskA = new FutureTask<List<TransactionEntity>>(serviceA);
//        FutureTask<List<TransactionEntity>> futureTaskB = new FutureTask<List<TransactionEntity>>(serviceB);

        Application.executorService.submit(futureTaskA);
//        Application.executorService.submit(futureTaskB);

        List<TransactionEntity> result = futureTaskA.get();
//        result.addAll(futureTaskB.get());

        return CalculateUtil.calculate(result);
    }
}