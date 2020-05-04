package recipe.app.rest.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.support.ResourceStringUtils;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import recipe.app.rest.model.Recipe;
import recipe.app.rest.repository.RecipeRepository;
import recipe.app.rest.service.RecipeService;

@RepositoryRestController
@CrossOrigin
public class RecipeAppController {
	
	@Autowired
	RecipeRepository recipeRepository;
//	RecipeService recipeService;
	
//	
//	@GetMapping(path = "/getRecipes", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Recipe>> getRecipes(@RequestParam(name = "category") String category) {
//		return null;
//		
//	}
//	
	@PostMapping(path = "recipe/recipeLOCAL", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> saveRecipe (Recipe newRecipe) {
		
		if (newRecipe.getMultiPartRecipeImage().getSize() != 0l) {
			try {
				newRecipe.setRecipeImage(newRecipe.getMultiPartRecipeImage().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Recipe savedRecipe = recipeRepository.save(newRecipe);
		String base64RecipeImage = Base64.getEncoder().encodeToString(savedRecipe.getRecipeImage());
		 
		 //savedRecipe.setRecipeImage(null);
		 savedRecipe.setMultiPartRecipeImage(null);
		// savedRecipe.setBase64RecipeImage(base64RecipeImage);
		
		
		Link selfLink = linkTo(methodOn(RecipeAppController.class)
			      .saveRecipe(newRecipe)).withSelfRel();
		
		EntityModel<Recipe> recipeModel = new EntityModel<>(savedRecipe);
		recipeModel.add(selfLink);
		
			
		return ResponseEntity.ok(recipeModel);
	}
//	
//	@PutMapping(path = "/updateRecipe", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateRecipe (@RequestBody Recipe updatedRecipe) {
//		return null;
//	}

}
