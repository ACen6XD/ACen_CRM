package com.crm.basedict.web.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ���ĵ��������ֵ��action��
 * @author ����
 *
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{
	//����ע��
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	//ģ��������װ����
	private BaseDict baseDict = new  BaseDict();
	public BaseDict getModel() {
		return baseDict;
	}
	private Integer currPage = 1;//��ǰҳ
	private Integer pageSize = 3;//ÿҳ��ʾ��������
	public void setCurrPage(Integer currPage) {
		if(currPage == 0)
			currPage = 1;
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == 0)
			pageSize = 3;
		this.pageSize = pageSize;
	}
	//�첽������ʾ�û��ĵ���Ȩ��
	public String findPremis() throws IOException{
		//ͨ��������û�����û��������ֵ��е�ʵ��
		BaseDict newBaseDict = baseDictService.findById(baseDict.getDict_id());
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // �Զ�Ϊ���ų�circle��  
		
		jsonConfig.setExcludes(new String[] { "baseDictPermission" }); // ����ת���к��Ե�����
		JSONObject jsonBaseDict = JSONObject.fromObject(newBaseDict,jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonBaseDict.toString());
		return NONE;
	}
	/**
	 * ����ҳ�������е������ֵ���Ϣ
	 */
	public String findByPage(){
		//�½�һ�����߲�ѯ
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//�ж�ǰ���Ƿ��д�ֵ
		if(baseDict.getDict_item_name()!=null && !"".equals(baseDict.getDict_item_name())){
			dc.add(Restrictions.like("dict_item_name", "%"+baseDict.getDict_item_name()+"%"));
		}
		if(baseDict.getDict_type_name()!=null && !"".equals(baseDict.getDict_type_name())){
			dc.add(Restrictions.eq("dict_type_name", baseDict.getDict_type_name()));
		}
		//�ҳ����еļ�¼��װ�ɷ�ҳʵ��
		PageBean<BaseDict> pageBean = baseDictService.findByPage(dc,currPage,pageSize);
		//�ҳ����е����
		List<String> listTypeName = baseDictService.findAllTypeName();
		//�ֶ�����ֵջ
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("listTypeName", listTypeName);
		return "findSuccess";
	}
	/**
	 * ����޸Ľ����޸�ҳ��
	 */
	public String editUI(){
		baseDict = baseDictService.findById(baseDict.getDict_id());
		ActionContext.getContext().getValueStack().push(baseDict);
		return "editUI";
	}
	/**
	 * �޸�����
	 */
	public String edit(){
		baseDictService.edit(baseDict);
		return "editSuccess";
	}
	/**
	 * ���������������ݵ�ҳ��
	 */
	public String addUI(){
		//�ҳ����е����
		List<String> listTypeName = baseDictService.findAllTypeName();
		//�ֶ�����ֵջ
		ActionContext.getContext().getValueStack().set("listTypeName", listTypeName);
		return "addUI";
	}
	/**
	 * @param
	 * @return
	 * �����ӽ����������
	 */
	public String add(){
		if(baseDict.getDict_type_name().equals("������Դ")){
			baseDict.setDict_type_code("1");
		}else if(baseDict.getDict_type_name().equals("��������")){
			baseDict.setDict_type_code("2");
		}else if(baseDict.getDict_type_name().equals("�û���ɫ")){
			baseDict.setDict_type_code("3");
		}else if(baseDict.getDict_type_name().equals("�ͻ�����")){
			baseDict.setDict_type_code("4");
		}else if(baseDict.getDict_type_name().equals("�ͻ�������ҵ")){
			baseDict.setDict_type_code("5");
		}else {
			baseDict.setDict_type_code("6");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		baseDict.setDict_id(df.format(new Date()));
		baseDictService.save(baseDict);
		return "addSuccess";
	}
	/**
	 * ���ɾ����������ɾ��
	 */
	public String delete(){
		baseDict = baseDictService.findById(baseDict.getDict_id());
		baseDictService.delete(baseDict);
		return "deleteSuccess";
	}
}
