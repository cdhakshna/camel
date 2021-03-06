/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.chronicle.engine;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.spi.annotations.Component;
import org.apache.camel.support.DefaultComponent;
import org.apache.camel.util.StringHelper;

/**
 * Represents the component that manages {@link ChronicleEngineEndpoint}.
 */
@Component("chronicle-engine")
public class ChronicleEngineComponent extends DefaultComponent {
    
    public ChronicleEngineComponent() {
    }

    public ChronicleEngineComponent(CamelContext context) {
        super(context);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        final ChronicleEngineConfiguration configuration = new ChronicleEngineConfiguration();
        setProperties(configuration, parameters);

        ChronicleEngineEndpoint answer = new ChronicleEngineEndpoint(uri, this, configuration);
        answer.setAddresses(StringHelper.before(remaining, "/"));
        answer.setPath(StringHelper.after(remaining, "/"));
        return answer;
    }
}
