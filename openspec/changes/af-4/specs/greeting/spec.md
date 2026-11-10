## ADDED Requirements

### Requirement: French greeting
The greeting module SHALL offer a French greeting next to the English one: `POST /greetings/french` with a non-blank
`name` returns a greeting whose text is `Bonjour, <name>!`, and the greeting is kept in the history. `POST /greetings`
keeps returning `Hello, <name>!`.

#### Scenario: Say hello in French
- **WHEN** a client posts `{"name": "Ada"}` to `/greetings/french`
- **THEN** the response is a greeting with text `Bonjour, Ada!`

#### Scenario: Blank name
- **WHEN** a client posts `{"name": " "}` to `/greetings/french`
- **THEN** the response is 400 and nothing is recorded

#### Scenario: English greeting unchanged
- **WHEN** a client posts `{"name": "Ada"}` to `/greetings`
- **THEN** the response is a greeting with text `Hello, Ada!`

### Requirement: French farewell
The greeting module SHALL offer a French farewell next to the English one: `POST /greetings/farewell/french` with a
non-blank `name` returns a greeting whose text is `Au revoir, <name>!`, and the farewell is kept in the history.
`POST /greetings/farewell` keeps returning `Goodbye, <name>!`.

#### Scenario: Say goodbye in French
- **WHEN** a client posts `{"name": "Ada"}` to `/greetings/farewell/french`
- **THEN** the response is a greeting with text `Au revoir, Ada!`

#### Scenario: Blank name
- **WHEN** a client posts `{"name": " "}` to `/greetings/farewell/french`
- **THEN** the response is 400 and nothing is recorded

#### Scenario: History keeps French and English
- **WHEN** a client greets `Ada` in English, then in French, then says farewell to `Ada` in French
- **THEN** `GET /greetings` lists `Hello, Ada!`, `Bonjour, Ada!` and `Au revoir, Ada!` in that order
