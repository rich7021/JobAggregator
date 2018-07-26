package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.entity.TransactionEntity;
import rifu.demo.jobaggregator.util.CalculateUtil;

import java.util.List;
import java.util.concurrent.Callable;

public abstract class TxService implements Callable {

    private List<TransactionEntity> data;

    public TxService(List<TransactionEntity> data) {
        this.data = data;
    }

    public List<TransactionEntity> call() throws Exception {
        System.out.println("Current call " + this.getClass().getName());
        return CalculateUtil.calculate(data);
    }
}
