package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private StandardServiceRegistry registry;

    private SessionFactory sf;

    @Override
    public void init() {
        registry = new StandardServiceRegistryBuilder()
                .configure().build();
         sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item itemEdit = findById(id);
        itemEdit.setName(item.getName());
        session.update(itemEdit);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = findById(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void findAllReact(Observe<Item> observe) {

    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item where name = :param1")
                .setParameter("param1", key)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findAllByOrder(String fieldName, String mode) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item order by :fieldName, :mode")
                .setParameter("fieldName", fieldName)
                .setParameter("mode", mode)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> sortAscendId() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item order by id asc").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> sortDescendId() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item order by id desc").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> sortDescendName() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item order by name desc ").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> sortAscendName() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item order by name asc").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
