import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SchoolDAO {
    public void save(School parents) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction tx1 = session.beginTransaction();
        session.save(parents);
        tx1.commit();
        session.close();
    }

    public School findById(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(School.class, id);
    }

    public List<School> find() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String sql = "select * from school";
        Query query = session.createSQLQuery(sql).addEntity(School.class);
        List result = query.list();
        session.close();

        return result;
    }
}
