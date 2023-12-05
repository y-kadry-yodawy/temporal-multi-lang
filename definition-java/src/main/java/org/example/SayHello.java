package org.example;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SayHello {
    @WorkflowMethod
    String run(String name);
}