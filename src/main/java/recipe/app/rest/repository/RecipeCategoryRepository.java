package recipe.app.rest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import recipe.app.rest.model.RecipeCategory;

/**
* Generated by Spring Data Generator on 16/04/2020
*/
@RepositoryRestResource(path = "recipeCategory")
@CrossOrigin
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer>{

}
