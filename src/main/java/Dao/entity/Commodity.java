package Dao.entity;

public class Commodity {
    private Integer id;
    private String commodityname;
    private Float price;

    public Commodity(String commodityname, Float price) {
        this.commodityname = commodityname;
        this.price = price;
    }

    public Commodity(Integer id, String commodityname, Float price) {
        this.id = id;
        this.commodityname = commodityname;
        this.price = price;
    }

    public Commodity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
