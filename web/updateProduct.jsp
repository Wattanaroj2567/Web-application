<%-- 
    Document   : updateProduct
    Created on : Jul 25, 2024, 6:47:06 PM
    Author     : NITRO V 15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Product" %>
<html>
    <head>
        <title>UBU Market Center</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="https://th.bing.com/th/id/OIP.op2SB84sutmugHJprE4o3AHaGp?w=184&h=180&c=7&r=0&o=5&pid=1.7" type="image/png">
    </head>
</html>

<h2>แก้ไขข้อมูล</h2>

<%
    Product product = (Product) session.getAttribute("product");
    if (product != null) {
        out.println("<p>ข้อมูลเดิม : <strong>" + product.getName() + "</strong> , <strong>" + product.getType() + "</strong> , "
                + " <strong>" + product.getQuantity() + "</strong> , <strong>" + product.getPrice() + "</strong><br/></p>");
    } else {
        out.println("<p>ไม่พบข้อมูลสินค้า การรีเฟรชหน้าเว็บ ''คุณอาจจะต้องกรอกข้อมูลใหม่อีกครั้ง'' </p>");
    }
%>

<form action="AddNewProductMySQL">
    <table>
        <tr><td>  <strong>ชื่อสินค้า :</strong></td><td><input type="text" name="productName"></td>
        <tr><td>  <strong>ประเภท :</strong></td>
            <td>
                <select name="productType">
                    <option value="อาหาร (Food)">อาหาร (Food)</option>
                    <option value="เครื่องดื่ม (Drink">เครื่องดื่ม (Drink)</option>
                    <option value="เครื่องใช้ไฟฟ้าต่างๆ  (Various electrical appliances)">เครื่องใช้ไฟฟ้าต่างๆ (Various electrical appliances)</option>
                    <option value="อุปกรณ์การใช้งานอื่นๆ (Other Devices)">อุปกรณ์การใช้งานอื่นๆ (Other Devices)</option>
                </select>
            </td>
        </tr>
        <tr><td>  <strong>จำนวน :</strong></td>
            <td>
                <input type="number" id="quantity" name="quantity" min="0" step="1"> <strong>ชิ้น</strong>
            </td>
        </tr>
        <tr><td>  <strong>ราคา :</strong></td><td><input type="text" name="price"> <strong>บาท</strong></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="Submit"></td></tr>
    </table>
</form>
 <a href="index.html">หน้าแรก</a><br/>
<% session.removeAttribute("product");%>