package net.simpleframework.module.contacts.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.ContactsTagR;
import net.simpleframework.module.contacts.IContactsTagRService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTagRService extends AbstractContactsService<ContactsTagR> implements
		IContactsTagRService {

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<ContactsTagR>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<ContactsTagR> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				for (final ContactsTagR tagr : coll(manager, paramsValue)) {
					doStat_contacts(tagr, -1);
				}
			}

			@Override
			public void onAfterInsert(final IDbEntityManager<ContactsTagR> manager,
					final ContactsTagR[] beans) throws Exception {
				super.onAfterInsert(manager, beans);
				for (final ContactsTagR tagr : beans) {
					doStat_contacts(tagr, 0);
				}
			}

			void doStat_contacts(final ContactsTagR tagr, final int delta) {
				final ContactsTag tag = _contactsTagService.getBean(tagr.getTagId());
				tag.setContacts(count("tagid=?", tag.getId()) + delta);
				_contactsTagService.update(new String[] { "contacts" }, tag);
			}
		});
	}
}