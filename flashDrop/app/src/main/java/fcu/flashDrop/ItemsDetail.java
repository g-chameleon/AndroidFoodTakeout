package fcu.flashDrop;

import java.io.Serializable;

class ItemsDetail implements Serializable {


    private int food_image;
    private String food_name;
    private String food_taste;
    private String food_sale;
    private String food_price;

    public ItemsDetail(int food_image,String food_name,String food_taste,String food_sale,String food_price) {
        this.food_image = food_image;
        this.food_name = food_name;
        this.food_taste = food_taste;
        this.food_sale = food_sale;
        this.food_price = food_price;
    }


    public int getFood_image() {return food_image;}
    public void setFood_image(int food_image) {this.food_image = food_image;}

    public String getFood_name() {return food_name;}
    public void setFood_name(String food_name) {this.food_name = food_name;}

    public String getFood_taste() { return food_taste;}
    public void setFood_taste(String food_taste){this.food_taste = food_taste;}

    public String getFood_sale() { return food_sale;}
    public void setFood_sale(String food_sale){this.food_sale= food_sale;}

    public String getFood_price() { return food_price;}
    public void setFood_price(String food_price){this.food_price = food_price;}

}
