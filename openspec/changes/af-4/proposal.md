# Change: French greeting

## Why
The greeting module only speaks English. Clients need a French hello and a French farewell next to the English ones.

## What Changes
- `GreetingService` gets `greetInFrench(String name)`, which records and returns a `Greeting` whose text is
  `Bonjour, <name>!`.
- `GreetingService` gets `farewellInFrench(String name)`, which records and returns a `Greeting` whose text is
  `Au revoir, <name>!`.
- `POST /greetings/french` and `POST /greetings/farewell/french` accept the same request body as `POST /greetings`
  and return that greeting.
- French greetings and farewells appear in the history like the English ones.
- The English `POST /greetings` and `POST /greetings/farewell` are unchanged.

## Capabilities
### Modified Capabilities
- `greeting`: French hello and farewell next to the English ones.

## Impact
Two interface methods, two service methods, two controller endpoints, API tests. No schema change: a French
greeting is a greeting row with a different text.
