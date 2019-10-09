package com.galaxysoft.project.auth.security.component;

import com.center.pmit.project.common.constant.CommonConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.galaxysoft.project.auth.security.exception.PigAuth2Exception;
import lombok.SneakyThrows;

/**
 * OAuth2 异常格式化
 *
 * @author Administrator
 */
public class PigAuth2ExceptionSerializer extends StdSerializer<PigAuth2Exception> {
    public PigAuth2ExceptionSerializer() {
        super(PigAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(PigAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
        gen.writeStartObject();
        gen.writeObjectField("code", CommonConstants.FAIL);
        gen.writeStringField("msg", value.getMessage());
        gen.writeStringField("data", value.getErrorCode());
        gen.writeEndObject();
    }
}
