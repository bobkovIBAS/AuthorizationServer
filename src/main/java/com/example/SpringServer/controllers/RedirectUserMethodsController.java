/*
package com.example.SpringServer.controllers;

import com.example.SpringServer.DAO.SearchPossibleFlightDAO;
import com.example.SpringServer.model.GuestCard;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/redirect")
public class RedirectUserMethodsController {

    String directionOfMethods = "http://localhost:8080/api/user/";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @GetMapping("/getAllCity")
     ResponseEntity<?> getAllCity() {
        return restTemplate.exchange(directionOfMethods + "getAllCity",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){ } );
    }


    @GetMapping("/getAllPossibleFlights")
    private ResponseEntity<?>getAllPossibleFlights() {
        return restTemplate.exchange(directionOfMethods + "getAllPossibleFlights",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){ } );
    }

    @GetMapping("/getAllFlights")
    private ResponseEntity<?> getAllFlights() {
        return restTemplate.exchange(directionOfMethods + "getAllFlights",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){ } );
    }

    @GetMapping("/getAvailableFlightsByDate/{date}")
    private ResponseEntity<?> getAvailableFlightsByDate(@PathVariable("date") String date){
        return restTemplate.exchange(directionOfMethods + "getAvailableFlightsByDate/"+ date,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){ } );
    }

    @PostMapping(value = "/registration/{id}", consumes = {"application/json"})
    public ResponseEntity<?> createRegistration(@PathVariable ("id") String id,@RequestBody GuestCard user) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(user, headers);
        return restTemplate.exchange(directionOfMethods + "registration/" + id,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<>(){ });
    }

    @PostMapping(value = "/searchFlight", consumes = {"application/json"})
    ResponseEntity<?> getAvailableFlightsByFilter(@RequestBody SearchPossibleFlightDAO search){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(search, headers);
        return restTemplate.exchange(directionOfMethods + "searchflight",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<>(){ });
    }

    @DeleteMapping("/deleteBookedFlight/{id}")
    public ResponseEntity<?> deleteBookedFlight(@PathVariable ("id") String id) {
        return restTemplate.exchange(directionOfMethods + "deleteBookedFlight/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<>(){ });
    }

}
*/
