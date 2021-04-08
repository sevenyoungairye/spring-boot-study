package top.bitqian.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author echo lovely
 * @date 2021/4/8 20:35
 * @description your desc
 */

@ConfigurationProperties("bit.hello")
public class HelloProperties {

    private String suffix;

    private String prefix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
