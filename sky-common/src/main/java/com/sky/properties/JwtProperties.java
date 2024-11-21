package com.sky.properties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sky.jwt")
public class JwtProperties {
    private String adminSecretKey;
    private Long adminTtl;
    private String adminTokenName;

    private String userSecretKey;
    private String userTtl;
    private String userTokenName;
}
