package com.BS4_exercise.BS4;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class VariableProperties {

    @Value("${var1}")
    private String var1;

    @Value("${my.var2}")
    private String var2;

    @Value("${VAR_SISTEMA:var3 no tiene valor}")
    private String var3;

}
