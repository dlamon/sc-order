package cn.net.liaowei.sc.order.controller;

import cn.net.liaowei.sc.order.domain.vo.ResultVO;
import cn.net.liaowei.sc.order.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoWei
 */
@RestController
@Slf4j
@Getter
@Api(tags = "/env", description = "环境变量服务")
@RequestMapping("/env")
public class EnvController {
    @Value("${env}")
    private String env;

    @GetMapping("/get")
    @ApiOperation("获取环境变量")
    public ResultVO<String> get() {
        return ResultUtil.success(this.getEnv());
    }
}
