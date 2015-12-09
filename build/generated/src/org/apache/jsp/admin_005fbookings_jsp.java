package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fbookings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/admin_dashboard.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>SmartHomes - Bookings</title>\n");
      out.write("        <link href=\"style/admin_core.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--<div id=\"scontent\">-->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Smarthomes - Admin</title>\n");
      out.write("                <link href=\"style/admin_core.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"dashboard-banner\">\n");
      out.write("            <h2>SmartHomes</h2>\n");
      out.write("            <h3> Property Management Dashboard</h3>>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"menu-bar\">\n");
      out.write("                <div class=\"menu-bar-item\"  id=\"first\"><a href=\"properties?requestId=1\">Properties</a></div>\n");
      out.write("                <div class=\"menu-bar-item\"><a href=\"admin_list_properties.jsp\">Bookings</a></div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"toolbar\">\n");
      out.write("                <a href=\"NewProp.jsp\"><img src=\"images/icons/ic_action_add.png\" width=\"30px\" height=\"30px\" alt=\"\"/>New</a>\n");
      out.write("                <a href=\"edit_properties.jsp\"><img src=\"images/icons/ic_action_edit.png\" width=\"30px\" height=\"30px\" alt=\"\"/>Edit</a>\n");
      out.write("                <a href=\"#\"><img src=\"images/icons/ic_action_search.png\" width=\"30px\" height=\"30px\" alt=\"\"/>Search</a>\n");
      out.write("                <a href=\"#\"><img src=\"images/icons/ic_action_sms.png\" width=\"30px\" height=\"30px\" alt=\"\"/>Delete</a>\n");
      out.write("                <a href=\"#\"><img src=\"images/icons/ic_action_trash.png\" width=\"30px\" height=\"30px\" alt=\"\"/>Delete</a>\n");
      out.write("                <span id=\"toolbar-item\"></span>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <thead></thead>\n");
      out.write("            <tbody>\n");
      out.write("            <c:forEach var=\"current\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bookings}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current.vDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current.visitor.lName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </c:forEach>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("        <!--</div>-->\n");
      out.write("</body>\n");
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
