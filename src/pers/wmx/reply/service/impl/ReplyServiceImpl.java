package pers.wmx.reply.service.impl;

import pers.wmx.reply.dao.ReplyDao;
import pers.wmx.reply.domain.Reply;
import pers.wmx.reply.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}



	@Override
	public void save(Reply reply) {
		replyDao.save(reply);
		
	}



	

}
