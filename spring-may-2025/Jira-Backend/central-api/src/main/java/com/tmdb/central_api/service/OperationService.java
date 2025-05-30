package com.tmdb.central_api.service;

import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Operation;
import com.tmdb.central_api.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class OperationService {

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    public List<Operation> getAllOperations(){
        return dbApiIntgeration.callGetAllOperationEndpoint();
    }

    public List<Operation> getAllOperationsByOperationName(List<String> oprNameList){
       List<Operation> operations = this.getAllOperations();
       List<Operation> res = new ArrayList<>();
       HashSet<String> oprSet = new HashSet<>(oprNameList);
       for(Operation opr : operations){
           if(oprSet.contains(opr.getName())){
               res.add(opr);
           }
       }
       return res;
    }



}
