/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.commons.util;

import com.alibaba.fastjson.JSON;

/**
 * 公共全局类
 * @author yanghe
 * @since 1.0
 */
public class Constants {
    public static final String SERVER_SSL = "server.ssl";
    public static final String SERVER_PORT = "server.port";
    public static final String SERVER_SSL_PORT = "server.ssl.port";

    public static final String WEBSOCKET_SSL = "websocket.ssl";
    public static final String WEBSOCKET_PORT = "websocket.port";
    public static final String WEBSOCKET_HANDLER_CLASS_NAME = "websocket.handler.class.name";

    public static final String CALLBACK = "callback";

    public static final String SSO_TOKEN = "sso.token";

    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String RESULT = "result";

    public static final byte[] createJsonErrorMessage(Object object) {
        if (object == null) {
            throw new NullPointerException("消息对象不能为空!");
        }
        
        return JSON.toJSONString(object).getBytes(Charsets.UTF_8);
    }
}
