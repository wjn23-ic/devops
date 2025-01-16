package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class PDFResultPage implements Page {
    private final String query;
    private final String answer;

    public PDFResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        // Create a temporary Markdown file
        File markdownFile = File.createTempFile("result", ".md");
        markdownFile.deleteOnExit();

        // Write the query result to the Markdown file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(markdownFile))) {
            if (answer == null || answer.isEmpty()) {
                writer.write("# " + query + "\n");
                writer.write("Sorry, we didn't understand the query.");
            } else {
                writer.write("# " + query + "\n");
                writer.write(answer);
            }
        }

        // Create a temporary PDF file
        File pdfFile = File.createTempFile("result", ".pdf");
        pdfFile.deleteOnExit();

        // Use ProcessBuilder to invoke pandoc
        ProcessBuilder pb = new ProcessBuilder(
                "pandoc",
                markdownFile.getAbsolutePath(),
                "-o", pdfFile.getAbsolutePath()
        );
        pb.directory(new File("/tmp")); // Set working directory
        pb.redirectErrorStream(true); // Combine stdout and stderr for debugging
        Process process = pb.start();

        // Read process output for debugging (optional)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }


        // Serve the PDF file
        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=\"result.pdf\"");

        try (InputStream in = new FileInputStream(pdfFile);
             OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush(); // Ensure all data is sent to the client
        }
    }
}
