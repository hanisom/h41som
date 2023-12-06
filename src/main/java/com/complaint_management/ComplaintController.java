package com.complaint_management;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping(value = "api/v1/complaint-managment/")
@Slf4j
@RequiredArgsConstructor
public class ComplaintController {

    private Complaint complaintInterface;

    @PostMapping
    public ResponseEntity createComplaint(@RequestBody ComplaintDTO complaint) {
        try {
            UUID userId = complaint.getUserId();
            log.info("Opening complaint for user id: {}", userId);
            boolean userIdExist = isUserIdExist(userId);
            if (!userIdExist) {
                log.error("The userId: {} doesn't exist in the systme,Cannot open complaint for this userId", userId);
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
            }
            complaintInterface.openComplaint(complaint);
            return ResponseEntity.status((HttpStatus.OK)).build();
        } catch (Exception e) {
            log.error("Failed to open complaint with error ", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity getComplaint(@PathParam("id") UUID complaintId) {
        try {
            log.info("Getting complaint details for complaint id: {}", complaintId);
            Optional<ComplaintDTO> complaintDetails = complaintInterface.getComplaintDetails(complaintId);
            if(complaintDetails.isEmpty()){
                log.error("Could not find complaint with this id: {}", complaintId);
                return ResponseEntity.status(NOT_FOUND).build();
            }
            return ResponseEntity.status((HttpStatus.OK)).body(complaintDetails);
        } catch (Exception e) {
            log.error("Failed to open complaint with error ", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    @VisibleForTesting
    public boolean isUserIdExist(UUID userId) {
        //ToDo call to getUser API to check that user is exist in the system
        return true;
    }
}

