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
package com.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProviderFactory;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/ApplicantApproval")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "ApplicantApproval")
@jakarta.enterprise.context.ApplicationScoped()
public class ApplicantApprovalResource {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("ApplicantApproval")
    Process<ApplicantApprovalModel> process;

    @Inject
    ProcessService processService;

    @Inject
    IdentityProviderFactory identityProviderFactory;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public Response createResource_ApplicantApproval(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        ProcessInstance<ApplicantApprovalModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new ApplicantApprovalModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"), null, httpHeaders.getHeaderString("X-KOGITO-ReferenceId"), null);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public List<ApplicantApprovalModelOutput> getResources_ApplicantApproval() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public Map<String, Object> getResourceSchema_ApplicantApproval() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput getResource_ApplicantApproval(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput deleteResource_ApplicantApproval(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput updateModel_ApplicantApproval(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public ApplicantApprovalModelOutput updateModelPartial_ApplicantApproval(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ApplicantApprovalModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ApplicantApproval", description = "")
    @jakarta.transaction.Transactional()
    public List<TaskModel> getTasks_ApplicantApproval(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItems(process, id, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.example.ApplicantApproval_TaskModelFactory::from).collect(Collectors.toList());
    }
}
