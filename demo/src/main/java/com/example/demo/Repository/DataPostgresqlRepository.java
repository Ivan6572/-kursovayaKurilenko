package com.example.demo.Repository;

import com.example.demo.Model.Data;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Properties;
@Component("postgreRepo")
public class DataPostgresqlRepository implements IRepository {
    private Statement statement;

    public DataPostgresqlRepository(){
        try {
            Properties properties = new Properties();
            properties.load(DataPostgresqlRepository.class.getClassLoader().getResourceAsStream("application.properties"));

            String connectionString = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(connectionString, username, password);
            statement = connection.createStatement();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Data get(int id) {
        try {
            String query = "SELECT * FROM furniture_store where id = '" + id + "'";
            var result = statement.executeQuery(query);
            result.next();

            Data dataObj = new Data();
            dataObj.id = Integer.parseInt(result.getString("id"));
            dataObj.name_furniture = result.getString("name_furniture");
            dataObj.description = result.getString("description");

            return dataObj;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public int insert(Data data){
        try{
            String query = "INSERT INTO furniture_store (name_furniture, description) " +
                    "VALUES('" + data.name_furniture + "', '" + data.description + "')";
            statement.executeUpdate(query);
            return data.id;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return 11;
    }

    public Data update(Data data){
        try{
            String query = "UPDATE furniture_store SET " +
                    "name_furniture = '" + data.name_furniture + "'," +
                    "description = '" + data.description +
                    "' WHERE id = '" + data.id + "'";
            statement.executeUpdate(query);
            return data;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public int delete(int id){
        try{
            String query = "DELETE FROM furniture_store WHERE id = '" + id + "'";
            statement.executeUpdate(query);
            return id;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return 0;
    }
}

