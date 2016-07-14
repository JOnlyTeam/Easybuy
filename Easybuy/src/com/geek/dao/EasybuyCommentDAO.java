package com.geek.dao;

import com.geek.bean.EasybuyComment;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * EasybuyComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.geek.bean.EasybuyComment
 * @author MyEclipse Persistence Tools
 */
public class EasybuyCommentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EasybuyCommentDAO.class);
	// property constants
	public static final String EC_REPLY = "ecReply";
	public static final String EC_CONTENT = "ecContent";
	public static final String EC_NICK_NAME = "ecNickName";

	public void save(EasybuyComment transientInstance) {
		log.debug("saving EasybuyComment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EasybuyComment persistentInstance) {
		log.debug("deleting EasybuyComment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EasybuyComment findById(java.lang.Integer id) {
		log.debug("getting EasybuyComment instance with id: " + id);
		try {
			EasybuyComment instance = (EasybuyComment) getSession().get(
					"com.geek.bean.EasybuyComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EasybuyComment instance) {
		log.debug("finding EasybuyComment instance by example");
		try {
			List results = getSession()
					.createCriteria("com.geek.bean.EasybuyComment")
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
		log.debug("finding EasybuyComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EasybuyComment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEcReply(Object ecReply) {
		return findByProperty(EC_REPLY, ecReply);
	}

	public List findByEcContent(Object ecContent) {
		return findByProperty(EC_CONTENT, ecContent);
	}

	public List findByEcNickName(Object ecNickName) {
		return findByProperty(EC_NICK_NAME, ecNickName);
	}

	public List findAll() {
		log.debug("finding all EasybuyComment instances");
		try {
			String queryString = "from EasybuyComment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EasybuyComment merge(EasybuyComment detachedInstance) {
		log.debug("merging EasybuyComment instance");
		try {
			EasybuyComment result = (EasybuyComment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EasybuyComment instance) {
		log.debug("attaching dirty EasybuyComment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EasybuyComment instance) {
		log.debug("attaching clean EasybuyComment instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}