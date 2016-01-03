package net.simpleframework.module.contacts;

import net.simpleframework.ado.bean.AbstractIdBean;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTagR extends AbstractIdBean {
	/* 标签id */
	private ID tagId;
	/* 联系人id */
	private ID contactsId;

	public ID getTagId() {
		return tagId;
	}

	public void setTagId(final ID tagId) {
		this.tagId = tagId;
	}

	public ID getContactsId() {
		return contactsId;
	}

	public void setContactsId(final ID contactsId) {
		this.contactsId = contactsId;
	}

	private static final long serialVersionUID = -154938572314348991L;
}
