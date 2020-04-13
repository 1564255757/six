package com.dhee.six.index.corporate.controller;
/**
 * 前台企业controller
 * 作者：尹希栋，李治鑫，葛文涛，贺丽萍
 * 完成时间：2019/09/05
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dhee.six.index.cities.service.CitiesService;
import com.dhee.six.index.corporate.service.CorporateService;
import com.dhee.six.index.scope.service.ScopeService;
import com.dhee.six.manager.base.service.M_BaseServiceImpl;
import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;
import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Scope;
import com.dhee.six.vo.Search;

@Controller
@RequestMapping("index/corporate")
public class CorporateController {
	@Autowired
	private CorporateService corporateService;
	//企业注册经营范围service
	@Autowired
	private ScopeService scopeService;	
	//企业注册城市范围service
	@Autowired
	private CitiesService citiesService;	
	//企业注册选择城市弹出相应的出口基地service
	@Autowired
	private M_BaseServiceImpl m_baseService;
	/*
	 * 查询所有城市
	 * 参数： 筛选条件实体类search
	 * 返回类型：符合条件的企业集合，及总数量 Map<String,Object>
	 */
	@RequestMapping("login_out")
	@ResponseBody
	public int login_out(HttpSession session){
		session.removeAttribute("corporate");
		return 1;
	}
	/*
	 * 查询所有城市
	 * 参数： 筛选条件实体类search
	 * 返回类型：符合条件的企业集合，及总数量 Map<String,Object>
	 */
	@RequestMapping("allCorporate")
	@ResponseBody
	public Map<String,Object> allCorporate(Search search){
		return corporateService.selCorporate(search);		
	}
	/*
	 * 查询某企业信息
	 * 参数： 当前登录企业的session
	 * 返回类型：企业信息对象，及所有企业范围集合 Map<String,Object>
	 */
	@RequestMapping("corporateInfo")
	@ResponseBody
	public Corporate selCorporate(String id){
		return corporateService.CorporateInfo(id);
	}
	/*
	 * 查询某企业信息
	 * 参数： 当前登录企业的session
	 * 返回类型：企业信息对象，及所有企业范围集合 Map<String,Object>
	 */
	@RequestMapping("selCorporateInfo")
	@ResponseBody
	public Map<String,Object> selCorporateInfo(HttpSession session){
		Corporate c=(Corporate)session.getAttribute("corporate");
		return corporateService.selCorporateInfo(c.getCorporate_username());
	}
	/*
	 * 检测当前用户修改的企业名称是否存在
	 * 参数： 修改的企业名称（name），企业id（id）
	 * 返回类型：是否重复（int）1：可以使用  0：已存在
	 */
	@RequestMapping("checkCorporateName")
	@ResponseBody
	public int checkCorporateName(String name,String id){
		return corporateService.selCorporateNameReapeat(name, id);
	}
	/*
	 * 前台用户更新企业信息
	 * 参数： 修改企业的实体类corporate
	 * 返回类型：返回数据库更新的影响行数（int）
	 */
	@RequestMapping("updCorporate")
	@ResponseBody
	public int updCorporate(Corporate corporate){
		return corporateService.updCorporate(corporate);
	}
	/*
	 * 前台用户更新企业密码
	 * 参数：企业的实体类corporate，修改的密码，当前用户session
	 * 返回类型：返回int 1：原密码与输入密码一致，更新成功1：原密码与输入密码不一致，更新失败
	 */
	@RequestMapping("updCorporatePassword")
	@ResponseBody
	public int updCorporatePassword( Corporate corporate,String oldPass,HttpSession session){
		
		Corporate c=(Corporate)session.getAttribute("corporate");
		corporate.setCorporate_username(c.getCorporate_username());
		return corporateService.updCorporatePassword(corporate,oldPass,session);
	}
	/*
	 * 前台用户更新企业logo
	 * 参数：企业的实体类corporate，上传的图片file，HttpServletRequest对象req
	 * 返回类型：返回数据库更新的影响行数（int）
	 */
	@RequestMapping("updCorporateLogo")
	@ResponseBody
	public int updCorporateLogo(Corporate corporate,MultipartFile file,HttpServletRequest req){
		String path=req.getServletContext().getRealPath("upload/images");	
		String filename=file.getOriginalFilename();
		String suffix=filename.substring(filename.lastIndexOf("."));
		String id=UUID.randomUUID().toString();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+id+suffix));
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
			new File("D:/practice/Six/WebContent/upload/images/"+id+suffix));
		} catch (IOException e) {
			e.printStackTrace();
		}
		corporate.setCorporate_logo_name(id+suffix);
		corporate.setCorporate_logo_path("upload/images");
		return corporateService.updCorporateLogo(corporate);
	}
	

	
	//李治鑫
	/*
	 * 查询骨干企业
	 * 参数：基地的id（base_id）
	 * 返回类型：基地骨干企业集合List<Corporate>
	 */
	@RequestMapping("selectGG")
	@ResponseBody
	public List<Corporate> selectGG(String base_id){
		return corporateService.selectGG(base_id);
		
	}
	
	//葛文涛
	/*
	 * 方法名：Corporate_Name_Repeat
	 * 作用：注册时验证企业名称是否相同
	 * 参数：Corporate实体类对象 corporatevo
	 * 返回类型：int
	 */
		@RequestMapping("corporate_Name_Repeat.do")
		@ResponseBody
		public int Corporate_Name_Repeat(Corporate corporatevo) {
			int i=corporateService.Corporate_Name_Repeat(corporatevo);
			return i;
		}
		
		
		/*
		 * 方法名：Corporate_Username_Repeat
		 * 作用：注册时验证用户名是否相同
		 * 参数：Corporate实体类对象 corporatevo
		 * 返回类型：int
		 */
			@RequestMapping("corporate_Username_Repeat.do")
			@ResponseBody
			public int Corporate_Username_Repeat(Corporate corporatevo) {
			int	i=corporateService.Corporate_Username_Repeat(corporatevo);
				return i; 
			}
		
		
			/*
			 * 方法名：index_registration
			 * 作用：前台注册
			 * 参数：Corporate实体类对象 corporatevo、上传的图片file、HttpServletRequest对象request
			 * 返回类型：int
			 */
		@RequestMapping("index_registration.do")
		@ResponseBody
		public int index_registration(Corporate corporateVo,MultipartFile file,HttpServletRequest request){
			
			String path=request.getServletContext().getRealPath("upload/images");
			String filename=file.getOriginalFilename();
			String suffix=filename.substring(filename.lastIndexOf("."));
			String id=UUID.randomUUID().toString();
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+id+suffix));
				FileUtils.copyInputStreamToFile(file.getInputStream(), 
						new File("D:/practice/Six/WebContent/upload/images"+"/"+id+suffix));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			corporateVo.setCorporate_logo_name(id+suffix);
			corporateVo.setCorporate_logo_path("upload/images");
			return corporateService.index_Reg(corporateVo);
			
		}
		
		
		/*
		 * 方法名：Select_Scope
		 * 作用：企业注册经营范围select
		 * 参数：无
		 * 返回类型：经营范围集合List<Scope>
		 */
		@RequestMapping("Select_Scope.do")
		@ResponseBody
		public List<Scope> Select_Scope(){
			List<Scope>list= scopeService.selAll();
			return list;
			
		}
		
		/*
		 * 方法名：Select_City
		 * 作用：企业注册城市范围select
		 * 参数：无
		 * 返回类型：城市集合List<Cities>
		 */
		@RequestMapping("Select_City.do")
		@ResponseBody
		public List<Cities> Select_City(){
			List<Cities>list= citiesService.selAll();
			return list;
			
		}
		/*
		 * 方法名：Select_City_Base
		 * 作用：企业注册选择城市弹出相应的出口基地
		 * 参数：城市实体类Cities对象citiesVo
		 * 返回类型：基地base集合List<Base>
		 */
		//企业注册选择城市弹出相应的出口基地
			@RequestMapping("Select_City_Base.do")
			@ResponseBody
			public List<Base> Select_City_Base(Cities citiesVo){
				List<Base>list=m_baseService.Cities_Base(citiesVo);
				return list;
				
			}
			
		//贺丽萍
			/*
			 * 方法名：select
			 * 作用：前台企业登录
			 * 参数：城市实体类Cities的corporate_username属性、corporate_password属性、请求会话HttpSession的session
			 * 返回类型：int
			 */
			@RequestMapping("cor")
			@ResponseBody
			public int select(String corporate_username, String corporate_password,HttpSession session) {
				return corporateService.select(corporate_username, corporate_password,session);
			    
			}
	
	
}
