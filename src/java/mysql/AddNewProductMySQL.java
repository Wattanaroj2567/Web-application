/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mysql;

import controller.DBConnection;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author NITRO V 15
 */
@WebServlet(name = "AddNewProductMySQL", urlPatterns = {"/AddNewProductMySQL"})
public class AddNewProductMySQL extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // รับค่าจากผู้ใช้งาน
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");
        try {
            // แปลงจาก String เป็น int
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int price = Integer.parseInt(request.getParameter("price"));
            
            // สร้าง instance of Product
            Product product = new Product();
            product.setName(productName);
            product.setType(productType);
            product.setQuantity(quantity);
            product.setPrice(price);

            // insert into MySQL: table Product
            DBConnection dbConnection = new DBConnection();
            if (!dbConnection.insertNewProduct(product)) {
                System.out.println(">>> AddNewProductMySQL ERROR");
            }

            // forward to addNewFoodSuccess.jsp
            HttpSession session = request.getSession();
            session.setAttribute("product", product);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/addNewProductSuccess.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            // จัดการกรณีที่การแปลงเกิดข้อผิดพลาด
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "กรุณากรอกข้อมูลด้วยครับ << ย้อนกลับเพื่อแก้ไข ลูกศรด้านบนฝั่งด้านซ้าย");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
