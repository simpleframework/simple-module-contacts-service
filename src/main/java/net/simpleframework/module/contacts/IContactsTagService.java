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
public interface IContactsTagService extends IDbBeanService<ContactsTag> {

	/**
	 * 添加联系人标签
	 * 
	 * @param orgId
	 * @param text
	 * @param description
	 * @return
	 */
	ContactsTag addContactsTag(ID orgId, String text, String description);

	/**
	 * 查询机构下标签
	 * 
	 * @param org
	 * @return
	 */
	IDataQuery<ContactsTag> queryOrgTags(Object org);
}
