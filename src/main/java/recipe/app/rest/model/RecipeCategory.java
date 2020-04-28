package recipe.app.rest.model;
// default package

// Generated Apr 16, 2020 3:33:16 PM by Hibernate Tools 5.4.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * RecipeCategory generated by hbm2java
 */
@Entity
@Table(name = "recipe_category", schema = "my_recipes")
public class RecipeCategory implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 4602792355747385336L;
	private int recipeCategoryId;
	private Category category;
	private Recipe recipe;

	public RecipeCategory() {
	}

	public RecipeCategory(int recipeCategoryId, Category category, Recipe recipe) {
		this.recipeCategoryId = recipeCategoryId;
		this.category = category;
		this.recipe = recipe;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeCategorySeq")
	@SequenceGenerator(name = "recipeCategorySeq", sequenceName = "recipe_category_recipe_category_id_seq", allocationSize = 1)
	@Column(name = "recipe_category_id", unique = true, nullable = false)
	public int getRecipeCategoryId() {
		return this.recipeCategoryId;
	}

	public void setRecipeCategoryId(int recipeCategoryId) {
		this.recipeCategoryId = recipeCategoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id", nullable = false)
	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
