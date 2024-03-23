package com.siloe.enss.domain.bussiness.finacial;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class FinancialTransaction {

    private MonetaryAmount value;
    private LocalDate date;
    private String description;
    private String invoice;
    private FormOfPaymentEnum formOfPayment;
    private TransactionTypeEnum transactionType;

    public MonetaryAmount getValue() {
        return value;
    }

    public void setValue(MonetaryAmount value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public FormOfPaymentEnum getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPaymentEnum formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinancialTransaction that = (FinancialTransaction) o;

        if (!value.equals(that.value)) return false;
        if (!date.equals(that.date)) return false;
        if (!description.equals(that.description)) return false;
        if (!invoice.equals(that.invoice)) return false;
        if (!formOfPayment.equals(that.formOfPayment)) return false;
        return transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + invoice.hashCode();
        result = 31 * result + formOfPayment.hashCode();
        result = 31 * result + transactionType.hashCode();
        return result;
    }
}
