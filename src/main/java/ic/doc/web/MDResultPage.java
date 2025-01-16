package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        // Set the content type to Plain text
        resp.setContentType("text/plain");

        // Set the Content-Disposition header to trigger download
        resp.setHeader("Content-Disposition", "attachment; filename=\"result.md\"");

        // Create a temporary file
        File tempFile = File.createTempFile("result", ".md");
        tempFile.deleteOnExit();

        // Write the query result to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            if (answer == null || answer.isEmpty()) {
                writer.write("# " + query + "\n");
                writer.write("Sorry, we didn't understand the query.");
            } else {
                writer.write("# " + query + "\n");
                writer.write(answer);
            }
        }

        // Serve the file data to the user
        try (InputStream in = new FileInputStream(tempFile);
             OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush(); // Ensure all data is sent to the client
        }
    }


        // Write Markdown content to the response output stream
        // try (OutputStream os = resp.getOutputStream()) {
        //     os.write(markdownContent.toString().getBytes());
        // }
    
}