
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!-- Coding by CodingNepal | www.codingnepalweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Responsive Admin Dashboard | CodingLab </title>
    <link rel="stylesheet" href="style.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!-- Style.css -->
<link rel="stylesheet" type="text/css"
	href="files\assets\css\dashboard.css">
<script
src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
</script>
   </head>
<body>
 <!--  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">CodingLab</span>
    </div>
      <ul class="nav-links">
        <li>
          <a href="#" class="active">
            <i class='bx bx-grid-alt' ></i>
            <span class="links_name">Dashboard</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-box' ></i>
            <span class="links_name">Product</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-list-ul' ></i>
            <span class="links_name">Order list</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-pie-chart-alt-2' ></i>
            <span class="links_name">Analytics</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-coin-stack' ></i>
            <span class="links_name">Stock</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-book-alt' ></i>
            <span class="links_name">Total order</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-user' ></i>
            <span class="links_name">Team</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-message' ></i>
            <span class="links_name">Messages</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-heart' ></i>
            <span class="links_name">Favrorites</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-cog' ></i>
            <span class="links_name">Setting</span>
          </a>
        </li>
        <li class="log_out">
          <a href="#">
            <i class='bx bx-log-out'></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
      </ul>
  </div> -->

<!--     <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search' ></i>
      </div>
      <div class="profile-details">
        <img src="images/profile.jpg" alt="">
        <span class="admin_name">Prem Shahi</span>
        <i class='bx bx-chevron-down' ></i>
      </div>
    </nav> -->

    <div class="home-content">
      <div class="overview-boxes">
        <div class="box">
          <div class="right-side">
            <div style="font-size: large;" class="pcoded-mtext">Eligible</div>
            <br>
            <div id="eligible_count" class="number">40</div>
           
            <div style="margin-top: 8px;" class="indicator">
            
              <!-- <i class='bx bx-up-arrow-alt'></i> -->
             <!--  <span class="text">Up from yesterday</span> -->
            </div>
          </div>
          <i class='bx bx-calendar-check cart'></i>
       
        </div>
        <div class="box">
          <div class="right-side">
            <div style="font-size: large;" class="pcoded-mtext">Not Eligible</div>
              <br>
            <div id="not_eligible_count" class="number">38</div>
            <div style="margin-top: 8px;"  class="indicator">
             <!--  <i class='bx bx-up-arrow-alt'></i> -->
           <!--    <span class="text">Up from yesterday</span> -->
            </div>
          </div>
          <i class='bx bx-calendar-minus cart' ></i>
         
        </div>
        <div class="box">
          <div class="right-side">
            <div style="font-size: large;" class="pcoded-mtext">Total Payout</div>
              <br>
            <div id="Incentive_amt" class="number">12,876</div>
            <div style="margin-top: 8px;"  class="indicator">
             <!--  <i class='bx bx-up-arrow-alt'></i> -->
            <!--   <span class="text">Up from yesterday</span> -->
            </div>
          </div>
          <i class='bx bx-coin-stack cart' ></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div style="font-size: large;" class="pcoded-mtext">Budget Avai </div>
              <br>
            <div id="budget_ava" class="number">11,086</div>
            <div style="margin-top: 8px;"  class="indicator">
            <!--   <i class='bx bx-down-arrow-alt down'></i> -->
             <!--  <span class="text">Down From Today</span> -->
            </div>
          </div>
          <i class='bx bx-dna cart' ></i>
        </div>
      </div>

      <div class="sales-boxes">
        <div class="recent-sales box">
          <div style="font-size: large;" class="pcoded-mtext">Recent Sales</div>
          <div class="dt-responsive table-responsive">
          
          <table style="width: 47em;" id="dashboardtable" class="table table-bordered nowrap table-hover">
    <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Dealer Code</th>  
            <th scope="col">Eligible</th> 
            <th scope="col">Amount</th>
        </tr>
    </thead>
    <tbody id="dashboardtable_tbody">
     <!--  <tr>
    <td>Abhinav</td>
    <td>Bihar</td>
    <td>Y</td>
    <td>300</td>
</tr>
<tr>
    <td>Birla</td>
    <td>Maharahtra</td>
    <td>Y</td>
    <td>800</td>
</tr>
<tr>
    <td>Sonata</td>
    <td>Tamil Nadu</td>
    <td>N</td>
    <td>0</td>
</tr>
<tr>
    <td>Kirloskar</td>
    <td>Gujrat</td>
    <td>Y</td>
    <td>500</td>
</tr> 
<tr>
    <td>Berger</td>
    <td>Goa</td>
    <td>N</td>
    <td>0</td>
</tr>   

<tr>
    <td>Abhinav</td>
    <td>jharkhand</td>
    <td>Y</td>
    <td>300</td>
</tr>
<tr>
    <td>Birla</td>
    <td>Pune</td>
    <td>Y</td>
    <td>800</td>
</tr>
<tr>
    <td>Sonata</td>
    <td>Kerla</td>
    <td>N</td>
    <td>0</td>
</tr>
<tr>
    <td>Kirloskar</td>
    <td>Haryana</td>
    <td>Y</td>
    <td>500</td>
</tr> 
<tr>
    <td>Berger</td>
    <td>Jammu</td>
    <td>N</td>
    <td>0</td>
</tr>   



<tr>
    <td>Abhinav</td>
    <td>punjab</td>
    <td>Y</td>
    <td>300</td>
</tr>
<tr>
    <td>Birla</td>
    <td>asam</td>
    <td>Y</td>
    <td>800</td>
</tr>
<tr>
    <td>Sonata</td>
    <td>meghalya</td>
    <td>N</td>
    <td>0</td>
</tr>
<tr>
    <td>Kirloskar</td>
    <td>madhy pradesh</td>
    <td>Y</td>
    <td>500</td>
</tr> 
<tr>
    <td>Berger</td>
    <td>karnataks</td>
    <td>N</td>
    <td>0</td>
</tr>    -->

    </tbody>
</table>

          <!--   <ul class="details">
              <li class="topic">Date</li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
              <li><a href="#">02 Jan 2021</a></li>
            </ul>
            <ul class="details">
            <li class="topic">Customer</li>
            <li><a href="#">Alex Doe</a></li>
            <li><a href="#">David Mart</a></li>
            <li><a href="#">Roe Parter</a></li>
            <li><a href="#">Diana Penty</a></li>
            <li><a href="#">Martin Paw</a></li>
            <li><a href="#">Doe Alex</a></li>
            <li><a href="#">Aiana Lexa</a></li>
            <li><a href="#">Rexel Mags</a></li>
             <li><a href="#">Tiana Loths</a></li>
          </ul>
          <ul class="details">
            <li class="topic">Sales</li>
            <li><a href="#">Delivered</a></li>
            <li><a href="#">Pending</a></li>
            <li><a href="#">Returned</a></li>
            <li><a href="#">Delivered</a></li>
            <li><a href="#">Pending</a></li>
            <li><a href="#">Returned</a></li>
            <li><a href="#">Delivered</a></li>
             <li><a href="#">Pending</a></li>
            <li><a href="#">Delivered</a></li>
          </ul>
          <ul class="details">
            <li class="topic">Total</li>
            <li><a href="#">$204.98</a></li>
            <li><a href="#">$24.55</a></li>
            <li><a href="#">$25.88</a></li>
            <li><a href="#">$170.66</a></li>
            <li><a href="#">$56.56</a></li>
            <li><a href="#">$44.95</a></li>
            <li><a href="#">$67.33</a></li>
             <li><a href="#">$23.53</a></li>
             <li><a href="#">$46.52</a></li>
          </ul> -->
          </div>
           <div id="see_all" >
         <!--    <a href="#">See All</a> -->
          </div> 
          <p></p>
          <div class="container">
             <div style="font-size: large;" class="pcoded-mtext">Budget vs Incentive Amount</div>
               <p> </p>
          <canvas id="myChart" style="width:40%;max-width:300px;margin-left: -3px;"></canvas>
          

</div>
        </div>
        <div class="top-sales box" style="height: 0%;">
          <div style="font-size: large;" class="pcoded-mtext">Top Incentive Dealers</div>
          <ul class="top-sales-details" id="ascending_result">
         <!--   <li>
            <a href="#">
              <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Vuitton Sunglasses</span>
            </a>
            <span class="pcoded-mtext">$1107</span>
          </li>
           <li>
            <a href="#">
              <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Hourglass Jeans </span>
            </a>
            <span class="pcoded-mtext">$1567</span>
          </li>
          <li>
            <a href="#">
            <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Nike Sport Shoe</span>
            </a>
            <span class="pcoded-mtext">$1234</span>
          </li>
          <li>
            <a href="#">
             <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Hermes Silk Scarves.</span>
            </a>
            <span class="pcoded-mtext">$2312</span>
          </li>
          <li>
            <a href="#">
            <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Succi Ladies Bag</span>
            </a>
            <span class="pcoded-mtext">$1456</span>
          </li>
          <li>
            <a href="#">
             <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Gucci Womens's Bags</span>
            </a>
            <span class="pcoded-mtext">$2345</span>
          <li>
            <a href="#">
             <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Addidas Running Shoe</span>
            </a>
            <span class="pcoded-mtext">$2345</span>
          </li>
<li>
            <a href="#">
             <img src="files\assets\images\avatar-4.jpg" class="img-radius" alt="User-Profile-Image">
              <span class="pcoded-mtext">Bilack Wear's Shirt</span>
            </a>
            <span class="pcoded-mtext">$1245</span>
          </li> -->
          </ul>
        </div>
      </div>
    </div>
    <script src="resources/newportal/vendor/jquery/jquery.js"></script>
    	<script type="text/javascript"
		src="files\bower_components\jquery\js\jquery.min.js"></script>
		
 
  <script>
  let total=0;
  window.onload = function () {

	
     var dealer_id="${dealer_id}";
     var scheme_name="${schnm}";

	  $.ajax({
			url: '${pageContext.request.contextPath}/schemeanalysis_dashboard_dealer',
			data : ({
				dealer_id : dealer_id,scheme_name : scheme_name
			}),
		    success: function(data) {				        	
		   console.log("scheme analysis data");
		   
		   console.log(data);
		   const ascending_result = data.filter((word) => word.reward_status == "NA");
		   const result = data.filter((word) => word.reward_status == "Q");
		   const result2 = data.filter((word) => word.reward_status == "NQ");
		   const result3 = data.filter((word) => word.reward_status == "NA");
		   const result4 = data.filter((word) =>{
			   if(word.reward_status == "NA" && word.reward_total>0){
				   return word;
			   }
		   });
		   
		
		   
		   result4.sort((a, b) => {
			    return a.reward_total - b.reward_total;
			});
		   
		   console.log("ascending_result");
		    console.log(result4);
		   
		    let sortable = [];
		    for (var vehicle in result4) {
		        sortable.push([vehicle, result4[vehicle]]);
		    }

		/*     sortable.sort(function(a, b) {
		        return a[1] - b[1];
		    }); */
		    
		   
		   
		   document.getElementById("eligible_count").innerHTML = result.length;
		   document.getElementById("not_eligible_count").innerHTML = result2.length;
		  
		   document.getElementById("budget_ava").innerHTML = 10500;
  			console.log("After array filer");
		   
		    console.log("Qualifield");
		    console.log(result);
		    console.log(" Not Qualifield");
		    console.log(result2);
		 
		    
		   
		    
		    for(var i=0;i<data.length;i++){
		    	
		    	total=total+data[i].reward_total;
		    }
		    
		    console.log("Total Value");
		    console.log(total);
		    document.getElementById("Incentive_amt").innerHTML = total;
		    
		    $("#dashboardtable").dataTable().fnDestroy();
		    var tb_string="";
		    var re_dlr_name="";
		    var re_dlr_bill_to="";
		    var re_reward_total="";
		    var commn="";
		    
		    var someStr = 'He said "Hello, my name is Foo"';
		    console.log('He said "Hello, my name is Foo"');
		    console.log(typeof(someStr));
		   
		    for(var i=0;i<result3.length;i++){
		    	
		    	
		   
 				tb_string=tb_string+'<tr><td>'+result3[i].dlr_name+'</td>'
 				+'<td>'+result3[i].dlr_bill_to+'</td>';
 				if(result3[i].reward_total > 0){
 					tb_string=tb_string+'<td>Q</td>';	
 				}else{
 					
 					tb_string=tb_string+'<td>NQ</td>';	
 				}
 				
 				tb_string=tb_string+'<td>'+result3[i].reward_total+'</td></tr>';
 				
		    }
		    
		    document.getElementById("dashboardtable_tbody").innerHTML = tb_string;
		    
		    var ascending_string="";
		    
		    for(var i=0;i<sortable.length;i++){
		    	
		    	if(i<=10){
		    		
		    	let obj=sortable[i][1];
		    	
		    	
				   
		    	ascending_string=ascending_string+'<li><a href="#"><img src="files\\assets\\images\\avatar-4.jpg" class="img-radius" alt="User-Profile-Image"><span class="pcoded-mtext">'+obj.dlr_name+'</span></a><span class="pcoded-mtext">'+obj.reward_total+'</span></li>';
		    	}
 				
		    }
		    
		    document.getElementById("ascending_result").innerHTML = ascending_string;
		    
		    $('#dashboardtable').DataTable({
			    'paging': true,
			    'lengthChange': false,
			    'searching': true,
			    'ordering': true,
			    'info': false,
			    'autoWidth': false,
			    'pageLength': 10
			  })
 			
			  
			  donut_chart();
	
 			//$('#dashboardtable tr').last().after(tb_string);
 			
 		
 			
 /* 		     $('table.paginated').each(function() {
 			   
 		    	 console.log("Inside table.paginated");
 		    	 var currentPage = 0;
 			    var numPerPage = 5;
  			   //var $table = $('#dashboardtable');

 			     var $table = $(this);
 			   
 			   
 			    $table.bind('repaginate', function() {
 			        $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
 			    });
 			    $table.trigger('repaginate');
 			    var numRows = $table.find('tbody tr').length;
 			    var numPages = Math.ceil(numRows / numPerPage);
 			    var $pager = $('<div class="pager"></div>');
 			    for (var page = 0; page < numPages; page++) {
 			        $('<span class="page-number"></span>').text(page + 1).bind('click', {
 			            newPage: page
 			        }, function(event) {
 			            currentPage = event.data['newPage'];
 			            $table.trigger('repaginate');
 			            $(this).addClass('active').siblings().removeClass('active');
 			        }).appendTo($pager).addClass('clickable');
 			    }
 			    $pager.insertAfter($("#see_all")).find('span.page-number:first').addClass('active');
 			}); */
		    
		    
		   
		
		    }
		  });


	  };
  </script>

     <script  type="text/javascript">
 
    
     function donut_chart(){

     let per_incentive=(total*100)/10500;
 	let per_budget=100-per_incentive;  
 	
    let tr_budget=Math.trunc(per_incentive);
 	let tr_incent=Math.trunc(per_budget);
 			  
  var xValues = ["Actual Budget = "+tr_budget+"%", "Incentive Amount = "+tr_incent+"%"];
  var yValues = [per_incentive, per_budget];
  var barColors = [
    "#b91d47",
    "#00aba9",
    "#2b5797",
    "#e8c3b9",
    "#1e7145"
  ];

  new Chart("myChart", {
    type: "doughnut",
    data: {
      labels: xValues,
      datasets: [{
        backgroundColor: barColors,
        data: yValues
      }]
    },
    options: {
      title: {
        display: true,
        text: "Comparison of Actual Budget vs Incentive Amount"
      }
    }
  });
  

	
	}

  
  function donut_chart2(){
	  
	  var data = {
			  labels: [
			    "Red",
			    "Blue"
			 
			  ],
			  datasets: [
			    {
			      data: [300, 50],
			      backgroundColor: [
			        "#FF6283",
			        "#36A2EB"			      
			      ],
			      hoverBackgroundColor: [
			        "#FF6283",
			        "#36A2EB"
		
			      ]
			    }]
			};
			var promisedDeliveryChart = new Chart(document.getElementById('myChart'), {
			  type: 'doughnut',
			  data: data,
			  options: {
			     responsive: true,
			    legend: {
			      display: false
			    }
			  }
			});
			Chart.pluginService.register({
			  beforeDraw: function(chart) {
			    var width = chart.chart.width,
			        height = chart.chart.height,
			        ctx = chart.chart.ctx;
			    ctx.restore();
			    var fontSize = (height / 114).toFixed(2);
			    ctx.font = fontSize + "em sans-serif";
			    ctx.textBaseline = "middle";
			    var text = "75%",
			        textX = Math.round((width - ctx.measureText(text).width) / 2),
			        textY = height / 2;
			    ctx.fillText(text, textX, textY);
			    ctx.save();
			  }
			});   
	  
	  
	  
	  /* let per_incentive=(total*100)/10500;
	  	let per_budget=100-per_incentive; 
	  	
	  	console.log("The Values per_incentive____ "+per_incentive);
		console.log("The Values per_budget____"+per_budget);
	  			  
	   var xValues = ["Actual Budget", "Incentive Amount"];
	   var yValues = [per_budget, per_incentive];
	   var barColors = [
	     "#b91d47",
	     "#00aba9",
	     "#2b5797",
	     "#e8c3b9",
	     "#1e7145"
	   ];

	   new Chart("myChart", {
	     type: "doughnut",
	     data: {
	       labels: xValues,
	       datasets: [{
	         backgroundColor: barColors,
	         data: yValues
	       }]
	     },
	     options: {
	       title: {
	         display: true,
	         text: "Comparison of Actual Budget vs Incentive Amount"
	       }
	     }
	   });
	   
	   
	   
	   Chart.pluginService.register({
		   beforeDraw: function(chart) {
		     var width = chart.chart.width,
		         height = chart.chart.height,
		         ctx = chart.chart.ctx;
		     ctx.restore();
		     var fontSize = (height / 114).toFixed(2);
		     ctx.font = fontSize + "em sans-serif";
		     ctx.textBaseline = "middle";
		     var text = "75%",
		         textX = Math.round((width - ctx.measureText(text).width) / 2),
		         textY = height / 2;
		     ctx.fillText(text, textX, textY);
		     ctx.save();
		   }
		 }); */

  }
 
  
 
 
 </script>
 
  <script>
/*    let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else{
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
} */
 </script>


</body>
</html>
