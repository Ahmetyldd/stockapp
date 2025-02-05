package com.stockapp.dto.trendyol;

import lombok.Data;

import java.util.List;

@Data
public class CreateProductsResponse {
    private long batchRequestId;
    private List<FailedItem> failedItems;
    private boolean success;
    private String message;

    // Getters and Setters
    public long getBatchRequestId() {
        return batchRequestId;
    }

    public void setBatchRequestId(long batchRequestId) {
        this.batchRequestId = batchRequestId;
    }

    public List<FailedItem> getFailedItems() {
        return failedItems;
    }

    public void setFailedItems(List<FailedItem> failedItems) {
        this.failedItems = failedItems;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}