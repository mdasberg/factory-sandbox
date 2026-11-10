# Change: Farewell greeting

## Why
The greeting module can only say hello. A factory smoke test needs one small, well-specified change that touches the
module API, its controller and its tests.

## What Changes
- `GreetingService` gets `farewell(String name)`, which records and returns a `Greeting` whose text is
  `Goodbye, <name>!`.
- `POST /greetings/farewell` accepts the same request body as `POST /greetings` and returns that greeting.
- Farewells appear in the history like greetings.

## Capabilities
### New Capabilities
- `greeting`: farewell next to greet.

## Impact
One interface method, one service method, one controller endpoint, one API test. No schema change: a farewell is a
greeting row with a different text.
