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
 * Stockin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Stockin
 * @author MyEclipse Persistence Tools
 */

public class StockinDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(StockinDAO.class);
	// property constants
	public static final String PURCHASED_PRICE = "purchasedPrice";
	public static final String STOCK_IN_QUANTITY = "stockInQuantity";
	public static final String SUPPLIER = "supplier";
	public static final String REMARK = "remark";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Stockin transientInstance)
	{
		log.debug("saving Stockin instance");
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

	public void delete(Stockin persistentInstance)
	{
		log.debug("deleting Stockin instance");
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

	public Stockin findById(java.lang.Integer id)
	{
		log.debug("getting Stockin instance with id: " + id);
		try
		{
			Stockin instance = (Stockin) getHibernateTemplate().get(
					"com.usc.daos.Stockin", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stockin instance)
	{
		log.debug("finding Stockin instance by example");
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
		log.debug("finding Stockin instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Stockin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPurchasedPrice(Object purchasedPrice)
	{
		return findByProperty(PURCHASED_PRICE, purchasedPrice);
	}

	public List findByStockInQuantity(Object stockInQuantity)
	{
		return findByProperty(STOCK_IN_QUANTITY, stockInQuantity);
	}

	public List findBySupplier(Object supplier)
	{
		return findByProperty(SUPPLIER, supplier);
	}

	public List findByRemark(Object remark)
	{
		return findByProperty(REMARK, remark);
	}

	public List findAll()
	{
		log.debug("finding all Stockin instances");
		try
		{
			String queryString = "from Stockin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stockin merge(Stockin detachedInstance)
	{
		log.debug("merging Stockin instance");
		try
		{
			Stockin result = (Stockin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stockin instance)
	{
		log.debug("attaching dirty Stockin instance");
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

	public void attachClean(Stockin instance)
	{
		log.debug("attaching clean Stockin instance");
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

	public static StockinDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (StockinDAO) ctx.getBean("StockinDAO");
	}
}