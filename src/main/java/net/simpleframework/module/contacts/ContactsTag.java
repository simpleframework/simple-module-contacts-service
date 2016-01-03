package net.simpleframework.module.contacts;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTag extends AbstractTextDescriptionBean {
	/* 机构id */
	private ID orgId;

	public ID getOrgId() {
		return orgId;
	}

	public void setOrgId(final ID orgId) {
		this.orgId = orgId;
	}

	private static final long serialVersionUID = 2889282054595763648L;
}
