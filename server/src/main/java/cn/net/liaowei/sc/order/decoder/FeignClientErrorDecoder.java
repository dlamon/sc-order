package cn.net.liaowei.sc.order.decoder;

import cn.net.liaowei.sc.order.domain.vo.ResultVO;
import cn.net.liaowei.sc.order.enums.ErrorEnum;
import cn.net.liaowei.sc.order.exception.SCException;
import com.google.gson.Gson;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author LiaoWei
 */
@Slf4j
//@Configuration
public class FeignClientErrorDecoder implements ErrorDecoder {

    private static final Gson gson = new Gson();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            String errorContent;
            try {
                errorContent = Util.toString(response.body().asReader());
                ResultVO<Void> result = gson.fromJson(errorContent, ResultVO.class);
                String code = result.getCode();
                if (!StringUtils.isEmpty(code) && !ErrorEnum.SYSTEM_INTERNAL_ERROR.equals(code)) {
                    // 否则为业务错误，需要跳过熔断计数
                    log.info("return SCException, code:{}, message:{}", result.getCode(), result.getMessage());
                    return new SCException(result.getCode(), result.getMessage());
                }
                // 如果属于系统报错， 则返回Exception,进行熔断计数
                return new Exception(errorContent);
            } catch (IOException e) {
                log.error("{}", e);
                return e;
            }
        }
        return FeignException.errorStatus(methodKey, response);
    }
}
