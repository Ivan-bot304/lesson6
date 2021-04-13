import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DistrictDAO {

    public void save(District parents) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction tx1 = session.beginTransaction();
        session.save(parents);
        tx1.commit();
        session.close();
    }

    public List<District> find() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String sql = "select * from District";
        Query query = session.createSQLQuery(sql).addEntity(District.class);
        List result = query.list();
        session.close();

        return result;
    }
}
