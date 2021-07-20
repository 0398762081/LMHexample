package vn.molu.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import vn.molu.dao.CategoryDAO;
import vn.molu.entity.CategoryEntity;
import vn.molu.util.HibernateUtil;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            String hql ="FROM CategoryEntity";
            List<CategoryEntity> list =session.createQuery(hql,CategoryEntity.class).list();
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
