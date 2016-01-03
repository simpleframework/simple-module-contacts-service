package net.simpleframework.module.contacts.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ctx.AbstractModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.contacts.IContactsContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsContext extends AbstractModuleContext implements IContactsContext {

	@Override
	protected Module createModule() {
		return new Module().setName(MODULE_NAME).setText($m("ContactsContext.0")).setOrder(3);
	}

}
