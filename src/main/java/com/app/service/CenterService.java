package com.app.service;

import com.app.model.entity.Center;
import com.app.model.entity.Fresher;


import java.util.List;

public interface CenterService {
    List<Center> getAllCenter();

    Center addCenter(Center center);

    void deleteCenter(String id);

    Center editCenter(Center center);

    List<Fresher> getListFresherOfCenter(String string);

}