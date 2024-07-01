package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.CategoryMapper;
import org.example.eleme.model.Category;
import org.example.eleme.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category>  implements CategoryService {



    public List<Category> getAllCategories() {
        return baseMapper.getAll();
    }

//    public Category getCategoryById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public Category createCategory(Category user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteCategory(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public Category getCategoryByCategoryname(String username) {
//        return userRepository.findByCategoryname(username);
//    }
}
