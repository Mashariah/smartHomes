package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class details_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menubar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>|Smarthomes - Property Details | </title>\n");
      out.write("        <!--css -->\n");
      out.write("        <script src=\"scripts/jquery-1.11.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"style/core.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link type=\"text/css\" href=\"style/nav-bar.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link type=\"text/css\" href=\"style/banner.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"style/unslider.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"scripts/unslider-min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"scripts/simplegallery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#img-gallery').simplegallery({\n");
      out.write("                    galltime: 400, // transition delay\n");
      out.write("                    gallcontent: '.content',\n");
      out.write("                    gallthumbnail: '.thumbnail',\n");
      out.write("                    gallthumb: '.thumb'\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"banner\">\n");
      out.write("            <div id=\"logo\"><img src=\"images/banners/logo_1.png\" width=\"100px\" height=\"100px\" alt=\"comp-logo\"/></div>\n");
      out.write("            <div id=\"comp-name\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"content-body\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" href=\"style/nav-bar.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link type=\"text/css\" href=\"style/core.css\" rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"nav-bar\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a id=\"nav\" href=\"index.jsp\">About</a></li>\n");
      out.write("                <li><a id=\"nav\" href=\"properties\">For Sale</a></li>\n");
      out.write("                <li><a id=\"nav\" href=\"#\">To Rent</a></li>\n");
      out.write("                <li><a id=\"nav\" href=\"#\">Developments</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            <div id=\"register-login-bar\">\n");
      out.write("                <a href=\"#\">Login</a> | \n");
      out.write("                <a href=\"#\">Register</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <section class=\"simplegallery\" id=\"img-gallery\">\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=index.jpg\" class=\"image_0\"/>\n");
      out.write("                    <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=thumb1.jpg\" class=\"image_1\" style=\"display: none;\" alt=\"\"/>\n");
      out.write("                    <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=thumb1.jpg\" class=\"image_2\" style=\"display: none;\" alt=\"\"/>\n");
      out.write("                    <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=thumb2.jpg\" class=\"image_3\" style=\"display: none;\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <div class=\"thumb\">\n");
      out.write("                        <a href=\"#\" rel=\"0\">\n");
      out.write("                            <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=index.jpg\" id=\"thumb_1\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"thumb\">\n");
      out.write("                        <a href=\"#\" rel=\"1\">\n");
      out.write("                            <img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=thumb1.jpg\" id=\"thumb_2\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"thumb last\">\n");
      out.write("                        <a href=\"#\" rel=\"2\"><img src=\"imgsrv?dirName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.imgDirLocation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&imageFile=thumb2.jpg\" id=\"thumb_3\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <div class=\"details-desc\">\n");
      out.write("                <table>\n");
      out.write("                    <tr><td id=\"head\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.header}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <!--<tr><td>Type: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.propertyType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>-->\n");
      out.write("                    <tr><td id=\"price-tag\">Price: Ksh ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.priceFormatted}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <tr><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <tr><td id=\"head\">Location Details</td></tr>\n");
      out.write("                    <tr><td><strong>County:</strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.location.county}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <tr><td><strong>Division:</strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.location.division}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <tr><td><strong>Town:</strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.location.town}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                    <tr><td><strong>Road:</strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${selectedProperty.location.road}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("                <div id=\"booking-panel\">\n");
      out.write("                    booking a visit?\n");
      out.write("                </div>\n");
      out.write("            <div class=\"details-toolbar\">\n");
      out.write("                <button type=\"button\" id=\"\">Email</button>\n");
      out.write("                <button type=\"button\">Text</button>\n");
      out.write("                <div class=\"email-board\">\n");
      out.write("                    <form>\n");
      out.write("                        <input type=\"text\" name=\"tx_subject\" placeholder=\"Subject\"/><br>\n");
      out.write("                        <textarea name=\"tx_message\" placeholder=\"Message\"></textarea>\n");
      out.write("                        <input id=\"sendBtn\" type=\"submit\" value=\"Send\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
