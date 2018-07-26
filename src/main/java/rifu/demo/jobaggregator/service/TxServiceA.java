package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.util.List;

public class TxServiceA extends TxService {
    public TxServiceA(List<TransactionEntity> data) {
        super(data);
    }
}
