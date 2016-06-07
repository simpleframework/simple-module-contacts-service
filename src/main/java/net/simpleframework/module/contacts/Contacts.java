package net.simpleframework.module.contacts;

import java.util.Date;

import net.simpleframework.ado.bean.AbstractTextDescriptionBean;
import net.simpleframework.ado.bean.IOrderBeanAware;
import net.simpleframework.common.ID;
import net.simpleframework.common.Pinyin;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class Contacts extends AbstractTextDescriptionBean implements IOrderBeanAware {
	/* 机构id */
	private ID orgId;

	/* 拼音 */
	private String py;
	/* 性别 */
	private String sex;
	/* 生日 */
	private Date birthday;

	/* 民族 */
	private String nation;

	/* 所在部门 */
	private String dept;
	/* 职务 */
	private String job;
	/* 昵称 */
	private String nick;

	/* 联系电话 */
	private String email;
	/* 移动电话 */
	private String mobile;

	/* 工作电话 */
	private String workphone;
	/* 工作电话2 */
	private String workphone2;

	/* 传真 */
	private String fax;

	/* 家庭电话 */
	private String homephone;

	/* 工作地址 */
	private String workaddress;
	/* 家庭地址 */
	private String homeaddress;

	/* 邮政编码 */
	private String postcode;

	private String qq;
	/* 微信 */
	private String weixin;

	/* 帐号id，如果有帐号，则关联 */
	private ID userId;
	/* 部门id，如果有帐号，则关联 */
	private ID deptId;
	/* 部门字典 */
	private String deptDict;

	/** 排序 **/
	private int oorder;

	public ID getOrgId() {
		return orgId;
	}

	public void setOrgId(final ID orgId) {
		this.orgId = orgId;
	}

	@Override
	public void setText(final String text) {
		super.setText(text);
		setPy(Pinyin.toPinYin(text));
	}

	public String getPy() {
		return py;
	}

	public void setPy(final String py) {
		this.py = py;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(final String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(final Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(final String nation) {
		this.nation = nation;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(final String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(final String job) {
		this.job = job;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(final String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(final String mobile) {
		this.mobile = mobile;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(final String workphone) {
		this.workphone = workphone;
	}

	public String getWorkphone2() {
		return workphone2;
	}

	public void setWorkphone2(final String workphone2) {
		this.workphone2 = workphone2;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(final String homephone) {
		this.homephone = homephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(final String fax) {
		this.fax = fax;
	}

	public String getWorkaddress() {
		return workaddress;
	}

	public void setWorkaddress(final String workaddress) {
		this.workaddress = workaddress;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(final String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(final String postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(final String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(final String weixin) {
		this.weixin = weixin;
	}

	public ID getUserId() {
		return userId;
	}

	public void setUserId(final ID userId) {
		this.userId = userId;
	}

	public ID getDeptId() {
		return deptId;
	}

	public void setDeptId(final ID deptId) {
		this.deptId = deptId;
	}

	public String getDeptDict() {
		return deptDict;
	}

	public void setDeptDict(final String deptDict) {
		this.deptDict = deptDict;
	}

	@Override
	public int getOorder() {
		return oorder;
	}

	@Override
	public void setOorder(final int oorder) {
		this.oorder = oorder;
	}

	private static final long serialVersionUID = 3940756391544046769L;
}
