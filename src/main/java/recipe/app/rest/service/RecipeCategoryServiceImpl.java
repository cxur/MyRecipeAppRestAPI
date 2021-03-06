package recipe.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipe.app.rest.model.RecipeCategory;
import recipe.app.rest.repository.RecipeCategoryRepository;

/**
* Generated by Spring Data Generator on 16/04/2020
*/
@Component
public class RecipeCategoryServiceImpl {

	private RecipeCategoryRepository recipeCategoryRepository;

	@Autowired
	public RecipeCategoryServiceImpl(RecipeCategoryRepository recipeCategoryRepository) {
		this.recipeCategoryRepository = recipeCategoryRepository;
	}

}
