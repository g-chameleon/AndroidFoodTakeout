package fcu.flashDrop;

public class ItemsDetailHead {
    private int shop_image;
    private String shop_name;
    private String shop_time;

    public ItemsDetailHead(int shop_image,String shop_name,String shop_time) {
        this.shop_image = shop_image;
        this.shop_name = shop_name;
        this.shop_time = shop_time;
    }


    public int getShop_image() {return shop_image;}
    public void setShop_image(int shop_image) {this.shop_image = shop_image;}

    public String getShop_name() {return shop_name;}
    public void setShop_name(String shop_name) {this.shop_name = shop_name;}

    public String getShop_time() { return shop_time;}
    public void setShop_time(String shop_time){this.shop_time = shop_time;}
}
