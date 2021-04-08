package top.bitqian.service;

import top.bitqian.bean.HelloProperties;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2021/4/8 20:34
 * @description
 * <p>
 *     功能类 这里不要放在容器中...
 * </p>
 */

public class HelloService {

    @Resource
    private HelloProperties helloProperties;

    public String sayHello(String name) {

        return helloProperties.getPrefix() + "\t" + name + "==>" + helloProperties.getSuffix();
    }

}
