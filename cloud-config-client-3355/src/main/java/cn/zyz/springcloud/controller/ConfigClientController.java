package cn.zyz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//添加动态刷新配置功能
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    // 这个值是在 gitee 上的 config-dev.yml 中进行配置过的
    // 获取配置文件中的配置信息，访问http://localhost:3344/master/config-***.yml文件
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo()
    {
        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }

}
