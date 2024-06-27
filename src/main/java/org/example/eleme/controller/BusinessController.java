package org.example.eleme.controller;

import org.example.eleme.model.Business;
import org.example.eleme.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    // 获取所有商家信息
    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    // 根据ID获取商家信息
    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    // 创建新的商家
    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessRepository.save(business);
    }

    // 更新商家信息
    @PutMapping("/{id}")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business businessDetails) {
        Business business = businessRepository.findById(id).orElse(null);
        if (business != null) {
            business.setName(businessDetails.getName());
            business.setDescription(businessDetails.getDescription());
            business.setAddress(businessDetails.getAddress());
            business.setPhone(businessDetails.getPhone());
            return businessRepository.save(business);
        }
        return null;
    }

    // 删除商家
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessRepository.deleteById(id);
    }
}
