package recipe.app.rest.model;
// default package

// Generated Apr 16, 2020 3:33:16 PM by Hibernate Tools 5.4.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import recipe.app.rest.converters.ImageConverter;

/**
 * Recipe generated by hbm2java
 */
@Entity
@Table(name = "recipe", schema = "my_recipes")
public class Recipe implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 3154870534609294756L;
	private Integer recipeId;
	private AppUser appUser;
	private String recipeName;
	private String recipeIngredients;
	private String recipeSteps;
	private byte[] recipeImage;
	private MultipartFile multiPartRecipeImage;
	private String base64RecipeImage;
	
	private String recipeUrl;
	private String recipeImageUrl;
	private String recipeSource;
	private String recipeComments;
	private Set<RecipeCategory> recipeCategories = new HashSet<RecipeCategory>(0);

	public Recipe() {
	}

	public Recipe(Integer recipeId, String recipeName, String recipeIngredients, String recipeSource,
			AppUser appUser) {
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.recipeIngredients = recipeIngredients;
		this.recipeSource = recipeSource;
		this.appUser = appUser;
	}

	public Recipe(Integer recipeId, String recipeName, String recipeIngredients, String recipeSteps, byte[] recipeImage,
			String recipeUrl, String recipeImageUrl, String recipeSource, String recipeComments, AppUser appUser,
			MultipartFile multiPartRecipeImage , Set<RecipeCategory> recipeCategories) {
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.recipeIngredients = recipeIngredients;
		this.recipeSteps = recipeSteps;
		this.recipeImage = recipeImage;
		this.multiPartRecipeImage = multiPartRecipeImage;
		this.recipeUrl = recipeUrl;
		this.recipeImageUrl = recipeImageUrl;
		this.recipeSource = recipeSource;
		this.recipeComments = recipeComments;
		this.appUser = appUser;
		this.recipeCategories = recipeCategories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSeq")
	@SequenceGenerator(name = "recipeSeq", sequenceName = "recipe_recipe_id_seq", allocationSize = 1)
	@Column(name = "recipe_id", unique = true, nullable = false)
	public Integer getRecipeId() {
		return this.recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	@Column(name = "recipe_name", nullable = false)
	public String getRecipeName() {
		return this.recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	@Column(name = "recipe_ingredients", nullable = false)
	public String getRecipeIngredients() {
		return this.recipeIngredients;
	}

	public void setRecipeIngredients(String recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	@Column(name = "recipe_steps")
	public String getRecipeSteps() {
		return this.recipeSteps;
	}

	public void setRecipeSteps(String recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	@Column(name = "recipe_image")
	public byte[] getRecipeImage() {
		return this.recipeImage;
	}
	
	

	public void setRecipeImage(byte[] recipeImage) {
		this.recipeImage = recipeImage;
	}

	@Column(name = "recipe_url")
	public String getRecipeUrl() {
		return this.recipeUrl;
	}

	public void setRecipeUrl(String recipeUrl) {
		this.recipeUrl = recipeUrl;
	}

	@Column(name = "recipe_image_url")
	public String getRecipeImageUrl() {
		return this.recipeImageUrl;
	}

	public void setRecipeImageUrl(String recipeImageUrl) {
		this.recipeImageUrl = recipeImageUrl;
	}

	@Column(name = "recipe_source", nullable = false)
	public String getRecipeSource() {
		return this.recipeSource;
	}

	public void setRecipeSource(String recipeSource) {
		this.recipeSource = recipeSource;
	}

	@Column(name = "recipe_comments")
	public String getRecipeComments() {
		return this.recipeComments;
	}

	public void setRecipeComments(String recipeComments) {
		this.recipeComments = recipeComments;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_user_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Transient
	public MultipartFile getMultiPartRecipeImage() {
		return multiPartRecipeImage;
	}

	public void setMultiPartRecipeImage(MultipartFile multiPartRecipeImage) {
		this.multiPartRecipeImage = multiPartRecipeImage;
	}
	
	@Transient	
	public String getBase64RecipeImage() {
		return base64RecipeImage;
	}

	public void setBase64RecipeImage(String base64RecipeImage) {
		this.base64RecipeImage = base64RecipeImage;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
	public Set<RecipeCategory> getRecipeCategories() {
		return this.recipeCategories;
	}

	public void setRecipeCategories(Set<RecipeCategory> recipeCategories) {
		this.recipeCategories = recipeCategories;
	}

}
