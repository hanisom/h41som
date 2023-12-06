package com.complaint_management;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ComplaintService implements Complaint {
    private final ConcurrentMap<UUID, ComplaintDTO> complaintMap = new ConcurrentHashMap<>();

    @Override
    public void openComplaint(ComplaintDTO complaint) {
        new ComplaintDTO.ComplaintDTOBuilder().complaintId(UUID.randomUUID())
                .userId(complaint.getUserId()).subject(complaint.getSubject()).purchaseId(complaint.getPurchaseId()).build();
         saveComplaint(complaint);
    }

    @Override
    public Optional<ComplaintDTO> getComplaintDetails(UUID complaintId) {
        return Optional.ofNullable(complaintMap.get(complaintId));
    }

    private void saveComplaint(ComplaintDTO complaint) {
        complaintMap.put(complaint.getUserId(), complaint);
    }

}


