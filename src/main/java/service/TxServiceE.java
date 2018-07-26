package service;

import entity.TransactionEntity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TxServiceE extends Thread {
    public void run() {

    }

    public List<TransactionEntity> calculate(List<TransactionEntity> entities) {
        entities.stream().collect(Collectors.groupingBy(()->{},() ->{}));
        Function<TransactionEntity, Boolean> compareFunction = new Function<TransactionEntity, Boolean>() {
            @Override
            public Boolean apply(TransactionEntity transactionEntity) {
                return null;
            }
        }
        return null;
    }

}
