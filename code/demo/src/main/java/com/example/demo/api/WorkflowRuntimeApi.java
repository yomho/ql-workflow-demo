package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.CurrentUserHelper;

import qinglian.workflow.sdk.api.interfaces.IWorkflowRuntimeApi;
import qinglian.workflow.sdk.api.vos.ActionHandleContextVO;
import qinglian.workflow.sdk.api.vos.RuntimeCurrentStepVO;
import qinglian.workflow.sdk.api.vos.RuntimeGraphVO;
import qinglian.workflow.sdk.api.vos.RuntimeNextStepVO;
import qinglian.workflow.sdk.api.vos.RuntimeRejectStepVO;
import qinglian.workflow.sdk.common.returns.ApiResult;

@RestController
@RequestMapping(value="/v1/api/workflow-runtime")
public class WorkflowRuntimeApi implements IWorkflowRuntimeApi {
	@Qualifier("WorkflowRuntimeApiImpl")
	@Autowired
	IWorkflowRuntimeApi workflowRuntimeApi;
	
	@RequestMapping(value = "graph", method = RequestMethod.GET)
	@Override
	public ApiResult getGraph(RuntimeGraphVO runtimeGraphVO) {
		return workflowRuntimeApi.getGraph(runtimeGraphVO);
	}

	@RequestMapping(value = "firststep", method = RequestMethod.GET)
	@Override
	public ApiResult getFirstStep(String template_id) {
		return workflowRuntimeApi.getFirstStep(template_id);
	}
	
	@RequestMapping(value = "currentstep", method = RequestMethod.GET)
	@Override
	public ApiResult getCurrentStep(RuntimeCurrentStepVO runtimeCurrentStepVO) {
		return workflowRuntimeApi.getCurrentStep(runtimeCurrentStepVO);
	}

	@RequestMapping(value = "nextstep", method = RequestMethod.GET)
	@Override
	public ApiResult getNextStep(RuntimeNextStepVO runtimeNextStepVO) {
		return workflowRuntimeApi.getNextStep(runtimeNextStepVO);
	}

	@RequestMapping(value = "rejectstep", method = RequestMethod.GET)
	@Override
	public ApiResult getRejectStep(RuntimeRejectStepVO runtimeRejectStepVO) {
		return workflowRuntimeApi.getRejectStep(runtimeRejectStepVO);
	}

	@RequestMapping(value = "handle_action", method = RequestMethod.POST)
	@Override
	public ApiResult handleAction(ActionHandleContextVO runtimeHandleActionVO) {
		runtimeHandleActionVO.setUserId(CurrentUserHelper.getCurrent_user_id());
		runtimeHandleActionVO.setUserName(CurrentUserHelper.getCurrent_user_name());
		return workflowRuntimeApi.handleAction(runtimeHandleActionVO);
	}

	@RequestMapping(value = "steppath", method = RequestMethod.GET)
	@Override
	public ApiResult getProcessStepPath(String node_runtime_id) {
		return workflowRuntimeApi.getProcessStepPath(node_runtime_id);
	}

	@RequestMapping(value = "listTemplates", method = RequestMethod.GET)
	@Override
	public ApiResult listTemplates(String kind_id) {
		return workflowRuntimeApi.listTemplates(kind_id);
	}
}
