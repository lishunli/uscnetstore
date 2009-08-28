package com.usc.services.custom;

import com.usc.daos.Custom;

public interface IPersonManage {
public void ChangerCustomPassword(Custom custom,String password);
public void ChangerCustomEmail(Custom custom,String email);
}
