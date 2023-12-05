from temporalio import activity

@activity.defn(name="GetGreeting")
async def get_greeting(name: str) -> str:
    return f"Hello, {name}!"