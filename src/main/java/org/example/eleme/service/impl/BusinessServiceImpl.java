package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.BusinessMapper;
import org.example.eleme.model.Business;
import org.example.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper,Business>  implements BusinessService {



    public List<Business> getAllBusinesses() {
        return baseMapper.getAll();
    }
    @Override
    public boolean deleteBusinessById(Long id) {
        return this.removeById(id);
    }

}
