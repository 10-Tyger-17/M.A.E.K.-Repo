package model;


public class Category {
	private int id;
	private String category_name;
	private String category_description;
	
	public Category(int id, String category_name, String category_description) {
		this.id = id;
		this.category_name = category_name;
		this.category_description = category_description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Category [id=" + id + ", category_name=" + category_name + ", category_description="
				+ category_description + "]";
	}
	
	
	
	
	

}
