package com.center.pmit.project.rabbitmq.config;

import com.rabbitmq.client.BlockedListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class RabbitBlockedListener implements BlockedListener {
    @Override
    public void handleBlocked(String s) throws IOException {
        log.info("=========================connection blocked, reason: {}", s);
    }

    @Override
    public void handleUnblocked() throws IOException {
        log.info("==============================connection unblocked");
    }
}

