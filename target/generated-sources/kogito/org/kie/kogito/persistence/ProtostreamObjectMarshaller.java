/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.persistence;

import java.io.IOException;
import org.infinispan.protostream.ProtobufUtil;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.config.Configuration;
import org.infinispan.protostream.impl.SerializationContextImpl;
import org.jbpm.flow.serialization.ObjectMarshallerStrategy;
import org.jbpm.flow.serialization.ProcessInstanceMarshallerException;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;

public class ProtostreamObjectMarshaller implements ObjectMarshallerStrategy {

    private static final String NAMESPACE = "org.kie.kogito/";

    private SerializationContext context;

    public ProtostreamObjectMarshaller() {
        context = new SerializationContextImpl(Configuration.builder().build());
        try {
            context.registerProtoFiles(((new org.infinispan.protostream.FileDescriptorSource()).addProtoFile("kogito-types.proto", getClass().getClassLoader().getResourceAsStream("META-INF/kogito-types.proto"))).addProtoFile("application-types.proto", getClass().getClassLoader().getResourceAsStream("META-INF/application-types.proto")));
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.StringProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.BooleanProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.DateProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.DoubleProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.FloatProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.IntegerProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.LongProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.InstantProtostreamBaseMarshaller());
            context.registerMarshaller(new org.jbpm.flow.serialization.marshaller.SerializableProtostreamBaseMarshaller());
            context.registerMarshaller(new org.kie.kogito.app.ApplicantMessageMarshaller());
            context.registerMarshaller(new org.kie.kogito.app.CreditCardMessageMarshaller());
        } catch (IOException e) {
        }
    }

    @Override
    public Integer order() {
        return 2;
    }

    @Override
    public boolean acceptForMarshalling(Object value) {
        return context.canMarshall(value.getClass());
    }

    @Override
    public Any marshall(Object unmarshalled) {
        try {
            String fullTypeName = context.getMarshaller(unmarshalled.getClass()).getTypeName();
            return Any.newBuilder().setTypeUrl(NAMESPACE + fullTypeName).setValue(ByteString.copyFrom(ProtobufUtil.toByteArray(context, unmarshalled))).build();
        } catch (IOException e) {
            throw new ProcessInstanceMarshallerException("cannot marshall protobuf stream", e);
        }
    }

    @Override
    public boolean acceptForUnmarshalling(Any data) {
        return data.getTypeUrl().startsWith(NAMESPACE);
    }

    @Override
    public Object unmarshall(Any data) {
        try {
            String fqn = context.getMarshaller(removeNamespace(data.getTypeUrl())).getJavaClass().getCanonicalName();
            byte[] bytes = data.getValue().toByteArray();
            return ProtobufUtil.fromByteArray(context, bytes, 0, bytes.length, Class.forName(fqn));
        } catch (IOException | ClassNotFoundException e) {
            throw new ProcessInstanceMarshallerException("cannot unmarshall protobuf stream", e);
        }
    }

    private String removeNamespace(String dataTypeURL) {
        return dataTypeURL.substring(NAMESPACE.length());
    }
}
