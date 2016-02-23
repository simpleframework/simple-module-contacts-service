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

	/* 我的联系人服务 */
	static IContactsService _contactsService = contactsContext.getContactsService();

	/* 联系人标签服务 */
	static IContactsTagService _contactsTagService = contactsContext.getContactsTagService();
	/* 标签关系服务 */
	static IContactsTagRService _contactsTagRService = contactsContext.getContactsTagRService();

	/* 我的联系人服务 */
	static IMyContactsService _mycontactsService = contactsContext.getMyContactsService();
	/* 我的联系人标签服务 */
	static IMyContactsTagService _mycontactsTagService = contactsContext.getMyContactsTagService();
}