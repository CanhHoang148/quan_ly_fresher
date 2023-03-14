package com.app.controll;

import com.app.model.dto.FresherDTO;
import com.app.model.dto.mapper.FresherMapper;
import com.app.model.entity.Fresher;
import com.app.model.response.ResponseObject;
import com.app.service.FresherService;
import com.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/fresher") //http://localhost:8088/fresher
public class FresherController {
    @Autowired
    FresherService fresherService;


    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all fresher successfully",
                        Collections.singletonList(fresherService.getAllFresher()))
        );
    }
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert fresher successfully",
                        fresherService.addFresher(fresher))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        fresherService.editFresher(fresher))
        );
    }
    @DeleteMapping("/delete/{fresherId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String fresherId) {
        fresherService.deleteFresher(fresherId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done","")
        );
    }

    @GetMapping("/search/name")
    public ResponseEntity<ResponseObject> searchFresherWithFresherName(@RequestParam String fresherName){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        Collections.singletonList(fresherService.searchFresherWithFresherName(fresherName)))
        );
    }
    @GetMapping("/search/fresherEmail")
    public ResponseEntity<ResponseObject> searchFresherWithFresherEmail(@RequestParam String fresherEmail){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        fresherService.searchFresherWithFresherEmail(fresherEmail))
        );
    }
    @GetMapping("/search/lp")
    public ResponseEntity<ResponseObject> searchFresherWithLP(@RequestParam String lp){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        Collections.singletonList(fresherService.searchFresherWithLP(lp)))
        );
    }
    @GetMapping("/transcript")
    public ResponseEntity<ResponseObject> getTranscript(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        Collections.singletonList(fresherService.getTranscript()))
        );
    }
}
