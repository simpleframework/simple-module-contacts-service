package net.simpleframework.module.contacts;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IMyContactsService extends IDbBeanService<MyContacts> {

	/**
	 * 
	 * @param user
	 * @param tags
	 * @return
	 */
	IDataQuery<MyContacts> queryMyContacts(Object user, MyContactsTag... tags);
}
