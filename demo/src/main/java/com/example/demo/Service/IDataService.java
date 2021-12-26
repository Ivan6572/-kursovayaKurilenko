package com.example.demo.Service;

import com.example.demo.Model.Data;

public interface IDataService {
    int     Create(Data data);
    Data    Read(int id) throws Exception;
    Data    Update(Data data) throws Exception;
    int     Delete(int id) throws Exception;
}
