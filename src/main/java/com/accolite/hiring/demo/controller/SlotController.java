package com.accolite.hiring.demo.controller;

import com.accolite.hiring.demo.entity.Slot;
import com.accolite.hiring.demo.service.GoogleSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SlotController {

    @Autowired
    GoogleSheetService googleSheetService;

    @GetMapping("/slot/{emailId}")
    List<Slot> getAllSlot(String emailId) {
        return googleSheetService.getAllSlots();
    }

    @GetMapping("/slot/add")
    Boolean putSlot(String emailId) {
        return googleSheetService.putSlot();
    }
}
