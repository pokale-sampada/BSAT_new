<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page import=" java.util.HashMap" import="java.util.Map"
	import="java.util.List" import="java.util.ArrayList"
	import="com.omfys.bsat.model.Bpil_Menu_Line"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BSAT-R3</title>
</head>
<body>
	 <nav class="pcoded-navbar">
                        <div class="pcoded-inner-navbar main-menu">
<!--                             <div class="pcoded-navigatio-lavel"></div> -->
                            <ul class="pcoded-item pcoded-left-item">
                            <c:forEach var="menus" items="${menus}">
						<c:set var="header_menu_id">${menus.menu_header_id}</c:set>
						<%
							String id = (String) pageContext.getAttribute("header_menu_id");
								// 							System.out.println(id);
								if (session.getAttribute("submenu" + id) != null) {
						%>
                                <li class="pcoded-hasmenu">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="feather icon-home"></i></span>
                                        <span class="pcoded-mtext">${menus.header_name}</span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                    <%
								ArrayList<Bpil_Menu_Line> mgls = new ArrayList<Bpil_Menu_Line>();
											//     								System.out.println(id);
								mgls = (ArrayList<Bpil_Menu_Line>) session.getAttribute("submenu" + id);
									for (Bpil_Menu_Line mgl : mgls) {
						%>
                                        <li class="">
                                            <a href="<%=mgl.getAction_name()%>">
                                                <span class="pcoded-mtext"><%=mgl.getLine_name()%></span>
                                            </a>
                                        </li>
                                        <%
									}
								%>
                                    </ul>
                                </li>
                                <%
							} else {
						%>
                                <li id="menu${menus.menu_header_id}" class="">
                                    <a href="${menus.action_name}">
                                        <span class="pcoded-micon"><i class="feather icon-sidebar"></i></span>
                                        <span class="pcoded-mtext">${menus.header_name}</span>
                                        <!-- <span class="pcoded-badge label label-warning">NEW</span> -->
                                    </a>
                                        </li>
                                        <%
							}
						%>
					</c:forEach>
					      </ul>
                          
                        </div>
                    </nav>
</body>
</html>