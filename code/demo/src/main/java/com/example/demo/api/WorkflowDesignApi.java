package com.example.demo.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import qinglian.workflow.sdk.api.interfaces.IWorkflowDesignApi;
import qinglian.workflow.sdk.api.vos.GraphVO;
import qinglian.workflow.sdk.api.vos.PageVO;
import qinglian.workflow.sdk.common.returns.ApiResult;
import qinglian.workflow.sdk.persistence.pos.BusinessFormPO;
import qinglian.workflow.sdk.persistence.pos.BusinessModelPO;
import qinglian.workflow.sdk.persistence.pos.BusinessModelWorkflowRelationPO;
import qinglian.workflow.sdk.persistence.pos.KindPO;
import qinglian.workflow.sdk.persistence.pos.TemplatePO;

@RestController
@RequestMapping(value="/v1/api/workflow-design")
public class WorkflowDesignApi implements IWorkflowDesignApi {
	@Qualifier("WorkflowDesignApiImpl")
	@Autowired
	IWorkflowDesignApi workflowDesignApiImpl;

	@RequestMapping(value = "saveOrUpdateTemplate", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateTemplate(@RequestBody TemplatePO templatePO) {
		return workflowDesignApiImpl.saveOrUpdateTemplate(templatePO);
	}

	@RequestMapping(value = "getTemplateDetail", method = RequestMethod.GET)
	@Override
	public ApiResult getTemplateDetail(String id) {
		return workflowDesignApiImpl.getTemplateDetail(id);
	}

	@RequestMapping(value = "deleteTemplate", method = RequestMethod.POST)
	@Override
	public ApiResult deleteTemplate(String id) {
		return workflowDesignApiImpl.deleteTemplate(id);
	}

	@RequestMapping(value = "listTemplates", method = RequestMethod.GET)
	@Override
	public ApiResult listTemplates(String kind_id) {
		return workflowDesignApiImpl.listTemplates(kind_id);
	}

	@RequestMapping(value = "saveOrUpdateTemplateKind", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateTemplateKind(@RequestBody KindPO kindPO) {
		return workflowDesignApiImpl.saveOrUpdateTemplateKind(kindPO);
	}

	@RequestMapping(value = "getTemplateKindDetail", method = RequestMethod.GET)
	@Override
	public ApiResult getTemplateKindDetail(String id) {
		return workflowDesignApiImpl.getTemplateKindDetail(id);
	}

	@RequestMapping(value = "deleteTemplateKind", method = RequestMethod.POST)
	@Override
	public ApiResult deleteTemplateKind(String id) {
		return workflowDesignApiImpl.deleteTemplateKind(id);
	}

	@RequestMapping(value = "listTemplateKinds", method = RequestMethod.GET)
	@Override
	public ApiResult listTemplateKinds() {
		return workflowDesignApiImpl.listTemplateKinds();
	}

	@RequestMapping(value = "saveOrUpdateTemplateGraphData", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateTemplateGraphData(GraphVO graphVO) {
		return workflowDesignApiImpl.saveOrUpdateTemplateGraphData(graphVO);
	}

	@RequestMapping(value = "getGraphDetailByTemplateId", method = RequestMethod.GET)
	@Override
	public ApiResult getGraphDetailByTemplateId(String id) {
		return workflowDesignApiImpl.getGraphDetailByTemplateId(id);
	}

	@RequestMapping(value = "saveOrUpdateBusinessModel", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateBusinessModel(@RequestBody BusinessModelPO businessModelPO) {
		return workflowDesignApiImpl.saveOrUpdateBusinessModel(businessModelPO);
	}

	@RequestMapping(value = "getBusinessModelDetail", method = RequestMethod.GET)
	@Override
	public ApiResult getBusinessModelDetail(String id) {
		return workflowDesignApiImpl.getBusinessModelDetail(id);
	}

	@RequestMapping(value = "deleteBusinessModel", method = RequestMethod.POST)
	@Override
	public ApiResult deleteBusinessModel(String id) {
		return workflowDesignApiImpl.deleteBusinessModel(id);
	}

	@RequestMapping(value = "listBusinessModel", method = RequestMethod.GET)
	@Override
	public ApiResult listBusinessModel(PageVO pageVO, Map<String, Object> params) {
		return workflowDesignApiImpl.listBusinessModel(pageVO, params);
	}

	@RequestMapping(value = "saveOrUpdateBusinessModelWorkflowRelation", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateBusinessModelWorkflowRelation(
			@RequestBody BusinessModelWorkflowRelationPO businessModelWorkflowRelationPO) {
		return workflowDesignApiImpl.saveOrUpdateBusinessModelWorkflowRelation(businessModelWorkflowRelationPO);
	}

	@RequestMapping(value = "getModelWorkflowRelation", method = RequestMethod.GET)
	@Override
	public ApiResult getModelWorkflowRelation(String template_id) {
		return workflowDesignApiImpl.getModelWorkflowRelation(template_id);
	}

	@RequestMapping(value = "saveOrUpdateBusinessForm", method = RequestMethod.POST)
	@Override
	public ApiResult saveOrUpdateBusinessForm(@RequestBody BusinessFormPO businessFormPO) {
		return workflowDesignApiImpl.saveOrUpdateBusinessForm(businessFormPO);
	}

	@RequestMapping(value = "getBusinessFormDetail", method = RequestMethod.GET)
	@Override
	public ApiResult getBusinessFormDetail(String id) {
		return workflowDesignApiImpl.getBusinessFormDetail(id);
	}

	@RequestMapping(value = "deleteBusinessForm", method = RequestMethod.POST)
	@Override
	public ApiResult deleteBusinessForm(String id) {
		return workflowDesignApiImpl.deleteBusinessForm(id);
	}

	@RequestMapping(value = "listBusinessForm", method = RequestMethod.GET)
	@Override
	public ApiResult listBusinessForm(PageVO pageVO, Map<String, Object> params) {
		return workflowDesignApiImpl.listBusinessForm(pageVO, params);
	}

	@RequestMapping(value = "listTemplateHistoryGraph", method = RequestMethod.GET)
	@Override
	public ApiResult listTemplateHistoryGraph(PageVO pageVO, @RequestParam Map<String, Object> params) {
		return workflowDesignApiImpl.listTemplateHistoryGraph(pageVO, params);
	}

	@RequestMapping(value = "trashHistoryGraph", method = RequestMethod.POST)
	@Override
	public ApiResult trashHistoryGraph(@RequestBody Map<String, Object> params) {
		return workflowDesignApiImpl.trashHistoryGraph(params);
	}

	@RequestMapping(value = "rollbackToHistoryGraph", method = RequestMethod.POST)
	@Override
	public ApiResult rollbackToHistoryGraph(@RequestBody Map<String, Object> params) {
		return workflowDesignApiImpl.rollbackToHistoryGraph(params);
	}

	@RequestMapping(value = "getGraphDetailByGraphId", method = RequestMethod.GET)
	@Override
	public ApiResult getGraphDetailByGraphId(String id) {
		return workflowDesignApiImpl.getGraphDetailByGraphId(id);
	}

}
