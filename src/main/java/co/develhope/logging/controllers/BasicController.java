package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private Environment environment;
    @Value("${customEnvs.n1}")
    int envValue1;
    @Value("${customEnvs.n2}")
    int envValue2;

    @Autowired
    BasicService basicService;
    Logger logger = LoggerFactory.getLogger(BasicController.class);

    // Return the message and log it
    @GetMapping("/")
    public void sayWelcome(){
        logger.info("We welcome you");
    }

    // Return calculateEXP
    @GetMapping("/exp")
    public String exp(){
        logger.info("I start calculating EXP");
        return basicService.calculateEXP(envValue1,envValue2);
    }

    // Generate an error and log it
    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("CUSTOM ERROR");
        logger.error("ERROR LOGGING",error);
    }
}