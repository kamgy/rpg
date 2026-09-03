# rpg

Companion source code for the posts on [blog.kamgy.dev](https://blog.kamgy.dev/), which work through building a
small text-based RPG in Scala 3, one post at a time.

## Stack

Scala 3, [Iron](https://github.com/Iltotore/iron) for refined types,
[Cats Effect](https://typelevel.org/cats-effect/) for the effect system, and MUnit + munit-scalacheck for tests.

## Running

```sh
sbt run   # run Main
sbt test  # run the test suite
```

## Following along with the posts

History is organised per post — commits and branches are named after the article they belong to. `main` always
holds the latest state, so to read the code as it stood for an earlier post, check out the corresponding commit
or branch (e.g. `post-3`, `post-4`).
