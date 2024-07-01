package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Business;
import java.util.List;


public interface  BusinessService extends IService<Business> {


    public List<Business> getAllBusinesses() ;

//    public Business getBusinessById(Long id);
//
//    public Business createBusiness(Business business);
//
//    public void deleteBusiness(Long id);
//
//    public Business getBusinessByBusinessname(String businessname);
}
