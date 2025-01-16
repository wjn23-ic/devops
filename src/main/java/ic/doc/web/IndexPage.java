package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexPage implements Page {

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Header
        writer.println("<html>");
        writer.println("<head><title>Welcome</title></head>");
        writer.println("<body>");

        // Content
        writer.println(
                "<h1>Welcome!!</h1>" +
                        "<p>Enter your query in the box below: " +
                        "<form method=\"get\">" +
                        "<input type=\"text\" name=\"q\" required />" +
                        "<br><br>" +
                        "<label><input type=\"radio\" name=\"format\" value=\"html\" checked> View as HTML</label><br>" +
                        "<label><input type=\"radio\" name=\"format\" value=\"markdown\"> Download as Markdown</label><br>" +
                        "<label><input type=\"radio\" name=\"format\" value=\"pdf\"> Download as PDF</label><br><br>" +
                        "<input type=\"submit\" value=\"Submit\">" +
                        "<form>" +
                        "</p>");

        // Footer
        //                         "<br><br><input type=\"Download as Markdown\">"
        writer.println("</body>");
        writer.println("</html>");
    }
    
}
