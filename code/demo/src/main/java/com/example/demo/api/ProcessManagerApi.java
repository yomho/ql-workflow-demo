package com.example.demo.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.CurrentUserHelper;

import qinglian.workflow.sdk.api.interfaces.IProcessManagerApi;
import qinglian.workflow.sdk.api.vos.PageVO;
import qinglian.workflow.sdk.api.vos.ResetAuditorVO;
import qinglian.workflow.sdk.common.returns.ApiResult;

@RestController
@RequestMapping(value="/v1/api/process-manager")
public class ProcessManagerApi implements IProcessManagerApi {
	@Qualifier("ProcessManagerApiImpl")
	@Autowired
	IProcessManagerApi processManagerApi;
	
	@RequestMapping(value = "processTracking", method = RequestMethod.GET)
	@Override
	public ApiResult getProcessTrackingList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.getProcessTrackingList(pageVO, params);
	}

	@RequestMapping(value = "getCurrentRuntimeStepIdAndAuditors", method = RequestMethod.GET)
	@Override
	public ApiResult getProcessRuntimeCurrentStepIdAndAuditors(@RequestParam Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.getProcessRuntimeCurrentStepIdAndAuditors(params);
	}

	@RequestMapping(value = "resetAuditor", method = RequestMethod.POST)
	@Override
	public ApiResult resetAuditor(@RequestBody ResetAuditorVO resetAuditorVO) {
		return processManagerApi.resetAuditor(resetAuditorVO);
	}

	@RequestMapping(value = "deleteProcessRuntime", method = RequestMethod.POST)
	@Override
	public ApiResult deleteProcessRuntime(@RequestBody Map<String, Object> params) {
		return processManagerApi.deleteProcessRuntime(params);
	}

	@RequestMapping(value = "getProcessRecycling", method = RequestMethod.GET)
	@Override
	public ApiResult getProcessRecycling(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.getProcessRecycling(pageVO, params);
	}

	@RequestMapping(value = "recoverProcessRuntime", method = RequestMethod.POST)
	@Override
	public ApiResult recoverProcessRuntime(@RequestBody Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.recoverProcessRuntime(params);
	}

	@RequestMapping(value = "trashProcessRuntime", method = RequestMethod.POST)
	@Override
	public ApiResult trashProcessRuntime(@RequestBody Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.trashProcessRuntime(params);
	}

	@RequestMapping(value = "getTemplateRecycling", method = RequestMethod.GET)
	@Override
	public ApiResult getTemplateRecycling(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.getTemplateRecycling(pageVO, params);
	}

	@RequestMapping(value = "recoverTemplate", method = RequestMethod.POST)
	@Override
	public ApiResult recoverTemplate(@RequestBody Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.recoverTemplate(params);
	}

	@RequestMapping(value = "trashTemplate", method = RequestMethod.POST)
	@Override
	public ApiResult trashTemplate(@RequestBody Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.trashTemplate(params);
	}

	@RequestMapping(value = "trashTemplateProcessRuntime", method = RequestMethod.POST)
	@Override
	public ApiResult trashTemplateProcessRuntime(@RequestBody Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return processManagerApi.trashTemplateProcessRuntime(params);
	}

}
