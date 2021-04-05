package top.bitqian.web.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @author echo lovely
 * @date 2021/4/5 21:25
 * @description
 * <p>
 *     <ul>
 *         <li>自定义端点</li>
 *         <li>可读可写, 读rest就能访问到端点的标注readOperation方法, jConsole访问write</li>
 *         <li>read http://localhost:8080/actuator/myDefineEndPoint</li>
 *     </ul>
 *     <ol>
 *         <li>read and write..</li>
 *     </ol>
 * </p>
 */

@Endpoint(id = "myDefineEndPoint")
@Component()
public class MyDefineEndPoint {

    // when get this: http://localhost:8080/actuator/myDefineEndPoint
    @ReadOperation
    public String readOperation() {
        System.out.println("read it, there is sth could be start...");
        return "read";
    }

    @WriteOperation
    public void writeOperation() {
        System.out.println("write it, do sth, this could be shutdown!");
    }

}
