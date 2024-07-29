const express = require("express")
const App = express();
App.use(express.json());
const  {createTodo, updateTodo} =require("./types");
const {todo} = require("./db")

App.post("/todo", async (req,res) => {
    const createPayload =  req.body;
    const parsePayload = createTodo.safeParse(createPayload);
    if(!parsePayload.success) {
        res.status(411).json({
            msg : "You sent the wrong inputs",
        })
        return;
    }
    //put it in mongodb
    await todo.create({
        title: createPayload.title ,
        description : createPayload.description,
        completed: false
    })
    res.json({
        msg : "To-Do created"
    })
})

App.get("/todos", async (res) => {
    // we want to send all of the saved dota
    const todos = await todo.find({});
    res.json({
        todos
    })
})

App.get("/completed", async (req, res) => {
    const updatePayload = req.body;
    const parsePayload = updateTodo.safeParse(updatePayload);
    if(! parsePayload.success) {
        res.status(411).json({
            msg : "You have sent the wrong inputs"
        })
        return;
    }
    // put it in the mongodb
    await todo.update({
        _id : req.body.id
    },
{
    completed : true
})
 res.json({
    msg: "The To-Do is Completed" 
})

})

App.listen(3000);