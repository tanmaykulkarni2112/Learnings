# Understanding Promises in JavaScript: An Analogy

## Analogy

### Promises as a "Security Guard":
In this analogy, the **promise** acts like a **security guard**. A promise is a contract that guarantees a value will be available in the future, but it’s not available immediately. It's like a guard telling you, "I’ll let you pass once the parcel (value) arrives," but until that happens, you can't move forward.

### Async/Await as "Fetching the Parcel":
**Async/await** comes into play when you're ready to **fetch the parcel** (the asynchronous operation). It’s like saying, "I’ll wait right here while the guard checks if the parcel is ready." You're not moving forward until the promise resolves (or rejects), much like waiting for the guard to approve the parcel.

### The "Guard Resolving the Parcel Allowance":
The promise (guard) must resolve (or reject) before the parcel can be handed over. If everything goes well, the promise **resolves** with the parcel (value); if something goes wrong, it **rejects** with an error (parcel lost, unavailable, etc.).

## Code Example: Promise with Async/Await

Here’s how you can combine promises and `async/await` to simulate the process of a promise being resolved or rejected, with the parcel data `{ item: 'pen' }`.

```javascript
// Creating a promise that resolves or rejects based on the parcel's availability
let promise = new Promise((resolve, reject) => {
    const parcel = { item: 'pen' };
    
    // Simulate whether the parcel is ready or not
    let isParcelReady = true;  // Set to false to simulate rejection
    
    if (isParcelReady) {
        resolve(parcel);  // Resolve the promise with the parcel if ready
    } else {
        reject("Parcel is not ready");  // Reject the promise if not ready
    }
});

// Using async/await to fetch the parcel
async function fetchParcel() {
    try {
        const result = await promise;  // Wait for the promise to resolve
        console.log("Parcel received:", result);  // If resolved, log the parcel
    } catch (error) {
        console.log("Error:", error);  // If rejected, log the error
    }
}

fetchParcel();
```
## Promises using function.
```javascript
// Function that returns a new promise
function fetchParcel(isParcelReady) {
    return new Promise((resolve, reject) => {
        const parcel = { item: 'pen' };

        if (isParcelReady) {
            resolve(parcel);  // Resolve with parcel if it's ready
        } else {
            reject("Parcel is not ready");  // Reject if not ready
        }
    });
}

// Using async/await to fetch the parcel
async function getParcel() {
    try {
        const result = await fetchParcel(true);  // Passing `true` to resolve
        console.log("Parcel received:", result);
    } catch (error) {
        console.log("Error:", error);
    }
}

getParcel();

```

## More relatable exmaple 
```javascript
// Function that returns a promise simulating an API call
function fetchDataFromAPI(url) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (url === 'valid-url') {
                resolve({ data: 'Some data from the API' });
            } else {
                reject('Invalid URL');
            }
        }, 1000); // Simulating a 1-second delay
    });
}

// Using async/await to handle the returned promise
async function getAPIData() {
    try {
        const data = await fetchDataFromAPI('valid-url');  // This will resolve
        console.log('Data from API:', data);
    } catch (error) {
        console.log('Error:', error);
    }
}

getAPIData();  // Simulate fetching data from a valid URL

```

Promise -> Allowance of using data
async/ await functiom -> Fetching data allowed by Promise
