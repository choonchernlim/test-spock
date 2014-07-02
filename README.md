# Playing with Spock Test Framework

### Example 0 : Understanding different phases of Spock
* `def setupSpec() {}` and `def cleanupSpec() {}` execute once per specification.
* `def setup() {}` and `def cleanup() {}` execute once per feature.
* Each feature can have its own `given:` and `cleanup:` to perform feature-specific setup and cleanup.

### Example 1 : `when, then` and `expect` constructs

* Use `expect` if `when, then` don't make sense to write.
* In `then`, don't need to use the word `assert`.

### Helpful Links

* https://code.google.com/p/spock/ - Spock's official site.
* http://spock-framework.readthedocs.org/en/latest/index.html - Spock Framework Reference Documentation by Spock author, Peter Niederwieser.