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

//使用注解的方式来访问我们的servlet
@WebServlet("/getdata")
public class getdata extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");//星号表示所有

        Enumeration<String> e = request.getParameterNames();//获得所有的参数名称
        List list =new ArrayList();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        while(e.hasMoreElements()){  //遍历Enumeration
            String str = (String)e.nextElement(); //取出下一个元素值

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
        String sql = "SELECT * FROM "+request.getParameter("table");
        request.setCharacterEncoding("utf-8");//设置编码方式，防止中文乱码

        //初始化数据库连接对象conn
        Connection conn = null;
        //利用try...catch处理异常
        try {
            //注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        try {
            //开始连接自己的数据库
            //test是数据库名称
            //root 一般不需要修改
            //password:修改为自己数据库的密码
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
            rs = ps.executeQuery();

            while(rs.next())
            {
                List list3 =new ArrayList();
                Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
                for(int i=0;i<blist.size();i++){
                        String b = (String) (blist.get(i));
                        resMap.put(b, "");   // 向Map对象中添加内容
                }
                System.out.println(resMap);
                for(int i=0;i<blist.size();i++){
                    try{
                        String b = (String)(blist.get(i));
                        String c = rs.getString(b);
                        if (c==null){
                            c="";
                        }
                        resMap.put(b,c);   // 向Map对象中添加内容

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
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
        resMap.put("data",blist2);   // 向Map对象中添加内容
        resMap.put("msg","操作成功");   // 向Map对象中添加内容
        System.out.println(resMap);
        String resJSON = JSON.toJSONString(resMap);     // 转换为json
        PrintWriter out = response.getWriter();
        out.print(resJSON); // 输出

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}