package com.stussy.stussyclone20220903SHC.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductManagementController {

    @GetMapping("/product/register")
    public String loadPropuctRegister(){
        return "admin/product_registration";
    }
}
