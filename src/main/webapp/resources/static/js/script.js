// ------------------------------------------------ Display Time to message -------------------------------------------------------------------------------------------------------

function timeclock() {
    var dt = new Date();
    var min = dt.getMinutes();
    var minute = (min < 10) ? ('0' + min) : min;
    var times = dt.getHours() + ":" + minute;
    var H = +times.substr(0, 2);

    var h = H % 12 || 12;
    var ampm = (H < 12 || H === 24) ? " AM" : " PM";
    //var time = h +":"+minute;
    var time = h + times.substr(2, 4) + ampm;
    return time;
}

var password_data = "";
var bot_previous_response = "";
window.path = "resources/static"
    //window.path = "resources/static"

// ------------------------------------------------on input/text enter---------------------------------------------------------------------------------------------------------------

$('.usrInput').on('keyup keypress', function(e) {
    var keyCode = e.keyCode || e.which;
    var text = $(".usrInput").val();

    console.log("data from user " + text)
    if (keyCode === 13) {

        if (text == "" || $.trim(text) == '') {
            e.preventDefault();
            return false;
        } else if (text.toLowerCase() == "clear") {
            document.getElementById("chats").innerHTML = "";

            $(".usrInput").val('');
            // send('Hi');
            e.preventDefault();
            return false;
        } else {
            //$(".usrInput").blur(); To keep cursor un-focus

            setUserResponse(text);
            send(text);
            password_data = text;
            e.preventDefault();
            return false;
        }
    }
});

//----------------------------------------------------------------------------------------Set user response-----------------------------------------------------------------------------
function setUserResponse(val) {

    console.log("previous rasa core message " + bot_previous_response)

    if (bot_previous_response.includes("password")) {
        time = timeclock();
        console.log("pass " + val)
        stars = "";
        for (i = 0; i < val.length; i++) {
            stars = stars + '&lowast;'
            console.log("value of i" + i);
        }
        console.log(stars);
        var UserResponse = '<p class="userMsg">' + stars + '</p><div class="clearfix"></div><time1>' + time + '</time1><div class="clearfix"></div>';
        $(UserResponse).appendTo('.chats').show('slow');
        $(".usrInput").val('');
        scrollToBottomOfResults();
        $('.menu').remove();
    } else {
        time = timeclock();

        var UserResponse = '<p class="userMsg">' + val + '</p><div class="clearfix"></div><time1>' + time + '</time1><div class="clearfix"></div>';
        $(UserResponse).appendTo('.chats').show('slow');
        $(".usrInput").val('');
        scrollToBottomOfResults();
        $('.menu').remove();
    }
}

//---------------------------------- Scroll to the bottom of the chats-------------------------------
function scrollToBottomOfResults() {
    var terminalResultsDiv = document.getElementById('chats');
    terminalResultsDiv.scrollTop = terminalResultsDiv.scrollHeight;
}


function send(message) {
    window.previous_user_msg = message;
    console.log("User Message:", message)
    var username = window.localStorage.getItem("username");
    console.log("username is " + username);


    if (document.getElementsByClassName("tb")) {
        var tb1 = document.getElementsByClassName("tb");
        $(tb1).remove();
    }

    // Rasa core url's: 
    URL = "https://oda.omfysgroup.com:8443/webhooks/rest/webhook";

   

    $.ajax({
        url: URL,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            "message": message,
            "sender": username
        }),
        beforeSend: function() {
            if (window.previous_user_msg == "/restart") {
                console.log("Inside beforeSend ajax request on /restart msg");

            } else {

                var spinn = spin();
                var BotResponse = '<img class="botAvatar" src="' + window.path + '/img/userAvatar.jpg"><spinb>' + spinn + '</spinb><div class="clearfix"></div>';
                $(BotResponse).appendTo('.chats').show();
                scrollToBottomOfResults();

            }
        },
        success: function(data, textStatus) {
            if (window.previous_user_msg == "Hi") {
                console.log("Inside if statement for popup msg of success");

            }





            console.log(data);
            //document.getElementsByClassName('spinner').innerHTML = "";
            setBotResponse(data);
            $('spinb').remove();
            console.log("Rasa Response: ", data, "\n Status:", textStatus)
            if (Object.keys(data).length > 1) {
                for (i = 0; i < Object.keys(data).length; i++) {

                    setBotResponse(data[i]);
                    console.log("Rasa Response: ", data[i], "\n Status:", textStatus)
                    $('strong').remove();
                }

            } else {
                setBotResponse(data[0]);
                console.log("Rasa Response: ", data[0], "\n Status:", textStatus)
                $('strong').remove();
            }

        },
        error: function(errorMessage) {
            if (window.previous_user_msg == "Hi") {
                console.log("Inside if statement for popup msg");
                // window.popmsg = "Hey! I am BSAT Digital Assitant. Please click here so that I can assist you."

            }


            $('spinb').remove();
            setBotResponse("");
            console.log('Error' + errorMessage);
        }
    });
}
//--------------------------------------------------------------------------------------- Set bot response -------------------------------------------------------------------------------------------
function setBotResponse(val) {
    setTimeout(function() {

        if (val.length < 1) {

            if (window.previous_user_msg == "/restart") {
                console.log("Inside if statement for /restart msg");
                send('Hi');

            } else {

                time = timeclock();
                // if there is no response from Rasa
                msg = 'I couldn\'t get that. Let\' try something else!';

                //  msg = 'I couldn\'t get that. Let\' try something else!'
                //  +'I couldnt get that. Let try something else!;


                var BotResponse = '<p class="botMsg">' + msg + '</p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>';
                $(BotResponse).appendTo('.chats').hide().fadeIn(1000);


                bot_previous_response = msg;
                if (bot_previous_response.includes("password")) {
                    text
                    $(".usrInput").attr('type', 'password');
                } else {

                    $(".usrInput").attr('type', 'text');
                }

                scrollToBottomOfResults();

            }
        } else {


            //if we get response from Rasa
            // for (i = 0; i < val.length; i++) {
            //check if there is text message
            if (val.hasOwnProperty("text")) {
                time = timeclock();

                var BotResponse = '<p class="botMsg">' + val.text + '</p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>';
                $(BotResponse).appendTo('.chats').hide().fadeIn(1000);
                bot_previous_response = val.text;
                if (bot_previous_response.includes("password")) {
                    $(".usrInput").attr('type', 'password');
                } else {

                    $(".usrInput").attr('type', 'text');
                }

            }
            //check if there is image
            if (val.hasOwnProperty("image")) {
                time = timeclock();
                var BotResponse = '<div class="singleCard">' +
                    '<img class="imgcard" src="' + val.image + '">' +
                    '</div><div class="clearfix"><time2>' + time + '</time2><div class="clearfix"></div>'
                $(BotResponse).appendTo('.chats').hide().fadeIn(1000);
            }

            //check if there is  button message
            if (val.hasOwnProperty("buttons")) {
                addSuggestion(val.buttons);
                $('.menu').remove();
            }

            if (val.hasOwnProperty("custom")) {
                console.log("Inside custom");
                data = JSON.parse(JSON.stringify(val));
                data1 = data.custom;
                console.log(data1[0].type);
                // if (JSON.parse(JSON.stringify(val)).custom.type == "table") {
                if (data1[0].type == "table") {
                    console.log("Checked for table");
                    window.row_count = val.length;
                    var title = JSON.parse(JSON.stringify(val)).custom.title;
                    var table_row_head = JSON.parse(JSON.stringify(val)).custom.table_row_head;
                    var row_data = JSON.parse(JSON.stringify(val)).custom.row_data;
                    window.row_data = row_data;
                    addTable(title, table_row_head, row_data);
                } else
                if (JSON.parse(JSON.stringify(val)).custom.type == "Hyperlink") {
                    console.log("Checked for hyperlink");
                    var links = JSON.parse(JSON.stringify(val)).custom.links;
                    var title = JSON.parse(JSON.stringify(val)).custom.title;
                    var level = JSON.parse(JSON.stringify(val)).custom.level;
                    window.level = level;
                    window.links = links;
                    addLinks(links, title, level);
                } else
                if (data1[0].type == "List") {
                    console.log("Checked for List");


                    var links = JSON.parse(JSON.stringify(val)).custom.links;
                    var title = JSON.parse(JSON.stringify(val)).custom.title;
                    window.level = level;
                    window.links = links;
                    addLists(title);
                } else if (data1[0].type == "Form") {
                    console.log("Checked forForm");
                    addForm(title);

                } else if (data1[0].type == "Graph") {
                    console.log("Checked for Graph");
                    addGraph();

                }
            }
        }
        scrollToBottomOfResults();
    }, 500);
}

//--------------------------------------------------------------------------------List-----------------------------------------------------------------------------------------------------------------------
function addLists(title) {
    window.more_l = new Array()
    window.link_href = new Array()

    listLength = Math.floor(data1.length / 15) + 1;
    console.log("data1.length / 15", data1.length / 15)
    console.log("listlength", listLength)

    var BotResponse = '<p class="botMsg">' + data1[0].title + '<div class="clearfix"></div><ol class="ordered_list"></ol></p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>'
    $(BotResponse).appendTo('.chats').hide().fadeIn(1000);

    displaylistNumber(1)


}

function displaylistNumber(usrClick) {


    $('.ordered_list').empty();
    console.log(typeof(usrClick))

    if (usrClick == 1) {
        if (data1.length < 15) {
            firstNode(1, data1.length);
        } else {
            firstNode(1, 15);
        }



    } else if (usrClick == listLength) {
        lastNode(Number(usrClick), data1.length);

    } else {

        middleNodes(Number(usrClick), Number(usrClick) * 15);
    }
}


function firstNode(usrClick, totalList) {
    next = usrClick + 1;

    if (data1.length <= 15) {
        $('<div class="currentRange">' + (1) + '&nbsp;to&nbsp;' + (totalList) + '&nbsp;out of&nbsp;' + data1.length + '</div>').appendTo('.ordered_list');
        scrollToBottomOfResults();
    } else {
        $('<div class="currentRange">' + (1) + '&nbsp;to&nbsp;' + (totalList) + '&nbsp;out of&nbsp;' + data1.length + '</div><div class="nextElement" onclick = displaylistNumber("' + (usrClick + 1) + '")> > <div>').appendTo('.ordered_list');
        scrollToBottomOfResults();

    }

    for (i = 0; i < totalList; i++) {

        scrollToBottomOfResults();

        $('<div class="parent_li" class="child_li"><List><a onclick = clickListElement("' + i + '")>' + data1[i].links[0].more_link + '</a></List></div><div class="clearfix"></div>').appendTo('.ordered_list');
        window.more_l[i] = data1[i].links[0].more_link;
        window.link_href[i] = data1[i].links[0].link_href;
        // window.btn1_text = data1[i].links[0].button[0].title;
        // window.btn2_text = data1[i].links[0].button[1].title;
        // window.btn1_payload = data1[i].links[0].button[0].payload;
        // window.btn2_payload = data1[i].links[0].button[1].payload;
        scrollToBottomOfResults();
    }
}

function middleNodes(usrClick, totalList) {


    end = totalList

    initial = (Math.floor(end / 15) * 15) - 15;
    next = usrClick + 1;

    previous = usrClick - 1;

    $('<div class="currentRange">' + (initial + 1) + '&nbsp;to&nbsp;' + totalList + '&nbsp;out of&nbsp;' + data1.length + '</div><div class="previousElement" onclick=displaylistNumber("' + previous + '")><</div><div class="nextElement" onclick = displaylistNumber("' + next + '")>></div>').appendTo('.ordered_list');
    scrollToBottomOfResults();

    for (i = initial; i < totalList; i++) {

        scrollToBottomOfResults();

        $('<div class="parent_li" class="child_li"><List><a onclick = clickListElement("' + i + '")>' + data1[i].links[0].more_link + '</a></List></div><div class="clearfix"></div>').appendTo('.ordered_list');
        window.more_l[i] = data1[i].links[0].more_link;
        window.link_href[i] = data1[i].links[0].link_href;
        // window.btn1_text = data1[i].links[0].button[0].title;
        // window.btn2_text = data1[i].links[0].button[1].title;
        // window.btn1_payload = data1[i].links[0].button[0].payload;
        // window.btn2_payload = data1[i].links[0].button[1].payload;
        scrollToBottomOfResults();
    }
}

function lastNode(usrClick, totalList) {


    var previous = (usrClick - 1);

    var end = totalList;

    var before_initial = Number(end);


    var initial = Math.floor(before_initial / 15) * 15;


    $('<div class="currentRange">' + (initial + 1) + '&nbsp;to&nbsp;' + (totalList) + '&nbsp;out of&nbsp;' + data1.length + '</div><div class="previousElement" onclick=displaylistNumber("' + previous + '")><</div>').appendTo('.ordered_list');
    scrollToBottomOfResults();

    for (i = initial; i < totalList; i++) {

        scrollToBottomOfResults();

        $('<div class="parent_li" class="child_li"><List><a onclick = clickListElement("' + i + '")>' + data1[i].links[0].more_link + '</a></List></div><div class="clearfix"></div>').appendTo('.ordered_list');
        window.more_l[i] = data1[i].links[0].more_link;
        window.link_href[i] = data1[i].links[0].link_href;
        // window.btn1_text = data1[i].links[0].button[0].title;
        // window.btn2_text = data1[i].links[0].button[1].title;
        // window.btn1_payload = data1[i].links[0].button[0].payload;
        // window.btn2_payload = data1[i].links[0].button[1].payload;
        scrollToBottomOfResults();

    }
}







// if (data1.length > 0 && data1[0].type == 'List') {
//     console.log("inside if")
//     for (i = 0; i < data1.length; i++) {

//         scrollToBottomOfResults();

//         $('<div class="parent_li" class="child_li"><List><a onclick = clickListElement("' + i + '")>' + data1[i].links[0].more_link + '</a></List></div><div class="clearfix"></div>').appendTo('.ordered_list');
//         window.more_l[i] = data1[i].links[0].more_link;
//         window.link_href[i] = data1[i].links[0].link_href;
//         // window.btn1_text = data1[i].links[0].button[0].title;
//         // window.btn2_text = data1[i].links[0].button[1].title;
//         // window.btn1_payload = data1[i].links[0].button[0].payload;
//         // window.btn2_payload = data1[i].links[0].button[1].payload;
//         scrollToBottomOfResults();




//     }




// }
function clickListElement(LstEle) {
    ListElements = document.getElementsByTagName('List')
    console.log("Length of list is", ListElements.length)
    if (ListElements.length > 0 && window.link_href[LstEle]) {
        console.log(LstEle)
            // console.log(window.link_href[LstEle])
        send(window.link_href[LstEle])
        setUserResponse(window.link_href[LstEle])
        $('.ordered_list').remove();
        scrollToBottomOfResults();
    }
}
// ---------------------------------------------Links-------------------------------------------------------------------------------


function addLinks(links, title, level) {
    setTimeout(function() {
        var link_length = links.length;
        $('<p class="botMsg">' + title + '</p><div class="boxWithHyperLinks"><ul class="unordered_list"></ul></div>').appendTo('.chats').hide().fadeIn(1000);
        // Loop through links

        if (level == "first_level") {
            for (i = 0; i < Number(link_length); i++) {
                $('<li class="parent_li"><i class="fa fa-chevron-circle-right icon_logo"></i><a class="child_li" href="#">' + links[i].link_text + '</a></li>').appendTo('.unordered_list');
            }
        } else if (level == "second_level") {
            for (i = 0; i < Number(link_length); i++) {
                window.new_page_url = links[i].link_href;
                $('<li class="parent_li"><i class="fas fa-angle-right icon_logo"></i><a class="child_li" href="#">' + links[i].link_text + '</a></li>').appendTo('.unordered_list');
            }
        }

        scrollToBottomOfResults();
    }, 1000);
}

// on click event of link 
$(document).on("click", ".unordered_list .parent_li .child_li", function() {
    console.log("click on url");
    console.log("window.level " + window.level);
    var links = window.links;
    console.log("Length of link" + Number(links.length));

    if (window.level == 'second level') {
        //for(i = 0; i< Number(links.length); i++){
        //console.log("inside second_level if statement");
        var text = this.innerText;
        setUserResponse(text);
        //send(text);
        var BotResponse = '<img class="botAvatar" src="' + window.path + '/img/userAvatar.jpg"><div class="clearfix"></div><p class="botMsg">Visited</p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>';
        $(BotResponse).appendTo('.chats').hide().fadeIn(1000);
        scrollToBottomOfResults();
        //send(text);
        $('.unordered_list').remove();
        //}   
    } else {
        var text = this.innerText;
        setUserResponse(text);
        send(text);
        $('.unordered_list').remove();
    }
    scrollToBottomOfResults();
});


// ------------------------------------------ Toggle chatbot -----------------------------------------------
$('#profile_div').click(function() {
    $('.profile_div').toggle();
    $('.widget').toggle();

    scrollToBottomOfResults();
    document.getElementById("prompt").style.display = "None";
});
$('#close').click(function() {
    $('.profile_div').toggle();
    // $('.popup').show();
    $('.widget').toggle();
});



// ------------------------------------------ Suggestions -----------------------------------------------

function addSuggestion(textToAdd) {
    setTimeout(function() {
        var suggestions = textToAdd;
        var suggLength = textToAdd.length;
        $(' <div class="menu"></div>').appendTo('.chats').hide().fadeIn(1000);
        // Loop through suggestions
        window.btnObj = [];
        for (i = 0; i < suggLength; i++) {
            console.log('suggestions[i].title ' + suggestions[i].title);
            console.log('suggestions[i].payload ' + suggestions[i].payload);
            window.btnObj[i] = {
                'title': suggestions[i].title,
                'payload': suggestions[i].payload
            };
            $('<div class="menuChips"><div class = "scrollmenu"><div class = "btn-group"><button>' + suggestions[i].title + '</button></div></div></div>').appendTo('.menu');
            //$('<div class="menuChips">' + suggestions[i].payload + '</div>').appendTo('.menu');

        }
        scrollToBottomOfResults();
    }, 1000);
}


// on click of suggestions, get the value and send to rasa
$(document).on("click", ".menu .menuChips", function() {
    var len = window.btnObj.length;
    var text = "";
    var payload = "";
    for (i = 0; i < len; i++) {

        if (window.btnObj[i].title == this.innerText) {
            console.log('title ' + window.btnObj[i].title);
            console.log('payload ' + window.btnObj[i].payload);
            console.log('this.innerText ' + this.innerText);
            text = window.btnObj[i].title;
            payload = window.btnObj[i].payload;
        }

    }
    var text = this.innerText;
    setUserResponse(text);
    send(payload);
    $('.menu').remove(); //delete the suggestions 
});
//---------------------------------------------close button --------------------------------------------------------------------------

var d = document.getElementById("chats");
// d.insertAdjacentHTML("afterend", "<div id='prompt'>Do you wish to end the <br>conversation?<br><a id='Ybut' class='confirmbutton' onclick='CloseY();'>Yes</a><a id='Nbut' class='confirmbutton' onclick='CloseN();'>No</a></div>");
d.insertAdjacentHTML("afterend", "<div id='prompt'>Do you wish to end the <br>conversation?<br><a id='Nbut' class='confirmbutton' onclick='CloseN();'>No</a><a id='Ybut' class='confirmbutton' onclick='CloseY();'>Yes</a></div>");

function Close() {
    //document.getElementById("widget").style.opacity = 0.5;
    //document.getElementById("widget").style.pointerEvents = "None";
    $('#chats').css("opacity", "0.5");
    $('#chats').css("pointer-events", "None");
    $('.keypad').css("pointer-events", "None");
    document.getElementById("prompt").style.display = "inline-block ";
    document.getElementById("prompt").style.opacity = 1;
    document.getElementById("prompt").style.backgroundColor = "#fff";

    //$('.widget>').wrap('<div class="blur-all">').append("afterend","<div id='prompt' >Do you wish to end the conversation?<br><br><a id='Ybut' class='confirmbutton' href='javascript:window.parent.CloseY();'>Yes</a><a id='Nbut' class='confirmbutton' href='javascript:window.parent.CloseN();'>No</a></div>");"afterend","<div id='prompt'>Do you wish to end the conversation?<br><br><a id='Ybut' class='confirmbutton' href='javascript:window.parent.CloseY();'>Yes</a><a id='Nbut' class='confirmbutton' href='javascript:window.parent.CloseN();'>No</a></div>");

}

//addEventListener("keypress", function(event){
//  if (event.code == 'KeyY' && event.which == '13'){
// CloseY();

//}
//});
//addEventListener("keypress", function(event){
//  if (event.code == 'KeyN'){
// CloseN();

//}
//});


// If user select Yes on Pop-up dialogue
function CloseY() {
    $('#chats').css("opacity", "1");
    localStorage.removeItem("username");
    document.getElementById("chats").innerText = "";
    var n = Math.floor(Math.random() * 1000000000);
    window.localStorage.setItem("username", n);
    document.getElementById("prompt").style.display = "none";
    $('.profile_div').show();
    // $('.popup').show();
    $('.widget').hide();
    send('/restart');
    popmsg = "Ask BSAT Digital Assitant."
    popup(popmsg)

    // $('.widget').close();
    $('.keypad').css("pointer-events", "auto");
    $('#chats').css("pointer-events", "auto");

}

// If user select No on Pop-up dialogue
function CloseN() {
    document.getElementById("prompt").style.display = "none";
    //$('.widget>').unwarp('<div class="blur-all">');
    $('#chats').css("opacity", "1");
    $('.keypad').css("pointer-events", "auto");
    $('#chats').css("pointer-events", "auto");
}
//----------------------------------------------Three dot spinner----------------------------------------------------------------------------
function spin() {

    var spinner = '<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>';
    return spinner;
}

//-----------------------------------------enter-icon----------------------------------------------------------------------------------------
function enter() {
    console.log("inside enter")
    var text = $(".usrInput").val();
    if (text == "" || $.trim(text) == '') {
        return false
    } else if (text.toLowerCase() == "clear") {
        document.getElementById("chats").innerHTML = "";
        $(".usrInput").val('');
        // send('Hi');
        return false;
    } else {
        //$(".usrInput").blur(); To keep cursor un-focus

        setUserResponse(text);
        send(text);
        password_data = text;
        return false;
    }
}
///------------------------------------------------------------------------------------TABLE DISPLAY----------------------------------------------------------
function addTable(title, table_head, row_data) {



    var table_head_length = data1[0]["table_row_head"].length
    console.log("length of coloumn", table_head_length);
    var row_data_length = data1[0]["row_data"].length
    console.log("length of data", row_data_length);

    // var BotResponse = '<p class="botMsg">' + data1[0].title + '<div class="clearfix"></div><div class="tb"><table id="table_data"></table></div></p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>';
    // $(BotResponse).appendTo('.chats').hide().fadeIn(1000);
    // Find a <table> element with id="myTable":
    var table_data = document.getElementById("table_data");
    console.log(data1[0]["table_row_head"][0]["title"])
        // add table heading <th>
        // $("<div class='tb'><table id='table_data'></table></div>").appendTo(".chats");
        // $("<div class='tb'><table id='table_data'>").appendTo('.chats');
        // $("<tr>").appendTo('#table_data');
    var head = "";
    var row_data = "";
    var str = "";

    window.bad = new Array()


    for (i = 0; i < table_head_length; i++) {

        head += "<th>"
        head += data1[0]["table_row_head"][i]["title"];
        head += "</th>";

        // $("<th>" + data1[0]["table_row_head"][i]["title"] + "</th>").appendTo('#table_data');
    }
    $("</tr>").appendTo("#table_data");

    for (i = 0; i < data1.length; i++) {
        // $("<tr>").appendTo('#table_data');
        row_data += "<tr>";
        var cell_data = "";
        for (j = 0; j < row_data_length; j++) {
            // $("<td>" + data1[i]["row_data"][j]["title"] + "</td>").appendTo('#table_data');

            if (data1[i]["row_data"][j]["badge"]) {
                var str = data1[i]["row_data"][j]["title"];
                var res = str.split(" ").join("");
                id1 = res.replace(",", "");
                id2 = id1.replace(")", "");
                id3 = id2.replace(" ", "");


                window.bad[i] = data1[i]["row_data"][j]["badge"]
                cell_data += "<td><div id = '" + id3 + "'></div>";
                cell_data += "<div onmouseover = cellPopup('" + id3 + "','" + i + "'); onmouseout = removehtml('" + id3 + "') style='color:blue; text-decoration:underline;'>" + data1[i]["row_data"][j]["title"];
                cell_data += "<div></td>";

            } else {
                cell_data += "<td>";
                cell_data += data1[i]["row_data"][j]["title"];
                cell_data += "</td>";
            }

        }
        row_data += cell_data;
        row_data += "</tr>";
        // $("</tr>").appendTo('#table_data');


    }
    title = data1[0].title
    var BotResponse = '<p class="botMsg">' + title + '<div class="clearfix"></div><div class="tb"><table id="table_data"><tr>' + head + '</tr><tr>' + row_data + '</tr></table></div></p><div class="clearfix"></div><time2>' + time + '</time2><div class="clearfix"></div>';
    $(BotResponse).appendTo('.chats').hide().fadeIn(1000);

    scrollToBottomOfResults();

}
//--------------------------------------------------------------pop up message-------------------------------------------------------------------------------------------------------------
function popup(val) {
    var popup = document.getElementById('profile_div')
    popup.insertAdjacentHTML("beforeend", '');
    popup.insertAdjacentHTML("beforeend", '<div class = "popup"><span class="popuptext" id = "myPopup">' + val + '</span></div>');

    console.log(val)
        //    var popup = document.getElementById('profile_div')
        //
}

//----------------------------------------------------------------------------Table_cell_pop--------------------------------------------------------------
function cellPopup(i, num) {

    id1 = i
    console.log(id1)
    var cellPopuptext = document.getElementById(id1);

    console.log(cellPopuptext.innerHTML)



    if (cellPopuptext.innerHTML) {
        cellPopuptext.innerHTML = "";
    } else {

        console.log("inside else")
        cellPopuptext.innerHTML = "<div class='cellpopup'><div class='cellpopuptext' id ='cellPopup'>" + window.bad[num] + "</div></div>";




        // cellPopuptext.insertAdjacentHTML("<div class='cellpopup'><div class='cellpopuptext' id ='cellPopup'>" + window.bad[i] + "</div></div>");

        addEventListener('mouseout', function() {
            console.log("removed")
            cellPopuptext.innerHTML = "";

        });


        console.log(i)

    }
}

// function removehtml(id1) {
//     var cellPopuptext = document.getElementById(id1);
//     console.log("removed")
//     cellPopuptext.innerHTML = "";

// }
//------------------------------------------------add form---------------------------------------------
function addForm() {
    console.log("Inside form printing")
    window.bot_previous_response = data1[0].title
    console.log(data1.length)
    console.log(data1[0].fields)
    console.log(data1[0].fields.length)

    var form_created = "";
    form_created += '<form id = "chat-bot-productsalesform">';
    for (i = 0; i < data1[0].fields.length; i++) {
        if (data1[0].fields[i].type == 'tel') {
            form_created += '<label id= "chat-bot-lb1" class="chat-bot-compulsary"><b>' + data1[0].fields[i].field + '</b></label><input type="' + data1[0].fields[i].type + '" class= "infield" id="chat-bot-' + data1[0].fields[i].field + '" name="' + data1[0].fields[i].name + '" placeholder="' + data1[0].fields[i].placeholder + '" pattern="' + data1[0].fields[i].pattern + '" autocomplete = "off" required /><br>';
        } else {
            form_created += '<label id= "chat-bot-lb1" class="chat-bot-compulsary"><b>' + data1[0].fields[i].field + '</b></label><input type="' + data1[0].fields[i].type + '" class= "infield" id="chat-bot-' + data1[0].fields[i].field + '" name="' + data1[0].fields[i].name + '" placeholder="' + data1[0].fields[i].placeholder + '" autocomplete = "off" required /><br>';
        }
    }
    console.log(form_created)

    var BotResponse = '<p class="botMsg">' + data1[0].title + '<div class="clearfix"></div><div id=full_form><form id = "chat-bot-productsalesform">' + form_created + '<button id="chat-bot-pfsubmit" onclick="Details()">Proceed</button></form></p></div><div class="clearfix"></div><time2> ' + time + ' </time2><div class="clearfix"></div>';
    $(BotResponse).appendTo('.chats').hide().fadeIn(1000);
}

function Details() {
    msg = ""
    console.log("Form Function called");
    for (i = 0; i < data1[0].fields.length; i++) {
        fld = "chat-bot-" + data1[0].fields[i].field;
        msg += document.getElementById(fld).value + "|";
    }
    send(msg)
    console.log("Data from Form" + msg)
    $('#full_form').remove();
    $('#myCarousel').remove();
}
// -----------------------------budget-analysis-graph-----------------------------------------
function addGraph() {

    console.log("Inside graph printing")
    window.bot_previous_response = data1[0].title
    console.log(data1.length)
    console.log(data1[0].fields)
    console.log(data1[0].fields.length)


    var budgetgraph = `<!--  sale analytics start -->
        <div class="col-xl-9 col-md-12">
             <div class="card">
                 <div class="card-header">
                     <p id="card_title">Sales Analytics</p>
                   <!--   <span class="text-muted">For more details about usage, please refer <a href="https://www.amcharts.com/online-store/" target="_blank">amCharts</a> licences.</span> -->
                     <div class="card-header-right">
                         <ul class="list-unstyled card-option">
                             <li><i class="feather icon-maximize full-card"></i></li>
                             <li><i class="feather icon-minus minimize-card"></i></li>
                             <li><i class="feather icon-trash-2 close-card"></i></li>
                         </ul>
                     </div>
                 </div>
                 <div class="card-block">
                 <div id="chartContainer" style="height: 400px; max-width: 920px; margin: 0px auto;"></div>
                    <!--  <div id="sales-analytics" style="height: 265px;"></div> -->
                 </div>
             </div>
         </div>
          <!--  sale analytics end -->`;


    var BotResponse = '<p class="botMsg">' + data1[0].title + '</p><div class="clearfix"></div><div id ="graph">' + budgetgraph + '</div><time2>' + time + '</time2><div class="clearfix"></div>';
    $(BotResponse).appendTo('.chats').hide().fadeIn(1000);



    var dataPoints1 = [],
        dataPoints2 = [];
    var stockChart = new CanvasJS.StockChart("chartContainer", {
        theme: "light2",
        animationEnabled: true,
        title: {
            text: ""
        },
        subtitles: [{
            text: "Budget vs Actual Sales"
        }],
        charts: [{
            axisY: {
                title: "Sales value in Rs."
            },
            toolTip: {
                shared: true
            },
            legend: {
                cursor: "pointer",
                itemclick: function(e) {
                    if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible)
                        e.dataSeries.visible = false;
                    else
                        e.dataSeries.visible = true;
                    e.chart.render();
                }
            },
            data: [{
                showInLegend: true,
                name: "Budget Sales in Rs",
                yValueFormatString: "#,##0",
                xValueType: "dateTime",
                dataPoints: dataPoints1
            }, {
                showInLegend: true,
                name: "Actual Sales in Rs",
                yValueFormatString: "#,##0",
                dataPoints: dataPoints2
            }]
        }],
        rangeSelector: {
            enabled: false
        },
        navigator: {
            data: [{
                dataPoints: dataPoints1
            }],
            slider: {
                minimum: new Date(2018, 00, 15),
                maximum: new Date(2018, 02, 01)
            }
        }
    });
    /*  $.getJSON("https://canvasjs.com/data/docs/btcvolume2018.json", function(data) {
       for(var i = 0; i < data.length; i++){
         dataPoints1.push({x: new Date(data[i].date), y: Number(data[i].volume_btc_usd)});
         dataPoints2.push({x: new Date(data[i].date), y: Number(data[i].volume_btc_eur)});
       }
       stockChart.render();
     }); */
    // $.get('${pageContext.request.contextPath}/getSalesData', {}, function(data) {
    for (var i = 0; i < data1[0].fields.length; i++) {

        console.log(data1[0].fields[i].s_date)
        dataPoints1.push({ x: new Date(data1[0].fields[i].s_date), y: Number(data1[0].fields[i].budget_value) });
        dataPoints2.push({ x: new Date(data1[0].fields[i].s_date), y: Number(data1[0].fields[i].actual_value) });
    }
    stockChart.render();

    //});
}