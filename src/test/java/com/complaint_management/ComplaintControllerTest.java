package com.complaint_management;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ExtendWith(MockitoExtension.class)
class ComplaintControllerTest {
    private static final UUID USER_ID = UUID.randomUUID();
    private static final UUID COMPLAINT_ID = UUID.randomUUID();
    @InjectMocks
    private ComplaintController complaintController;
    @Mock
    private ComplaintDTO complaintDTO;
    @Mock
    private ComplaintRepositoryImpl complaintRepository;

    @Test
    public void whenCallCreateComplaintThenGetSuccessResponse() {
        complaintController.createComplaint(complaintDTO);
        verify(complaintRepository).openComplaint(complaintDTO);
    }

    @Test
    public void whenCallCreateComplaintForUserWhichDoesntExistThenReturnErrorResponse() {
        when(complaintController.isUserIdExist(USER_ID)).thenReturn(false);
        complaintController.createComplaint(complaintDTO);
        verify(complaintRepository).openComplaint(complaintDTO);
    }

    @Test
    public void whenCallGetComplaintThenReturnTheComplaintDetails(){
        when(complaintRepository.getComplaintDetails(COMPLAINT_ID)).thenReturn(Optional.of(complaintDTO));
        complaintController.getComplaint(USER_ID);
        verify(complaintRepository).getComplaintDetails(USER_ID);
    }
    @Test
    public void whenCallGetComplaintForNonExistComplaintThenReturnError(){
        when(complaintRepository.getComplaintDetails(USER_ID)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = complaintController.getComplaint(USER_ID);
        assertThat(responseEntity.getStatusCode(),is(NOT_FOUND));

    }

}