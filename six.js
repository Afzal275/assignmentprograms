var input=[];
function array_push(n)
{
    var n=parseInt(document.getElementById("number1").value);
    if (n<=0)
    alert("no negative or zeroes");
    else
    {
        input.push(n);
    }
    document.getElementById("number1").value="";

}
function pairs()
{
    var i;
    var n=parseInt(document.getElementById("number").value);
    for(i=0;i<input.length;i++)
    {
        for(var j=i+1;j<input.length;j++)
        {
            if(input[i]+input[j]==n)
            document.getElementById("answer").innerHTML +="\""+input[i]+"\""+","+"\""+input[j]+"\""<1
        }
    }
}
