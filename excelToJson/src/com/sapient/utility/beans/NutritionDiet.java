package com.sapient.utility.beans;

public class NutritionDiet {

	private String item;
    private Boolean flag;
	public NutritionDiet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NutritionDiet(String item, Boolean flag) {
		super();
		this.item = item;
		this.flag = flag;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
        
}
