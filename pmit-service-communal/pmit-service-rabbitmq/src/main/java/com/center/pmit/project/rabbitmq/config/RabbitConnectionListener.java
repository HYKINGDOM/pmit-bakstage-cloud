package com.center.pmit.project.rabbitmq.config;

import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitConnectionListener implements ConnectionListener {
    @Autowired
    private RabbitBlockedListener rabbitBlockedListener;

    @Override
    public void onCreate(Connection connection) {
        log.info("================onCreate: {}", connection);
        connection.addBlockedListener(rabbitBlockedListener);
    }

    @Override
    public void onClose(Connection connection) {
        log.info("================onClose: {}", connection);
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        log.info("================onShutDown: {}", signal);
    }
}

