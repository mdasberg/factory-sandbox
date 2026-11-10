## ADDED Requirements

### Requirement: Farewell greeting
The greeting module SHALL offer a farewell next to the greeting: `POST /greetings/farewell` with a non-blank `name`
returns a greeting whose text is `Goodbye, <name>!`, and the farewell is kept in the history.

#### Scenario: Say goodbye
- **WHEN** a client posts `{"name": "Ada"}` to `/greetings/farewell`
- **THEN** the response is a greeting with text `Goodbye, Ada!`

#### Scenario: Blank name
- **WHEN** a client posts `{"name": " "}` to `/greetings/farewell`
- **THEN** the response is 400 and nothing is recorded

#### Scenario: History keeps both kinds
- **WHEN** a client greets `Ada` and then says farewell to `Ada`
- **THEN** `GET /greetings` lists the hello greeting followed by the farewell
