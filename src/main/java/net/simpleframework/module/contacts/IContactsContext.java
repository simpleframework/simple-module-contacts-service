package net.simpleframework.module.contacts;

import net.simpleframework.ctx.IModuleContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IContactsContext extends IModuleContext {

	static String MODULE_NAME = "simple-module-contacts";

	/**
	 * 获取联系人服务
	 * 
	 * @return
	 */
	IContactsService getContactsService();

	/**
	 * 获取联系人标签服务
	 * 
	 * @return
	 */
	IContactsTagService getContactsTagService();

	/**
	 * 获取联系人标签关系服务
	 * 
	 * @return
	 */
	IContactsTagRService getContactsTagRService();
}