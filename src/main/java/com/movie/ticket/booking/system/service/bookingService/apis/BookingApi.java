package com.movie.ticket.booking.system.service.bookingService.apis;

import com.movie.ticket.booking.system.service.bookingService.dtos.BookingDto;
import com.movie.ticket.booking.system.service.bookingService.dtos.ResponseDto;
import com.movie.ticket.booking.system.service.bookingService.services.BookingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
@Slf4j
public class BookingApi {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<ResponseDto> createBooking(@Valid @RequestBody BookingDto bookingDto) {

        log.info("bookingDto: {}", bookingDto);
        ResponseDto rd = bookingService.createBooking(bookingDto);

        return new ResponseEntity<>(rd, HttpStatus.CREATED);
    }
}
