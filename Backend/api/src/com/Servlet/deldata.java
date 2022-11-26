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

@WebServlet("/deldata")
public class deldata extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");//* means all

        Enumeration<String> e = request.getParameterNames();//get parameter names
        List list =new ArrayList();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        while(e.hasMoreElements()){  //Enumeration
            String str = (String)e.nextElement(); //get the next element value

            if(str.equals("table")){
                continue;
            }
            list.add(str);
        }
        String string = "";
        String string2 = "";
        String string3 = "";
        for(int i=0;i<list.size();i++){
            if(string==""){
                string="`"+(String)list.get(i)+"` varchar(255) DEFAULT NULL";
                string2=(String)list.get(i);
                string3="?";
            }else{
                string=string+','+"`"+(String)list.get(i)+"` varchar(255) DEFAULT NULL";
                string2=string2+","+(String)list.get(i);
                string3=string3+","+"?";
            }
        }
        string3=string3+","+"?";
        String sql = "delete from "+request.getParameter("table")+" WHERE  id="+request.getParameter("id");
        request.setCharacterEncoding("utf-8");//Set the encoding method 

        //Initialize the database connection object conn
        Connection conn = null;
        //try...catch
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp",
                    "root",
                    "bear");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        ResultSet rs = null;

        List blist2 =new ArrayList();

        try {


            String sql2 = "desc  "+request.getParameter("table");
            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps2 = conn.prepareStatement(sql2);
            rs = ps2.executeQuery();
            List blist =new ArrayList();

            while(rs.next())
            {
                blist.add(rs.getString("Field"));

            }
            System.out.println(blist);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            while(rs.next())
            {
                List list3 =new ArrayList();
                Map<String,Object> resMap = new HashMap<>();    // Use Map to store key-value pairs
                for(int i=0;i<blist.size();i++){
                    try{
                        String b = (String)(blist.get(i));
                        resMap.put(b,rs.getString(b));   // Add content to the Map object

                    }catch(SQLException e1){
                        continue;
                    }finally{
                        continue;
                    }
                }
                blist2.add(resMap);
                System.out.println(list3);

            }
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
        Map<String,Object> resMap = new HashMap<>();    // Use Map to store key-value pairs
        resMap.put("data",blist2);   // Add content to the Map object
        resMap.put("msg","操作成功");   // Add content to the Map object
        System.out.println(resMap);
        String resJSON = JSON.toJSONString(resMap);     // convert to json
        PrintWriter out = response.getWriter();
        out.print(resJSON); // output

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
