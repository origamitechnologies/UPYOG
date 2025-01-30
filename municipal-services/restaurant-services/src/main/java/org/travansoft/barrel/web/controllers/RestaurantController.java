package org.travansoft.barrel.web.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.travansoft.barrel.service.RestaurantService;
import org.travansoft.barrel.web.models.RestaurantDetails;
import org.travansoft.barrel.web.models.contract.request.RestaurantRequest;
import org.travansoft.barrel.web.models.contract.response.RestaurantResponse;

import javax.validation.Valid;

@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-04-12T12:56:34.514+05:30")

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/hello")
    public void helloWorld() {
        System.out.println("abc");
    }

    @RequestMapping(value = "/_create", method = RequestMethod.POST)
    public ResponseEntity<RestaurantDetails> createRestaurantDetails(@Valid @RequestBody RestaurantRequest restaurantRequest) {
       RestaurantDetails restaurantDetails = restaurantService.create(restaurantRequest);
        RestaurantResponse response = new RestaurantResponse();
        return new ResponseEntity<>(restaurantDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/_update", method = RequestMethod.POST)
    public ResponseEntity<RestaurantDetails> updateRestaurantDetails(@Valid @RequestBody RestaurantRequest restaurantRequest) {
        RestaurantDetails restaurantDetails = restaurantService.update(restaurantRequest);
        RestaurantResponse response = new RestaurantResponse();
        return new ResponseEntity<>(restaurantDetails, HttpStatus.OK);
    }

}
