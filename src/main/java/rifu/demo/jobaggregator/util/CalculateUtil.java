package rifu.demo.jobaggregator.util;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateUtil {
    public static List<TransactionEntity> calculate(List<TransactionEntity> data) {
        List<TransactionEntity> result = new ArrayList<>();
        Map<TransactionEntity, Long> groupCount = data.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        groupCount.forEach((k, v) -> {
            k.setCount(new BigDecimal(v));
            result.add(k);
        });
        return result;
    }

}
