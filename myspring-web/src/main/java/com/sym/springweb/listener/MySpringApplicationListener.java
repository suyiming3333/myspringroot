package com.sym.springweb.listener;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring 容器加载完成监听器
 */
@Component
public class MySpringApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("11111111111");
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            System.out.println("spring父容器启动完成");
        }else{
            System.out.println("spring子容器启动完成");
        }
    }
}
