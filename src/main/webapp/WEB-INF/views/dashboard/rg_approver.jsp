<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.stock.min.js"></script>
<title>BSAT-R3</title>
</head>
<body>
 
                                    <div class="row">
                                            <!-- task, page, download counter  start -->
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-yellow update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Incomplete">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${incomplete}</h4>
                                                                <h6 class="text-white m-b-0">WIP Schemes</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-1" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-green update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Pending for Approval">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${approvalpending}</h4>
                                                                <h6 class="text-white m-b-0">Approval Pending</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-2" height="50"></canvas>
                                                            </div>
                                                        </div>
                                                    </div></a>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-pink update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Requested">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${requested}</h4>
                                                                <h6 class="text-white m-b-0">Requested to RA</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-3" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-lite-green update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Pending for RG Approval">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${provisioned}</h4>
                                                                <h6 class="text-white m-b-0">Provisioned</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-4" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                    <!-- <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-n_green update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Ready To Launch">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${launch}</h4>
                                                                <h6 class="text-white m-b-0">Ready to launch</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-5" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-n_pink update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Active">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${active}</h4>
                                                                <h6 class="text-white m-b-0">Active</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-6" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-purple update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Freezed">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${freezed}</h4>
                                                                <h6 class="text-white m-b-0">Freezed</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-7" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-lime update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Closed">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${closed}</h4>
                                                                <h6 class="text-white m-b-0">Redeemed And Closed</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-8" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-deep_purple update-card">
                                                    <div class="card-block"><a href="schemehistoryforit">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${review}</h4>
                                                                <h6 class="text-white m-b-0">Ready For Financial Analysis</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-9" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-teal update-card">
                                                    <div class="card-block"><a href="schemehistoryforit">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${redemptionReady}</h4>
                                                                <h6 class="text-white m-b-0">Inactive Prior Redemption</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-10" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-pink update-card">
                                                    <div class="card-block"><a href="schemehistoryforit?status=Processed">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${processed}</h4>
                                                                <h6 class="text-white m-b-0">Inactive Post Redemption</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-11" height="50"></canvas>
                                                            </div>
                                                        </div></a>
                                                    </div>
                                                   <!--  <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>update : 2:15 am</p>
                                                    </div> -->
                                                </div>
                                            </div>
                                            <!--  sale analytics start -->
                                           <div class="col-xl-9 col-md-12">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Sales Analytics</h5>
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
                                             <!-- Donut chart start -->
                                             <div class="col-xl-3">
                                               <div class="card">
                                                    <div class="card-header">
                                                        <h5>Server load</h5>
<!--                                                         <span>lorem ipsum dolor sit amet, consectetur adipisicing elit</span> -->
                                                    </div>
                                                    <div class="card-block">
                                                        <div id="server-load" style="height:300px"></div>
                                                    </div>
                                                </div>
                                            </div> 
                                            <!-- Donut chart Ends -->
                                             <!--  sale analytics end -->
                                            <!-- task, page, download counter  end -->
                                            <!--  sale analytics start -->
                                           <!--  <div class="col-xl-9 col-md-12">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Sales Analytics</h5>
                                                        <span class="text-muted">For more details about usage, please refer <a href="https://www.amcharts.com/online-store/" target="_blank">amCharts</a> licences.</span>
                                                        <div class="card-header-right">
                                                            <ul class="list-unstyled card-option">
                                                                <li><i class="feather icon-maximize full-card"></i></li>
                                                                <li><i class="feather icon-minus minimize-card"></i></li>
                                                                <li><i class="feather icon-trash-2 close-card"></i></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="card-block">
                                                        <div id="sales-analytics" style="height: 265px;"></div>
                                                    </div>
                                                </div>
                                            </div> -->
                                            <%-- <div class="col-xl-3 col-md-6">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>New Users</h5>
                                                    </div>
                                                    <div class="card-block">
                                                        <canvas id="newuserchart" height="250"></canvas>
                                                    </div>
                                                    <div class="card-footer ">
                                                        <div class="row text-center b-t-default">
                                                            <div class="col-4 b-r-default m-t-15">
                                                                <h5>${incomplete}</h5>
                                                                <p class="text-muted m-b-0">Incomplete</p>
                                                            </div>
                                                             <div class="col-4 b-r-default m-t-15">
                                                                <h5>${active}</h5>
                                                                <p class="text-muted m-b-0">complete</p>
                                                            </div>
                                                            <div class="col-4 b-r-default m-t-15">
                                                                <h5>6%</h5>
                                                                <p class="text-muted m-b-0">Unsatisfied</p>
                                                            </div>
                                                            <div class="col-4 m-t-15">
                                                                <h5>9%</h5>
                                                                <p class="text-muted m-b-0">NA</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div> --%>
                                             <div class="col-md-12 col-lg-6">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Exploading a slice chart</h5>
                                                        <span>lorem ipsum dolor sit amet, consectetur adipisicing elit</span>

                                                    </div>
                                                    <div class="card-block">
                                                        <div id="chart_Exploading" style="width: 100%; height: 300px;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--  sale analytics end -->
                                            
                                        </div>
</body>
<script type="text/javascript">
window.onload = function () {
	$("text").remove();
	 var myChartGauge = echarts.init(document.getElementById('server-load'));

	  var optionGauge = {

	          tooltip : {
	              formatter: "{b} : {c}%"
	          },
	          toolbox: {
	              show : false,
	              feature : {
	                  mark : {show: false},
	                  restore : {show: false},
	                  saveAsImage : {show: true}
	              }
	          },
	          series : [
	              {
	                  name:'Server Load',
	                  type:'gauge',
	                  center: ['50%', '50%'],
	                  radius: ['0%', '100%'],
	                  axisLine: {
	                      show: true,
	                      lineStyle: {
	                          color: [
	                              [0.2, '#93BE52'],
	                              [0.8, '#4680ff'],
	                              [1, '#FC6180']
	                          ],
	                          width: 10
	                      }
	                  }  ,
	                  title: {
	                      show : false,
	                      offsetCenter: [0, '120%'],
	                      textStyle: {
	                          color: '#93BE52',
	                          fontSize : 15
	                      }
	                  }  ,
	                  detail: {
	                      show : true,
	                      backgroundColor: 'rgba(0,0,0,0)',
	                      borderWidth: 0,
	                      borderColor: '#ccc',
	                      width: 100,
	                      height: 40,
	                      offsetCenter: [0, '40%'],
	                      formatter:'{value}%',
	                      textStyle: {
	                          color: 'auto',
	                          fontSize : 20
	                      }
	                  },

	                  data:[{value: 50, name: 'Server Load (MB)'}]
	              }
	       ]
	};
	
	
	gauge_load_chart(optionGauge);
	var timeTicket = setInterval(function (){

	gauge_load_chart(optionGauge);
	},2000);


	function gauge_load_chart(optionGauge){

	optionGauge.series[0].data[0].value = (Math.random()*100).toFixed(2) - 0;
	myChartGauge.setOption(optionGauge,true);
	}

	 var dataPoints1 = [], dataPoints2 = [];
	  var stockChart = new CanvasJS.StockChart("chartContainer",{
	    theme: "light2",
	    animationEnabled: true,
	    title:{
	      text:""
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
	            itemclick: function (e) {
	              if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible)
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
	        dataPoints : dataPoints1
	      },{
	        showInLegend: true,
	        name: "Actual Sales in Rs",
	        yValueFormatString: "#,##0",
	        dataPoints : dataPoints2
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
	  $.get('${pageContext.request.contextPath}/getSalesData', {
	     }, function(data) {
	    	 for(var i = 0; i < data.length; i++){
	    	      dataPoints1.push({x: new Date(data[i].s_date), y: Number(data[i].budget_value)});
	    	      dataPoints2.push({x: new Date(data[i].s_date), y: Number(data[i].actual_value)});
	    	    }
	    	    stockChart.render();
	    	 
	     }
	     );
	  

}</script>
</html>