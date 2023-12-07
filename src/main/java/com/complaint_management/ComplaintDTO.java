package com.complaint_management;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Builder
public class ComplaintDTO {
    @NotEmpty(message = "user id cannot be empty.")
    UUID complaintId;
    @JsonProperty("user_id")
    UUID userId;
    @NotEmpty(message = "complaint subject cannot be empty.")
    @JsonProperty("subject")
    String subject;
    @NotEmpty(message = "complaint description cannot be empty.")
    @JsonProperty("complaint")
    String complaint;
    @JsonProperty("purchase_id")
    String purchaseId;

    public ComplaintDTO(UUID complaintId, UUID userId, String subject, String complaint, String purchaseId) {
        this.complaintId = complaintId;
        this.userId = userId;
        this.subject = subject;
        this.complaint = complaint;
        this.purchaseId = purchaseId;
    }
}