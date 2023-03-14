package com.app.controll;

import com.app.model.dto.CenterDTO;
import com.app.model.dto.mapper.CenterMapper;
import com.app.model.entity.Center;
import com.app.model.response.ResponseObject;
import com.app.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/center") //http://localhost:8088/center
public class CenterController {
    @Autowired
    CenterService centerService;
    @GetMapping("/all")
    public ResponseEntity<ResponseObject> getAllCenter() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Successfully",
                        Collections.singletonList(centerService.getAllCenter()))
        );
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Successfully",
                        Collections.singletonList(centerService.addCenter(center)))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Successfully",
                        centerService.editCenter(center))
        );
    }
    @DeleteMapping("/delete/{centerId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String centerId) {
        centerService.deleteCenter(centerId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Successfully","")
        );
    }
    @GetMapping(path = "/fresher/{centerId}")
    public ResponseEntity<ResponseObject> getAllFresherOfCenter(@PathVariable String centerId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Done " + centerId,
                        Collections.singletonList(centerService.getListFresherOfCenter(centerId)))
        );
    }
}