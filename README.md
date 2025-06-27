# COMP 271 SU25 WEEK 05

This assignment has **THREE** parts: a **midterm review part,** a coding part based on current material we discuss in class and a reflection part to evaluate work you have already submitted.


## MIDTERM REVIEW

*Ungrading* is an assessment technique that measures learning and professional development. Learning is assessed by how you learn from your mistakes. Professional development is assessed by your overall engagement with the course.

Looking at the first five assignments, discuss how you learned from any mistakes you made. Repeating mistakes is a sign that your learning needs to be improved. If you have repeated mistakes, discuss how you learning will be improved in the second half of the course. Typical mistakes for this discussion include:
* code that doesn't compile (even in one assignment);
* lack of comments;
* lack of Javadoc;
* Programmer Pact violations;
* Missed assignments (even when due to not committing/synchronizing your CodeSpaces);

Looking at your course engagement over the first six weeks, discuss how you've managed so far. The ideal standard is that you treat the course as a job that you like, that you wish to keep, and in which you aspire to grow and be promoted. Factors to consider include:
* Timeliness -- joining the class meeting on time
* Consistency -- not missing classes (except for university-justified absences)
* Participation -- asking questions, answering questions
* Proactiveness -- each out to the instructor with any difficulties you encounter, in a way that allows a timely resolution
* Initiative -- trying additiona problems from the book and discussing them with the instructor; learning something new, like writing your reflections in MarkDown.
* Commitment: studying/working on the course for ~3 hours per hour class-hour, i.e., 9 hours per week in addition to coming to class.

Your discussion for the above should be in the form of a well-written essay, 200-300 words. You may include it in your week05 assignemnt as `midterm_review.md`.


## Standing requirements

* **Programmers Pact:** Your work must be compliant with the [Programmers Pact](./ProgrammerPact.pdf). 
* **Comments:** Your code must be sufficiently documented with comments.
* **No imports:** You may not use the import statement in your code, with one exception: `import Arrays;` is allowed only for using `Arrays.toString()`. No other methods of class `Arrays` may be used.
* **Only `System.out` calls:** you may use `System.out` to print to the console. No other methods from `System` are allowed. Only `System.out.println`, `System.out.printf`, and `System.out.print`. 


## Finals week policy

There is no final exam for the course. There will be a final assignemnt that will be published the week before finals and will be due the week of finals. Additionally, 8 students in the course will be [invited randomly](https://github.com/lgreco/random-selection-final-oral) to a brief meeting with the instructor during the course's final exam slot. The final exam slot for this course is on Tuesday, August 5, 2025 from 9 to 11 AM. If you are selected for a brief meeting, we'll spend about 15 minutes during the final exam slot to review your work. This interview will cover coding practices based on your past assignments. It is meant as a checkpoint to ensure that you have internalized the work you submitted.

---

## Code

You'll work with classes `DynamicArray.java` and `DynamicArray_Implementation.java`. There are 6 tasks in this assignment.


### Complete method `int indexOf(String string)`
This method should return the index position of the given `string`, in the underlying array. If the `string` is not present, the method should return -1.


### Complete method `boolean contains(String string)`
The method should return `true` if the `string` is present in the underlying array and `false` otherwise.


### Complete method `int countOf(String string)`
The method should return the number of times the given `string` appears in the underlying array. If the `string` is not present, the method returns 0.


### Complete method `String remove(int index)`
The method removes and returns the contents at the `index` position of the underlying array. It's important to shift the elements after the removed string one position to the left.


### Complete method `String remove(String string)`
The method removes and returns the contents of the first element in the underlying array that contains the give `string`. If the `string` is not present, the method shall return `null`.


### Complete method `String toString()`
Be creative; try to avoid magic values as much as possible. Remember that Loyola is like Hogwarts: *help will always be given at Hogwarts to those who ask for it.*

---

## Study

From the BJP textbook Chapter 10; or [Ch. 6 from Collins’ book](https://learning.oreilly.com/library/view/data-structures-and/9780470482674/13-chapter06.html). In addition, you should be up to speed with the following.

* Chapter 3.1 (about method overloading) (alternatively Java's [tutorial on methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html))
* Chapter 18.2 from the BJP textbook (or at the very least Leo’s notes titled “What’s Realistic”)
* Chapter 8 from the BJP textbook (or at the very least Java’s tutorial on Classes and Objects)
* Chapter 9 from the BJP textbook (or at the very least Java's tutorial on interfaces and inheritance)

---

## Reflect

Compare your code from the previous assignment with [Leo's posted solutions](https://github.com/lgreco/lgreco-comp-271-su25-week04/blob/main/solution_DoubleLinkedList.java).

Then write a brief reflection (100-300 words) discussing what you got right, what you got close but not quite, and where you may have missed the mark. Also discuss what you learned by comparing your code to the posted solutions. The reflection must be substantive. For example, you may find that you missed something in the assignment because you did not put enough time in it or because you did not start work early. It's fine to acknowledge these issues. It is also important to propose a plan to avoid them in the future. And, in later reflections, evaluate how that plan worked.

In the assignment for WEEK 04 you were given class `DoubleLinkedList` and asked to improve it in several ways.


### TECHNICAL NOTES FOR UNGRADING


#### Complete `void add(Node node)` in `DoubleLinkedList` 

This required use of the newly introduced field attribute `tail`. Your `add` method should not have a while loop. Instead it should use the `tail` reference to extend the linked list. Initially, you may be tempted to write the solution as:
```java
public void add(Node node) {
    if (this.head == null) {
        this.head = node;
        this.tail = node;
    } else {
        this.tail.setNext(node);
        node.setPrevious(this.tail); 
        this.tail = node;
    }
    this.size++;
}
```
Upon review, you may also notice that the `tail` aassignment occurs on both branches of the if statement. Therefore, it can (and should) be factored out:
```java
public void add(Node node) {
    if (this.head == null) {
        this.head = node;
    } else {
        this.tail.setNext(node);
        node.setPrevious(this.tail); 
    }        
    this.tail = node;
    this.size++;
}
```
Because we are dealing with a **double** linked list, it is important to assign the `previous` pointer as well, as shown above.


#### Complete `void add(String value)` in `DoubleLinkedList`
If your code has more than one line, you probably got it wrong. The solution here is what is called a *wrapper function.* Such functions call existing functions to simplify a task, provide additional behavior, etc. In this case, we wrap the existing function `void add(Node node)` as follows:
```java
public void add(String string) {
    this.add(new Node(string));
}
```
A wrapper function delegates its work to another function. Here we create a new `Node` for the given `string` and then ask the existing `add` function to do its 
job.


#### Complete `int compareTo(DoubleLinkedList other)` in `DoubleLinkedList`
The obvious choice here is to
```java
return this.size - other.size;
```
If you came up with a different metric, I would love to hear from you. The more weird your metric is, the more curious I am about it.


#### Write an `indexOf` method in `DoubleLinkedList``
There are two potential errors here. First, the use of a second `return` statement that would violate the Programmer's Pact. Second, an *off-by-one error.* The idea is to write a loop that traverses the list and counts the steps. When the target node is found, the loop ends. The loop also ends when it reaches the end of the list without finding anything. But let's focus on the positive side: we found the target node. As the loop exits, the counter variable used it in, is incremented by 1. For example, if the target node is at position 4, the counter **may be** showing 5. This depends on where we evaluate the boolean expression that stops the loop. We have to take this into consideration and return `counter-1` to compensate for the error.


#### Write a `contains` method in `DoubleLinkedList`
This will be another wrapper function, returning a call to `indexOf`:
```java
return this.indexOf(value) != -1; // > -1 ok too
```

You may be tempted to write
```java
return this.indexOf(value) > 0;
```
This would be wrong as it exludes the first node of the list (whose position is at 0).


#### Report the number of nodes in a `DoubleLinkedList`
This is also a one-liner method that returns the current value of `this.size`.


#### Does your code compile? 
If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.


#### Did your code pass the tests?
If not, the assignment is incomplete. If your assignment is incomplete you must make an appointment to speak with Leo, as soon as possible.


#### Incomplete code

If your code is incomplete for any of the reasons above, please reflect on the cause. Did you start late? Did you hit a roadblock but did not ask for help? Did you not read the Programmer's Pact? Something else?


#### How to submit

Your reflection should be submitted together with the current homework assignment due 6/25. Write your reflection as a *markdown* file called `reflection.md` in the current assignment's repository. **MarkDown** is a fairly simple markup (I know!) language that's worth learning. You can use a [simple cheat sheet](https://www.markdownguide.org/basic-syntax/) for MarkDown (.md) files or you can look at the course code of any `.md` file I share with you such as this one here. You can open any `.md` file on your CodeSpaces editor to see how it's written. 

If MarkDown is not your cup of tea that's ok too. Write your reflection in an email and send it to me with the header "reflection" in the subject line. But if you see yourself as a programmer/computer scientist down the road, it's worth the time to learn to write in MarkDown.
