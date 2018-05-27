function factr()
{
    var numb= document.getElementById("number").value;
    var x=parseInt(numb);
    document.getElementById("answer").innerHTML=factor(x);
}
function factor(x)
{
    if((x==0)||(x==1))
    return 1;
    else
    return x*factor(x-1);
}