const mongoose = require('mongoose');
const Msg = require('./models/messages');
const stream = require('socket.io')(3000)
const mongoDB = 'mongodb+srv://Gator2020:Mcraft321@cluster0.niuuw.mongodb.net/message-database?retryWrites=true&w=majority';
mongoose.connect(mongoDB, { useNewUrlParser: true, useUnifiedTopology: true }).then(() => {
    console.log('connected')
}).catch(err => console.log(err))
stream.on('Connection succesful', (socket) => {
    Msg.find().then(result => {
        socket.emit('output-messages', result)
    })
    console.log('connected');
    socket.emit('message', 'Hello world');
    socket.on('disconnect', () => {
        console.log('user disconnected');
    });
    socket.on('Message appended', msg => {
        const message = new Msg({ msg });
        message.save().then(() => {
            stream.emit('message', msg)
        })


    })
});