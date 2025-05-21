<%-- 
    Document   : calculate
    Created on : Jul 14, 2022, 12:05:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border:1px solid black;
            }

            td {
                text-align: center;
                height: 20px;
            }
        </style>
    </head>

    <body>
        <form action="cal2" method="post">
            <table style="width: 100%; ">
                <tr>
                    <th>a</th>
                    <th>b</th>
                    <th>c</th>
                </tr>

                <tr>
                    <td>
                        <input required="" type="number" name="a" value="${to.a}"/>
                    </td>
                    <td>
                        <input required="" type="number" name="b" value="${to.b}"/>
                    </td>
                    <td>
                        <input readonly="" type="number" name="c" value="${to.c}"/>
                    </td>
                </tr>
            </table>

            <a href="cal2?a=${to.a}&b=${to.b}">Save</a> 
            <button type="submit">Load</button>
        </form>
    </body>
</html>
