package by.prokopovich.switter.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/just-auth")
    public String justAuth() {
        return "This is protected resource-1";
    }

    @GetMapping("/just-role-user")
    public String justRoleUser() {

        return "This is protected resource-2";
    }

    @GetMapping("/just-role-admin")
    public String justRoleAdmin() {

        return "This is protected resource-3";
    }


}
