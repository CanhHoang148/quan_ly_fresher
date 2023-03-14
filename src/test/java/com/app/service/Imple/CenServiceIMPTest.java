package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.exception.NotImplementedException;
import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import com.app.repositories.CenterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CenServiceIMPTest {
    @Mock
    CenterRepository centerRepository;
    @InjectMocks
    CenServiceIMP cenServiceIMP;
    private Center center;
    @BeforeEach
    void setUp() {
        center = new Center();
        center.setCenterId("1");
    }

    @Test
    void getAllCenter() {
        List<Center> centerList = new ArrayList<>();
        centerList.add(mock(Center.class));
        centerList.add(mock(Center.class));
        when(centerRepository.findAll()).thenReturn(centerList);
        List<Center> centers = cenServiceIMP.getAllCenter();
        int num = centers.size();
        assertThat(num).isEqualTo(centerList.size());
        verify(centerRepository).findAll();
    }

    @Test
    void addCenter() {
        when(centerRepository.findById(center.getCenterId()))
                .thenReturn(Optional.empty());
        when(centerRepository.save(center)).thenReturn(center);
        Center center1 = cenServiceIMP.addCenter(center);
        assertThat(center1).isNotNull();
    }

    @Test
    void addCenterButException(){
        when(centerRepository.findById(center.getCenterId()))
                .thenReturn(Optional.of(center));
        assertThrows(NotImplementedException.class,()->{
            cenServiceIMP.addCenter(center);
                });
        verify(centerRepository,times(1)).findById(center.getCenterId());
        verify(centerRepository,never()).save(center);
    }

    @Test
    void deleteCenter() {
        when(centerRepository.existsById(center.getCenterId()))
                .thenReturn(Boolean.TRUE);
        cenServiceIMP.deleteCenter(center.getCenterId());
        verify(centerRepository).deleteById(center.getCenterId());
    }

    @Test
    void deleteCenterButException(){
        String id = "1";
        when(centerRepository.existsById(center.getCenterId()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            cenServiceIMP.deleteCenter(id);
        });
        verify(centerRepository,never()).deleteById(id);
    }

    @Test
    void editCenter() {
        when(centerRepository.findById(center.getCenterId())).thenReturn(Optional.of(center));
        when(centerRepository.save(center)).thenReturn(center);
        Center upCenter = centerRepository.findById(center.getCenterId())
                .map(center1 -> {
                    center1.setCenterName(center1.getCenterName());
                    center1.setCenterAddress(center1.getCenterAddress());
                    center1.setCenterPhone(center1.getCenterPhone());
                    return centerRepository.save(center1);
                }).orElseGet(()->centerRepository.save(center));
        Center newCenter = cenServiceIMP.editCenter(center);
        assertEquals(newCenter,upCenter);
    }

    @Test
    void editCnterButException(){
        when(centerRepository.findById(center.getCenterId())).thenReturn(Optional.empty());
        when(centerRepository.save(center)).thenReturn(center);
        Center upCenter = centerRepository.findById(center.getCenterId())
                .map(center1 -> {
                    center1.setCenterName(center1.getCenterName());
                    center1.setCenterAddress(center1.getCenterAddress());
                    center1.setCenterPhone(center1.getCenterPhone());
                    return centerRepository.save(center1);
                }).orElseGet(()->centerRepository.save(center));
        Center newCenter = cenServiceIMP.editCenter(center);
        assertEquals(newCenter,upCenter);
    }

    @Test
    void getListFresherOfCenter() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(centerRepository.getFresherOfCenter(center.getCenterId())).thenReturn(freshers);

        List<Fresher>fresherList = cenServiceIMP.getListFresherOfCenter(center.getCenterId());
        int size = fresherList.size();
        assertThat(size).isEqualTo(freshers.size());
    }

    @Test
    void getListFresherOfCenterButException(){
        List<Fresher> freshers = new ArrayList<>();

        when(centerRepository.getFresherOfCenter(center.getCenterId())).thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            cenServiceIMP.getListFresherOfCenter(center.getCenterId());
        });
    }
}