package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    public String calculateEXP(int customEnvs1, int customEnvs2){
        try {
            // LOG - Start of calculation
            logger.info("Start EXP - envValue1: " + customEnvs1 + " envValue2: " + customEnvs2);

            double exp1 = Math.getExponent(customEnvs1);
            double exp2 = Math.getExponent(customEnvs2);
            return "Exponent of [Value1] = 2 - is: " + exp1 + " - Exponent of [Value2] = 8 - is:  " + exp2;
        }finally {
            // End of calculation
            logger.info("END EXP");
        }
    }
}