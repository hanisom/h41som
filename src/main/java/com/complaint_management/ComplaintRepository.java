package com.complaint_management;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ComplaintRepository  {
    Optional<ComplaintDTO> getComplaintDetails(UUID complaintId);
    UUID openComplaint(ComplaintDTO complaint);
}

