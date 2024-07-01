package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Category;

import java.util.List;


public interface CategoryService extends IService<Category> {


    public List<Category> getAllCategories() ;

//    public Category getCategoryById(Long id);
//
//    public Category createCategory(Category user);
//
//    public void deleteCategory(Long id);
//
//    public Category getCategoryByCategoryname(String username);
}
