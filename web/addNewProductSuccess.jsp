<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product, java.util.Arrays" %>

<html>

    <head>
        <title>UBU Market Center</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="https://th.bing.com/th/id/R.fcd3fe81c6d9a0fef683d1ed0f071617?rik=JPleyvaqoKrYCg&riu=http%3a%2f%2fwww.pngmart.com%2ffiles%2f7%2fMarket-PNG-Free-Download.png&ehk=WIqzKBn6kFjsR4WKZq5YOWYl8iyUmiBqKBcCnjh9AEI%3d&risl=&pid=ImgRaw&r=0" 
              type="image/png">
    </head>
    
    <body>
        <h3> เพิ่มข้อมูลสำเร็จแล้ว (โปรดตรวจสอบข้อมูลให้ถูกต้อง)</h3>
        <%
            Product product = (Product) session.getAttribute("product");
        %>
        <div>
            <strong>ชื่อ :</strong> <%= product.getName()%><br/>
            <strong>ประเภท :</strong> <%= product.getType()%><br/>
            <strong>จำนวน :</strong> <%= product.getQuantity()%> ชิ้น<br/>
            <strong>ราคา :</strong> <%= product.getPrice()%> บาท<br/>
        </div>
        <a href="updateProduct.jsp">แก้ไขข้อมูล</a><br/>
        <a href="index.html">หน้าแรก</a><br/>
    </body>
</html>
