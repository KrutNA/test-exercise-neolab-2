
# Table of Contents

1.  [Second Test Exercise for NEOLAB Internship](#org891d1ad)
    1.  [About](#orgffb7804)
        1.  [Exercise 1.](#org9fdf268)
        2.  [Exercise 2.](#org51bbdb9)
        3.  [Exercise 3.](#orgd45a184)
    2.  [Building](#orgfa2e9e5)
        1.  [To build application.](#orga43ea35)
        2.  [To run application.](#org85f13c4)
        3.  [To test application.](#orga7d2742)
        4.  [To create javadoc.](#orge7a77f6)
        5.  [To create jar with all dependecies.](#orgeffe03a)


<a id="org891d1ad"></a>

# Second Test Exercise for [NEOLAB Internship](https://internship.neolab.io/)


<a id="orgffb7804"></a>

## About

All classes are in `com.krutna.testexercise` package.


<a id="org9fdf268"></a>

### Exercise 1.

Function, which sorts only odds in inputed array.

`int[] App#check(int[] array)` in [App.java](src/main/java/com/krutna/testexercise/App.java).

Uses method `int[] SuitableSorter#sortOnlyFiltered(int[] array, IntPredicate function)` in [SuitableSorter.java](src/main/java/com/krutna/testexercise/SuitableSorter.java).

Where predicate for checking is `x -> x % 2 == 1` (Checks is number an odd).

Base method can use any predicates for integers to sort only them and ignore other.

Tests are in `AppTest#testOddsSorting()` in [AppTest.java](src/test/java/com/krutna/testexercise/AppTest.java).


<a id="org51bbdb9"></a>

### Exercise 2.

Function which corrects time from regex format `\d{0,4}:\d{0,4}:\d{0,4}` to 24h format like `00:00:00`.

`String App#correctTime(String time)` in [App.java](src/main/java/com/krutna/testexercise/App.java).

Uses method `String TimeProcessor#correct(String time)` in [TimeProcessor.java](src/main/java/com/krutna/testexercise/TimeProcessor.java).

Tests are in `AppTest#testTimeConvertion()` in [AppTest.java.](src/test/java/com/krutna/testexercise/AppTest.java)


<a id="orgd45a184"></a>

### Exercise 3.

Function which checks checkmate in the input `String`

`boolean App#checkChess(String chess)` in [App.java](src/main/java/com/krutna/testexercise/App.java).

Uses method `boolean Chessboard#check(String time)` in [Chessboard.java](src/main/java/com/krutna/testexercise/Chessboard.java).

`Chessboard` class may be with any sizes from 1 \* 1 to `MaxInt` \* `MaxInt`. But `App` creates 4 \* 4.

Tests are in `AppTest#testChessboard()` in [AppTest.java](src/test/java/com/krutna/testexercise/AppTest.java).


<a id="orgfa2e9e5"></a>

## Building

All examples are shown for \*nix, for Windows use `gradlew.bat` instead of `gradlew`


<a id="orga43ea35"></a>

### To build application.

`$ gradlew build`

Results into `./bin/` directory as \*.class files


<a id="org85f13c4"></a>

### To run application.

`$ gradlew run`

But nothing happens, because App only creates class instances, no other logic.


<a id="orga7d2742"></a>

### To test application.

`$ gradlew test`

Here 3 tests in `AppTest`. 1 for each task:

For tests used JUnit 4.

All tests passes successfully.


<a id="orge7a77f6"></a>

### To create javadoc.

`$ gradlew javadoc` 

Results into `./build/doc/javadoc/` directory.

Javadoc uses API of `Java SE 11`.


<a id="orgeffe03a"></a>

### To create jar with all dependecies.

`$ gradlew fatJar`

Results into `./build/libs/` directory.

