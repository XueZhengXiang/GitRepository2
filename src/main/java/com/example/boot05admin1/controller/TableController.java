package com.example.boot05admin1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {
    @GetMapping("/table1")
    public String table1() {
        return "table/table1";
    }

    @GetMapping("/table2")
    public String table2() {
        return "table/table2";
    }

    @GetMapping("/table3")
    public String table3() {
        return "table/table3";
    }

    @GetMapping("/table4")
    public String table4() {
        return "table/table4";
    }
}
