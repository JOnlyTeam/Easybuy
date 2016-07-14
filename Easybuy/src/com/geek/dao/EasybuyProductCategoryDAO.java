package com.geek.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geek.bean.EasybuyProductCategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * EasybuyProductCategory entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.geek.bean.EasybuyProductCategory
 * @author MyEclipse Persistence Tools
 */
public class EasybuyProductCategoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EasybuyProductCategoryDAO.class);
	// property constants
	public static final String EPC_NAME = "epcName";
	public static final String EPC_PARENT_ID = "epcParentId";

	public void save(EasybuyProductCategory transientInstance) {
		log.debug("saving EasybuyProductCategory instance");
		try {
			Session session = getSession();
			session.save(transientInstance);
			session.flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EasybuyProductCategory persistentInstance) {
		log.debug("deleting EasybuyProductCategory instance");
		try {
			Session session = getSession();
			session.delete(persistentInstance);
			session.flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EasybuyProductCategory findById(java.lang.Integer id) {
		log.debug("getting EasybuyProductCategory instance with id: " + id);
		try {
			EasybuyProductCategory instance = (EasybuyProductCategory) getSession()
					.get("com.geek.bean.EasybuyProductCategory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EasybuyProductCategory instance) {
		log.debug("finding EasybuyProductCategory instance by example");
		try {
			List results = getSession()
					.createCriteria("com.geek.bean.EasybuyProductCategory")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EasybuyProductCategory instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EasybuyProductCategory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEpcName(Object epcName) {
		return findByProperty(EPC_NAME, epcName);
	}

	public List findByEpcParentId(Object epcParentId) {
		return findByProperty(EPC_PARENT_ID, epcParentId);
	}

	public List findAll() {
		log.debug("finding all EasybuyProductCategory instances");
		try {
			String queryString = "from EasybuyProductCategory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EasybuyProductCategory merge(EasybuyProductCategory detachedInstance) {
		log.debug("merging EasybuyProductCategory instance");
		try {
			EasybuyProductCategory result = (EasybuyProductCategory) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EasybuyProductCategory instance) {
		log.debug("attaching dirty EasybuyProductCategory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EasybuyProductCategory instance) {
		log.debug("attaching clean EasybuyProductCategory instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}