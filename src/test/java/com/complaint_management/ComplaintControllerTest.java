package com.complaint_management;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComplaintControllerTest {
    private static final UUID USER_ID = UUID.randomUUID();
    @InjectMocks
    private ComplaintController complaintController;
    @Mock
    private ComplaintDTO complaintDTO;
    @Mock
    private ComplaintService complaintService;

    @Test
    public void whenCallCreateComplaintThenGetSuccessResponse() {
        complaintController.createComplaint(complaintDTO);
        verify(complaintService).openComplaint(complaintDTO);
    }

    @Test
    public void whenCallCreateComplaintForUserWhichDoesntExistThenReturnErrorResponse() {
        when(complaintController.isUserIdExist(USER_ID)).thenReturn(false);
        complaintController.createComplaint(complaintDTO);
        verify(complaintService).openComplaint(complaintDTO);
    }

}