/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sun.misc.IOUtils;

/**
 *
 * @author Alexandre
 */
@WebServlet(urlPatterns = {"/getReceiveFromRaspiInformation"})
public class getReceiveFromRaspiInformation extends HttpServlet {

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
        response.setContentType("image/jpeg");
        System.out.println("Received Image!!!!!!!!!!!!!!!!!");

//Esse funciona
//        InputStream newStream = request.getInputStream();
//        String inputStreamString = new Scanner(newStream,"UTF-8").useDelimiter("\\A").next();
//        System.out.println(inputStreamString);
        InputStream newStream = request.getInputStream();
        String pathToWeb = getServletContext().getRealPath(File.separator);
        BufferedImage newImage = ImageIO.read(newStream);
        System.out.println(newImage.getHeight());
        File file = new File(pathToWeb + "image2.jpg");
        ImageIO.write(newImage, "jpg", file);

        updateImage();

//esse nao
//        try (PrintWriter out = response.getWriter()) {
//            String pathToWeb = getServletContext().getRealPath(File.separator);
//
//            System.out.println("Received Image");
//            /* TODO output your page here. You may use following sample code. */
//
//            InputStream newStream = request.getInputStream();
//            BufferedImage newImage = ImageIO.read(newStream);
//            File file = new File(pathToWeb + "image1.jpg");
//
//            ImageIO.write(newImage, "jpg", file);
        // }
    }

    private void updateImage() throws IOException {
        String pathToWeb = getServletContext().getRealPath(File.separator);

        File file1 = new File(pathToWeb + "image1.jpg");
        BufferedImage img1 = ImageIO.read(file1);
        System.out.println("who?" + img1.getHeight());

        System.out.println("Path" + pathToWeb);
        File file2 = new File(pathToWeb + "image2.jpg");
        BufferedImage img2 = ImageIO.read(file2);
        System.out.println("whos?" + img2.getHeight());
        ImageIO.write(img1, "jpg", file2);
        ImageIO.write(img2, "jpg", file1);
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
