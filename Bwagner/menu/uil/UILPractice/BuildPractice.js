var currentQuestion = 1;
var previousQuestion = 0;
var problemStatus = [];
    // status 0 - not attempted
    // status 1 - correct
    // status 2 - incorrect

function buildPractice(dataFile)
{
        xmlDoc=loadXMLDoc(dataFile);
	problem=xmlDoc.getElementsByTagName("problem");
        
        document.write("<div id= practice_main>");
        
        buildHeader(problem.length);
        
        document.write("<div id= practice_columns>");
        document.write("<div id= practice_leftCol>");
        
        for(i = 0; i < problem.length; i++)
        {
            problemStatus[i] = 0;    // status is available;
        }
        
	
        question = problem[0].getElementsByTagName("question"); 
        code = problem[0].getElementsByTagName("code");
        a = problem[0].getElementsByTagName("a");
        b = problem[0].getElementsByTagName("b");
        c = problem[0].getElementsByTagName("c");
        d = problem[0].getElementsByTagName("d");
        e = problem[0].getElementsByTagName("e");
        answer = problem[0].getElementsByTagName("answer");

        document.write('<div id="question">'+question[0].childNodes[0].nodeValue+'</div>');

        
        document.write('<div id="a"><input type = "radio" id = "radio_a" name = "choices" value = "a"><label for="radio_a"><span><span></span></span>'+a[0].childNodes[0].nodeValue+'</label></div>');
        document.write('<div id="b"><input type = "radio" id = "radio_b" name = "choices" value = "b"><label for="radio_b"><span><span></span></span>'+b[0].childNodes[0].nodeValue+'</label></div>');
        document.write('<div id="c"><input type = "radio" id = "radio_c" name = "choices" value = "c"><label for="radio_c"><span><span></span></span>'+c[0].childNodes[0].nodeValue+'</label></div>');
        document.write('<div id="d"><input type = "radio" id = "radio_d" name = "choices" value = "d"><label for="radio_d"><span><span></span></span>'+d[0].childNodes[0].nodeValue+'</label></div>');
        document.write('<div id="e"><input type = "radio" id = "radio_e" name = "choices" value = "e"><label for="radio_e"><span><span></span></span>'+e[0].childNodes[0].nodeValue+'</label></div>');      
        
        document.write("</div>");   // left column
        document.write("<div id= practice_rightCol>");
        if(code[0].childNodes[0] != null)
           document.write('<div id="code">'+code[0].childNodes[0].nodeValue+'</div>');
        
        document.write("</div>");   // right column
        document.write("</div>");  // columns

}

function buildProblem(problemNum)
{
    question = problem[problemNum].getElementsByTagName("question"); 
    code = problem[problemNum].getElementsByTagName("code");
    a = problem[problemNum].getElementsByTagName("a");
    b = problem[problemNum].getElementsByTagName("b");
    c = problem[problemNum].getElementsByTagName("c");
    d = problem[problemNum].getElementsByTagName("d");
    e = problem[problemNum].getElementsByTagName("e");
    answer = problem[problemNum].getElementsByTagName("answer");
    
    document.getElementById("question").innerHTML=question[0].childNodes[0].nodeValue;
    if(code[0].childNodes[0] != null)
       document.getElementById("code").innerHTML=code[0].childNodes[0].nodeValue;
    
    document.getElementById("a").innerHTML='<input type = "radio" id = "radio_a" name = "choices" value = "a"><label for="radio_a"><span><span></span></span>'+a[0].childNodes[0].nodeValue+'</label>';
    document.getElementById("b").innerHTML='<input type = "radio" id = "radio_b" name = "choices" value = "b"><label for="radio_b"><span><span></span></span>'+b[0].childNodes[0].nodeValue+'</label>';
    document.getElementById("c").innerHTML='<input type = "radio" id = "radio_c" name = "choices" value = "c"><label for="radio_c"><span><span></span></span>'+c[0].childNodes[0].nodeValue+'</label>';
    document.getElementById("d").innerHTML='<input type = "radio" id = "radio_d" name = "choices" value = "d"><label for="radio_d"><span><span></span></span>'+d[0].childNodes[0].nodeValue+'</label>';
    document.getElementById("e").innerHTML='<input type = "radio" id = "radio_e" name = "choices" value = "e"><label for="radio_e"><span><span></span></span>'+e[0].childNodes[0].nodeValue+'</label>';

    var  ans = answer[0].childNodes[0].nodeValue;
    if(problemStatus[problemNum] === 1)
    {
        document.getElementById("radio_"+ans).nextSibling.firstChild.firstChild.style.background = "#00FF00";
        document.getElementById("radio_"+ans).checked = true;   
    }
    if(problemStatus[problemNum] === 2)
    {
        document.getElementById("radio_"+ans).nextSibling.firstChild.firstChild.style.background = "red";
        document.getElementById("radio_"+ans).checked = true;   
    }

}

function buildHeader(numButtons)
{
    document.write('<div id="header">');
    document.write('<button id="submitButton" onclick=processSubmit()>Submit</button>');
    for(i = 1; i <= numButtons; i++)
    {
        document.write('<button class="buttonList" onclick=processButton('+i+') id=button'+i+'>'+i+'</button>');
    }
    document.write('</div>');
    document.getElementById("button"+currentQuestion).style.background="yellow";
}

function processSubmit()
{
    if(problemStatus[currentQuestion-1] === 0)  // not attempted
    {
        var response = document.querySelector('input[name = "choices"]:checked').value;
        var  correct_answer = answer[0].childNodes[0].nodeValue;
        if(response === answer[0].childNodes[0].nodeValue)
        {
            document.getElementById("button"+currentQuestion).style.background="#00FF00";  // green
            problemStatus[currentQuestion - 1] = 1;  // status change to correct
            var  ans1 = answer[0].childNodes[0].nodeValue;

            document.getElementById("radio_"+correct_answer).nextSibling.firstChild.firstChild.style.background = "#00FF00";
            document.getElementById("radio_"+correct_answer).checked = true;   

        }
        else
        {
            document.getElementById("button"+currentQuestion).style.background="red";
            problemStatus[currentQuestion - 1] = 2;  // status change to incorrect

            document.getElementById("radio_"+correct_answer).nextSibling.firstChild.firstChild.style.background = "red";
            document.getElementById("radio_"+correct_answer).checked = true;   
    
        }
    }
    
    
}

function processButton(id)
{
    buildProblem(id-1);
    previousQuestion = currentQuestion;
    currentQuestion = id;
    
    if(problemStatus[previousQuestion-1] === 0)
    {
        document.getElementById("button"+previousQuestion).style.background="#EEEEEE";
    }
    if(problemStatus[previousQuestion-1] === 1)
    {
        document.getElementById("button"+previousQuestion).style.background="#00FF00";
    }
    if(problemStatus[previousQuestion-1] === 2)
    {
        document.getElementById("button"+previousQuestion).style.background="red";
    }
    
    if(problemStatus[currentQuestion-1] === 0)
    {
        document.getElementById("button"+currentQuestion).style.background="yellow";
    }
    if(problemStatus[currentQuestion-1] === 1)
    {
        document.getElementById("button"+currentQuestion).style.background="#00FF00";
    }
    if(problemStatus[currentQuestion-1] === 2)
    {
        document.getElementById("button"+currentQuestion).style.background="red";
    }
    
    
}

function loadXMLDoc(dname)
{ 
    if (window.XMLHttpRequest)
    {
	xhttp=new XMLHttpRequest();
    }
    else
    {
	xhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
	
    xhttp.open("GET",dname,false);
    xhttp.send();
	
    return xhttp.responseXML;
}


