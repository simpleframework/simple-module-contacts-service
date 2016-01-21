package net.simpleframework.module.contacts;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.ado.bean.IOrderBeanAware;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTag extends AbstractTextDescriptionBean implements IOrderBeanAware {
	/* 机构id */
	private ID orgId;

	/* 统计字段，联系人数 */
	private int contacts;

	/* 排序字段 */
	private int oorder;

	public ID getOrgId() {
		return orgId;
	}

	public void setOrgId(final ID orgId) {
		this.orgId = orgId;
	}

	@Override
	public int getOorder() {
		return oorder;
	}

	@Override
	public void setOorder(final int oorder) {
		this.oorder = oorder;
	}

	public int getContacts() {
		return contacts;
	}

	public void setContacts(final int contacts) {
		this.contacts = contacts;
	}

	private static final long serialVersionUID = 2889282054595763648L;
}
