package com.dgn.redirect.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/myrepo")
public class RedirectController {

    @GetMapping("/first")
    public RedirectView getMyGitHubFirst(){
        return new RedirectView("https://github.com/dogan-gunes");
    }
    @GetMapping("/second")
    public RedirectView getMyGitHubSecond(){
        return new RedirectView("/myrepo/first");
    }
    @GetMapping("/third")
    public ResponseEntity<Void> getMyGitHubThird(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION,"/myrepo/first");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);//302 Found
    }
}
