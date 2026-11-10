# Design

Follow the farewell change: reuse the greeting entity and repository. A French greeting is stored as a greeting with
text `Bonjour, <name>!` and a French farewell as `Au revoir, <name>!`, so `history()` returns all kinds in creation
order and no changeset is needed. The punctuation matches the English texts (no space before `!`).

Endpoints add `/french` to the path of the English endpoint they mirror: `POST /greetings` becomes
`POST /greetings/french`, `POST /greetings/farewell` becomes `POST /greetings/farewell/french`. Both reuse
`GreetRequest`.

Keep the module boundary: the controller calls `GreetingService.greetInFrench` and
`GreetingService.farewellInFrench`, never the repository. Validation stays on the request record (`@NotBlank name`),
identical to `greet`.

No language parameter or locale handling: the discussion chose a separate endpoint per language.
