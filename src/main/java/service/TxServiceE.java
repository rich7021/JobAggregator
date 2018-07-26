package service;

import entity.TransactionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class TxServiceE implements Callable {
    List<TransactionEntity> data;

    public TxServiceE(List<TransactionEntity> data) {
        this.data = data;
    }

    private List<TransactionEntity> calculate() {
        List<TransactionEntity> result = new ArrayList<>();
        Map<TransactionEntity, Long> groupCount = data.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        groupCount.forEach((k, v) -> {
            k.setCount(new BigDecimal(v));
            result.add(k);
        });
        return result;
    }

    @Override
    public List<TransactionEntity> call() throws Exception {
        return calculate();
    }
}
