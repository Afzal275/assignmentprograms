function fuzzbuzz(){
    var num=Number(document.getElementById("value").value);
    for (var i=1; i<=num; i++) {
        if (i%15===0) {
            echo("FizzBuzz");
            //document.getElementById("result").innerHTML = "FizzBuzz";
        } else if (i%3===0) {
         alert("Fizz");
            //document.getElementById("result").innerHTML = "Fizz";
        } else if (i%5===0) {
            alert("Buzz");
            //document.getElementById("result").innerHTML = "Buzz";
        } else {
            alert(i);
            //document.getElementById("result").innerHTML = i;
        }
    }
    
}