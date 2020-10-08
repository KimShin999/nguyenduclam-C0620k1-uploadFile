package service.LandScape;

import Model.LandScape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanScapeService implements ILanScapeService {
    private static Map<Long, LandScape> listLandScape;
    static {
        listLandScape = new HashMap<>();
        listLandScape.put(1L, new LandScape(1L, "Mã Phí Lèng", "Việt Nam", "MaPhiLeng.jpg"));
        listLandScape.put(2L, new LandScape(2L,"Ô Quý Hồ", "Việt Nam", "OQuyHo.jpg"));
        listLandScape.put(3L, new LandScape(3L,"Pha Đin", "Việt Nam", "PhaDin.jpg"));
        listLandScape.put(4L, new LandScape(4L,"Khau Phạ", "Việt Nam", "KhauPha.jpg"));
    }

    @Override
    public List<LandScape> findAll() {
        ArrayList list = new ArrayList<>(listLandScape.values());
        return list;
    }

    @Override
    public LandScape findById(Long id) {
        return listLandScape.get(id);
    }

    @Override
    public void update(LandScape model) {
        listLandScape.put(model.getId(), model);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void save(LandScape model) {
        Long stt = listLandScape.size() + 1L;
        model.setId(stt);
        listLandScape.put(stt, model);

    }
}
