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
package org.kie.kogito.app;

import java.io.IOException;
import org.infinispan.protostream.MessageMarshaller;

public class ApplicantMessageMarshaller implements MessageMarshaller<org.acme.cc_approval.model.Applicant> {

    public java.lang.Class<org.acme.cc_approval.model.Applicant> getJavaClass() {
        return org.acme.cc_approval.model.Applicant.class;
    }

    public String getTypeName() {
        return "org.kie.kogito.app.Applicant";
    }

    public org.acme.cc_approval.model.Applicant readFrom(ProtoStreamReader reader) throws IOException {
        org.acme.cc_approval.model.Applicant value = new org.acme.cc_approval.model.Applicant();
        value.setAge(reader.readInt("age"));
        value.setAnnualIncome(reader.readLong("annualIncome"));
        value.setCreditScore(reader.readInt("creditScore"));
        value.setName(reader.readString("name"));
        value.setStudent(reader.readBoolean("student"));
        return value;
    }

    public void writeTo(ProtoStreamWriter writer, org.acme.cc_approval.model.Applicant t) throws IOException {
        writer.writeInt("age", t.getAge());
        writer.writeLong("annualIncome", t.getAnnualIncome());
        writer.writeInt("creditScore", t.getCreditScore());
        writer.writeString("name", t.getName());
        writer.writeBoolean("student", t.isStudent());
    }
}
