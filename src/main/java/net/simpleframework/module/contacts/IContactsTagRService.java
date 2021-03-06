package net.simpleframework.module.contacts;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IContactsTagRService extends IDbBeanService<ContactsTagR> {

	ContactsTagR addContactsTagR(Contacts contacts, ContactsTag tag);

	/**
	 * 获取联系人标签
	 * 
	 * @param contacts
	 * @return
	 */
	IDataQuery<ContactsTagR> queryTagRs(Contacts contacts);
}
