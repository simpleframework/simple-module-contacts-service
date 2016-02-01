package net.simpleframework.module.contacts.impl;

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
		return null;
	}
}