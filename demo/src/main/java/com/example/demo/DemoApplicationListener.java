package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 *在一些业务场景中，当容器初始化完成之后，需要处理一些操作，比如一些数据的加载、初始化缓存、特定任务的注册等等。
 * 这个时候我们就可以使用Spring提供的ApplicationListener来进行操作。
 */
public class DemoApplicationListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        /**
         * 此处是为了防止二次调用,spring-boot不会出现二次调用的问题,在传统项目的application.xml和project-servler.xml配置中出现二次调用
         * 主要原因是初始化root容器之后，会初始化project-servlet.xml对应的子容器
         */
        if(contextRefreshedEvent.getApplicationContext().getParent() != null){
            return;
        }
        System.out.println("我的父容器为：" + contextRefreshedEvent.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }
}
