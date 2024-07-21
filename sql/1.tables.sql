CREATE TABLE t_wf_kind (
	kind_id VARCHAR(36) NOT NULL,
	kind_name VARCHAR(100) NOT NULL,
	kind_desc VARCHAR(400),
	parent_kind_id VARCHAR(36),
	order_no INT,
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (kind_id)
) ;

CREATE TABLE t_wf_template (
	template_id VARCHAR(36) NOT NULL,
	wf_id VARCHAR(36),
	kind_id VARCHAR(36),
	template_name VARCHAR(1000),
	is_active INT default 0,
	template_description VARCHAR(400),
	start_date DATETIME,
    end_date DATETIME,
	main_ver INT,
	order_no INT default 0,
	pending_title VARCHAR(400),
	extend_property VARCHAR(4000),
	is_delete INT default 0,
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (template_id)
) ;

CREATE TABLE t_wf_graph (
	graph_id VARCHAR(36) NOT NULL,
	template_id VARCHAR(36) NOT NULL,
	graph_content LONGBLOB,
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (graph_id)
) ;

CREATE TABLE t_wf_graph_step (
	step_id VARCHAR(36) NOT NULL,
	graph_id VARCHAR(36) NOT NULL,
	step_name VARCHAR(100) NOT NULL,
	element_id VARCHAR(36) NOT NULL,
	step_type INT,
	step_predecessors VARCHAR(2000),
	step_successors VARCHAR(2000),
	step_json TEXT(65535),
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (step_id)
) ;

CREATE TABLE t_wf_graph_relation (
	relation_id VARCHAR(36) NOT NULL,
	graph_id VARCHAR(36) NOT NULL,
	source_step_id VARCHAR(36),
	target_step_id VARCHAR(36),
	element_id VARCHAR(36) NOT NULL,
	source_element_id VARCHAR(36),
	target_element_id VARCHAR(36),
	relation_json TEXT(65535),
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (relation_id)
) ;

CREATE TABLE t_wf_action_dic (
	id INT NOT NULL,
	action_name VARCHAR(100),
	i18n_key VARCHAR(100),
	can_config_step INT,
	is_need_ui INT,
	is_need_remind INT,
	CONSTRAINT `PRIMARY` PRIMARY KEY (id)
) ;

CREATE TABLE t_wf_process_runtime (
	process_runtime_id VARCHAR(36) NOT NULL,
	template_id VARCHAR(36),
	process_name VARCHAR(1000),
	owner_user_id VARCHAR(36),
	owner_user_name VARCHAR(100),
	process_status INT,
	is_closed INT DEFAULT 0,
	current_step_names VARCHAR(2000),
	current_step_ids VARCHAR(2000),
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (process_runtime_id)
) ;

CREATE TABLE t_wf_step_runtime (
	step_runtime_id VARCHAR(36) NOT NULL,
	step_id VARCHAR(36),
	process_runtime_id VARCHAR(36),
	step_runtime_status INT,
	is_current INT DEFAULT 0,
	last_step_runtime_id VARCHAR(36),
	next_step_args varchar(2000),
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (step_runtime_id)
) ;

CREATE TABLE t_wf_node_runtime (
	node_runtime_id VARCHAR(36) NOT NULL,
	step_runtime_id VARCHAR(36),
	auditor VARCHAR(36),
	auditor_name VARCHAR(200),
	node_runtime_status INT,
	handler VARCHAR(200),
	handler_name VARCHAR(100),
	business_data LONGTEXT,
	hand_action varchar(36),
	hand_action_summary varchar(100),
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (node_runtime_id)
) ;

CREATE TABLE t_wf_process_pending (
	process_pending_id VARCHAR(36) NOT NULL,
	process_runtime_id VARCHAR(36),
	node_runtime_id VARCHAR(36),
	auditor_id VARCHAR(36),
	auditor_name VARCHAR(100),
	is_deleted INT DEFAULT 0,
	pending_status INT DEFAULT 0,
	pending_type int default 0,
	update_date DATETIME DEFAULT current_timestamp NOT NULL,
	create_date DATETIME DEFAULT current_timestamp NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (process_pending_id)
) ;

CREATE TABLE `t_wf_idempotent` (
  `idempotent_id` varchar(36) NOT NULL,
  `operator_id` varchar(36) NOT NULL,
  `operator_name` varchar(100) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idempotent_id`)
);