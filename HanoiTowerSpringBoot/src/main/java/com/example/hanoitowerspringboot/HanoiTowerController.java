package com.example.hanoitowerspringboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HanoiTowerController {
    @RequestMapping(
            value = "/{diskCount}",
            produces = { "text/plain"},
            method = RequestMethod.GET)
    public String hanoiTower(@PathVariable int diskCount) {
        List<String> moves = new ArrayList<>();
        HanoiTower tower = new HanoiTower(diskCount,moves);
        return tower.toString().replaceAll(",","\n").replaceAll("[\\[\\]]"," ");
    }


}
