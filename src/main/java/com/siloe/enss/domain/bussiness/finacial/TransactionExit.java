package com.siloe.enss.domain.bussiness.finacial;

public class TransactionExit extends FinancialTransaction{

    public TransactionExit() {
        super.setTransactionType(TransactionTypeEnum.EXIT);
    }
}
