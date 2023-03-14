package com.app.model.dto.mapper;

import com.app.model.dto.CenterDTO;
import com.app.model.entity.Center;

public class CenterMapper {
    public Center toCenter(CenterDTO centerDTO) {
        Center center = new Center();
        center.setCenterId(centerDTO.getCenterId());
        center.setCenterName(centerDTO.getCenterName());
        center.setCenterAddress(centerDTO.getCenterAddress());
        center.setCenterPhone(centerDTO.getCenterPhone());
        return center;
    }
}