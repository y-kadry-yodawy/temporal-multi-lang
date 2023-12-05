import asyncio
from temporalio.client import Client
from temporalio.worker import Worker

# Import the activity and workflow from our other files
from activities import get_greeting

async def main():
    # Create client connected to server at the given address
    client = await Client.connect("localhost:7233")

    # Run the worker
    worker = Worker(
      client,
      task_queue="python-task-queue",
      activities=[get_greeting]
    )
    await worker.run()

if __name__ == "__main__":
    asyncio.run(main())