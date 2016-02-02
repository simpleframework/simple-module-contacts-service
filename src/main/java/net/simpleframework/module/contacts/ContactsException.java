package net.simpleframework.module.contacts;

import net.simpleframework.common.th.RuntimeExceptionEx;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class ContactsException extends RuntimeExceptionEx {

	public ContactsException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

	public static ContactsException of(final Throwable throwable) {
		return _of(ContactsException.class, null, throwable);
	}

	public static ContactsException of(final String msg) {
		return _of(ContactsException.class, msg);
	}

	private static final long serialVersionUID = -6033170413374714098L;
}
