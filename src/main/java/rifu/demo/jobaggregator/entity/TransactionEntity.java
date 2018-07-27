package rifu.demo.jobaggregator.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionEntity {
    private String clientLayout;
    private String billingCode;
    private String batchNumber;
    private BigDecimal count;

    public TransactionEntity() {
    }

    public TransactionEntity(String clientLayout, String billingCode, String batchNumber) {
        this.clientLayout = clientLayout;
        this.billingCode = billingCode;
        this.batchNumber = batchNumber;
    }

    public TransactionEntity(String clientLayout, String billingCode, String batchNumber,
            BigDecimal count) {
        this.clientLayout = clientLayout;
        this.billingCode = billingCode;
        this.batchNumber = batchNumber;
        this.count = count;
    }

    public String getClientLayout() {
        return clientLayout;
    }

    public void setClientLayout(String clientLayout) {
        this.clientLayout = clientLayout;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TransactionEntity))
            return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(clientLayout, that.clientLayout) && Objects
                .equals(billingCode, that.billingCode) && Objects
                .equals(batchNumber, that.batchNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientLayout, billingCode, batchNumber);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" + "clientLayout='" + clientLayout + '\'' + ", batchNumber='"
                + batchNumber + '\'' + ", billingCode='" + billingCode + '\'' + ", count=" + count
                + '}';
    }
}
