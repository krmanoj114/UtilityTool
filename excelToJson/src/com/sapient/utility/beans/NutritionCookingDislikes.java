package com.sapient.utility.beans;

public class NutritionCookingDislikes {
	
	private String item;
    private Boolean flag;
        
    public NutritionCookingDislikes(){}

    
	public NutritionCookingDislikes(String item, Boolean flag) {
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
