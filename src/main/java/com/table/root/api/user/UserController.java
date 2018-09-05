package com.table.root.api.user;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("userList")
    public ResponseEntity getUserList(){
        List<String> rtn = Lists.newArrayList();
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        rtn.add("a");
        return new ResponseEntity<>(rtn,HttpStatus.OK);
    }
}
