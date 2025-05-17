package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Library Login</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 20px; }\n");
      out.write("        .login-container {\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            padding: 30px;\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 0 15px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        h1 { text-align: center; color: #333; margin-bottom: 30px; }\n");
      out.write("        .form-group { margin-bottom: 20px; }\n");
      out.write("        label { display: block; margin-bottom: 8px; font-weight: bold; }\n");
      out.write("        input[type=\"text\"], input[type=\"password\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("        .btn-login {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("        .btn-login:hover { background-color: #45a049; }\n");
      out.write("        .error {\n");
      out.write("            color: #d9534f;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            padding: 10px;\n");
      out.write("            background-color: #f8d7da;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"login-container\">\n");
      out.write("        <h1>Library Management System</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"login\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"username\">Username:</label>\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"password\">Password:</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Login\" class=\"btn-login\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
 
            String error = request.getParameter("error");
            if (error != null) {
                String message = "";
                if (error.equals("invalid")) {
                    message = "Invalid username or password!";
                } else if (error.equals("empty")) {
                    message = "Please enter both username and password!";
                } else if (error.equals("session")) {
                    message = "Session expired. Please login again.";
                }
        
      out.write("\n");
      out.write("            <div class=\"error\">");
      out.print( message );
      out.write("</div>\n");
      out.write("        ");
 } 
      out.write("\n");
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
