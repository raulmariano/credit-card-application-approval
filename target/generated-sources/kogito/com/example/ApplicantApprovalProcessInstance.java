package com.example;

import com.example.ApplicantApprovalModel;

public class ApplicantApprovalProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ApplicantApprovalModel> {

    public ApplicantApprovalProcessInstance(com.example.ApplicantApprovalProcess process, ApplicantApprovalModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ApplicantApprovalProcessInstance(com.example.ApplicantApprovalProcess process, ApplicantApprovalModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ApplicantApprovalProcessInstance(com.example.ApplicantApprovalProcess process, ApplicantApprovalModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ApplicantApprovalProcessInstance(com.example.ApplicantApprovalProcess process, ApplicantApprovalModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ApplicantApprovalProcessInstance(com.example.ApplicantApprovalProcess process, ApplicantApprovalModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ApplicantApprovalModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ApplicantApprovalModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
