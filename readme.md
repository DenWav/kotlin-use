# kotlin-use

#### AutoCloseable utilities for Kotlin

## Background

Kotlin provides a single primitive for handling resources, the [`use`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/use.html)
function. `use` is good for what it's for, but it has some significant downsides that Java's try-with-resources
inherently does not, as try-with-resources is a language construct and not simply a function.

This project is essentially a second-draft at addressing this issue, from my original work [here](https://github.com/DenWav/kotlin-try-with-resources).
The readme in that project goes into further details about the deficiencies of simply using `use` for all resource
management needs in Kotlin.

Nothing in this project is remotely new, not in programming in general, nor in Kotlin in specific. Obviously my own
project from 6 years ago makes that clear, but there have been a number of prior works which all do essentially similar
things:

 * [The original discussion about the topic.](https://discuss.kotlinlang.org/t/kotlin-needs-try-with-resources/214)
 * [The basis for my first draft, which I expanded off of](https://discuss.kotlinlang.org/t/kotlin-needs-try-with-resources/214/2)
 * [Another solution from 6 years ago](https://github.com/uluckas/s2s-KotlinAutoClose)
 * [A similar solution also from the same time](https://github.com/FelixEngl/KotlinUsings)
 * [A use-case for context-receivers includes a `defer` implementation](https://github.com/Kotlin/KEEP/blob/master/proposals/context-receivers.md#use-cases)

I never went anywhere with the original project because it never seemed good enough. The required `finally` block was
particularly bad, but also the resulting bytecode was a mess. But this problem has never stopped bugging me with Kotlin,
so I decided to take another stab at it when I was surprised to find there doesn't appear to be a ready-built library
which does this, from what I could find.

I decided to simply ditch error handling for this implementation, which simplifies everything quite a lot. I really
dislike error handling not being a first-class citizen of resource management, as they are intrinsically tied. But I
have decided that outside of a proper language construct, it's simply not possible. The `catching` variants at least
do help to bridge the gap in some programming styles.

I've also decided to try to make this a common library that works on all Kotlin platforms, not just the JVM. This isn't
perfect yet as the `AutoCloseable` interface in the Kotlin stdlib is still marked as experimental, but hopefully it will
be stabilized soon.

## Example Usage

There are two core functions this library provides, `using`, and `deferrable`. Each function has two forms, the standard
form which throws unhandled exceptions, and the catching form which returns a `Result` instead.

### [`using`](https://github.com/DenWav/kotlin-use/blob/main/src/commonMain/kotlin/using.kt)

Similar to C#'s `using` construct, the idea here is simply to easily allow using multiple resources at once without
requiring unnecessary over-indention of the code due to nested `use` calls.

`using` is limited to at most 10 resources at a time, but I hope no one ever actually gets close to needing so many
resources in a single context. For larger or more complex scenarios, [`deferrable`](#deferrable) is better.

Using 2 resources:

```kt
using(getConnection(), file.bufferedWriter()) { conn, writer ->
    ...
}
```

If exceptions are to be handled, the whole block needs to be wrapped:
```kt
try {
    using(getConnection(), file.bufferedWriter()) { conn, writer ->
        ...
    }
} catch (e: IOException) {
    ...
}
```

Or, the catching variant can be used:
```kt
val result = useCatching(getConnection(), file.bufferedWriter()) { conn, writer ->
    ...
}
```

### [`deferrable`](https://github.com/DenWav/kotlin-use/blob/main/src/commonMain/kotlin/deferrable.kt)

Similar to Swift or Go's `defer` construct, `deferrable` allows you to define blocks of code which are guaranteed to be
executed at the end of the `deferrable` block.

Using `defer` has the benefit of maximum flexibility, resources can be created and closed naturally without complicated
nested code or the need to have everything defined directly up front:

```kt
deferrable {
    val conn = getConnection().deferClose()
    val writer = file.bufferedWriter().deferClose()
    ...
}
```

If exceptions are to be handled, the whole block needs to be wrapped:
```kt
try {
    deferrable {
        val conn = getConnection().deferClose()
        val writer = file.bufferedWriter().deferClose()
        ...
    }
} catch (e: IOException) {
    ...
}
```

Or, the catching variant can be used:
```kt
val result = deferrableCatching {
    val conn = getConnection().deferClose()
    val writer = file.bufferedWriter().deferClose()
    ...
}
```

`deferrable` can handle more complex situations as well, such as conditional resources:
```kt
deferrable {
    // conn will be closed automatically if it's not-null, and ignored otherwise
    val conn = if (isDatabaseEnabled) {
        getConnection().deferClose()
    } else {
        null
    }

    // Either resource will be closed automatically, regardless which is chosen
    val writer = if (writeToFile) {
        file.bufferedWriter()
    } else {
        inMemoryStore.writer()
    }.deferClose()
}
```

`defer` can also be used to execute arbitrary code, not just closing `AutoCloseable` resources:
```kt
deferrable {
    val conn = getConnection().deferClose()
    val writer = file.bufferedWriter().deferClose()

    defer {
        writer.appendLine("We're done!")
    }
    ...
}
```

Defer blocks are executed in the reverse order they are defined (last to first), so it's safe to reference resources
which are closed in previous `defer` blocks from later `defer` blocks, as the latter will be executed before the former
is closed.
