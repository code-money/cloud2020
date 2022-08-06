package cn.zyz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule
{
    @Bean
    public IRule myRule()
    {
        //定义访问服务的方式为随机
        return new RandomRule();
        //定义访问服务的方式为轮询(默认)
        //return new RoundRobinRule();
    }
}
