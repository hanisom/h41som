package com.complaint_management;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import java.util.UUID;

@Value
@Data
@Builder
public class ComplaintDTO{
//    @NotEmpty(message = "user id cannot be empty.")
    UUID complaintId;
    @JsonProperty("user_id")
    UUID userId;
//    @NotEmpty(message = "complaint subject cannot be empty.")
    @JsonProperty("subject")
    String subject;
//    @NotEmpty(message = "complaint description cannot be empty.")
    @JsonProperty("complaint")
    String complaint;
    @JsonProperty("purchase_id")
    String purchaseId;
}