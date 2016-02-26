package net.simpleframework.module.contacts.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.permission.PermissionUser;
import net.simpleframework.module.contacts.IMyContactsTagService;
import net.simpleframework.module.contacts.MyContactsTag;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class MyContactsTagService extends AbstractContactsService<MyContactsTag> implements
		IMyContactsTagService {

	@Override
	public MyContactsTag addContactsTag(final ID userId, final String text, final String description) {
		final MyContactsTag tag = createBean();
		final PermissionUser user = getPermission().getUser(userId);
		tag.setOwnerId(user.getId());
		tag.setOrgId(user.getDomainId());
		tag.setText(text);
		tag.setDescription(description);
		insert(tag);
		return tag;
	}

	@Override
	public MyContactsTag getMyContactsTag(final Object user, final String text, final boolean create) {
		final Object userId = getIdParam(user);
		MyContactsTag tag = getBean("ownerid=? and text=?", userId, text);
		if (create && tag == null) {
			tag = addContactsTag(getPermission().getUser(userId).getId(), text, null);
		}
		return tag;
	}

	@Override
	public IDataQuery<MyContactsTag> queryMyTags(final Object user) {
		if (user == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("ownerid=? order by oorder desc", getIdParam(user));
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<MyContactsTag>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<MyContactsTag> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				for (final MyContactsTag tag : coll(manager, paramsValue)) {
					// 删除关系
					_contactsTagRService.deleteWith("tagid=?", tag.getId());
				}
			};
		});
	}
}
