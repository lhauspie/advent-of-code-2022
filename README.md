# Advent of Code 2022

This year, I decided to practice some development practices that I'm not comfortable with.

By coding during this Advent of Code I hope to learn or improve some development practices like TDD, DDD, Clean Code.

Just let try and see what will happen during this journey.

## Starting by the model

As we start the puzzle resolution process by a partial understanding of the problem to solve, almost in all the case, starting by coding the model will locks us quite easily in an inadequate model that could be difficult to adapt.


## Over engineering

The first thing I can notice is that if we start to over engineer the model, we'll have some difficulties to adapt it in case of partial comprehension of the global problem.
It was particularly the case during the day-05 and day-06.
I spent a lot of time to adapt the model.
The good thing is that the resulting model is really near to the reality.

Over engineering is time expensive.


## Adding test during the refactor phase

Sometimes, I refactored my code to split the problem in smaller piece.
During the refactor, I made some regressions, we're human after all. And as human, we make some mistakes.

But the problem is that when we have tens of tests KO, it's pretty difficult to know where the issue comes from exactly...

So I started to add some tests during the refactor phase in `day-15` and it was much more easier to detect bugs as soon as possible.