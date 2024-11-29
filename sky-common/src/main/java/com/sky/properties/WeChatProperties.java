package com.sky.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.wechat")
@Data
public class WeChatProperties {
    private String appid;
    private String secret;
    private String mchid;
    private String mchSerialNo;
    private String privateKeyFilePath;
    private String apiV3Key;
    private String weChatPayCertFilePath;
    private String notifyUrl;
    private String refundNotifyUrl;
}
