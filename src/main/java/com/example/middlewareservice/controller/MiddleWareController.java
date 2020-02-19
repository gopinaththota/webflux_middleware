package com.example.middlewareservice.controller;


import com.example.middlewareservice.pojo.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class MiddleWareController {

    WebClient webClient = WebClient.create("http://172.16.100.174:8080");

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<Employee>> employeesList() {

        Flux<Employee> empList = webClient.get().uri("/search")
                .retrieve()
                .bodyToFlux(Employee.class)
                .log("Employee list details : ");

        // Flux.from(empList);
        return new ResponseEntity<>(Flux.from(empList), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Employee>> saveEmployeeDetails(@RequestBody Employee employee) {

        Mono<Employee> emp = webClient.post().uri("/save")
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @RequestMapping(value = "/view/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Employee>> findEmployeeDetails(@PathVariable("employeeId") int employeeId) {

        Mono<Employee> emp = webClient.get().uri("/view/"+employeeId)
                .retrieve()
                .bodyToMono(Employee.class);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Long>> deleteEmployeeDetails(@PathVariable("employeeId") int employeeId) {

        Mono<Long> emp = webClient.get().uri("/delete/"+ employeeId)
                .retrieve()
                .bodyToMono(Long.class);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

}
