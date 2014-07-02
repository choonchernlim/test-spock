# Testing Spock Test Framework

## Example 0 : Understanding different phases of Spock
* `def setupSpec() {}` and `def cleanupSpec() {}` execute once per specification.
* `def setup() {}` and `def cleanup() {}` execute once per feature.
* Each feature can have its own `given:` and `cleanup:` to perform feature-specific setup and cleanup.

