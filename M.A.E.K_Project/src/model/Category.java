package model;

/**
 * The Category class represents a category with a name and description.
 * It provides methods to get and set the category's name and description.
 */
public class Category {
    private String category_name;
    private String category_description;

    /**
     * Constructs a new Category with the specified name and description.
     *
     * @param category_name the name of the category
     * @param category_description the description of the category
     */
    public Category(String category_name, String category_description) {
        this.category_name = category_name;
        this.category_description = category_description;
    }

    /**
     * Returns the name of the category.
     *
     * @return the category name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * Sets the name of the category.
     *
     * @param category_name the new category name
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * Returns the description of the category.
     *
     * @return the category description
     */
    public String getCategory_description() {
        return category_description;
    }

    /**
     * Sets the description of the category.
     *
     * @param category_description the new category description
     */
    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    /**
     * Returns a string representation of the category.
     *
     * @return a string representation of the category
     */
    @Override
    public String toString() {
        return "Category: " + category_name + "    " + "Description: " + category_description;
    }
}