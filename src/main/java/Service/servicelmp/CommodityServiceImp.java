package Service.servicelmp;

import Dao.entity.Commodity;
import Dao.mapper.CommodityMapper;
import Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommodityServiceImp implements CommodityService {
    private CommodityMapper commodityDao;
    @Autowired
    public void setCommodityDao(CommodityMapper commodityDao){this.commodityDao=commodityDao;}

    @Override
    public List<Commodity> GetAllCommodity() {
        return commodityDao.GetAllCommodity();
    }

    @Override
    public void AddCommodity(Commodity commodity) {
        commodityDao.AddCommodity(commodity);
    }

    @Override
    public List<Commodity> GetCommodityByname(String commodityname) {
        return commodityDao.GetCommodityByname(commodityname);
    }

    @Override
    public void Deleteit(int id) {
        commodityDao.Deleteit(id);
    }

    @Override
    public Commodity GetDetail(int id) {
        return commodityDao.GetDetail(id);
    }

    @Override
    public void UpdateCommodity(Commodity commodity) {
        commodityDao.UpdateCommodity(commodity);

    }

    @Override
    public List<Commodity> Searchit(String commodityname, Float price) {
        return commodityDao.Searchit(commodityname,price);
    }
}
