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
@WebServlet("/savedata")
public class savedata extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");//星号表示所有

        Enumeration<String> e = request.getParameterNames();//获得所有的参数名称
        List list =new ArrayList();
        while(e.hasMoreElements()){  //遍历Enumeration
            String str = (String)e.nextElement(); //取出下一个元素值

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
        request.setCharacterEncoding("utf-8");//设置编码方式，防止中文乱码

        String sql = "INSERT "+request.getParameter("table")+"("+string2+") VALUES("+string3+")";
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
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
        resMap.put("msg","操作成功");   // 向Map对象中添加内容
        String resJSON = JSON.toJSONString(resMap);     // 转换为json
        PrintWriter out = response.getWriter();
        out.print(resJSON); // 输出

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}