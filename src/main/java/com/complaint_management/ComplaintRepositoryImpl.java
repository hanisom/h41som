package com.complaint_management;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class ComplaintRepositoryImpl implements ComplaintRepository {
    private final ConcurrentMap<UUID, ComplaintDTO> complaintMap = new ConcurrentHashMap<>();

    @Override
    public UUID openComplaint(ComplaintDTO complaint) {
        final UUID complaintId = UUID.randomUUID();
        complaintMap.put(complaintId, new ComplaintDTO.ComplaintDTOBuilder().complaintId(complaintId)
                .userId(complaint.getUserId()).subject(complaint.getSubject()).purchaseId(complaint.getPurchaseId()).build());
        return complaintId;
    }

    @Override
    public Optional<ComplaintDTO> getComplaintDetails(UUID complaintId) {
        return Optional.ofNullable(complaintMap.get(complaintId));
    }
}


