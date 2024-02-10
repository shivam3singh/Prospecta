package com.prospecta.service;

import com.prospecta.Dto.AllEntryDTO;
import com.prospecta.Dto.Data;
import com.prospecta.entity.Entry;
import com.prospecta.Dto.EntryDto;
import com.prospecta.exception.EntryException;
import com.prospecta.repository.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class EntryServiceImpl implements EntryService{
    @Autowired
    private EntryRepo entryRepo;

    @Autowired
    private RestTemplate  restTemplate;
    @Override
    public List<EntryDto> getEntryByCategory(String category) {
        String uri = "https://api.publicapis.org/entries";

        ResponseEntity<AllEntryDTO> responseEntity = restTemplate.getForEntity(uri, AllEntryDTO.class);

        List<EntryDto> list = new ArrayList<>();

        for(Entry e: responseEntity.getBody().getEntries()){
            if(category.equals(e.getCategory())){
                list.add(new EntryDto((String) e.getTitle(), (String) e.getDescription()));
            }
        }

        if(list.size()==0)
            throw new EntryException("No Entry found with category : "+category);

        return list;

    }

    @Override
    public Entry saveEntry() {
        String uri = "https://api.publicapis.org/random";

        ResponseEntity<AllEntryDTO> responseEntity = restTemplate.getForEntity(uri, AllEntryDTO.class);

        Entry entry = responseEntity.getBody().getEntries().get(0);

        return entryRepo.save(entry);
    }


}
