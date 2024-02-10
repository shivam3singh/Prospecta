package com.prospecta.controller;

import com.prospecta.entity.Entry;
import com.prospecta.Dto.EntryDto;
import com.prospecta.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import  java.util.*;
@RestController
public class EntryController {
    @Autowired
    private EntryService entryService;

    @PostMapping("/entries")
    public ResponseEntity<Entry> saveEntryHandler(){
           Entry en = entryService.saveEntry();
        return new ResponseEntity<>(en, HttpStatus.OK);
    }

    @GetMapping("/entries/{category}")
    public ResponseEntity<List<EntryDto>> findEntryByCategoryHandler(@PathVariable("category") String category){
        List<EntryDto> list= entryService.getEntryByCategory(category);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
