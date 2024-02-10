package com.prospecta.service;

import com.prospecta.entity.Entry;
import com.prospecta.Dto.EntryDto;

import java.util.*;
public interface EntryService {

   public List<EntryDto> getEntryByCategory(String category);

   public Entry saveEntry();

}
