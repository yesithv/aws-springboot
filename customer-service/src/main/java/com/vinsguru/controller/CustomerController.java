package com.vinsguru.controller;

import com.vinsguru.dto.CustomerDto;
import com.vinsguru.dto.GenreUpdateRequest;
import com.vinsguru.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{pIdCustomer}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer pIdCustomer) {
        var customerDto = this.customerService.getCustomer(pIdCustomer);
        return ResponseEntity.ok(customerDto);
    }

    @PatchMapping("/{pIdCustomer}/genre")
    public ResponseEntity<Void> updateGenre(@PathVariable Integer pIdCustomer, @RequestBody GenreUpdateRequest request) {
        log.info("pIdcustomer: {}, request: {} ", pIdCustomer, request);
        this.customerService.updateCustomerGenre(pIdCustomer, request);
        return ResponseEntity.noContent().build(); // 204
    }

}
