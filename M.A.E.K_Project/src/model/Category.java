package model;


public class Category {
	private String category_name;
	private String category_description;

	public Category(String category_name, String category_description) {
		this.category_name = category_name;
		this.category_description = category_description;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	@Override
	public String toString() {
		return "Category: " + category_name + "    " + "Description: " + category_description;
	}
}
