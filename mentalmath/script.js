console.log('Hello World');
function printQuestion(){
var outputDiv = document.getElementById("question");
symbol = Math.floor(Math.random()* (3-0+1) )+ 0;
switch(symbol){
    case 0:
        symbol = "+";
        break;
        case 1:
        symbol = "-";
        break;
        case 2:
            symbol = "x";
            break;
            case 3:
                symbol = ":";
                break;
}
min = 2;
max = 999;
if(symbol === '+'){
    num1 = Math.floor(Math.random()* (max - min + 1) ) + min;
    lenn = num1.toString().length;
    var min = Math.pow(10, lenn- 1);
    num2 = Math.floor(Math.random()* (max-min + 1) ) + min;
    output = num1.toString() + symbol + num2.toString();
    console.log(output);
    outputDiv.innerHTML = output;
}
else if(symbol === '-'){
    num1 = Math.floor(Math.random()* (max - min + 1) ) + min;
    lenn = num1.toString().length;
    var min = Math.pow(10, lenn- 1);
    num2 = Math.floor(Math.random()* (max-min + 1) ) + min;
    output = num1.toString() + symbol + num2.toString();
    console.log(output);
    outputDiv.innerHTML = output;
}
else if(symbol === ':'){
    num1 = Math.floor(Math.random()* (max - min + 1) ) + min;
    num2 = Math.floor(Math.random()* (num1-min+ 1) ) + min;
    while(num1 % num2 !== 0){
        num2 = Math.floor(Math.random()* (num1-min+ 1) ) + min;
    }
    output = num1.toString() + symbol + num2.toString();
    console.log(output);
    outputDiv.innerHTML = output;
}
else if(symbol === 'x'){
    num1 = Math.floor(Math.random()* (max - min + 1) ) + min;
    num2 = Math.floor(Math.random()* (20-min + 1) ) + min;
    output = num1.toString() + symbol + num2.toString();
    console.log(output);
    outputDiv.innerHTML = output;
}
console.log(symbol);
}
function isNumeric(value) {
    return !isNaN(parseFloat(value)) && isFinite(value);
}
document.getElementById("ansinput").addEventListener("input", function(event) {
    var inputValue = event.target.value;
    if (event.inputType === "deleteContentBackward" || event.inputType === "deleteContentForward") {  
        
    }

    else if (!isNumeric(inputValue)) {

        inputValue = inputValue.slice(0, -1);
    }
    console.log(inputValue);
    if(inputValue == 99){
        event.target.value = "";
        inputValue = "";
    }

});
printQuestion();