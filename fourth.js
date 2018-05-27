
function mul(x)
{
   
    
        var n = Number(document.getElementById("value").value);
        var i = 0;
        var nearestValue=0;
        while(Math.pow(2,i)<n){
            nearestValue=i;
            i++;
        }
    alert(nearestValue);
    }