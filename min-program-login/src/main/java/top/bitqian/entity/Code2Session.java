package top.bitqian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     调用微信接口 返回授权信息~
 * </p>
 * @author echo lovely
 * @date 2020/12/4 21:56
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Code2Session {

    //用户唯一标识
    private String openid;
    // 会话密钥
    private String session_key;
    // 用户在开放平台的唯一标识符
    private String unionid;
    // 错误码
    private Integer errcode;
    // 错误信息
    private String errmsg;

}
