package com.siloe.enss.domain.bussiness.finacial;

public class TransactionEntry extends FinancialTransaction{

    public TransactionEntry() {
        super.setTransactionType(TransactionTypeEnum.ENTRY);
    }
}
