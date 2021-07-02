package Service;

import Dao.entity.Commodity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommodityService {
    public List<Commodity> GetAllCommodity();
    public void AddCommodity(Commodity commodity);
    List<Commodity> GetCommodityByname(String commodityname);
    void Deleteit(int id);

    Commodity GetDetail(int id);

    void UpdateCommodity(Commodity commodity);
    public  List<Commodity> Searchit(String commodityname,Float price);
}
