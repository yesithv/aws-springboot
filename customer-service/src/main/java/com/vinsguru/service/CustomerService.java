package com.vinsguru.service;

import com.vinsguru.client.MovieClient;
import com.vinsguru.dto.CustomerDto;
import com.vinsguru.dto.GenreUpdateRequest;
import com.vinsguru.exceptions.CustomerNotFoundException;
import com.vinsguru.mapper.EntityDtoMapper;
import com.vinsguru.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final MovieClient movieClient;
    private final CustomerRepository customerRepository;

    public CustomerDto getCustomer(Integer id) {
        var customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        var recommendedMovies = this.movieClient.getMovies(customer.getFavoriteGenre());
        return EntityDtoMapper.toDto(customer, recommendedMovies);
    }

    public void updateCustomerGenre(Integer id, GenreUpdateRequest request) {
        var customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setFavoriteGenre(request.favoriteGenre());
        this.customerRepository.save(customer);
    }

}
