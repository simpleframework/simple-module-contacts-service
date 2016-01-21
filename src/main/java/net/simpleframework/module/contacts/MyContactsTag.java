package net.simpleframework.module.contacts;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class MyContactsTag extends ContactsTag {

	/* 联系人owner */
	private ID ownerId;

	public ID getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(final ID ownerId) {
		this.ownerId = ownerId;
	}

	private static final long serialVersionUID = 4939807013172434773L;
}
