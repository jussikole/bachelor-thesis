package sport.item;

import io.db.HibernateUtil;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@MappedSuperclass
public abstract class Item {
	private Logger log = Logger.getLogger(Item.class);
	private int id;
	
	@Id
	@GeneratedValue()
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public abstract String toString();
	
	public void save() {
		HibernateUtil.begin();
		boolean success = true;
		try {
			HibernateUtil.save(this);
		} catch(Exception e) {
			success = false;
		}
		HibernateUtil.commit(success);
		log.info("Saved " + this.toString());
	}
	
	protected static Object findById(String model, int id) {
		Query query = HibernateUtil.createQuery("FROM " + model + " WHERE id = :id");
		query.setParameter("id", id);
		Object result = query.uniqueResult();
		return result;
	}
	
	protected static Object findByName(String model, String name) {
		Query query = HibernateUtil.createQuery("FROM " + model + " WHERE name = :name");
		query.setParameter("name", name);
		Object result = query.uniqueResult();
		HibernateUtil.closeSession();
		return result;
	}
}
