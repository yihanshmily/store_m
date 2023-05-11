//package com.lry.store.config.solve503.utils;
//
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.naming.event.NamingEvent;
//
//@Component
//public class NacosServerListListener implements ServerListListener {
//
//    @Resource
//    private NacosServiceManager nacosServiceManager;
//
//    private NamingService namingService;
//
//    @Autowired
//    private NacosDiscoveryProperties properties;
//
//    @PostConstruct
//    public void init() {
//        namingService =  nacosServiceManager.getNamingService(properties.getNacosProperties());
//    }
//
//    /**
//     * 创建监听器
//     */
//    @Override
//    public void listen(String serviceId, ServerEventHandler eventHandler) {
//        try {
//            namingService.subscribe(serviceId, event -> {
//                if (event instanceof NamingEvent) {
//                    NamingEvent namingEvent = (NamingEvent) event;
////                    log.info("服务名：" + namingEvent.getServiceName());
////                    log.info("实例：" + namingEvent.getInstances());
//                    // 实际更新
//                    eventHandler.update();
//                }
//            });
//        } catch (NacosException e) {
//            e.printStackTrace();
//        }
//    }
//}
