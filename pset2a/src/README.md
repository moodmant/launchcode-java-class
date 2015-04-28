#Problem Set 2a - Inheritance

Your task for this problem set is to update problem set 1 to incorporate an `Instructor` class. Before you get to that point, however, you will first construct a more generic `Person` class.

Both `Student` and `Instructor` should eventually inherit from the `Person` class (yes, instructors are people too!). To help you construct these classes, consider the following:

- What do students and instructors have in common?
- What makes students and instructors different?

The answers to these questions will help you determine where you should put your code. Remember - we want to reuse code as much as possible!

As usual, write some unit tests for these classes and make sure they pass before moving on.

#Extending Student

Students come in many forms, but for this exercise we will focus on two types: part-time and full-time students. The primary difference between these two types is how much tuition they have to pay. Full-time students pay by the semester, part-time students pay by the credit hour.

Create two classes that inherit from the `Student` class, and implement the desired behavior. For the part time student, use a tuition payment of $300 per credit.

Then, consider how this affects the `Student` base class. Should this class be changed as a result of adding the two sub-classes (hint: the answer is yes)? Consider why this makes sense from a design standpoint, and be prepared to explain your answer.

