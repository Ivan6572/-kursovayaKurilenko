package com.example.demo.Service;

import com.example.demo.Model.Data;
import com.example.demo.Repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DataService implements IDataService {
    private final IRepository iRepository;

    @Autowired
    public DataService(
            @Qualifier("postgreRepo") IRepository iRepository //connect to postgresql
    ){
        this.iRepository = iRepository;
    }

    @Override
    @Async
    public int Create(Data data) {
        data.id = (int) Math.random();
        var id = iRepository.insert(data);

        return id;
    }

    @Override
    public Data Read(int id) throws Exception {
        var data = iRepository.get(id);
        if (data == null)
            throw new Exception();

        return data;
    }

    @Override
    public Data Update(Data newData) throws Exception {
        var currentData = iRepository.get(newData.id);
        if (currentData == null)
            throw new Exception();
        return iRepository.update(newData);
    }

    @Override
    public int Delete(int id) throws Exception {
        var currentData = iRepository.get(id);
        if (currentData == null)
            throw new Exception();

        return iRepository.delete(id);
    }
}

