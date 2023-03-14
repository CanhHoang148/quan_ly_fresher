package com.app.controll;


import com.app.model.dto.SubjectDTO;
import com.app.model.dto.mapper.SubjectMapper;
import com.app.model.entity.Subject;
import com.app.model.response.ResponseObject;
import com.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subject") //http://localhost:8088/subject
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<ResponseObject> addSubject (@RequestBody SubjectDTO subjectDTO){
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        subjectService.addSubject(subject))
        );
    }
    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAllSubject(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done",
                        subjectService.getAllSubject())
        );
    }

    @DeleteMapping(path = "/delete/{subjectId}")
    public ResponseEntity<ResponseObject> deleteSubject (@PathVariable String subjectId){
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Done","" )
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change successfully",
                        subjectService.editSubject(subject))
        );
    }


}
