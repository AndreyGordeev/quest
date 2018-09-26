package com.andreiy.gordeev.controller;

import com.andreiy.gordeev.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {

    @Autowired
    private RaceService raceService;

    @RequestMapping(value="/race", method=RequestMethod.GET)
    public String getRace() {
        return raceService.getRaceList();
    }
}
