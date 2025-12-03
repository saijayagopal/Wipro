package com.wipro.WiproSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // ✅ This is NOW a separate API, not conflicting with /login
    @GetMapping("/check-login")
    public String checkUser(
            @RequestParam String name,
            @RequestParam String password) {

        String sql = "SELECT COUNT(*) FROM users WHERE name=? AND password=?";
        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                name,
                password
        );

        if (count != null && count > 0) {
            return "Login Successful ✅";
        } else {
            return "Login Failed ❌";
        }
    }
}
