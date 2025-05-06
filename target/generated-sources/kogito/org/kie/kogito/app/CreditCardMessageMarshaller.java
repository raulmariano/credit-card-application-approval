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

public class CreditCardMessageMarshaller implements MessageMarshaller<org.acme.cc_approval.model.CreditCard> {

    public java.lang.Class<org.acme.cc_approval.model.CreditCard> getJavaClass() {
        return org.acme.cc_approval.model.CreditCard.class;
    }

    public String getTypeName() {
        return "org.kie.kogito.app.CreditCard";
    }

    public org.acme.cc_approval.model.CreditCard readFrom(ProtoStreamReader reader) throws IOException {
        org.acme.cc_approval.model.CreditCard value = new org.acme.cc_approval.model.CreditCard();
        value.setCardHolderName(reader.readString("cardHolderName"));
        value.setCardNumber(reader.readString("cardNumber"));
        value.setCreditLimit(reader.readDouble("creditLimit"));
        value.setCvv(reader.readString("cvv"));
        value.setExpirationDate((java.time.LocalDate) (reader.readObject("expirationDate", java.io.Serializable.class)));
        return value;
    }

    public void writeTo(ProtoStreamWriter writer, org.acme.cc_approval.model.CreditCard t) throws IOException {
        writer.writeString("cardHolderName", t.getCardHolderName());
        writer.writeString("cardNumber", t.getCardNumber());
        writer.writeDouble("creditLimit", t.getCreditLimit());
        writer.writeString("cvv", t.getCvv());
        writer.writeObject("expirationDate", (java.time.LocalDate) (t.getExpirationDate()), java.io.Serializable.class);
    }
}
