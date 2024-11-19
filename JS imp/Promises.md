# Promises in JavaScript

In JavaScript, **Promises** provide a way to handle asynchronous operations. A Promise represents a value that may not be available yet, but will be resolved at some point in the future. Promises have three states: **pending**, **fulfilled** (resolved), or **rejected**. When a promise is resolved, you can use `.then()` to handle the successful result and `.catch()` to handle any errors. Promises allow you to chain operations, and you can pass any value (number, object, etc.) through `resolve()` or `reject()`. However, when performing mathematical operations on the resolved value, you need to ensure it's a valid number or convert it if necessary.

For instance, if a promise resolves with a number, you can directly perform operations on it. If it resolves with a string or an object, you may need to convert or extract the value before performing the operations. Importantly, the result of the operations won't be displayed unless you explicitly **log** it using `console.log()` or return it for further handling in the promise chain.

## Example:

```javascript
function example() {
    return new Promise(function(success, reject) {
        let statusObtained = true;
        let result = { value: "15" };  // Resolving with an object containing a string

        if (statusObtained) {
            success(result);  // Resolving with the object
        } else {
            reject("Something went wrong");
        }
    });
}

example()
    .then((data) => {
        let number = Number(data.value);  // Convert string to number
        let result = number + 10;  // Perform mathematical operation
        console.log(result);  // Log the result (25)
    })
    .catch((error) => {
        console.log(error);  // Will log if the promise is rejected
    });
