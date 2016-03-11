package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.ContactsTagR;
import net.simpleframework.module.contacts.IMyContactsService;
import net.simpleframework.module.contacts.MyContacts;
import net.simpleframework.module.contacts.MyContactsTag;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class MyContactsService extends AbstractContactsService<MyContacts> implements
		IMyContactsService {

	@Override
	public IDataQuery<MyContacts> queryMyContacts(final Object user, final MyContactsTag... tags) {
		if (user == null) {
			return DataQueryUtils.nullQuery();
		}

		final StringBuilder sql = new StringBuilder();
		final List<Object> params = new ArrayList<Object>();
		if (tags == null || tags.length == 0) {
			sql.append("ownerid=?");
			params.add(getIdParam(user));
			return query(sql.append("order by oorder asc"), params.toArray());
		} else {
			sql.append("select c.* from ").append(getTablename(MyContacts.class))
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
			sql.append(")) t on c.id=t.contactsid where c.ownerid=?");
			params.add(getIdParam(user));
			return query(new SQLValue(sql.append("order by c.oorder asc"), params.toArray()));
		}
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<MyContacts>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<MyContacts> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				for (final MyContacts contacts : coll(manager, paramsValue)) {
					// 删除标签关联
					_contactsTagRService.deleteWith("contactsid=?", contacts.getId());
				}
			}
		});
	}
}
