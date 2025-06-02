package com.movie.ticket.booking.system.service.bookingService.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ResponseDto {
    private List<String> errorMessage;
    private BookingDto bookingDetails;
}
