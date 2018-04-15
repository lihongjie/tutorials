package org.disco.racer.domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.Collection;

class RunnerDAOImpl implements RunnerDAO {

    private SessionFactory sessionFactory;

    public RunnerDAOImpl() {
        super();
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection<Runner> findByFirstAndLastName(final String fname, final String lname) {
        final HibernateTemplate hibernateTemplate = new HibernateTemplate(
                this.sessionFactory);

        return (Collection<Runner>) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                return session.createQuery(
                        "from org.disco.racer.domain.Runner as runner where runner.firstName = ? and runner.lastName = ?")
                        .setString(0, fname)
                        .setString(1, lname)
                        .list();
            }
        });
    }

    public Runner findById(final Long id) {

        final HibernateTemplate hibernateTemplate = new HibernateTemplate(
                this.sessionFactory);

        return (Runner) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                return session.createQuery(
                        "from org.disco.racer.domain.Runner as runner where runner.id = ?")
                        .setLong(0, id)
                        .uniqueResult();
            }
        });
    }


    public void create(final Runner runner) {
        final HibernateTemplate tmplte = new HibernateTemplate(
                this.sessionFactory);
        tmplte.save(runner);
    }

    /**
     * @param
     */
    public void update(final Runner runner) {
        final HibernateTemplate tmplte = new HibernateTemplate(
                this.sessionFactory);
        tmplte.saveOrUpdate(runner);
    }

    /**
     * @param
     */
    public void remove(final Runner runner) {
        final HibernateTemplate tmplte = new HibernateTemplate(
                this.sessionFactory);
        tmplte.delete(runner);
    }
}