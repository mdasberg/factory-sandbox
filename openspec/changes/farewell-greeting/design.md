# Design

Reuse the greeting entity and repository: a farewell is stored as a greeting with text `Goodbye, <name>!`, so
`history()` returns both kinds in creation order and no changeset is needed.

Keep the module boundary: the controller calls `GreetingService.farewell`, never the repository. Validation stays on
the request record (`@NotBlank name`), identical to `greet`.
