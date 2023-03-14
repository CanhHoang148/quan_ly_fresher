package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.exception.NotImplementedException;
import com.app.model.entity.Fresher;
import com.app.model.response.Transcript;
import com.app.repositories.FresherRepository;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FreServiceIMPTest {
    @Mock
    FresherRepository fresherRepository;
    @InjectMocks
    FreServiceIMP freServiceIMP;
    private Fresher fresher;

    @BeforeEach
    void setUp() {
        fresher = new Fresher();
        fresher.setFresherId("1");
        fresher.setFresherName("name1");
        fresher.setFresherAddress("hn");
        fresher.setFresherPhone("123");
        fresher.setFresherEmail("123@gmail.com");
    }

    @Test
    void getAllFresher() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findAll()).thenReturn(freshers);

        List<Fresher> list = freServiceIMP.getAllFresher();
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());

        verify(fresherRepository).findAll();
    }

    @Test
    void getTranscript() {
        List<Transcript> transcripts = new ArrayList<>();
        transcripts.add(mock(Transcript.class));
        transcripts.add(mock(Transcript.class));

        when(fresherRepository.getTranscript()).thenReturn(transcripts);
        List<Transcript> list = freServiceIMP.getTranscript();
        int size = list.size();
        assertThat(size).isEqualTo(transcripts.size());;
        verify(fresherRepository).getTranscript();
    }

    @Test
    void addFresher() {
        given(fresherRepository.save(fresher)).willReturn(fresher);
        Fresher saveFresher = freServiceIMP.addFresher(fresher);
        assertThat(saveFresher).isNotNull();
    }
    @Test
    void addFresherButException(){
        when(fresherRepository.findById(fresher.getFresherId()))
                .thenReturn(Optional.of(fresher));

        assertThrows(NotImplementedException.class, ()->{
            freServiceIMP.addFresher(fresher);
        });
        verify(fresherRepository, times(1)).findById(fresher.getFresherId());
        verify(fresherRepository, never()).save(any(Fresher.class));
    }

    @Test
    void editFresher() {
        when(fresherRepository.findById(fresher.getFresherId())).thenReturn(Optional.of(fresher));
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher upFresher = fresherRepository.findById(fresher.getFresherId())
                .map(f -> {
                    f.setFresherName(fresher.getFresherName());
                    f.setFresherAddress(fresher.getFresherAddress());
                    f.setFresherPhone(fresher.getFresherPhone());
                    f.setFresherEmail(fresher.getFresherEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher newFresher = freServiceIMP.editFresher(fresher);
        assertEquals(upFresher, newFresher);
    }
    @Test
    void editFresherButException(){
        when(fresherRepository.findById(fresher.getFresherId())).thenReturn(Optional.of(fresher));
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher upFresher = fresherRepository.findById(fresher.getFresherId())
                .map(f -> {
                    f.setFresherName(fresher.getFresherName());
                    f.setFresherAddress(fresher.getFresherAddress());
                    f.setFresherPhone(fresher.getFresherPhone());
                    f.setFresherEmail(fresher.getFresherEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher newFresher = freServiceIMP.editFresher(fresher);
        assertEquals(upFresher, newFresher);
    }

    @Test
    void deleteFresher() {
        when(fresherRepository.existsById(fresher.getFresherId()))
                .thenReturn(Boolean.TRUE);
        freServiceIMP.deleteFresher(fresher.getFresherId());
        verify(fresherRepository).deleteById(fresher.getFresherId());
    }
    @Test
    void deleteFresherButException(){
        String id = "1";
        when(fresherRepository.existsById(fresher.getFresherId()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            freServiceIMP.deleteFresher(id);
        });
        verify(fresherRepository,never()).deleteById(id);
    }

    @Test
    void searchFresherWithFresherName() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByFresherName(fresher.getFresherName()))
                .thenReturn(freshers);

        List<Fresher> list = freServiceIMP.searchFresherWithFresherName(fresher.getFresherName());
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByFresherName(fresher.getFresherName());
    }

    @Test
    void seachFresherWithNameButException(){
        String name = fresher.getFresherName();
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByFresherName(name))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            freServiceIMP.searchFresherWithFresherName(name);
        });
        verify(fresherRepository, times(1)).findByFresherName(name);
    }
    @Test
    void searchFresherWithFresherEmail() {
        Fresher fresher = mock(Fresher.class);
        when(fresherRepository.findByFresherEmail(fresher.getFresherEmail()))
                .thenReturn(Optional.of(fresher));
        Fresher fresherOptional = freServiceIMP.searchFresherWithFresherEmail(fresher.getFresherEmail());
        assertThat(fresherOptional.getFresherId()).isEqualTo(fresher.getFresherId());
        verify(fresherRepository).findByFresherEmail(fresher.getFresherEmail());
    }
    @Test
    void seachFresherWithEmailButException(){
        String email = fresher.getFresherEmail();
        when(fresherRepository.findByFresherEmail(email))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,()->{
            freServiceIMP.searchFresherWithFresherEmail(email);
        });
        verify(fresherRepository,times(1)).findByFresherEmail(email);
    }

    @Test
    void searchFresherWithLP() {
        String lp = "Java";
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByFresherWithLP(lp))
                .thenReturn(freshers);
        List<Fresher> list = freServiceIMP.searchFresherWithLP(lp);
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByFresherWithLP(lp);
    }
    @Test
    void seachFresherWithLpButException(){
        String lp = "JAVA";
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByFresherWithLP(lp))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            freServiceIMP.searchFresherWithLP(lp);
        });
        verify(fresherRepository,times(1)).findByFresherWithLP(lp);
    }
}