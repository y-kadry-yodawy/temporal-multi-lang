package org.example;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class SayHelloImpl implements SayHello {

    @Override
    public String run(String name) {
        // Create an activity stub
        GreetingActivities activities = Workflow.newActivityStub(
                GreetingActivities.class,
                ActivityOptions.newBuilder().setTaskQueue("python-task-queue")
                .setStartToCloseTimeout(Duration.ofSeconds(10)).build()
        );
        // Use the activity to get the greeting
        return activities.getGreeting(name);
    }
}