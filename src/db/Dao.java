package db;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;

public class Dao {
    Connection connection=null;
    public JSONArray getAllNews(){
        String SQL="select * from oa.news";
        try {
            connection=ConnectSQL.getConnection();

            Statement statement = connection.createStatement(); //创建Statement对象
            ResultSet resultSet=statement.executeQuery(SQL);
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();

            while(resultSet.next()){
                jsonobj.put("news_id",resultSet.getString("news_id"));
                jsonobj.put("news_title",resultSet.getString("news_title"));
                jsonobj.put("news_content",resultSet.getString("news_content"));
                jsonarray.add(jsonobj);
            }
            connection.close();
            statement.close();
            return jsonarray;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



}
