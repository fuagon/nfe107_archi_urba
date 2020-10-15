package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.MouseRequest;
import net.cnam.nfe107.controller.dto.MouseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 15/10/2020/10/2020 - 20:52
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

/**
 * MouseController is a rest controller mapped on "/mouse".
 * The objective of this controller consist in gathering all http request linked to mouse.
 */
@RestController
@RequestMapping("mouse")
public class MouseController {

    @GetMapping()
    public ResponseEntity<MouseResponse> getMouse(@RequestParam int id, @RequestParam String name, @RequestParam Boolean male){
        return ResponseEntity.ok(new MouseResponse(id, name, male));
    }

    @PostMapping()
    public ResponseEntity<MouseResponse> postMouse(@RequestBody MouseRequest mouseRequest){
        return ResponseEntity.ok(new MouseResponse(mouseRequest));
    }
}
