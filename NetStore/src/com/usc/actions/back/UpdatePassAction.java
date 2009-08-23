package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

public class UpdatePassAction extends ActionSupport
{
	private Operator operator;// ����Ա����ͨ��Struts2������
	private IManger manger;// �ӿ�ʵ�ֶ���ͨ��Springע��
	//	private String oldPass;//ԭ����
	private String newPass;//������
	private String reNewPass;//�ظ�����

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
		this.operator.setOperatorName(ActionContext.getContext().getSession()
				.get("manger").toString());
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}

	public String getNewPass()
	{
		return newPass;
	}

	public void setNewPass(String newPass)
	{
		this.newPass = newPass;
	}

	public String getReNewPass()
	{
		return reNewPass;
	}

	public void setReNewPass(String reNewPass)
	{
		this.reNewPass = reNewPass;
	}

	@Override
	public void validate()
	{
		if (null == operator)
		{
		} else
		{
			if (null == operator.getOperatorPass()
					|| "".equals(operator.getOperatorPass().trim()))// �����
			{
				this.addFieldError("operator.operatorPass", "ԭ���벻��Ϊ��");
			}
			if(null == newPass || "".equals(newPass))// �������
			{
				this.addFieldError("newPass", "�����벻��Ϊ��");
			}
			else if(!newPass.equals(reNewPass))//�ظ�������������벻һ��
			{
				this.addFieldError("reNewPass", "�ظ�������������벻һ��");
			}
			//			System.out.println(operator.getOperatorName() + "  " + operator.getOperatorPass() + "  " + newPass);
		}

	}

	@Override
	public String execute() throws Exception
	{
		if (null != operator)
		{
			if (manger.updatePass(operator, newPass))//�޸ĳɹ�
				return SUCCESS;
			else//�޸�ʧ�ܣ��������޸�
			{
				this.addFieldError("operator.operatorPass", "�޸�ʧ�ܣ��������޸�");
			}
		}
		return INPUT;

	}

}
