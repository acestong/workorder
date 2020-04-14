package com.fea.project.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/4/26 15:03
 * 自定义线程池配置
 **/
@Configuration
public class ThreadPoolConfig {

    @Value("${threadPool.corePoolSize}")
    private Integer corePoolSize;

    @Value("${threadPool.maximumPoolSize}")
    private Integer maximumPoolSize;

    @Value("${threadPool.keepAliveTime}")
    private Long keepAliveTime;

    @Value("${threadPool.capacity}")
    private Integer capacity;

    private BlockingQueue<Runnable> workQueue;

    private RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();

    @Bean(name = "sysThreadPool")
    public ThreadPoolExecutor threadPoolExecutor() {
        workQueue = new ArrayBlockingQueue<>(this.capacity);
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue, rejectedExecutionHandler);
    }
}
