package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.module.contacts.Contacts;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.ContactsTagR;
import net.simpleframework.module.contacts.IContactsService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsService extends AbstractContactsService<Contacts> implements IContactsService {

	@Override
	public IDataQuery<Contacts> queryContacts(final Object org, final ContactsTag... tags) {
		final StringBuilder sql = new StringBuilder();
		final List<Object> params = new ArrayList<Object>();
		if (tags == null || tags.length == 0) {
			sql.append("1=1");
			if (org != null) {
				sql.append(" and orgid=?");
				params.add(getIdParam(org));
			} else {
				sql.append(" and orgid is null");
			}
			return query(sql, params.toArray());
		} else {
			sql.append("select c.* from ").append(getTablename(Contacts.class))
					.append(" c right join (select distinct contactsid from ")
					.append(getTablename(ContactsTagR.class)).append(" where (");
			int i = 0;
			for (final ContactsTag tag : tags) {
				if (i++ > 0) {
					sql.append(" or ");
				}
				sql.append("tagid=?");
				params.add(tag.getId());
			}
			sql.append(")) t on c.id=t.contactsid where 1=1");
			if (org != null) {
				sql.append(" and c.orgid=?");
				params.add(getIdParam(org));
			} else {
				sql.append(" and c.orgid is null");
			}
			return query(new SQLValue(sql, params.toArray()));
		}
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<Contacts>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<Contacts> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				for (final Contacts contacts : coll(manager, paramsValue)) {
					// 删除标签关联
					_contactsTagRService.deleteWith("contactsid=?", contacts.getId());
				}
			}
		});
	}
}