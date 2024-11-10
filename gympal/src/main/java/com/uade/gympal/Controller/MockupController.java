package com.uade.gympal.Controller;

import com.uade.gympal.Service.MockupDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mockup")
public class MockupController {
    @Autowired
    private MockupDatosService mockupService;
    @PostMapping
    public void iniciarDatos(){
        mockupService.iniciarDatos();
    }
}
