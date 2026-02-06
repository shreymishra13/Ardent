package com.ardent.backend.configuration;


import com.ardent.backend.entity.AppCacheEntity;
import com.ardent.backend.repository.AppCacheRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class AppCache {

    @Autowired
    AppCacheRepository appCacheRepository;

    private Map<String, String> appCacheMap = new HashMap<>() ;



    @PostConstruct
    public void init(){
        appCacheMap = new HashMap<>();
        List<AppCacheEntity> appCacheList = appCacheRepository.findAll();

        for(AppCacheEntity appCacheEntity : appCacheList){
            appCacheMap.put(appCacheEntity.getKey() , appCacheEntity.getValue());

        }

    }

}
