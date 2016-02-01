package net.simpleframework.module.contacts;

import net.simpleframework.ctx.IModuleContextAware;
import net.simpleframework.ctx.ModuleContextFactory;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IContactsContextAware extends IModuleContextAware {

	static final IContactsContext contactsContext = ModuleContextFactory.get(IContactsContext.class);

	static IContactsService _contactsService = contactsContext.getContactsService();

	static IContactsTagService _contactsTagService = contactsContext.getContactsTagService();
}