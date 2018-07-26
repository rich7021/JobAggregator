package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.util.List;

public class TxServiceB extends TxService {
    public TxServiceB(List<TransactionEntity> data) {
        super(data);
    }
}
