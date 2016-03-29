package com.anatwine.stock.service;

public enum StockStatus {
    ACTIVE_STATUS("activated"), APPROVED("approved"), PENDING_STATUS("pending");

    private String databaseString;

    StockStatus(String databaseString) {

        this.databaseString = databaseString;
    }

    public String getValueAsString() {
        return databaseString;
    }
}
