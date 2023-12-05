package org.example;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class SayHelloWorker {

    public static void main(String[] args) {

        WorkflowServiceStubsOptions workflowServiceStubsOptions =
                WorkflowServiceStubsOptions.newBuilder()
                        .setTarget("localhost:7233")
                        .build();

        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(workflowServiceStubsOptions);

        // Configure the Temporal client
        WorkflowClient workflowClient = WorkflowClient.newInstance(service);
        // Create a WorkerFactory
        WorkerFactory workerFactory = WorkerFactory.newInstance(workflowClient);
        // Create a Worker for the "hello-task-queue"
        Worker worker = workerFactory.newWorker("java-task-queue");
        // Register the workflow implementation
        worker.registerWorkflowImplementationTypes(SayHelloImpl.class);

        // Start the worker
        workerFactory.start();
    }
}