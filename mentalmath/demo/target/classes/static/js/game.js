document.addEventListener('DOMContentLoaded', function () {
    const startButton = document.getElementById('start-game');
    startButton.addEventListener('click', function () {
        console.log(Array.from(document.getElementsByName("diff")));
        choice = document.getElementsByClassName("diff")
        console.log(Array.from(choice));
        console.log(choice.item(0))
        console.log(choice.item(0).value)
        console.log(choice.item(1))
        console.log(choice.item(1).value)
        console.log(choice.item(2))
        console.log(choice.item(2).value)

        console.log(choice.item(0).value)
        const socket = new WebSocket("ws://localhost:8080/play");
        const uponConnecting = {
            "type" : "getInfo",
            "join" : false
        }
        socket.onopen = (event) => {
            socket.send(JSON.stringify(uponConnecting));
        }
        socket.onmessage = (event) => {
            const msg = JSON.parse(event.data);
            console.log("hi " + msg["playerId"] + "in game " + msg["gameId"] );
            socket.close();
        }




    });
});