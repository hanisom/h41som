package com.complaint_management;

import java.util.Optional;
import java.util.UUID;

public interface Complaint {
        void openComplaint(ComplaintDTO complaint) ;
        Optional<ComplaintDTO> getComplaintDetails(UUID complaintId);
    }
