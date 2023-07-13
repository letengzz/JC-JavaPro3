package com.hjc.demo.client;

import com.hjc.entity.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "userservice",fallback = UserClient.Fallback.class,fallbackFactory = UserClient.FallBackFactory.class)   //声明为userservice服务的HTTP请求客户端
public interface UserClient {
    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") Integer uid);  //参数和返回值也保持一致

    @Component
    static class Fallback implements UserClient {
        @Override
        public  User getUserById(Integer uid) {
            //这里我们自行对其进行实现，并返回我们的替代方案
            User user = new User();
            user.setName("熔断降级方法返回");
            return user;
        }
    }

    @Component
    static class FallBackFactory implements FallbackFactory<Fallback> {

        @Override
        public Fallback create(Throwable cause) {
            cause.printStackTrace();
            return new Fallback();
        }
    }

}