package com.BS4_exercise.BS4;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test")
public class VariableYML {
    private String var1;
    private String my_var2;
    private String var3;
}
