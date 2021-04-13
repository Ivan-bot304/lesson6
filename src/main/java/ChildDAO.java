import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChildDAO {

    public void save(Child child) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction tx1 = session.beginTransaction();
        session. save(child);
        tx1.commit();
        session.close();
    }

    public void update(Child user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public Child findById(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(Child.class, id);
    }

    public List<Child> find() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String sql = "select * from child";
        Query query = session.createSQLQuery(sql).addEntity(Child.class);
        List result = query.list();
        session.close();

        return result;
    }
}
