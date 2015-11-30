
package smarthomes.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import smarthomes.domain.Property;

/**
 *
 * @author Kelli
 * Get the details of the currently selected property 
 * from  the list of items stored in the ServletContext
 */
public class PropertyDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get property item selected from using the id
        int selectionId = Integer.parseInt(request.getParameter("propId"));
        if(selectionId<1)return ;
        ArrayList<Property> pList = (ArrayList<Property>)getServletContext().getAttribute("listing");
        Property property = getSelectedProperty(pList, selectionId);
        request.setAttribute("selectedProperty", property);
        request.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
    }
    
    //get the target property using the selection id provided.
    private Property getSelectedProperty(ArrayList<Property> list, int propId){
        Property target = null;
        for (Property property : list) {
            if(property.getPropertyId()==propId){
                target = property;
            }
        }
            return target;
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
