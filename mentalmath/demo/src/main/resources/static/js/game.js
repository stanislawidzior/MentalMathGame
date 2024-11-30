document.addEventListener('DOMContentLoaded', function () {
    const startButton = document.getElementById('start-game');
    startButton.addEventListener('click', function () {
        console.log(Array.from(document.getElementsByName("diff")));
        choice = document.getElementsByClassName("diff")
        let selectedValue = "hard"
        for (let i = 0; i < choice.length; i++) {
            if (choice.item(i).checked) {
                selectedValue = choice.item(i).value;
            }
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