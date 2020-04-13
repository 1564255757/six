package com.dhee.six.manager.corporate.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.dhee.six.manager.corporate.service.M_CorporateService;
import com.dhee.six.vo.Corporate;

/**
 * 后台企业controller层 
 * 作者：葛文涛 贺丽萍
 * 完成时间：2019/09/04
 */
@Controller
@RequestMapping("manager/corporate")
public class M_CorporateController {

	/*
	 * 葛文涛 
	 **/
	// 后台出口基地查询service
	@Autowired
	private M_CorporateService m_corporateService;

	/*
	 * 方法名：Manager_Select_Base
	 * 作用：后台select出口基地查询
	 * 参数：无
	 * 返回类型：Map<String, Object> 
	 */
	@RequestMapping("Manager_Select_Base.do")
	@ResponseBody
	public Map<String, Object> Manager_Select_Base(Integer page) {
		Map<String, Object> map = m_corporateService.manager_Select_Company(page);
		return map;

	}

	/*
	 * 方法名：Manager_Delete_Base
	 * 作用：删除基地企业
	 * 参数：corporateVo，用于获取企业id
	 * 返回类型：int
	 */
	@RequestMapping("Manager_Delete_Base.do")
	@ResponseBody
	public int Manager_Delete_Base(Corporate corporateVo) {
		return m_corporateService.manager_Delete_Company(corporateVo);

	}

	/*
	 * 方法名：manager_SelectTarget_Company
	 * 作用：后台出口基地编辑前查询目标企业
	 * 参数：Corporate corporateVo
	 * 返回类型：Corporate类型的对象
	 */
	@RequestMapping("manager_SelectTarget_Company.do")
	@ResponseBody
	public Corporate manager_SelectTarget_Company(Corporate corporateVo) {
		return m_corporateService.manager_SelectTarget_Company(corporateVo);
	}

	/*
	 * 方法名：Manager_Update_Company_Name_Repeat
	 * 作用：
	 * （manager_SelectCorporate_name_Company）：后台编辑基地企业时验证修改后企业名称是否冲突
	 * （Company_Corporate_Repeat）：检查编辑操作前添写基地企业名时基地企业名是否存在
	 * 参数：String companyName（文本框的企业名称）, Corporate corporateVo
	 * 返回类型：int
	 */
	@RequestMapping("Manager_Update_Company_Name_Repeat.do")
	@ResponseBody
	public int Manager_Update_Company_Name_Repeat(String companyName, Corporate corporateVo) {
		return m_corporateService.Manager_Update_Company_Name_Repeat(companyName, corporateVo);
	}

	/*
	 * 方法名：manager_Update_Select_Username
	 * 作用：后台出口基地编辑前查询目标企业的用户名
	 * 参数：String companyName（文本框里的企业名称）, Corporate corporateVo
	 * 返回类型：Corporate类型的对象
	 */
	@RequestMapping("manager_Update_Select_Username.do")
	@ResponseBody
	public Corporate manager_Update_Select_Username(Corporate corporateVo) {
		return m_corporateService.manager_Update_Select_Username(corporateVo);
	}

	/*
	 * 方法名： Company_Username_Repeat
	 * 作用：后台出口基地编辑前将查询到的目标企业的用户名进行数据库查重判断
	 * （Company_Username_Repeat）：后台编辑基地企业时验用户名是否冲突
	 * （Company_Username_Repeat_Two）：判断修改后的用户名是否冲突
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	@RequestMapping("Company_Username_Repeat.do")
	@ResponseBody
	public int Company_Username_Repeat(Corporate corporateVo) {
		return m_corporateService.Company_Username_Repeat(corporateVo);
	}

	/*
	 * 方法名：Company_Update_company_Logo
	 * 作用：后台更改企业logo
	 * 参数：corporatevo、上传图片的file、HttpServletRequest request
	 * 返回类型：int
	 */
	@RequestMapping("Company_Update_company_Logo.do")
	@ResponseBody
	public int Company_Update_company_Logo(Corporate corporateVo, MultipartFile file, HttpServletRequest request) {

		String path = request.getServletContext().getRealPath("upload/images");
		String filename = file.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf("."));
		String id = UUID.randomUUID().toString();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + "/" + id + suffix));
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File("D:/practice/Six/WebContent/upload/images/"+ id + suffix));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		corporateVo.setCorporate_logo_name(id + suffix);
		corporateVo.setCorporate_logo_path("upload/images");
		return m_corporateService.Company_Update_company_Logo(corporateVo);
	}

	/*
	 * 方法名：manager_Update_Company
	 * 作用：后台出口基地修改编辑
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	@RequestMapping("manager_Update_Company.do")
	@ResponseBody
	public int manager_Update_Company(Corporate corporateVo) {
		int i = m_corporateService.manager_Update_Company(corporateVo);
		return i;
	}

	/*
	 * 方法名：manager_Update_Company_Username_password
	 * 作用：后台企业用户名密码修改编辑
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	@RequestMapping("manager_Update_Company_Username_password.do")
	@ResponseBody
	public int manager_Update_Company_Username_password(Corporate corporateVo) {
		int i = m_corporateService.manager_Update_Company_Username_password(corporateVo);
		return i;
	}

	/*
	 * 方法名：manager_Insert_Company
	 * 作用：添加基地企业
	 * 参数：corporateVo
	 * 返回类型：int
	 */
	@RequestMapping("manager_Insert_Company.do")
	@ResponseBody
	public int manager_Insert_Company(Corporate corporateVo,MultipartFile file,HttpServletRequest request) {
		String path=request.getServletContext().getRealPath("upload/images");
		String filename=file.getOriginalFilename();
		
		System.out.println(filename);
		
		String suffix=filename.substring(filename.lastIndexOf("."));
		String id=UUID.randomUUID().toString();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+id+suffix));
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					new File("D:/practice/Six/WebContent/upload/images/"+id+suffix));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		corporateVo.setCorporate_logo_name(id+suffix);
		corporateVo.setCorporate_logo_path("upload/images");
		int i = m_corporateService.manager_Insert_Company(corporateVo);
		return i;
	}
	
	
	/*贺丽萍*/
	/*
	 * 后台企业未审核数量
	 * 参数： 无
	 * 返回类型：待审核企业数量int
	 */
		@RequestMapping("selectByCorporatenoAmount.do")
		@ResponseBody
		public int selectByCorporatenoAmount() {
			return m_corporateService.selectCorporatenoAmount();
		}
		/*
		 * 后台查看后台待审核企业
		 * 参数： 无
		 * 返回类型：未通过审核的基地的企业的集合 List<Corporate>
		 */
		@RequestMapping("sh")
		@ResponseBody
		public List<Corporate> selectByCorporateno(){
			
			return m_corporateService.selectByCorporateno();
		}
		
		/*
		 * 后台修改待审核企业状态
		 * 参数： 企业id：corporate_id，企业状态值：state
		 * 返回类型：是否修改成功标志(1：成功，0：失败)  int
		 */
		@RequestMapping("new")
		@ResponseBody
		public int update(String corporate_id,Integer state){
			System.out.println(corporate_id+"-"+state);
			return  m_corporateService.update(corporate_id,state) ;
			
		}
		/*
		 * 后台查看待审核企业的具体信息
		 * 参数： 企业id：corporate_id
		 * 返回类型：未通过审核的基地的企业的所有信息Corporate
		 */
		@RequestMapping("xx")
		@ResponseBody
		public Corporate selectByCorporateId(String corporate_id){
			return m_corporateService.selectByCorporateId(corporate_id);
			
		}

}
