
package smarthomes.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import smarthomes.controllers.PropertyController;
import smarthomes.domain.Property;

/**
 *
 * @author Kelli
 */
public class PropertiesList extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("typeOfProperty");
        String requestingId = request.getParameter("requestId");
        
        String navigationPage;
        List<Property> listing;
        if(type!=null){
            listing = new PropertyController().getPropertyOfType(type);
        }else{
            listing = new PropertyController().getAllProperties();
        }
        Logger.getLogger(PropertiesList.class.getName()).
                log(Level.INFO, "Items in List {0}",String.valueOf(listing.size()));
        getServletContext().setAttribute("listing", listing);
        if(requestingId !=null){
            navigationPage = "/admin_list_properties.jsp";
        Logger.getLogger(PropertiesList.class.getName()).
                log(Level.INFO, "Admin listing request, value of requestingId {0}",requestingId);
        }else{
            navigationPage = "/properties.jsp";
        }
        request.getRequestDispatcher(navigationPage).forward(request, response);
        
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
