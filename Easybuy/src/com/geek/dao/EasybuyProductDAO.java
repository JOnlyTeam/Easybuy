package com.geek.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geek.bean.EasybuyProduct;

/**
 * A data access object (DAO) providing persistence and search support for
 * EasybuyProduct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.geek.bean.EasybuyProduct
 * @author MyEclipse Persistence Tools
 */
public class EasybuyProductDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EasybuyProductDAO.class);
	// property constants
	public static final String EP_NAME = "epName";
	public static final String EP_DESCRIPTION = "epDescription";
	public static final String EP_PRICE = "epPrice";
	public static final String EP_STOCK = "epStock";
	public static final String EPC_ID = "epcId";
	public static final String EPC_CHILD_ID = "epcChildId";
	public static final String EP_FILE_NAME = "epFileName";
	public static final String EP_BARGAIN = "epBargain";

	public void save(EasybuyProduct transientInstance) {
		log.debug("saving EasybuyProduct instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EasybuyProduct persistentInstance) {
		log.debug("deleting EasybuyProduct instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EasybuyProduct findById(java.lang.Integer id) {
		log.debug("getting EasybuyProduct instance with id: " + id);
		try {
			EasybuyProduct instance = (EasybuyProduct) getSession().get(
					"com.geek.bean.EasybuyProduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EasybuyProduct instance) {
		log.debug("finding EasybuyProduct instance by example");
		try {
			List results = getSession()
					.createCriteria("com.geek.bean.EasybuyProduct")
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
		log.debug("finding EasybuyProduct instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EasybuyProduct as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEpName(Object epName) {
		return findByProperty(EP_NAME, epName);
	}

	public List findByEpDescription(Object epDescription) {
		return findByProperty(EP_DESCRIPTION, epDescription);
	}

	public List findByEpPrice(Object epPrice) {
		return findByProperty(EP_PRICE, epPrice);
	}

	public List findByEpStock(Object epStock) {
		return findByProperty(EP_STOCK, epStock);
	}

	public List findByEpcId(Object epcId) {
		return findByProperty(EPC_ID, epcId);
	}

	public List findByEpcChildId(Object epcChildId) {
		return findByProperty(EPC_CHILD_ID, epcChildId);
	}

	public List findByEpFileName(Object epFileName) {
		return findByProperty(EP_FILE_NAME, epFileName);
	}

	public List findByEpBargain(Object epBargain) {
		return findByProperty(EP_BARGAIN, epBargain);
	}

	public List findAll() {
		log.debug("finding all EasybuyProduct instances");
		try {
			String queryString = "from EasybuyProduct";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EasybuyProduct merge(EasybuyProduct detachedInstance) {
		log.debug("merging EasybuyProduct instance");
		try {
			EasybuyProduct result = (EasybuyProduct) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EasybuyProduct instance) {
		log.debug("attaching dirty EasybuyProduct instance");
		try {
			Session session = getSession();
			session.saveOrUpdate(instance);
			session.flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EasybuyProduct instance) {
		log.debug("attaching clean EasybuyProduct instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}