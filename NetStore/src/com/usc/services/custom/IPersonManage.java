package com.usc.services.custom;

import com.usc.daos.Custom;

public interface IPersonManage {
	
public void changeCustomInfo(Custom custom,String realName,String sex,String address,String postCode,String mobile,String phone);

public void changeCustomPassword(Custom custom,String newPassword);

public void changeCustomEmail(Custom custom,String email);
}
