package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;

public class MDResultPage implements Page {
    private final String query;
    private final String answer;

    public MDResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        // Set response headers to enable file download
        resp.setContentType("text/markdown");
        resp.setHeader("Content-Disposition", "attachment; filename=\"result.md\"");

        // Create Markdown content
        StringBuilder markdownContent = new StringBuilder();
        markdownContent.append("# ").append(query).append("\n\n");
        if (answer == null || answer.isEmpty()) {
            markdownContent.append("Sorry, we didn't understand the query.\n");
        } else {
            markdownContent.append(answer).append("\n");
        }

        // Write Markdown content to the response output stream
        try (OutputStream os = resp.getOutputStream()) {
            os.write(markdownContent.toString().getBytes());
        }
    }
}