/*
 * Copyright 2015
 *  http://wazza.co.ke
 * Had to borrow this from a previous project (saved 1 manhour)
 */

package smarthomes.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kelli
 */
public class ImagesServer extends HttpServlet {

    private static final String APPLICATION_IMGS_DIR = "C:\\Users\\Kelli\\smrt_images\\";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("image/jpg");
                OutputStream os  = response.getOutputStream();
                
            String currPropImgDir = request.getParameter("dirName");
            String imageFile = request.getParameter("imageFile");
            
            Logger.getLogger(ImagesServer.class.getName()).log(Level.INFO,"Images Base Dir: {0}",APPLICATION_IMGS_DIR);   
            Logger.getLogger(ImagesServer.class.getName()).log(Level.INFO,"Current File Dir: {0}",currPropImgDir);   
            Logger.getLogger(ImagesServer.class.getName()).log(Level.INFO,"Current Image Name: {0}",imageFile);   
            
            currPropImgDir = prependBaseDir(currPropImgDir); //add base dir to filename
            Logger.getLogger(ImagesServer.class.getName()).log(Level.INFO,"Final Image Path: {0}",currPropImgDir);   
            sendFile(currPropImgDir+"\\"+imageFile,os);
    }
    
    public static void sendFile(String name,OutputStream os){
        //works with bytes
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(name);
            Logger.getLogger(ImagesServer.class.getCanonicalName())
                    .log(Level.INFO, "mambo sawa... so far....");
            byte[] buffer = new byte[4*1024]; //4Kb buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer))!=-1){
                os.write(buffer,0, bytesRead);
            }
        }catch(FileNotFoundException fex){
            Logger.getLogger(ImagesServer.class.getName())
                    .log(Level.SEVERE, "File fetch error: {0}",fex.getMessage());
            
        }catch(IOException ioe){
            Logger.getLogger(ImagesServer.class.getName())
                    .log(Level.SEVERE, "IO error: {0}",ioe.getLocalizedMessage());
        }
        finally{
            if(fis!=null){
                try{
                fis.close();
                    
                }catch(IOException ioe){}
            }
        }
    }
    
    /**
     * Prepend the application's images base directory to the directory of 
     * the current image.
     * @param dirName
     * @return 
     */
    private String prependBaseDir(String dirName){
        dirName = APPLICATION_IMGS_DIR+dirName;
        return dirName;
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
