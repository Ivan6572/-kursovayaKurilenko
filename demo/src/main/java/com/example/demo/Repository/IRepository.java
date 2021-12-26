package com.example.demo.Repository;

import com.example.demo.Model.Data;
public interface IRepository {
    int insert(Data data);
    Data get(int id) throws Exception;
    Data update(Data newData) throws Exception;
    int delete(int id) throws Exception;
}

