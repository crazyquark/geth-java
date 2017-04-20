package com.cegeka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cristias on 20/04/17.
 */
@RestController
@RequestMapping("/api/health")
public class ServerHealth {
    /**
     * This is for the verify site so it can check if the server is alive.
     *
     * @return just HTTP OK
     */
    @RequestMapping(value = "/check")
    public ResponseEntity<Void> checkHEalth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

