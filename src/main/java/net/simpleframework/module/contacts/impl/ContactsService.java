package net.simpleframework.module.contacts.impl;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.module.contacts.Contacts;
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
	public IDataQuery<Contacts> queryContacts(final ID orgId) {
		return null;
	}
}