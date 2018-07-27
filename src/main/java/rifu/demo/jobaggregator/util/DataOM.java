package rifu.demo.jobaggregator.util;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataOM {

    private static Random random = new Random();
    private static int leftLimit = 65;
    private static int rightLimit = 66;

    public static List<TransactionEntity> generateMockData() {

        List<TransactionEntity> entities = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String clientLayout = getRandomUpperChar();
            String billingCode = getRandomUpperChar();
            String batchNumber = getRandomUpperChar();
            BigDecimal count = new BigDecimal((int) (random.nextFloat() * 10));
            entities.add(new TransactionEntity(clientLayout, billingCode, batchNumber, count));
        }
        return entities;
    }

    private static String getRandomUpperChar() {
        int limitedRandomInt =
                leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
        return Character.toString((char) limitedRandomInt);
    }
}
