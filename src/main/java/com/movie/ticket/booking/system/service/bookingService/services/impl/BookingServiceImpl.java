package com.movie.ticket.booking.system.service.bookingService.services.impl;

import com.movie.ticket.booking.system.service.bookingService.brokers.PaymentServiceBroker;
import com.movie.ticket.booking.system.service.bookingService.dtos.BookingDto;
import com.movie.ticket.booking.system.service.bookingService.dtos.ResponseDto;
import com.movie.ticket.booking.system.service.bookingService.entities.BookingEntity;
import com.movie.ticket.booking.system.service.bookingService.enums.BookingStatus;
import com.movie.ticket.booking.system.service.bookingService.repositories.BookingRepo;
import com.movie.ticket.booking.system.service.bookingService.services.BookingService;
import com.movie.ticket.booking.system.service.bookingService.utility.DtoConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final Double TICKET_PRICE = 250.00;

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    PaymentServiceBroker paymentService;

    @Override
    public ResponseDto createBooking(BookingDto bookingDto) {

       Double bookingAmount =  calculateBookingAmount(bookingDto.getSeatsSelected().size());
        BookingEntity be = DtoConvertor.convertBookingDtoToBookingEntity(bookingDto);
        be.setBookingAmount(bookingAmount);
        bookingRepo.save(be);
        String paymentStatus = this.paymentService.doPayment();
        log.info("Payment status: " + paymentStatus);
        return ResponseDto.builder().bookingDetails(BookingDto.builder().bookingId(be.getBookingId()).bookingAmount(bookingAmount).bookingStatus(paymentStatus!=null? BookingStatus.CONFIRMED:be.getBookingStatus()).movieId(be.getMovieId()).userId(be.getUserId()).seatsSelected(be.getSeatsSelected()).showDate(be.getShowDate()).showTime(be.getShowTime()).build()).build();
    }

    private Double calculateBookingAmount(int numSeats) {

        return numSeats * TICKET_PRICE;
    }
}
