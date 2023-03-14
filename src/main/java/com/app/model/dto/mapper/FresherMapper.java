package com.app.model.dto.mapper;

import com.app.model.dto.FresherDTO;
import com.app.model.entity.Fresher;

public class FresherMapper {
    public Fresher toFresher(FresherDTO fresherDTO) {
        Fresher fresher = new Fresher();
        fresher.setFresherId(fresherDTO.getFresherId());
        fresher.setFresherName(fresherDTO.getFresherName());
        fresher.setFresherAddress(fresherDTO.getFresherAddress());
        fresher.setFresherPhone(fresherDTO.getFresherPhone());
        fresher.setFresherEmail(fresherDTO.getFresherEmail());
        return fresher;
    }
}
