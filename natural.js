function sum()
{
    var x= document.getElementById("number").value;
    var n=parseInt(x);
    document.getElementById("answer").innerHTML=sumo(n);
}
function sumo(n)
{
  var sum=0;
  var i;
  for(i=0;i<=n;i++)
{
    sum=sum+i;
}
return sum;
}