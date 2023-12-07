package com.complaint_management;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.AllOf.allOf;

@ExtendWith(MockitoExtension.class)
class ComplaintRepositoryImplTest {
    @InjectMocks
    private ComplaintRepositoryImpl complaintRepository;

    @Test
    public void whenOpenComplaintThenReturnComplaintId() {
        UUID userId = UUID.randomUUID();
        ComplaintDTO COMPLAINT_DTO = new ComplaintDTO.ComplaintDTOBuilder()
                .userId(userId).subject("complaint subject").build();
        UUID actualComplaintId = complaintRepository.openComplaint(COMPLAINT_DTO);
        Optional<ComplaintDTO> complaintDetails = complaintRepository.getComplaintDetails(actualComplaintId);
        assertThat(complaintDetails.get(), equalsTo(COMPLAINT_DTO, actualComplaintId));
    }

    private Matcher<ComplaintDTO> equalsTo(ComplaintDTO expected, UUID actualComplaintId) {
        return allOf(
                hasProperty("userId", equalTo(expected.getUserId())),
                hasProperty("subject", equalTo(expected.getSubject())),
                hasProperty("complaintId", equalTo(actualComplaintId)));
    }


}