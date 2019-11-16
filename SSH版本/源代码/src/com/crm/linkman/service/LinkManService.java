package com.crm.linkman.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.linkman.domain.LinkMan;
import com.crm.user.domain.User;
/**
 * 该类是联系人的业务逻辑层的接口类
 * @author 岑洛彬
 *
 */
public interface LinkManService {
	
	//根据当前登入的客户经理按分页查询他负责的客户的所有联系人的信息
	PageBean<LinkMan> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);
	//新增用户
	void save(LinkMan linkMan);
	//根据id找出要进行操作的联系人实体
	LinkMan findById(Integer lkm_id);
	//更新实体
	void edit(LinkMan linkMan);
	//删除实体
	void delete(LinkMan linkMan);
	//根据客户id查出联系人
	PageBean<LinkMan> findByCust(DetachedCriteria dc, Integer currPage, Integer pageSize,Integer cust_id);

}
