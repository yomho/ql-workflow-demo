package com.example.demo.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.CurrentUserHelper;

import qinglian.workflow.sdk.api.interfaces.IWorkflowTasksApi;
import qinglian.workflow.sdk.api.vos.PageVO;
import qinglian.workflow.sdk.common.returns.ApiResult;

@RestController
@RequestMapping(value="/v1/api/workflow-tasks")
public class WorkflowTasksApi implements IWorkflowTasksApi {
	@Qualifier("WorkflowTasksApiImpl")
	@Autowired
	IWorkflowTasksApi workflowTasksApi;
	
	@RequestMapping(value = "pending", method = RequestMethod.GET)
	@Override
	public ApiResult getPendingList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getPendingList(pageVO, params);
	}

	@RequestMapping(value = "launch", method = RequestMethod.GET)
	@Override
	public ApiResult getLaunchList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getLaunchList(pageVO, params);
	}

	@RequestMapping(value = "approve", method = RequestMethod.GET)
	@Override
	public ApiResult getApproveList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getApproveList(pageVO, params);
	}

	@RequestMapping(value = "alltasks", method = RequestMethod.GET)
	@Override
	public ApiResult getAllTasksList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getAllTasksList(pageVO, params);
	}

	@RequestMapping(value = "steppath", method = RequestMethod.GET)
	@Override
	public ApiResult getProcessRuntimeStepPath(@RequestParam Map<String, Object> params) {
		return workflowTasksApi.getProcessRuntimeStepPath(params);
	}

	@RequestMapping(value = "cc", method = RequestMethod.GET)
	@Override
	public ApiResult getCCList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getCCList(pageVO, params);
	}

	@RequestMapping(value = "draft", method = RequestMethod.GET)
	@Override
	public ApiResult getDraftList(PageVO pageVO, Map<String, Object> params) {
		params.put("user_id", CurrentUserHelper.getCurrent_user_id());
		return workflowTasksApi.getDraftList(pageVO, params);
	}

}
