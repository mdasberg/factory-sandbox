# Change: Tell the time

## Why
Clients have no way to ask the service what time it is.

## What Changes
- A new `clock` module with public API `ClockService` and the record `CurrentTime(Instant time)`.
- `ClockService.now()` returns the current time as a `CurrentTime`.
- `GET /time` returns that `CurrentTime`, e.g. `{"time": "2026-11-11T10:15:30.123Z"}` (ISO-8601, UTC).
- The greeting module is unchanged.

## Capabilities
### New Capabilities
- `clock`: tell the current time over HTTP.

## Impact
One new module (package-info, interface, record, service impl, controller) and an API test. No schema change and
nothing is stored: the time is read, not recorded.
