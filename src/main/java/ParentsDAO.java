import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ParentsDAO {

    public void save(Parent parents) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction tx1 = session.beginTransaction();
        session.save(parents);
        tx1.commit();
        session.close();
    }

    public void update(Parent user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public List<Parent> find() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String sql = "select * from Parent";
        Query query = session.createSQLQuery(sql).addEntity(Parent.class);
        List result = query.list();
        session.close();

        return result;
    }

}
