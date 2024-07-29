const z =  require("zod");
// OR const z = require("zod");

// for /todo path <- posting
const schema_Todo = z.object({
    title : z.string() ,
    description : z.string(),

});

// for /completed path which will use the ID to say the todo is completed
const schema_Completed = z.object({
    id : z.number(),
});

// we will use these export objects futher on
module.exports = {
    createTodo : schema_Todo,
    updateTodo : schema_Completed
}
