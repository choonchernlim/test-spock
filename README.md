# Playing with Spock Test Framework

### Example 0 : Understanding different phases of Spock
* `def setupSpec() {}` and `def cleanupSpec() {}` execute once per specification.
* `def setup() {}` and `def cleanup() {}` execute once per feature.
* Each feature can have its own `given:` and `cleanup:` to perform feature-specific setup and cleanup.

### Example 1 : `when, then` and `expect` constructs

* Use `expect` if `when, then` don't make sense to write.
* In `then`, don't need to use the word `assert`.

### Example 2 : Exception handling with `thrown(...)`, `@FailsWith` and `notThrown(...)`

* `thrown(...)` is preferred, `@FailsWith` is not recommended in most usage.

### Example 3 : Multiple assertions with `where` using table and left shift operator. Using `@Unroll` to separate assertions into isolated test case.

* Two different ways to perform assertions with different set of data.
* Ability to create custom label for `@Unroll` to make test case label more readable.

### Example 4 : Shared and non-shared instance fields.

* By default, all instance fields are not shared between feature methods.
* Use `@Shared` if the instance is very expensive to create.


### Helpful Links

* https://code.google.com/p/spock/ - Spock's official site.
* http://spock-framework.readthedocs.org/en/latest/index.html - Spock Framework Reference Documentation by Spock author, Peter Niederwieser.