db.createUser(
   {
     user: "homework",
     pwd: "123456",
     roles:
       [
         { role: "readWrite", db: "file" }
       ]
   }
);

db = connect("data");
db.createUser(
   {
     user: "homework",
     pwd: "123456",
     roles:
       [
         { role: "readWrite", db: "data" }
       ]
   }
);