# COMP 271 SU25 WEEK 04

This assignment has two parts: a coding part based on current material we discuss in class and a reflection part to evaluate work you have already submitted.


# Standing requirements

* **Programmers Pact:** Your work must be compliant with the [Programmers Pact](./ProgrammerPact.pdf). 
* **Comments:** Your code must be sufficiently documented with comments.
* **No imports:** You may not use the import statement in your code, with one exception: `import Arrays;` is allowed only for using `Arrays.toString()`. No other methods of class `Arrays` may be used.
* **Only `System.out` calls:** you may use `System.out` to print to the console. No other methods from `System` are allowed. Only `System.out.println`, `System.out.printf`, and `System.out.print`. 

# Finals week policy

There is no final exam for the course. There will be a final assignemnt that will be published the week before finals and will be due the week of finals. Additionally, 8 students in the course will be [invited randomly](https://github.com/lgreco/random-selection-final-oral) to a brief meeting with the instructor during the course's final exam slot. The final exam slot for this course is on Tuesday, August 5, 2025 from 9 to 11 AM. If you are selected for a brief meeting, we'll spend about 15 minutes during the final exam slot to review your work. This interview will cover coding practices based on your past assignments. It is meant as a checkpoint to ensure that you have internalized the work you submitted.

# Code

You'll work with classes `Node.java` and `DoubleLinkedList.java`. There are 6 tasks in this assignment.

## Complete `void add(Node node)` in `DoubleLinkedList`

This method takes a `Node` object and adds it to the end of the linked list. The method, as written, is incomplete. It only sets the newly added node's `next` pointer. Write code that takes care of the newly added notes `previous` pointer.

## Complete `void add(String value)` in `DoubleLinkedList`

The earlier method adds a `Node` to the list. This method adds a node to the list after it creates a new one based a given `value`.

## Report the number of nodes in a `DoubleLinkedList`
Modify the class `DoubleLinkedList` so that it can report the number of nodes present in the list. The reporting should be done with method
```java
public int size() {}
```

## Complete `int compareTo(DoubleLinkedList other)` in `DoubleLinkedList`

Imagine two `DoubleLinkedList` objects, say `A` and `B`. How would you like to compare them? Rewrite method `compareTo` so that
```java
A.compareTo(B)
```
will return a negative integer number is `A` is smaller than `B`, a positive integer number if `A` is greater than `B`, and zero when `A` and `B` are the similar. You are free to define what a smaller/greater/similar list is. For consistency, if `A.compareTo(B)` is negative then `B.compareTo(A)` must be positive. *Ideally,* we want
$$
\texttt{A.compareTo(B)} = -\ \texttt{B.compareTo(A)}
$$
This identity applies even when `A` and `B` are similar because we can always claim that $0=-\ 0$.

## Write an `indexOf` method in `DoubleLinkedList``
The method's header should be 
```java
public int indexOf(String value) {}
```
and should return the position of the node in the list with the given value, starting with 0 for the `head` node. If no node in the list has the given value, the method should return `-1`. 

## Write a `contains` method in `DoubleLinkedList`
The method's header should be 
```java
public boolean contains(String value) {}
```
and should return `true` if the list contains a node with the given string and `false` otherwise.

# Study

The [Comparable interface](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Comparable.html) on Java.

From the BJP textbook Chapters 16.1, 16.2, and 16.3; or [Ch. 5 from Collins’ book](https://learning.oreilly.com/library/view/data-structures-and/9780470482674/14-chapter07.html). In addition, you should be up to speed with the following.

* Chapter 18.2 from the BJP textbook (or at the very least Leo’s notes titled “What’s Realistic”)
* Chapter 8 from the BJP textbook (or at the very least Java’s tutorial on Classes and Objects)
* Chapter 9 from the BJP textbook (or at the very least Java's tutorial on interfaces and inheritance)

# Reflect

Compare your code from the previous assignment with Leo's posted solutions: ([solutions_TrainLine](https://github.com/lgreco/comp-271-su25-week03/blob/main/solution_TrainLine.java); and for testing purposes: [solutions_TrainLine_Implementation](https://github.com/lgreco/comp-271-su25-week03/blob/main/solution_TrainLine_Implementation.java)). 

Then write a brief reflection (100-300 words) discussing what you got right, what you got close but not quite, and where you may have missed the mark. Also discuss what you learned by comparing your code to the posted solutions. The reflection must be substantive. For example, you may find that you missed something in the assignment because you did not put enough time in it or because you did not start work early. It's fine to acknowledge these issues. It is also important to propose a plan to avoid them in the future. And, in later reflections, evaluate how that plan worked.

In the assignment for WEEK 03 you were given class `TrainLine` and asked to improve it in several ways.

* **Modify the class for faster station additions.** Originally, method `TrainLine.add` was written to traverse the length of the line in order to find its last station; then add the new station after the last station. There is a faster way to add a station. We demonstrated, in class, how a train line traversal can be replaced by a single variable, when we realized that we do not need to count the train stations every time we need to find how many of them are in a line. Instead we created a new class variable (`numberOfStations`) and we kept it current every time we added a station. Similarly, the while-loop in `TrainLine.add` can be avoided if we introduce an second `Station` field in `TrainLine`. In the solutions, the new field is called `last` and is meant as a pointer to the last station of the line. With this new field in place, the `add` method does not need a while-loop any more. A new station can he added directly after the last station,<br/>
`this.last.setNext(newStation);`<br/>
and then the last station pointer updated:<br/>
`this.last = newStation;`

* **Write an `int indexOf` method.** This requires a traversal (iteration) of the line until the target station is found or until we reach the end of the line without finding the target station. The method may be a bit challenging because it **must be written with a single `return` statement.** If your code for this method has more than one return statement, the assignment is incomplete. In this case, you must make an appointment to speak with Leo, as soon as possible.

* **Write a `boolean contains` method.** This is an exercise in coding efficiency. The contains method can be writen with a while-loop traversing the line until the station is found or not found... sounds familiar? That's what the `indexOf` method already does. And if a station is present in the line, its `indexOf` value will be $>-1$. And so, the `contains` method requires only a call to `indexOf`!

* **Does your code compile** with class `TrainLine_Implemnetation`? If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.

* **Did your code pass the tests** in `TrainLine_Implementation`? If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.

* If your code is incomplete for any of the reasons above, please reflect on the cause. Did you start late? Did you hit a roadblock but did not ask for help? Did you not read the Programmer's Pact? Something else?


Your reflection should be submitted together with the current homework assignment due 6/25. Write your reflection as a *markdown* file called `reflection.md` in the current assignment's repository. **MarkDown** is a fairly simple markup (I know!) language that's worth learning. You can use a [simple cheat sheet](https://www.markdownguide.org/basic-syntax/) for MarkDown (.md) files or you can look at the course code of any `.md` file I share with you such as this one here. You can open any `.md` file on your CodeSpaces editor to see how it's written. 

If MarkDown is not your cup of tea that's ok too. Write your reflection in an email and send it to me with the header "reflection" in the subject line. But if you see yourself as a programmer/computer scientist down the road, it's worth the time to learn to write in MarkDown.
