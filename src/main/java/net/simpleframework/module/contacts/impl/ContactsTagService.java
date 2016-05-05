package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.module.contacts.ContactsTag;
import net.simpleframework.module.contacts.IContactsTagService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsTagService extends AbstractContactsService<ContactsTag> implements
		IContactsTagService {

	@Override
	public ContactsTag addContactsTag(final ID orgId, final String text, final String description) {
		final ContactsTag tag = createBean();
		tag.setOrgId(orgId);
		tag.setText(text);
		tag.setDescription(description);
		insert(tag);
		return tag;
	}

	@Override
	public IDataQuery<ContactsTag> queryOrgTags(final Object org) {
		final StringBuilder sb = new StringBuilder("1=1");
		final List<Object> params = new ArrayList<Object>();
		if (org != null) {
			sb.append(" and (orgid=? or orgid is null)");
			params.add(getIdParam(org));
		} else {
			if (!LoginUser.isManager()) {
				sb.append(" and orgid is null");
			}
		}
		return query(sb.append(" order by oorder desc"), params.toArray());
	}

	@Override
	public ContactsTag getContactsTag(final Object org, final String text, final boolean create) {
		final StringBuilder sb = new StringBuilder("text=?");
		final List<Object> params = new ArrayList<Object>();
		params.add(text);

		final ID orgId = getPermission().getDept(getIdParam(org)).getId();
		if (orgId != null) {
			sb.append(" and orgid=?");
			params.add(orgId);
		} else {
			sb.append(" and orgid is null");
		}

		ContactsTag tag = getBean(sb.toString(), params.toArray());
		// 机构为空时不自动创建
		if (create && tag == null && orgId != null) {
			tag = addContactsTag(orgId, text, null);
		}
		return tag;
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<ContactsTag>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<ContactsTag> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);

				for (final ContactsTag tag : coll(manager, paramsValue)) {
					// 不在同一个域内
					assetDomainId_delete(tag.getOrgId());
					// 删除关系
					_contactsTagRService.deleteWith("tagid=?", tag.getId());
				}
			}
		});
	}
}