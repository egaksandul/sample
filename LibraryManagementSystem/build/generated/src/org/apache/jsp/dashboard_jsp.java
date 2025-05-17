package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.library.model.User;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write('\n');
      out.write('\n');

    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp?error=session");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial, sans-serif; margin: 20px; }\n");
      out.write("        .dashboard-container { \n");
      out.write("            width: 80%; \n");
      out.write("            margin: 30px auto; \n");
      out.write("            padding: 20px; \n");
      out.write("            border: 1px solid #ddd; \n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .welcome-message { margin-bottom: 20px; }\n");
      out.write("        .action-buttons { margin: 20px 0; }\n");
      out.write("        .btn-action { \n");
      out.write("            display: inline-block; \n");
      out.write("            padding: 10px 20px; \n");
      out.write("            margin-right: 10px; \n");
      out.write("            background-color: #4CAF50; \n");
      out.write("            color: white; \n");
      out.write("            text-decoration: none; \n");
      out.write("            border-radius: 3px;\n");
      out.write("        }\n");
      out.write("        .btn-logout { \n");
      out.write("            background-color: #f44336;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"dashboard-container\">\n");
      out.write("        <div class=\"welcome-message\">\n");
      out.write("            <h2>Welcome, ");
      out.print( user.getUsername() );
      out.write(' ');
      out.write('[');
      out.print( user.getRole() );
      out.write("]</h2>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"action-buttons\">\n");
      out.write("            ");
 if ("Student".equals(user.getRole())) { 
      out.write("\n");
      out.write("                <a href=\"searchBook.jsp\" class=\"btn-action\">Search Books</a>\n");
      out.write("            ");
 } else if ("Admin".equals(user.getRole())) { 
      out.write("\n");
      out.write("                <a href=\"addBook.jsp\" class=\"btn-action\">Add Books</a>\n");
      out.write("                <a href=\"reservation?action=view\" class=\"btn-action\">View Reservations</a>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <a href=\"logout\" class=\"btn-action btn-logout\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
