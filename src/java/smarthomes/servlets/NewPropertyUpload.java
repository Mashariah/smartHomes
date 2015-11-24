

package smarthomes.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import smarthomes.controllers.PropertyController;
import smarthomes.domain.Location;
import smarthomes.domain.Property;
import smarthomes.domain.PropertyOwner;
import smarthomes.domain.utilities.CodeGenerator;

/**
 *
 * @author Kelli
 */
public class NewPropertyUpload extends HttpServlet {

    //TODO: Code for getting user directory
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Kelli\\smrt_images";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3Mb
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; //10Mb
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 30; //30Mb

    //on submission parse request data to read upload data and save the file on disk
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Logger logger = Logger.getLogger(NewPropertyUpload.class.getName());
        LinkedHashMap<String, String> imageFiles = new LinkedHashMap<>();
        LinkedHashMap<String, String> formParams = new LinkedHashMap<>();
        String dirName = String.valueOf(new CodeGenerator().getNextInt());

        //check if the request contains upload data...
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter p = response.getWriter();
            p.println("form has no enctype=multipart/form-data");
            p.flush();
            return;
        }

        //configure upload settings 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //set the memory threshold...bigger files will be stored on disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //set the temporary location to store the files 
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        Logger.getLogger(NewPropertyUpload.class.getName())
                .log(Level.INFO, new File(System.getProperty("java.io.tmpdir")).getAbsolutePath());

        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //set the max size of the upload file 
        fileUpload.setFileSizeMax(MAX_FILE_SIZE);
        //set the maximum size of the request (file size + form data)
        fileUpload.setSizeMax(MAX_REQUEST_SIZE);

        //Generate a name for the directory
        String uploadPath = UPLOAD_DIRECTORY+"\\"+dirName;
        //create the directory if it does not exist
        File uploadDirectory = new File(uploadPath);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdir();
        }

        try {
            //parse the request's content to extract the file data
            List<FileItem> formItems = fileUpload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                //iterate over the foem fields 
                for (FileItem current : formItems) {
                    //process fields that are not form fields
                    if (!current.isFormField()) {
                        String fileName = new File(current.getName()).getName();
                        //save original filename in client's filesystem
                        imageFiles.put(current.getFieldName(), current.getName());
                        String filepath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filepath);

                        //save the file to disk
                        current.write(storeFile);
                        logger.log(Level.INFO, "Created image file: {0}",storeFile.getName());
                    }
                    else{
                        //process form data...
                         String fName = current.getFieldName();
                        String value = current.getString();
                        formParams.put(fName, value);
                        logger.log(Level.INFO, "Field Name: {0} Value: {1}", new Object[]{fName, value});
                    }
                } //end for
            }//end try
        } catch (Exception exception) {
            logger.log(Level.SEVERE,"Exception in processing form: {0}",exception.getLocalizedMessage());
        }
        
        //Use PropertyController to create the Prop object
        //create propertyOwner instance (join both emails and phone nums provided as one string)
        PropertyOwner owner = new PropertyOwner(formParams.get("tx_fname"),
                formParams.get("tx_lname"),formParams.get("tx_email1")+";"+formParams.get("tx_email2"),
                formParams.get("tx_phone1")+";"+formParams.get("tx_phone2"));
        
        Location location = new Location(formParams.get("s_county"),
                formParams.get("tx_division"),formParams.get("tx_town"), formParams.get("tx_road"));
        
            Property property = new Property(owner,location,formParams.get("s_proptype"),
                formParams.get("s_propintent"),formParams.get("tx_price"),
                formParams.get("tx_description"),formParams.get("tx_header"),
                        formParams.get("tx_keywords"),dirName);
            
        PropertyController  controller = new PropertyController();
        boolean isAdded = controller.addNewProperty(property);
        
        if(isAdded){
            request.setAttribute("status", "Property Item Added");
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
        }else{
            request.setAttribute("status", "Property Item Adding failed");
            getServletContext().getRequestDispatcher("/NewProp.jsp").forward(request, response);
            
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
