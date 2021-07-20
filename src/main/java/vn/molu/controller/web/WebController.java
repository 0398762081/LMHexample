package vn.molu.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.molu.dao.CategoryDAO;
import vn.molu.dao.ProductDAO;
import vn.molu.entity.CategoryEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "homeControllerOfWeb2")
public class WebController {

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/trang-chu2.html", method = RequestMethod.GET)
    public ModelAndView homePage() {
//        CategoryEntity model = new CategoryEntity();
        ModelAndView mav = new ModelAndView("web/home");
//        (categoryDAO.getAllCategory());
//        mav.addObject("listcategory",model);
//        mav.addObject("producthot",productDAO.getProductHot());
//        mav.addObject("listthethao",productDAO.getProductByCategory(code));

        return mav;
    }

    @RequestMapping(value = "/dang-nhap.html", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/thoat.html", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/trang-chu2.html");

    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/dang-nhap.html?accessDenied");
    }

}
