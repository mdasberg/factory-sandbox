## ADDED Requirements

### Requirement: Tell the time
The service SHALL tell the current time: `GET /time` returns an object whose `time` field is the current instant as an
ISO-8601 UTC timestamp. Nothing is recorded.

#### Scenario: Ask the time
- **WHEN** a client gets `/time`
- **THEN** the response is 200 with a body like `{"time": "2026-11-11T10:15:30.123Z"}`

#### Scenario: Time is current
- **WHEN** a client gets `/time`
- **THEN** the returned `time` is not before the moment the request was sent and not after the response arrived

#### Scenario: Greetings unchanged
- **WHEN** a client gets `/time`
- **THEN** `GET /greetings` lists the same greetings as before
