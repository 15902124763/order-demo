package com.yarm.service.impl;

import com.yarm.service.OrderService;
import com.yarm.service.ThreadService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    private OrderService orderService;

    @Override
    @SneakyThrows
    public void future(){
        // 创建一个线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        // 启动几个线程
        for (int i = 0; i < 10 ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    orderService.fechInsert();
                }
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
