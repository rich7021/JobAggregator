package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.Application;
import rifu.demo.jobaggregator.entity.TransactionEntity;
import rifu.demo.jobaggregator.util.CalculateUtil;
import rifu.demo.jobaggregator.util.DataOM;

import java.util.List;
import java.util.concurrent.FutureTask;

public class TxServiceF extends TxService {

    public TxServiceF() {
        super(null);
    }

    @Override
    public List<TransactionEntity> call() throws Exception {

        TxServiceB serviceB = new TxServiceB(DataOM.generateMockData());
        TxServiceC serviceC = new TxServiceC(DataOM.generateMockData());
        TxServiceD serviceD = new TxServiceD(DataOM.generateMockData());

        FutureTask<List<TransactionEntity>> futureTaskB = new FutureTask<List<TransactionEntity>>(serviceB);
        FutureTask<List<TransactionEntity>> futureTaskC = new FutureTask<List<TransactionEntity>>(serviceC);
        FutureTask<List<TransactionEntity>> futureTaskD = new FutureTask<List<TransactionEntity>>(serviceD);

        Application.executorService.submit(futureTaskB);
        Application.executorService.submit(futureTaskC);
        Application.executorService.submit(futureTaskD);

        List<TransactionEntity> result = futureTaskB.get();
        result.addAll(futureTaskC.get());
        result.addAll(futureTaskD.get());

        return CalculateUtil.calculate(result);
    }
}
