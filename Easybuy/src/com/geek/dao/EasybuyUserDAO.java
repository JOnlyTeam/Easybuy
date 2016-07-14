package com.geek.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geek.bean.EasybuyUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * EasybuyUser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.geek.dao.EasybuyUser
 * @author MyEclipse Persistence Tools
 */
public class EasybuyUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EasybuyUserDAO.class);
	// property constants
	public static final String EU_USER_NAME = "euUserName";
	public static final String EU_PASSWORD = "euPassword";
	public static final String EU_SEX = "euSex";
	public static final String EU_BIRTHDAY = "euBirthday";
	public static final String EU_IDENTITY_CODE = "euIdentityCode";
	public static final String EU_EMAIL = "euEmail";
	public static final String EU_MOBILE = "euMobile";
	public static final String EU_ADDRESS = "euAddress";
	public static final String EU_STATUS = "euStatus";

	public void save(EasybuyUser transientInstance) {
		log.debug("saving EasybuyUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EasybuyUser persistentInstance) {
		log.debug("deleting EasybuyUser instance");
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

	public EasybuyUser findById(java.lang.Integer id) {
		log.debug("getting EasybuyUser instance with id: " + id);
		try {
			EasybuyUser instance = (EasybuyUser) getSession().get(
					"com.geek.bean.EasybuyUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EasybuyUser instance) {
		log.debug("finding EasybuyUser instance by example");
		try {
			List results = getSession()
					.createCriteria("com.geek.dao.EasybuyUser")
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
		log.debug("finding EasybuyUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EasybuyUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEuUserName(Object euUserName) {
		return findByProperty(EU_USER_NAME, euUserName);
	}

	public List findByEuPassword(Object euPassword) {
		return findByProperty(EU_PASSWORD, euPassword);
	}

	public List findByEuSex(Object euSex) {
		return findByProperty(EU_SEX, euSex);
	}

	public List findByEuBirthday(Object euBirthday) {
		return findByProperty(EU_BIRTHDAY, euBirthday);
	}

	public List findByEuIdentityCode(Object euIdentityCode) {
		return findByProperty(EU_IDENTITY_CODE, euIdentityCode);
	}

	public List findByEuEmail(Object euEmail) {
		return findByProperty(EU_EMAIL, euEmail);
	}

	public List findByEuMobile(Object euMobile) {
		return findByProperty(EU_MOBILE, euMobile);
	}

	public List findByEuAddress(Object euAddress) {
		return findByProperty(EU_ADDRESS, euAddress);
	}

	public List findByEuStatus(Object euStatus) {
		return findByProperty(EU_STATUS, euStatus);
	}

	public List findAll() {
		log.debug("finding all EasybuyUser instances");
		try {
			String queryString = "from EasybuyUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EasybuyUser merge(EasybuyUser detachedInstance) {
		log.debug("merging EasybuyUser instance");
		try {
			EasybuyUser result = (EasybuyUser) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EasybuyUser instance) {
		log.debug("attaching dirty EasybuyUser instance");
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

	public void attachClean(EasybuyUser instance) {
		log.debug("attaching clean EasybuyUser instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}