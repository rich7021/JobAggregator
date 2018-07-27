package rifu.demo.jobaggregator.util;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateUtil {
    public static List<TransactionEntity> calculate(List<TransactionEntity> data) {
        Map<TransactionEntity, Integer> groupCount = data.stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.summingInt(o -> sumTxn(o))));

        List<TransactionEntity> result = new ArrayList<>();
        groupCount.forEach((k, v) -> {
            k.setCount(new BigDecimal(v));
            result.add(k);
        });
        return result;
    }

    private static int sumTxn(TransactionEntity txn) {
        return txn.getCount().intValue();
    }

    public static int compare(TransactionEntity txn1, TransactionEntity txn2) {
        int c = txn1.getClientLayout().compareTo(txn2.getClientLayout());
        if (c == 0) {
            c = txn1.getBatchNumber().compareTo(txn2.getBatchNumber());
        }
        if (c == 0) {
            c = txn1.getBillingCode().compareTo(txn2.getBillingCode());
        }
        return c;
    }


}
