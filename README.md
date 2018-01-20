# java-car
An object-oriented command line car with Java classes and interfaces. From [RevaturePro](https://app.revature.com).

# Assignment Prompt:
You've just received a crash course in Java. You may be completely new to this, or you may have only learned one or two new things. In any case, it's key that you cement your newfound knowledge with practice.

Now we're going to take some time to practice writing some simple Java programs. In doing so, you will become familiar with Eclipse and how to run your applications.

1. Create a Java project in eclipse, called "PracticeCar"
2. Create a class called "Simulator", with a main() method.
3. Create a "Car" class, with a run() method.
4. Inside the main() method of Simulator, create an instance of a Car object, and invoke that object's run() method.

Now, you will create additional classes that represent the different components of a car - the engine, the fuel tank, the wheels, etc. These classes should have methods related to their behaviors, and properties representing their various states (an engine is running or not, tires have levels of wear, etc).

1. Every class representing a car part should inherit from a superclass called "CarPart." The CarPart class will have at least the following states and behaviors:
 - condition - an integer that represents the remaining durability of the part (starts at 100, goes down to 0 when the part is broken)
 - status() - a method that prints the condition of the part to the console.
2. The CarPart class should also implement a Functional interface, which declares a method "function()".
3. Each subclass of CarPart should have at least one state unique to that part (like the number of cylinders in an engine, or the fuel level of a fuel tank). Each subclass should also implement the inherited function() method to print a unique message to the console that incorporates the variables unique to that class. The CarPart subclasses should not define unique methods, unless those methods are called from their overriden function() or status() methods.
4. Make sure that your Car class creates an instance of each CarPart subclass, as part of its constructor. These instances should be added to a collection of CarPart reference variables.
5. The run() method of your Car class should iterate through the Car's collection of CarPart references, which stores the instances of the CarPart subclasses. On each iteration, the function() method of the current object in the collection should be invoked.

Many of the design details for this task will be up to you - this is an exercise to help you get into the habit of thinking in an object-oriented way, so get creative! There are no additional requirements for the functionality of the program, save that it actually works when executed. When you are done, ZIP it and upload it.
