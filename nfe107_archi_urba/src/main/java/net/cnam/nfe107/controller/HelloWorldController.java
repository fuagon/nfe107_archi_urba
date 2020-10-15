package net.cnam.nfe107.controller;

/*
 * @created 15/10/2020/10/2020 - 20:32
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController is a rest controller mapped on "/hello"
 * The objective of this controller consist to have a test path for the development.
 */
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping()
    public String helloWorld() {
        return "Hello World!";
    }
}