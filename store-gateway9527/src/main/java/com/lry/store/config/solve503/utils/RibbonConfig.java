//package com.lry.store.config.solve503.utils;
//
//import com.alibaba.cloud.nacos.ribbon.ConditionalOnRibbonNacos;
//import com.lry.store.config.solve503.utils.NacosServerListListener;
//import com.lry.store.config.solve503.utils.NotificationServerListUpdater;
//import com.netflix.loadbalancer.ServerListUpdater;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConditionalOnRibbonNacos
//public class RibbonConfig {
//    @Bean
//    public ServerListUpdater ribbonServerListUpdater(NacosServerListListener listener) {
//        return new NotificationServerListUpdater(listener);
//    }
//}
