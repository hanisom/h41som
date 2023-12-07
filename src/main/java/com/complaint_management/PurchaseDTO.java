package com.complaint_management;

import java.time.LocalDateTime;
import java.util.UUID;

public class PurchaseDTO extends ComplaintDTO{
    UUID id;
    UUID userId;
    UUID productId;
    String productName;
    Float pricePaidAmount;
    String priceCurrency;
    Float discountPercent;
    UUID merchantId;
    LocalDateTime purchaseDate;

    public PurchaseDTO(UUID complaintId, UUID userId, String subject, String complaint, String purchaseId, UUID id, UUID userId1, UUID productId, String productName,
                       Float pricePaidAmount, String priceCurrency, Float discountPercent, UUID merchantId, LocalDateTime purchaseDate) {
        super(complaintId, userId, subject, complaint, purchaseId);
        this.id = id;
        this.userId = userId1;
        this.productId = productId;
        this.productName = productName;
        this.pricePaidAmount = pricePaidAmount;
        this.priceCurrency = priceCurrency;
        this.discountPercent = discountPercent;
        this.merchantId = merchantId;
        this.purchaseDate = purchaseDate;
    }
}
