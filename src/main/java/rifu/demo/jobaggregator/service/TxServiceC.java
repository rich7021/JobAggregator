package rifu.demo.jobaggregator.service;

import rifu.demo.jobaggregator.entity.TransactionEntity;

import java.util.List;

public class TxServiceC extends TxService {
    public TxServiceC(List<TransactionEntity> data) {
        super(data);
    }
}
