package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.IContactsTagService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTagService extends AbstractContactsService<ContactsTag> implements
		IContactsTagService {

	@Override
	public ContactsTag addContactsTag(final ID orgId, final String text, final String description) {
		return null;
	}

	@Override
	public IDataQuery<ContactsTag> queryTags(final ID orgId) {
		final StringBuilder sb = new StringBuilder("1=1");
		final List<Object> params = new ArrayList<Object>();
		if (orgId != null) {
			sb.append(" and (orgid=? or orgid is null)");
			params.add(orgId);
		}
		return query(sb, params.toArray());
	}
}