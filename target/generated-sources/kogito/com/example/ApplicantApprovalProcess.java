package com.example;

import com.example.ApplicantApprovalModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("ApplicantApproval")
@io.quarkus.runtime.Startup()
public class ApplicantApprovalProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.ApplicantApprovalModel> {

    @jakarta.inject.Inject()
    public ApplicantApprovalProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public ApplicantApprovalProcess() {
    }

    @Override()
    public com.example.ApplicantApprovalProcessInstance createInstance(com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.ApplicantApprovalModel value) {
        return new com.example.ApplicantApprovalProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.ApplicantApprovalModel createModel() {
        return new com.example.ApplicantApprovalModel();
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.ApplicantApprovalModel) value);
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.ApplicantApprovalModel) value);
    }

    public com.example.ApplicantApprovalProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ApplicantApprovalProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.ApplicantApprovalProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.ApplicantApprovalProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("ApplicantApproval", true);
        factory.variable("approval", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "output", "approval", "approval", "ItemSubjectRef", "_approvalItem"));
        factory.variable("applicant", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.cc_approval.model.Applicant.class), java.util.Map.of("customTags", "input", "ItemSubjectRef", "_applicantItem", "applicant", "applicant"));
        factory.variable("creditCard", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.cc_approval.model.CreditCard.class), java.util.Map.of("customTags", "output", "creditCard", "creditCard", "ItemSubjectRef", "_creditCardItem"));
        factory.name("ApplicantApproval");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D"));
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.name("Approved");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.terminate(false);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("UniqueId", "_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("elementname", "Approved");
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("x", 966);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("width", 56);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("y", 141);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.metaData("height", 56);
        endNode_DA9DF6E7_E6AE_457B_9B61_DE88FB3E9D4D.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"));
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.name("Generate CC Details");
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("UniqueId", "_BEC94605-17AA-4BE5-8F8E-F72068BBB457");
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("elementname", "Generate CC Details");
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("NodeType", "ScriptTask");
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("x", 732);
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("width", 154);
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("y", 118);
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.metaData("height", 102);
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.action(kcontext -> {
            System.out.println("Credit card details generation task");
        });
        actionNode_BEC94605_17AA_4BE5_8F8E_F72068BBB457.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"));
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.name("Credit Card Eligibility");
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("UniqueId", "_F6716F5D-2B5A-4F61-93C8-2D42209F874A");
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("elementname", "Credit Card Eligibility");
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("NodeType", "ScriptTask");
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("x", 498);
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("width", 154);
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("y", 118);
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.metaData("height", 102);
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.action(kcontext -> {
            System.out.println("Credit card eligibility script task");
        });
        actionNode_F6716F5D_2B5A_4F61_93C8_2D42209F874A.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"));
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.name("Log application received");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("UniqueId", "_50B329DB-59A7-4B5D-BA57-9C27C7021173");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("elementname", "Log application received");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("NodeType", "ScriptTask");
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("x", 264);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("width", 154);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("y", 118);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.metaData("height", 102);
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.action(kcontext -> {
            System.out.println("Process started for: ");
        });
        actionNode_50B329DB_59A7_4B5D_BA57_9C27C7021173.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2F9DBBF0-37A2-42F8-894D-AF497FC494B6"));
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.name("Start");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.interrupting(false);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("UniqueId", "_2F9DBBF0-37A2-42F8-894D-AF497FC494B6");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("EventType", "none");
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("x", 128);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("width", 56);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("y", 141);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.metaData("height", 56);
        startNode_2F9DBBF0_37A2_42F8_894D_AF497FC494B6.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DA9DF6E7-E6AE-457B-9B61-DE88FB3E9D4D"), "_D0C118E6-C8CB-49D5-9CFA-A944F83A1B91");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_BEC94605-17AA-4BE5-8F8E-F72068BBB457"), "_17433920-3E97-4B51-A758-1585B552624C");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F6716F5D-2B5A-4F61-93C8-2D42209F874A"), "_228DC407-38B6-4639-8AB3-FDC40C5E357A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_2F9DBBF0-37A2-42F8-894D-AF497FC494B6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_50B329DB-59A7-4B5D-BA57-9C27C7021173"), "_841F3056-50C5-4390-8715-78A245ACB44A");
        factory.validate();
        return factory.getProcess();
    }
}
