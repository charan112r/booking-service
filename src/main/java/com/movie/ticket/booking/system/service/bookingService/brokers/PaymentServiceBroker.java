package com.movie.ticket.booking.system.service.bookingService.brokers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment-service", url = "http://localhost:9091/payment")
public interface PaymentServiceBroker {

    @GetMapping
    public String doPayment();

}
