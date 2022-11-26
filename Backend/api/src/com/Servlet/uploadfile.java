package com.Servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/uploadfile")
public class uploadfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Upload file storage directory
    private static final String UPLOAD_DIRECTORY = "upload";

    //upload configuration
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * Upload data and save files
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");//* means all

        // Detect whether it is a multimedia upload
        if (!ServletFileUpload.isMultipartContent(request)) {
            // stop if not
            PrintWriter writer = response.getWriter();
            writer.println("Error: he form must contain enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // Configure upload parameters
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Set the memory threshold - when exceeded, temporary files will be generated and stored in the temporary directory
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // Set temporary storage directory
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set the maximum file upload value
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // Set the maximum request value (including file and form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // Chinese processing
        upload.setHeaderEncoding("UTF-8");

        // Construct a temporary path to store uploaded files
        // This path is relative to the directory of the current application
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;

        String filePath="";
        String filePathr="";
        // Create the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // Parse the content of the request to extract the file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterate form data
                for (FileItem item : formItems) {
                    // Handle fields not in the form
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        filePathr="/"+UPLOAD_DIRECTORY+File.separator + fileName;
                        File storeFile = new File(filePath);
                        // The upload path of the output file in the console
                        System.out.println(filePath);
                        //save file to hard drive
                        item.write(storeFile);
                        request.setAttribute("message",
                                "File uploaded successfully!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "Error message: " + ex.getMessage());
        }
        Map<String,Object> resMap = new HashMap<>();    // Use Map to store key-value pairs
        resMap.put("msg","Successful operation");   // Add content to the Map object
        resMap.put("path",filePathr);   // Add content to the Map object

        System.out.println(resMap);
        String resJSON = JSON.toJSONString(resMap);     // convert to json
        PrintWriter out = response.getWriter();
        out.print(resJSON); // output

    }
}
