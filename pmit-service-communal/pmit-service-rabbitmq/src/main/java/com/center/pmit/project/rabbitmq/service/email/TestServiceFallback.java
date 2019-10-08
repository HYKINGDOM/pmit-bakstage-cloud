package com.center.pmit.project.rabbitmq.service.email;

import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 邮件接口熔断异常
 * @author Administrator
 */
@Component
public class TestServiceFallback implements FallbackFactory<EmailSendService> {

    private static final Logger LOG = LoggerFactory.getLogger(TestServiceFallback.class);

    public static final String ERR_MSG = "Test接口暂时不可用: ";

    @Override
    public EmailSendService create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            LOG.error(msg);
        }
        return object -> msg;
    }
}
