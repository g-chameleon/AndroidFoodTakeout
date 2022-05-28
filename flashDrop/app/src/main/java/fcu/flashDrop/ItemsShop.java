package fcu.flashDrop;

import java.io.Serializable;

class ItemsShop implements Serializable {


    private int shop_image;
    private String shop_name;
    private String shop_sale;
    private String shop_cost;
    private String shop_welfare;
    private String shop_time;

    public ItemsShop(int shop_image, String shop_name, String shop_price,String shop_sale,String shop_cost,String shop_welfare,String shop_time) {
        this.shop_image = shop_image;
        this.shop_name = shop_name;
        this.shop_sale = shop_sale;
        this.shop_cost = shop_cost;
        this.shop_welfare = shop_welfare;
        this.shop_time = shop_time;
    }

    public int getShop_image() {return shop_image;}
    public void setShop_image(int food_image) {this.shop_image = shop_image;}

    public String getShop_name() {return shop_name;}
    public void setShop_name(String food_name) {this.shop_name = shop_name;}

    public String getShop_sale() { return shop_sale;}
    public void setShop_sale(String food_sale){this.shop_sale = shop_sale;}

    public String getShop_cost() { return shop_cost;}
    public void setShop_cost(String food_cost){this.shop_cost= shop_cost;}

    public String getShop_welfare() { return shop_welfare;}
    public void setShop_welfare(String food_welfare){this.shop_welfare = shop_welfare;}

    public String getShop_time() { return shop_time;}
    public void setShop_time(String food_time){this.shop_time = shop_time;}
}
