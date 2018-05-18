package org.kosta.momsbay;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.common.PointListVO;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.mapper.PointHistoryMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MyAccountMapperTest {
	@Autowired
	MemberMapper mapper;
	MemberVO member= new MemberVO();
	
	@Autowired
	PointHistoryMapper hMapper;

	public void updateMember() {
		member.setId("java");
		member.setPassword("1234");
		member.setAddress("수원22");
		member.setAddress2("1003");
		member.setName("hello");
		
		mapper.updateMember(member);
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void getPointHistoryById() {
		String id="java";
		String pageNo=null;
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		
		int totalCount=hMapper.getTotalPointHistoryById(id);
		
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(10);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(10);
		}
		map.put("pagingBean", pagingBean);
		System.out.println(hMapper.getPointHistoryById(map));
	}
}
