package com.siloe.enss.domain.bussiness.finacial;

public class TransactionExporadicEvent extends FinancialTransaction{

    public TransactionExporadicEvent() {
        super.setTransactionType(TransactionTypeEnum.EXPORADIC_EVENT);
    }
}
