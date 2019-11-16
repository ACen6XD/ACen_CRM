package com.crm.sale.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.service.SaleChanceService;
import com.crm.user.domain.User;
import com.crm.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ���������ۻ���ı��ֲ��action��
 * @author ����
 *
 */
public class SaleChanceAction extends ActionSupport implements ModelDriven<SaleChance>{
	//����ע��
	private SaleChanceService saleChanceService;
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//ʹ��ģ��������װ����
	private SaleChance saleChance = new SaleChance();
	public SaleChance getModel() {
		return saleChance;
	}
	//��ȡǰ�˴�����ҳ����ص�ֵ
	private Integer currPage = 1;
	private Integer pageSize = 3 ;
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
	//��ȡ��ǰ�����û���������Ϣ
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	/**
	 * ��ѯ���ݿ�������δ����Ķ��� 	 
	 **/
	public String findByPage(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//�������߲�ѯ
		DetachedCriteria dc = DetachedCriteria.forClass(SaleChance.class);
		//�ж�ǰ��ҳ���Ƿ񴩲�ѯ��ֵ
		if(saleChance.getSale_name()!=null && !"".equals(saleChance.getSale_name())){
			dc.add(Restrictions.like("sale_name", "%"+saleChance.getSale_name()+"%"));
		}
		if(saleChance.getBaseDictSource()!=null){
			if(saleChance.getBaseDictSource().getDict_id()!=null && !"".equals(saleChance.getBaseDictSource().getDict_id())){
				dc.add(Restrictions.like("baseDictSource.dict_id", saleChance.getBaseDictSource().getDict_id()));
			}
		}
		if(saleChance.getBaseDictChanceComm()!=null){
			if(saleChance.getBaseDictChanceComm().getDict_id()!=null && !"".equals(saleChance.getBaseDictChanceComm().getDict_id())){
				dc.add(Restrictions.like("baseDictChanceComm.dict_id", saleChance.getBaseDictChanceComm().getDict_id()));
			}
		}
		if(saleChance.getSale_linkman()!=null && !"".equals(saleChance.getSale_linkman())){
			dc.add(Restrictions.like("sale_linkman", "%"+saleChance.getSale_linkman()+"%"));
		}
		//��ҳ��ѯ��Ӧ����
		PageBean<SaleChance> pageBean = saleChanceService.findByPage(dc,currPage,pageSize);
		//�ֶ�ѹ��ջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSuccess";
	}
	
	/**
	 * ��ת�����ҳ�棬ͬʱͬ������������ѡ��
	 */
	public String addUI(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//���õ�ǰ������û�Ϊ������
		saleChance.setSale_buildman(user);
		//��ȡ��ǰ������ʱ��
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		saleChance.setSale_date(dt.format(new Date()));
		return "addUI";
	}
	
	/**
	 * ����µ����ۻ���
	 */
	public String add(){
		saleChance.setSale_buildman(user);
		saleChanceService.add(saleChance);
		return "addSuccess";
	}
	/**
	 * ɾ����¼
	 */
	public String delete(){
		//����ǰ�˴�����ֵ���ҵ���Ҫ���в����ļ�¼ʵ��
		SaleChance newSaleChance = saleChanceService.findById(saleChance.getSale_id());
		//ɾ��������¼
		saleChanceService.delete(newSaleChance);
		return "deleSuccess";
	}
	/**
	 * �����޸�ҳ��
	 */
	public String editUI(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//����ǰ�˴�����ֵ���ҵ���Ҫ���в����ļ�¼ʵ��
		saleChance = saleChanceService.findById(saleChance.getSale_id());
		ActionContext.getContext().getValueStack().push(saleChance);
		return "editUI";
	}
	/**
	 * �޸�����
	 */
	public String edit(){
		saleChance.setSale_buildman(user);
		saleChanceService.edit(saleChance);
		return "editSuccess";
	}
	/**
	 * ����ָ��ҳ��
	 */
	public String appointUI(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�ҳ����ݿ������еĿͻ�����
		List<User> userList = userService.findByPermis("2");
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		ActionContext.getContext().getValueStack().set("userList", userList);
		//����ǰ�˴�����ֵ���ҵ���Ҫ���в����ļ�¼ʵ��
		saleChance = saleChanceService.findById(saleChance.getSale_id());
		ActionContext.getContext().getValueStack().push(saleChance);
		//��ȡ��ǰ������ʱ��
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		saleChance.setSale_respdate(dt.format(new Date()));
		
		return "appointUI";
	}
	/**
	 * ָ�ɹ���
	 */
	public String appoint(){
		//ͨ��ǰ�˴���ֵȡ�õ�ǰ���ۻ���
		SaleChance newSaleChance = saleChanceService.findById(saleChance.getSale_id());
		//����ѡ��ĸ����û���id��ȡ�û�ʵ��
		User respUser = userService.findById(saleChance.getSale_respman().getUser_id());
		//�������ۻ����ָ���˺�ʱ��
		newSaleChance.setSale_respman(respUser);
		newSaleChance.setSale_respdate(saleChance.getSale_respdate());
		newSaleChance.setSale_status("������");
		//���ݿ��н��и���
		saleChanceService.edit(newSaleChance);
		
		return "appointSuccess";
	}
	
}
