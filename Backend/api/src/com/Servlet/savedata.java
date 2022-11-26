package com.Servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

//Use annotations to access servlet
@WebServlet("/savedata")
public class savedata extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");//* means all

        Enumeration<String> e = request.getParameterNames();//get all parameter names
        List list =new ArrayList();
        while(e.hasMoreElements()){  //traverse Enumeration
            String str = (String)e.nextElement(); //get the next element value

            if(str.equals("table")){
                continue;
            }
            if(str.equals("database")){
                continue;
            }

            list.add(str);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String string = "";
        String string2 = "";
        String string3 = "";
        for(int i=0;i<list.size();i++){
            if(string==""){
                string="`"+(String)list.get(i)+"` varchar(255) DEFAULT NULL";
                string2=(String)list.get(i);
                string3="'"+request.getParameter((String)list.get(i))+"'";
            }else{
                string=string+','+"`"+(String)list.get(i)+"` varchar(255) DEFAULT NULL";
                string2=string2+","+(String)list.get(i);
                string3=string3+","+"'"+request.getParameter((String)list.get(i))+"'";
            }
        }
        string3=string3;
        String sql1 = "create table if not exists "+request.getParameter("table")+" (`id` int(11) NOT NULL AUTO_INCREMENT , `creatTime` varchar(255) DEFAULT NULL, "+string+",PRIMARY KEY (`id`))";
        request.setCharacterEncoding("utf-8");//Set the encoding method

        String sql = "INSERT "+request.getParameter("table")+"("+string2+") VALUES("+string3+")";
        //Initialize the database connection object conn
        Connection conn = null;
        //try...catch, handle exception
        try {
            //Register database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        try {
             //Start connecting to the own database
            //test: is the database name
            //root: Generally do not need to modify
            //password:Change to the password of the own database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp??useSSL=false&characterEncoding=utf-8",
                    "root",
                    "bear");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        ResultSet rs = null;


        try {
            System.out.println(sql1);
            System.out.println(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            ps2.executeUpdate();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
        Map<String,Object> resMap = new HashMap<>();    // Use Map to store key-value pairs
        resMap.put("msg","Successful operation");   //Add content to the Map object
        String resJSON = JSON.toJSONString(resMap);     // convert to json
        PrintWriter out = response.getWriter();
        out.print(resJSON); // output

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
