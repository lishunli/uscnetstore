package com.usc.daos;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Consumptiondetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.usc.daos.Consumptiondetail
 * @author MyEclipse Persistence Tools
 */

public class ConsumptiondetailDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory
			.getLog(ConsumptiondetailDAO.class);
	// property constants
	public static final String LAST = "last";
	public static final String CURRENT = "current";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Consumptiondetail transientInstance)
	{
		log.debug("saving Consumptiondetail instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Consumptiondetail persistentInstance)
	{
		log.debug("deleting Consumptiondetail instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Consumptiondetail findById(java.lang.Integer id)
	{
		log.debug("getting Consumptiondetail instance with id: " + id);
		try
		{
			Consumptiondetail instance = (Consumptiondetail) getHibernateTemplate()
					.get("com.usc.daos.Consumptiondetail", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Consumptiondetail instance)
	{
		log.debug("finding Consumptiondetail instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Consumptiondetail instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from Consumptiondetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLast(Object last)
	{
		return findByProperty(LAST, last);
	}

	public List findByCurrent(Object current)
	{
		return findByProperty(CURRENT, current);
	}

	public List findAll()
	{
		log.debug("finding all Consumptiondetail instances");
		try
		{
			String queryString = "from Consumptiondetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Consumptiondetail merge(Consumptiondetail detachedInstance)
	{
		log.debug("merging Consumptiondetail instance");
		try
		{
			Consumptiondetail result = (Consumptiondetail) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Consumptiondetail instance)
	{
		log.debug("attaching dirty Consumptiondetail instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Consumptiondetail instance)
	{
		log.debug("attaching clean Consumptiondetail instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ConsumptiondetailDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (ConsumptiondetailDAO) ctx.getBean("ConsumptiondetailDAO");
	}
}