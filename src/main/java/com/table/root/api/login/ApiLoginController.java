package com.table.root.api.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ApiLoginController {
    @RequestMapping("signIn.json")
    public Object signIn(){
        return null;
    }
    @RequestMapping("signUp.json")
    public Object signUp(){
        return null;
    }
    @RequestMapping("signOut.json")
    public Object signOut(){
        return null;
    }
}
