package top.bitqian.web.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import top.bitqian.web.entity.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 自定义消息转换器
 * @author echo lovely
 * @date 2021/3/25 21:14
 */

public class BitMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {

        // 响应为person类型
        return clazz == Person.class;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        // 请求类型accept是application/x-bit
        return MediaType.parseMediaTypes("application/x-bit");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream body = outputMessage.getBody();
        // 以 field + "; " + field... 格式返回到客户端
        String res = person.getId() + "; " + person.getName();
        body.write(res.getBytes());

        body.flush();
        body.close();
    }
}
