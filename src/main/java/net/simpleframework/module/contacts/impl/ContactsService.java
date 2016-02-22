package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
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
	public IDataQuery<Contacts> queryContacts(final ID orgId, final ContactsTag... tags) {
		final StringBuilder sql = new StringBuilder();
		final List<Object> params = new ArrayList<Object>();
		if (tags == null || tags.length == 0) {
			sql.append("1=1");
			if (orgId != null) {
				sql.append(" and (orgid=? or orgid is null)");
				params.add(orgId);
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
			if (orgId != null) {
				sql.append(" and (c.orgid=? or c.orgid is null)");
				params.add(orgId);
			}
			return query(new SQLValue(sql, params.toArray()));
		}
	}
}