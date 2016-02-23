package net.simpleframework.module.contacts.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.AbstractADOModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.contacts.Contacts;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.ContactsTagR;
import net.simpleframework.module.contacts.IContactsContext;
import net.simpleframework.module.contacts.IContactsService;
import net.simpleframework.module.contacts.IContactsTagRService;
import net.simpleframework.module.contacts.IContactsTagService;
import net.simpleframework.module.contacts.IMyContactsTagService;
import net.simpleframework.module.contacts.MyContacts;
import net.simpleframework.module.contacts.MyContactsTag;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsContext extends AbstractADOModuleContext implements IContactsContext {

	@Override
	protected DbEntityTable[] createEntityTables() {
		return new DbEntityTable[] { new DbEntityTable(Contacts.class, "sf_contacts"),
				new DbEntityTable(ContactsTag.class, "sf_contacts_tag"),
				new DbEntityTable(ContactsTagR.class, "sf_contacts_tagr"),
				new DbEntityTable(MyContacts.class, "sf_mycontacts"),
				new DbEntityTable(MyContactsTag.class, "sf_mycontacts_tag") };
	}

	@Override
	protected Module createModule() {
		return new Module().setName(MODULE_NAME).setText($m("ContactsContext.0")).setOrder(3);
	}

	@Override
	public IContactsService getContactsService() {
		return singleton(ContactsService.class);
	}

	@Override
	public IContactsTagService getContactsTagService() {
		return singleton(ContactsTagService.class);
	}

	@Override
	public IContactsTagRService getContactsTagRService() {
		return singleton(ContactsTagRService.class);
	}

	@Override
	public IMyContactsTagService getMyContactsTagService() {
		return singleton(MyContactsTagService.class);
	}
}
