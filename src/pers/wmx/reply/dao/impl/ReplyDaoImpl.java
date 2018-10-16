package pers.wmx.reply.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.wmx.reply.dao.ReplyDao;
import pers.wmx.reply.domain.Reply;

public class ReplyDaoImpl extends HibernateDaoSupport implements ReplyDao{

	@Override
	public void save(Reply reply) {
		this.getHibernateTemplate().save(reply);
	}
	
}
