package recipe.app.rest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import recipe.app.rest.model.Recipe;

@RestController
@RequestMapping(path = "/recipe_app/v1/")
public class RecipeAppController {
	
	@GetMapping(path = "/getRecipes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getRecipes(@RequestParam(name = "category") String category) {
		return null;
		
	}
	
	@PostMapping(path = "/saveRecipe", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveRecipe (@RequestBody Recipe newRecipe) {
		return null;
	}
	
	@PutMapping(path = "/updateRecipe", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateRecipe (@RequestBody Recipe updatedRecipe) {
		return null;
	}

}
