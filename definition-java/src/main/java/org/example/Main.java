package org.example;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

public class Main {

    public static void main(String[] args) {

        WorkflowServiceStubsOptions workflowServiceStubsOptions =
                WorkflowServiceStubsOptions.newBuilder()
                        .setTarget("localhost:7233")
                        .build();

        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);

        // Configure the Temporal client
        WorkflowClient workflowClient = WorkflowClient.newInstance(service);

        // Create WorkflowOptions with desired settings
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue("python-task-queue").build();

        // Create a workflow stub
        SayHello sayHelloWorkflow = workflowClient.newWorkflowStub(SayHello.class, options);

        // Print the result
        System.out.println("Workflow result: " + sayHelloWorkflow.run("Youssef"));
    }
}
