package com.complaint_management;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Builder
@Data
public class UserDTO extends ComplaintDTO {
    UUID id;
    String fullName;
    String emailAddress;
    String physicalAddress;

    public UserDTO(UUID complaintId, UUID userId, String subject, String complaint,
                   String purchaseId, UUID id, String fullName, String emailAddress, String physicalAddress) {
        super(complaintId, userId, subject, complaint, purchaseId);
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }
}
