package net.simpleframework.module.contacts;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IMyContactsTagService extends IDbBeanService<MyContactsTag> {

	/**
	 * 添加我的联系人
	 * 
	 * @param userId
	 * @param text
	 * @param description
	 * @return
	 */
	MyContactsTag addContactsTag(ID userId, String text, String description);

	IDataQuery<MyContactsTag> queryMyTags(Object user);

	/**
	 * 获取标签
	 * 
	 * @param user
	 * @param text
	 * @param create
	 * @return
	 */
	MyContactsTag getMyContactsTag(Object user, String text, boolean create);
}
