package smarthomes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import smarthomes.controllers.BookingController;
import smarthomes.domain.utilities.SMSEngine;

/**
 *
 * @author Kelli Handle all text messages.
 */
public class VisitBooking extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Get user values for creating a Booking*/
        String fName = request.getParameter("tx_fName");
        String lName = request.getParameter("tx_lName");
        String phoneNumber = request.getParameter("tx_phone");
        String emailAddr = request.getParameter("tx_emailAddr");
        String visitDate = request.getParameter("tx_dateFrom");
        String visitTime = request.getParameter("tx_timeFrom");
        int propertyId = Integer.parseInt(request.getParameter("tx_propId"));
        
        

        //convert booking date and time
        Date vDate = getDateFromString(visitDate);
        Time vTime = getTimeFromString(visitTime);
        
        BookingController controller = new BookingController();
        //create visitor
        int visitorId = controller.createVisitor(fName, lName, emailAddr, lName);
        //create booking
        controller.createBooking(visitorId, propertyId, vDate, vTime);
        SMSEngine engine = new SMSEngine();
        
        //create and send the SMS message
        String message = "Your booking for the property visit has been confirmed for"
                + visitDate+" at "+visitTime;
        engine.sendMessage(message, phoneNumber);
        
        //
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write("Thanks for your booking. A confirmation text message has been sent "
                + " to the phone number provided");
    }

    //get user date for the booking
    private   Date getDateFromString(String dtVal) {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date date = null;
        try {
            java.util.Date dateVal = df.parse(dtVal);
            date = new java.sql.Date(dateVal.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(VisitBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
      }
    
    //get user time for booking
    private   Time getTimeFromString(String dtVal) {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        java.sql.Time time = null;
        try {
            java.util.Date dateVal = df.parse(dtVal);
            time = new  java.sql.Time(dateVal.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(VisitBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return time;
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
