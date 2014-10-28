package com.unitek.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitek.dao.AddMapper;
import com.unitek.model.Add;
import com.unitek.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	private AddMapper addMapper;

	public AddMapper getAddMapper() {
		return addMapper;
	}
	@Autowired
	public void setAddMapper(AddMapper addMapper) {
		this.addMapper = addMapper;
	}

	@Override
	public String addInfo(Add addInfo) {
		if (addMapper.insertSelective(addInfo) == 1) {
			return "添加成功";
		}
		return "添加失败";
	}
	@Override
	public List<Add> getAll() {
		return addMapper.getAll();
	}
	@Override
	public String delete(String id) {
		if (addMapper.deleteByPrimaryKey(id) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}
	@Override
	public Add findById(String id) {
		return addMapper.selectByPrimaryKey(id);
	}
	@Override
	public String update(Add addInfo) {
		if (addMapper.updateByPrimaryKeySelective(addInfo) == 1) {
			return "更新成功";
		}
		return "更新失败";
	}
	

}
