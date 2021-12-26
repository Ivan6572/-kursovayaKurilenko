package com.example.demo;

import com.example.demo.Model.Data;
import com.example.demo.Service.IDataService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Data controller", description = "Controller for management data with mongo db")
public class DataController {
    private final IDataService iDataService;

    @Autowired
    public DataController(IDataService iDataService) {
        this.iDataService = iDataService;
    }

    @GetMapping(value = "/{id}")
    public Data Get(
            @Parameter(description = "Идентификатор данных") @PathVariable int id
    ) throws Exception {
        return iDataService.Read(id);
    }

    @PostMapping
    public int Create(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ){
        return iDataService.Create(data);
    }

    @PutMapping
    public Data Update(
            @Parameter(description = "Данные в формате json") @RequestBody Data data
    ) throws Exception {
        return iDataService.Update(data);
    }

    @DeleteMapping("/{id}")
    public int Delete(
            @Parameter(description = "Идентификатор данных") @PathVariable int id
    ) throws Exception {
        return iDataService.Delete(id);
    }
}

