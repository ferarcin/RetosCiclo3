package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId() == null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux = categoryRepository.getCategory(c.getId());
            if(caux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> c=categoryRepository.getCategory(category.getId());

            if(!c.isEmpty()){
                if(category.getName()!=null){
                    c.get().setName(category.getName());
                }

                if(category.getDescription()!=null){
                    c.get().setDescription(category.getDescription());
                }

                categoryRepository.save(c.get());
                return c.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean deleteCategory(int id){
        Boolean aRespuesta = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aRespuesta;
    }
}
