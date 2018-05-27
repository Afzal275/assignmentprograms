function third()
{
    var numb= document.getElementById("number").value;
    var x=parseInt(numb);
    document.getElementById("answer").innerHTML=mul(x);
}
function mul(x)
{
    var sum=0,i;
    for(i=0;i<x;i++)
    if(i%3==0 || i%5==0)
    sum=sum+i;
    return sum;
   
}