package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qinglian.workflow.sdk.api.interfaces.IAuditorApi;
import qinglian.workflow.sdk.api.vos.AuditorVO;
import qinglian.workflow.sdk.api.vos.PageVO;
import qinglian.workflow.sdk.common.returns.ApiResult;

@RestController
@RequestMapping(value="/v1/api/3rd-party-auditor")
public class AuditorApi implements IAuditorApi {
	static List<AuditorVO> memoryAuditorDataSource = new ArrayList<AuditorVO>();
	static{
		AuditorVO auditorVO = new AuditorVO();
		auditorVO.setAuditorId("1");
		auditorVO.setAuditorName("admin");
		auditorVO.setUserType(0);
		memoryAuditorDataSource.add(auditorVO);
		auditorVO = new AuditorVO();
		auditorVO.setAuditorId("2");
		auditorVO.setAuditorName("yomho");
		auditorVO.setUserType(0);
		memoryAuditorDataSource.add(auditorVO);
		auditorVO = new AuditorVO();
		auditorVO.setAuditorId("3");
		auditorVO.setAuditorName("zhangsan");
		auditorVO.setUserType(0);
		memoryAuditorDataSource.add(auditorVO);
	}
	
	@RequestMapping(value = "getMainAuditors", method = RequestMethod.GET)
	@Override
	public ApiResult getMainAuditors(PageVO pageVO, Map<String, Object> params) {
		ApiResult apiResult = new ApiResult();
		apiResult.setServiceResult(memoryAuditorDataSource);
		apiResult.setSuccess(true);
		return apiResult;
	}

	@RequestMapping(value = "getSubAuditors", method = RequestMethod.GET)
	@Override
	public ApiResult getSubAuditors(PageVO pageVO, Map<String, Object> params) {
		ApiResult apiResult = new ApiResult();
		apiResult.setMsg("未实现相关接口");
		apiResult.setSuccess(false);
		return apiResult;
	}

	@RequestMapping(value = "getAuditorByIdAndType", method = RequestMethod.GET)
	@Override
	public ApiResult getAuditorByIdAndType(Map<String, Object> params) {
		ApiResult apiResult = new ApiResult();
		String id = String.valueOf(params.get("id"));
		int type = Integer.valueOf(String.valueOf(params.get("type")));
		AuditorVO auditor = null;
		for (int i = 0; i < memoryAuditorDataSource.size(); i++) {
			if (id.equals(memoryAuditorDataSource.get(i).getAuditorId())
					&& type == memoryAuditorDataSource.get(i).getUserType()) {
				auditor = memoryAuditorDataSource.get(i);
				break;
			}
		}
		apiResult.setServiceResult(auditor);
		apiResult.setSuccess(true);
		return apiResult;
	}
}
