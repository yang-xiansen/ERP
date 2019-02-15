package edson.web.erp.department.service;

import edson.web.erp.department.dao.DeptDaoInter;
import edson.web.erp.department.domain.Department;
import edson.web.erp.utils.base.EqHqlParamters;
import edson.web.erp.utils.publicBean.PageBean;

import java.util.List;
import java.util.Map;

public class DeptService implements DeptServiceInter {
	
	private DeptDaoInter dao;

	public final void setDao(DeptDaoInter dao) {
		this.dao = dao;
	}

	@Override
	public void save(Department dept) {
		dao.save(dept);
	}

	@Override
	public PageBean<Department> findListByPageBean(Integer currentPage) {
		//查询总记录数
		String hql="select count(*) from Department";
		long totalRecord=dao.findTotalRecord(hql,null);
		//查询分页信息
		hql="from Department";
		PageBean<Department>pageBean=null;
		pageBean=dao.findListByPageBean(pageBean, currentPage, (int)totalRecord, Department.ONE_PAGE_RECORD, Department.PATH, hql, null);
		
		return pageBean;
	}

	@Override
	public Department findById(Integer id) {
		return dao.findById(id);
	}
	

	@Override
	public void update(Department t) {
		dao.update(t);
	}

	@Override
	public void delete(Department t) {
		dao.delete(t);
	}

	

	@Override
	public PageBean<Department> queryByCriteriaObjects(
			Map<String, Object> criteriaMap, int currentPage) {
		String hql="select count(*) from Department where 1=1";
		String hql2="from Department where 1=1";
		
		long totalRecord=dao.findTotalRecord(setHqlAndPramaters(hql, criteriaMap).toString(),criteriaMap.values().toArray());
		//查询分页信息
		PageBean<Department>pageBean=null;
		pageBean=dao.findListByPageBean(pageBean,currentPage,(int)totalRecord,Department.ONE_PAGE_RECORD, Department.PATH,setHqlAndPramaters(hql2, criteriaMap).toString(),criteriaMap.values().toArray());
		return pageBean;
	}

	@Override
	public StringBuffer setHqlAndPramaters(String hql,
			Map<String, Object> criteriaMap) {
		return new EqHqlParamters().setHqlAndPramaters(hql, criteriaMap);
	}

	@Override
	public Department findByCriteriaMap(Map<String, Object> criteriaMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findListByCriteriaMap(Map<String, Object> criteriaMap) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
