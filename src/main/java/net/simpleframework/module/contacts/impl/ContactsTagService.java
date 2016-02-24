package net.simpleframework.module.contacts.impl;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
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
		}
		return query(sb, params.toArray());
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