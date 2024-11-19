# Prototypal Inheritance in JavaScript

In JavaScript, every object has an internal property called `[[Prototype]]`, which points to another object. This forms a prototype chain. Prototypal inheritance allows one object to inherit properties and methods from another. In this system, objects can share behavior through the prototype mechanism without using classes in the traditional sense (though ES6 introduced `class`, the underlying inheritance model is still prototypal).

In the example below, a `person` constructor function is used to create new objects. The method `greet` is added to `person.prototype`, meaning all instances of `person` will inherit this method.

## Code Example:

```javascript
function person(name) {
    this.name = name;  // Constructor sets the `name` property
}

// Adding a method to the prototype of person
person.prototype.greet = function() {
    console.log(`Hello, ${this.name}`);
};

// Creating a new instance of person
let obj = new person("Tanmay");

// Calling the inherited greet method
obj.greet();  // Output: Hello, Tanmay
