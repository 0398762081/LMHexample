package vn.molu.service.impl;

import org.springframework.stereotype.Service;
import vn.molu.service.HomeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {


    @Override
    public List<String> loadMenu() {
        List<String> menus = new ArrayList<>();
        menus.add("Sản phẩm");
        menus.add("Giới thiệu");
        menus.add("Tin tức");
        menus.add("Liên hệ");
        return menus;
    }
}
