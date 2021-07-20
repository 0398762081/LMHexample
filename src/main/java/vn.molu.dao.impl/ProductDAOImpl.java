package vn.molu.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import vn.molu.dao.ProductDAO;
import vn.molu.entity.Products;
import vn.molu.util.HibernateUtil;

import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO {

//    @Autowired
//    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<Products> getProductHot() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list =session.createSQLQuery("from"+ Products.class.getName()).list();
            session.getTransaction().commit();
            return list;
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }


    @Override
    public List<Products> getProductByCategory(String categoryCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
             Query query = session.createSQLQuery("from products where category.code = : code");
             query.setParameter(categoryCode,categoryCode);
             List list = query.list();
            session.getTransaction().commit();
            return list;
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Products> getProductByCategoryLimit4(String categoryCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createSQLQuery("from products where category.code = : code");
            query.setParameter(categoryCode,categoryCode);
            query.setMaxResults(4);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }
}
