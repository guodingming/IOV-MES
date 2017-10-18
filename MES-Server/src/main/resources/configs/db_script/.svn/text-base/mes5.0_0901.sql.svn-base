-- --------------------------------------------------------
-- 主机:                           192.168.5.12
-- 服务器版本:                        5.6.35 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5141
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 mes_db_test 的数据库结构
DROP DATABASE IF EXISTS `mes_db_test`;
CREATE DATABASE IF NOT EXISTS `mes_db_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mes_db_test`;

-- 导出  表 mes_db_test.exec_system_module_copy 结构
DROP TABLE IF EXISTS `exec_system_module_copy`;
CREATE TABLE IF NOT EXISTS `exec_system_module_copy` (
  `system_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL,
  `sub_module_id` bigint(20) NOT NULL,
  `system_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`system_id`,`module_id`,`sub_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.exec_system_module_copy 的数据：~0 rows (大约)
DELETE FROM `exec_system_module_copy`;
/*!40000 ALTER TABLE `exec_system_module_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `exec_system_module_copy` ENABLE KEYS */;

-- 导出  表 mes_db_test.exec_transmit_set_tb 结构
DROP TABLE IF EXISTS `exec_transmit_set_tb`;
CREATE TABLE IF NOT EXISTS `exec_transmit_set_tb` (
  `send_module` bigint(20) NOT NULL,
  `send_sub_module` bigint(20) NOT NULL,
  `send_message` bigint(20) NOT NULL,
  `receive_module` bigint(20) NOT NULL,
  `receive_sub_module` bigint(20) NOT NULL,
  `receive_message` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`send_module`,`send_sub_module`,`send_message`,`receive_module`,`receive_sub_module`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.exec_transmit_set_tb 的数据：~0 rows (大约)
DELETE FROM `exec_transmit_set_tb`;
/*!40000 ALTER TABLE `exec_transmit_set_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `exec_transmit_set_tb` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_agent 结构
DROP TABLE IF EXISTS `mes_agent`;
CREATE TABLE IF NOT EXISTS `mes_agent` (
  `id` varchar(50) DEFAULT NULL,
  `workstation_id` varchar(50) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT 'agent状态，0为离线，1为在线'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_agent 的数据：~0 rows (大约)
DELETE FROM `mes_agent`;
/*!40000 ALTER TABLE `mes_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_agent` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dept 结构
DROP TABLE IF EXISTS `mes_dept`;
CREATE TABLE IF NOT EXISTS `mes_dept` (
  `id` varchar(50) NOT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dept 的数据：~1 rows (大约)
DELETE FROM `mes_dept`;
/*!40000 ALTER TABLE `mes_dept` DISABLE KEYS */;
INSERT INTO `mes_dept` (`id`, `parent_id`, `name`, `code`, `description`, `create_date`, `update_date`) VALUES
	('HD68D16B21F3D4D2D80A4283CF0CF4F75', '0', '技术部', '01', NULL, NULL, NULL);
/*!40000 ALTER TABLE `mes_dept` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dept_expand 结构
DROP TABLE IF EXISTS `mes_dept_expand`;
CREATE TABLE IF NOT EXISTS `mes_dept_expand` (
  `exp_f1` varchar(30) DEFAULT NULL,
  `exp_f2` int(11) DEFAULT NULL,
  `id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dept_expand 的数据：~0 rows (大约)
DELETE FROM `mes_dept_expand`;
/*!40000 ALTER TABLE `mes_dept_expand` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dept_expand` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_barcode 结构
DROP TABLE IF EXISTS `mes_dp_barcode`;
CREATE TABLE IF NOT EXISTS `mes_dp_barcode` (
  `id` varchar(50) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `generation` varchar(50) DEFAULT NULL,
  `function_type_id` varchar(50) DEFAULT NULL,
  `function_id` varchar(50) DEFAULT NULL,
  `rule_type_id` varchar(50) DEFAULT NULL,
  `rule_id` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `type_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_barcode 的数据：~0 rows (大约)
DELETE FROM `mes_dp_barcode`;
/*!40000 ALTER TABLE `mes_dp_barcode` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_barcode` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_barcode_type 结构
DROP TABLE IF EXISTS `mes_dp_barcode_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_barcode_type` (
  `id` varchar(50) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_barcode_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_barcode_type`;
/*!40000 ALTER TABLE `mes_dp_barcode_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_barcode_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_box 结构
DROP TABLE IF EXISTS `mes_dp_box`;
CREATE TABLE IF NOT EXISTS `mes_dp_box` (
  `id` varchar(50) NOT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  `box_key` varchar(50) DEFAULT NULL,
  `barcode_type_id` varchar(50) DEFAULT NULL,
  `barcode_id` varchar(50) DEFAULT NULL,
  `label_type_id` varchar(50) DEFAULT NULL,
  `label_id` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `is_forced_pack` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_box 的数据：~0 rows (大约)
DELETE FROM `mes_dp_box`;
/*!40000 ALTER TABLE `mes_dp_box` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_box` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_box_pallet 结构
DROP TABLE IF EXISTS `mes_dp_box_pallet`;
CREATE TABLE IF NOT EXISTS `mes_dp_box_pallet` (
  `id` varchar(50) NOT NULL,
  `pallet_key` varchar(50) DEFAULT NULL,
  `barcode_type_id` varchar(50) DEFAULT NULL,
  `barcode_id` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `capacity` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `label_type_id` varchar(50) DEFAULT NULL,
  `label_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_box_pallet 的数据：~0 rows (大约)
DELETE FROM `mes_dp_box_pallet`;
/*!40000 ALTER TABLE `mes_dp_box_pallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_box_pallet` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_box_pallet_info 结构
DROP TABLE IF EXISTS `mes_dp_box_pallet_info`;
CREATE TABLE IF NOT EXISTS `mes_dp_box_pallet_info` (
  `id` varchar(50) NOT NULL,
  `pallet_id` varchar(50) DEFAULT NULL,
  `box_id` varchar(50) DEFAULT NULL,
  `box_key` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_box_pallet_info 的数据：~0 rows (大约)
DELETE FROM `mes_dp_box_pallet_info`;
/*!40000 ALTER TABLE `mes_dp_box_pallet_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_box_pallet_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_box_product_info 结构
DROP TABLE IF EXISTS `mes_dp_box_product_info`;
CREATE TABLE IF NOT EXISTS `mes_dp_box_product_info` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `pd_name` varchar(50) DEFAULT NULL,
  `soft_version` varchar(500) DEFAULT NULL,
  `hard_version` varchar(50) DEFAULT NULL,
  `work_order_id` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `work_order_batch_num` varchar(50) DEFAULT NULL,
  `box_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_box_product_info 的数据：~0 rows (大约)
DELETE FROM `mes_dp_box_product_info`;
/*!40000 ALTER TABLE `mes_dp_box_product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_box_product_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_data_dictionary 结构
DROP TABLE IF EXISTS `mes_dp_data_dictionary`;
CREATE TABLE IF NOT EXISTS `mes_dp_data_dictionary` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `mes_dp_data_dictionary_type_id` varchar(50) DEFAULT NULL COMMENT '属所数据字典分类ID',
  `cn_name` varchar(50) DEFAULT NULL COMMENT '字典中文名',
  `key_k` varchar(50) DEFAULT NULL COMMENT '字典key',
  `value_v` varchar(50) DEFAULT NULL COMMENT '字典value',
  `description` longtext COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-数据字典表';

-- 正在导出表  mes_db_test.mes_dp_data_dictionary 的数据：~0 rows (大约)
DELETE FROM `mes_dp_data_dictionary`;
--com组件接口使用
insert into `mes_dp_data_dictionary` (`id`, `mes_dp_data_dictionary_type_id`, `cn_name`, `key_k`, `value_v`, `description`, `create_date`) values('H4454F0C8AA204E25844D3A117729CE15','6376A83CB15E448FB2C88B45F7913BF8','温度上限','procedure_top','procedure_top','','2017-09-07 15:38:34');
--com组件接口使用
insert into `mes_dp_data_dictionary` (`id`, `mes_dp_data_dictionary_type_id`, `cn_name`, `key_k`, `value_v`, `description`, `create_date`) values('H60A4C494C4534E11BC0A782027CC9249','6376A83CB15E448FB2C88B45F7913BF8','温度下限','procedure_bottom','procedure_bottom','','2017-09-07 15:38:49');
/*!40000 ALTER TABLE `mes_dp_data_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_data_dictionary` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_data_dictionary_type 结构
DROP TABLE IF EXISTS `mes_dp_data_dictionary_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_data_dictionary_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '字典分类名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-数据字典类型';

-- 正在导出表  mes_db_test.mes_dp_data_dictionary_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_data_dictionary_type`;
insert into `mes_dp_data_dictionary_type` (`id`, `name`, `create_date`) values('6327FB5622D44B07AB2D2150BFF1AE1E','工序扩展属性','2017-08-07 09:58:16');
--com组件接口使用
insert into `mes_dp_data_dictionary_type` (`id`, `name`, `create_date`) values('6376A83CB15E448FB2C88B45F7913BF8','工序字典','2017-08-03 16:29:11');
insert into `mes_dp_data_dictionary_type` (`id`, `name`, `create_date`) values('88167A96142A460FAC5AE377904A9F3C','生产BOM属性名','2017-08-01 14:13:38');
/*!40000 ALTER TABLE `mes_dp_data_dictionary_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_data_dictionary_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_form 结构
DROP TABLE IF EXISTS `mes_dp_form`;
CREATE TABLE IF NOT EXISTS `mes_dp_form` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '表单名称',
  `form_type_id` varchar(50) DEFAULT NULL COMMENT '属所表单分类',
  `url` varchar(50) DEFAULT NULL COMMENT '表单URL',
  `javascript` longtext,
  `html` longtext COMMENT '内容',
  `height` varchar(10) DEFAULT NULL,
  `width` varchar(10) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-表单';

-- 正在导出表  mes_db_test.mes_dp_form 的数据：~6 rows (大约)
DELETE FROM `mes_dp_form`;
/*!40000 ALTER TABLE `mes_dp_form` DISABLE KEYS */;
INSERT INTO `mes_dp_form` (`id`, `name`, `form_type_id`, `url`, `javascript`, `html`, `height`, `width`, `description`, `create_date`) VALUES
	('AB30C1589ACF4A069E91D87FF8CE9117', 'PCBA检验上料-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, 'window.mes__tool = {\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n    	window.mes_form_main.get("/mes/dproutes/startWorkFlow",{\n            SN: $("#mes__tool .mes__tool__pdCode").val(),\n            num: window.mes_form_main.info.workOrder.num,\n            pdId: window.mes_form_main.info.workOrder.pdId,\n            workOrderId:window.mes_form_main.info.workOrder.id\n        },()=>{\n            window.mes__table.queryData()\n        })\n	}\n}\n\nwindow.mes__table = {\n  	formOption:[{\n      prop: "sN",\n      label: "SN"\n    }, {\n      prop: "softVersion",\n      label: "软件版本"\n    }, {\n      prop: "hardVersion",\n      label: "硬件版本"\n    }, {\n      prop: "workOrderBatchNum",\n      label: "批次号"\n    }, {\n      prop: "status",\n      label: "状态"\n    }, {\n      prop: "createDate",\n      label: "创建时间"\n    }],\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		$("#mes__table thead tr").html(headString);\n		$("#mes__table tbody").html(bodyString);\n      	this.operate(\'<td><button class="mes__formDesign_button mes__formDesign_primary tiny" style="">良品</button><button class="mes__formDesign_button mes__formDesign_primary tiny" style="">不良品</button></td>\')\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    $("#mes__table thead tr").append("<th>操作</th>")\n	    $("#mes__table tbody tr").each(function(index,dom){\n	    	dom.append(template)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    $(".mes__table__index").each(function(index,dom){\n	    	dom.prepend(\'<input type="checkbox"/>\')\n	    })\n	},\n  	queryData: function(){\n    	window.mes_form_main.post("/mes/pdproductinfo/byCondition",{\n          workOrderId:window.mes_form_main.info.workOrder.id\n        },(res)=>{\n          this.loadData(this.formOption,res.content)\n          $(".opNum").html(res.content.length)\n          $(".rtNum").html(window.mes_form_main.info.workOrder.workOrderTotal - res.content.length)\n        })\n    }\n}\n\nwindow.mes__list = {\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n		$("#mes__list .list").empty()\n	    var htmlString = ""\n	    arr.forEach(function(val){\n	        htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n	    })\n		$("#mes__list .list").append(htmlString)\n	}\n}\n\nwindow.mes_form_main = {\n  	info: null,\n  	getInfo: function(){\n      	this.get("/mes/user/stationValidate",{}, (res) => {\n          this.info = res.content\n          this.init()\n        })\n    },\n  	get: function(url,data,callback){\n    	$.ajax({\n            url:url,\n            type:"GET",\n          	data: data,\n            success: (res) => {\n              callback(res)\n            }\n        })\n    },\n  	post: function(url,data,callback){\n     	$.ajax({\n          url:url,\n          type:"POST",\n          contentType: "application/json",\n          data: JSON.stringify(data),\n          success: (res) => {\n            callback(res)\n          }\n        })\n    },\n	init: function(){\n        $(".mes__tool__plate").val(this.info.workOrder.num)\n        $(".rqNum").html(this.info.workOrder.workOrderTotal)\n       	window.mes__table.queryData()\n    }\n}\n\nwindow.mes_form_main.getInfo()\n\n\n\n\n\n\n\n\n', '<div class="nodes" id="node_1503652747933" style="left: 20px; top: 10px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1405px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n		<div class="mes__formDesign_input_com" style="">\n			<span class="mes__formDesign_word small" style="">联板数量</span>\n			<div class="mes__formDesign_input tiny" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__plate" style="" disabled="">\n			</div>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503652776504" style="left: 20px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1405px;">\n    <span style="">提示：请输入产品条码</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503652790504" style="left: 20px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 939px; height: 527px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">投产信息</span>\n	<div class="nodes" id="node_1503652968422" containerid="node_1503652790504" style="left: 30px; top: 50px; position: absolute;">\n	<div class="mes__formDesign_label_com mes__formDesign_primary" style="">\n    <span class="word" style="">需求数量</span>\n    <span class="number rqNum" style="">0</span>\n	</div>\n</div>\n<div class="nodes" id="node_1503653021332" containerid="node_1503652790504" style="left: 350px; top: 50px; position: absolute;">\n	<div class="mes__formDesign_label_com mes__formDesign_success" style="">\n    <span class="word" style="">已投产数量</span>\n    <span class="number opNum" style="">0</span>\n	</div>\n</div>\n<div class="nodes" id="node_1503653030874" containerid="node_1503652790504" style="left: 670px; top: 50px; position: absolute;">\n	<div class="mes__formDesign_label_com mes__formDesign_warning" style="">\n    <span class="word" style="">剩余数量</span>\n    <span class="number rtNum" style="">0</span>\n	</div>\n</div>\n<div class="nodes" id="node_1503653097318" containerid="node_1503652790504" style="left: 24px; top: 214px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 882px;max-height: 290px;overflow: auto">\n		<table>\n			<thead>\n				<tr>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n<div class="nodes" id="node_1503653144950" containerid="node_1503652790504" style="left: 28px; top: 168px; position: absolute;">\n	<span class="mes__formDesign_word" style="">投产历史</span>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503652808824" style="left: 980px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 443px; height: 525px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">工单产品信息</span>\n	</div>\n</div>\n<div class="nodes" id="node_1503653243210" style="left: 1010px; top: 200px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="width: 374px;">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>', '683', '1438', '测试表单', '2017-08-14 10:41:16'),
	('H026E6B5BCF714B10B958F8D2A59F54F1', '包装-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, '\nwindow.mes__logo = {\n	id:"mes__logo",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	init: function(){\n		if(!window.systemData){\n			window.systemData = {\n				pdLine:"暂无数据",\n				status:"暂无数据"\n			}\n		}\n		function getDateStr(nowDate){\n			var res = ""\n			var str = ""; \n			var week = nowDate.getDay(); \n			if (week == 0) { \n			    str = "星期日"; \n			} else if (week == 1) { \n			    str = "星期一"; \n			} else if (week == 2) { \n			    str = "星期二"; \n			} else if (week == 3) { \n			    str = "星期三"; \n			} else if (week == 4) { \n			    str = "星期四"; \n			} else if (week == 5) { \n			    str = "星期五"; \n			} else if (week == 6) { \n			    str = "星期六"; \n			}  \n			str = " "+str+" "\n			res = nowDate.toLocaleString(\'chinese\',{hour12:false}).replace(/ /,str)\n			return res\n		}\n		var dom = this.getDom()\n		dom.querySelector(".date").innerHTML = getDateStr(new Date())\n		dom.querySelector(".pdLine").innerHTML = window.systemData.pdLine\n		dom.querySelector(".status").innerHTML = window.systemData.status\n		window.setInterval(function(){\n			dom.querySelector(".date").innerHTML = getDateStr(new Date())\n		},1000)\n	}\n	\n}\nwindow.mes__logo.init()	\n\n\nwindow.mes__tool = {\n	id:"mes__tool",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	/*\n	 * 获取产品编码值\n	 */\n	getPdCode: function(){\n		return this.getDom().querySelector(".mes__tool__pdCode").value\n	},\n	/*\n	 * 设置联板数量值\n	 */\n	setPlate: function(value){\n		this.getDom().querySelector(".mes__tool__plate").value = value\n	},\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n		console.log(this.getPdCode())\n	},\n	/*\n	 * 点击离开执行函数\n	 */\n	exit: function(){\n		window.location.href = "/"\n	}\n}\n\n\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\nwindow.mes__list = {\n	id:"mes__list",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n	     var htmlString = ""\n       arr.forEach(function(val){\n          htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n       })\n		  this.getDom().querySelector(".list").innerHTML = htmlString\n	}\n}\nwindow.mes__modal = {\n	/*\n	 * 初始化模态框\n	 */\n	init: function(){\n        $("#mes__modal").hide()\n	},\n    /*\n	 * show方法显示模态框\n	 */\n	show: function(){\n		$(window).append(\'<div class="mes__modal__mask"></div>\')\n		$("#mes__modal").css({"z-index":1040})\n		$("#mes__modal").fadeIn()\n	},\n    /*\n	 * show方法隐藏模态框\n	 */\n	hide: function(){\n		$(".mes__modal__mask").remove()\n		$("#mes__modal").css({"z-index":auto})\n		$("#mes__modal").fadeOut()\n	}\n}\nwindow.mes__modal.init()\n\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}', '\n<div class="nodes" id="node_1503653994268" style="left: 0px; top: 0px; position: absolute;">\n	<div class="mes__formDesign_logo" id="mes__logo" style="width: 1436px;">\n    	<div class="image">\n    	\n		</div>\n    	<div class="title">\n    		包装\n		</div>\n    	<div class="info">\n    		<div class="date">\n    			\n			</div>\n    		<div class="line">\n    			<span class="ball red"></span>\n    			<span class="word pdLine"></span>\n    			<span class="ball yellow"></span>\n    			<span class="word status"></span>\n			</div>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654003175" style="left: 10px; top: 90px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1415px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n		\n		<div class="mes__formDesign_input_com operate" style="">\n			<select class="mes__formDesign_select tiny" style="">\n			   <option disabled="" selected="">切换站点</option>\n			</select>\n			<div class="backSystem" style="">\n				<span class="icon-signout" style=""></span>\n				<span class="mes__formDesign_word small" style="" onclick="mes__tool.exit()">安全退出</span>\n			</div>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654019219" style="left: 10px; top: 160px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1413px;">\n    <span style="">提示：请输入产品条码</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503654055971" style="left: 10px; top: 220px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 947px; height: 644px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">装箱信息 &gt;&gt;</span>\n	<div class="nodes isContainer" id="node_1503654086875" containerid="node_1503654055971" style="left: 20px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_rect" style="width: 916px; height: 84px;"><div class="nodes" id="node_1503654103875" containerid="node_1503654086875" style="left: 4px; top: 24px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">箱号</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654121058" containerid="node_1503654086875" style="left: 284px; top: 24px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">额定数量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654170069" containerid="node_1503654086875" style="left: 482px; top: 22px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">已装数量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654233571" containerid="node_1503654086875" style="left: 692px; top: 22px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="window.mes__modal.show()">强制装箱</button>\n</div>\n<div class="nodes" id="node_1503654246944" containerid="node_1503654086875" style="left: 812px; top: 22px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_success" style="" onclick="window.mes__modal.show()">拆并箱</button>\n</div>\n</div>\n</div>\n<div class="nodes" id="node_1503654275712" containerid="node_1503654055971" style="left: 20px; top: 160px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 916px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503654069638" style="left: 990px; top: 220px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 435px; height: 643px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">文字示例</span>\n	<div class="nodes" id="node_1503654308202" containerid="node_1503654069638" style="left: 12px; top: 52px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>\n\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503656380339" style="left: 60px; top: 70px; position: absolute;">\n	<div class="mes__formDesign_modal in" id="mes__modal" style="width: 1324px; height: 673px;">\n	    <div class="head" style="">\n	    	装箱信息\n	    	<span class="exit icon-remove-sign" onclick="window.mes__modal.hide()"></span>\n	    </div>\n	<div class="nodes isContainer" id="node_1503656445274" containerid="node_1503656380339" style="left: 20px; top: 60px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 340px; height: 538px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">源箱信息</span>\n	<div class="nodes" id="node_1503656691887" containerid="node_1503656445274" style="left: 60px; top: 50px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">箱号</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656747144" containerid="node_1503656445274" style="left: 28px; top: 100px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">额定数量</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656749921" containerid="node_1503656445274" style="left: 60px; top: 150px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">数量</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656775926" containerid="node_1503656445274" style="left: 30px; top: 210px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 275px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503656597567" containerid="node_1503656380339" style="left: 560px; top: 60px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 336px; height: 536px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">移动产品</span>\n	<div class="nodes" id="node_1503656835659" containerid="node_1503656597567" style="left: 50px; top: 50px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">条码</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656846460" containerid="node_1503656597567" style="left: 20px; top: 210px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 288px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n\n\n<div class="nodes" id="node_1503658572367" containerid="node_1503656597567" style="left: 130px; top: 470px; position: absolute;">\n	<button style="" class="mes__formDesign_button mes__formDesign_primary small">移动到目标箱  &gt;&gt;</button>\n</div>\n<div class="nodes" id="node_1503658574830" containerid="node_1503656597567" style="left: 30px; top: 470px; position: absolute;">\n	<button style="" class="mes__formDesign_button mes__formDesign_danger small">&lt;&lt;  移除</button>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503656601084" containerid="node_1503656380339" style="left: 940px; top: 60px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 354px; height: 537px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">目标箱信息</span>\n	<div class="nodes" id="node_1503656899728" containerid="node_1503656601084" style="left: 30px; top: 210px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 288px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n<div class="nodes" id="node_1503656939145" containerid="node_1503656601084" style="left: 60px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">箱号</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656945215" containerid="node_1503656601084" style="left: 28px; top: 90px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">额定数量</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503656947711" containerid="node_1503656601084" style="left: 60px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">数量</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n</div>\n</div>\n\n<div class="nodes" id="node_1503658513753" containerid="node_1503656380339" style="left: 410px; top: 370px; position: absolute;">\n	<button style="" class="mes__formDesign_button mes__formDesign_primary small">添加  &gt;&gt;</button>\n</div>\n<div class="nodes" id="node_1503658518408" containerid="node_1503656380339" style="left: 410px; top: 420px; position: absolute;">\n	<button style="" class="mes__formDesign_button mes__formDesign_danger small">&lt;&lt;  移除</button>\n</div>\n</div>\n</div>', '900', '1440', '', '2017-08-24 18:12:39'),
	('H362E0201482740968BC047BDBE7DDC85', '维修站-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, 'window.mes__tool = {\n	id:"mes__tool",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	/*\n	 * 获取产品编码值\n	 */\n	getPdCode: function(){\n		return this.getDom().querySelector(".mes__tool__pdCode").value\n	},\n	/*\n	 * 设置联板数量值\n	 */\n	setPlate: function(value){\n		this.getDom().querySelector(".mes__tool__plate").value = value\n	},\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n		console.log(this.getPdCode())\n	}\n}\n\n\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\nwindow.mes__list = {\n	id:"mes__list",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n	     var htmlString = ""\n       arr.forEach(function(val){\n          htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n       })\n		  this.getDom().querySelector(".list").innerHTML = htmlString\n	}\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}', '<div class="nodes" id="node_1503652922733" style="left: 10px; top: 10px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1412px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503652949664" style="left: 10px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1412px;">\n    <span style="">提示：请输入产品条码！</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503652997802" style="left: 10px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 1412px; height: 157px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">维修</span>\n	<div class="nodes" id="node_1503653022745" containerid="node_1503652997802" style="left: 20px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 1369px;">\n		<table>\n			<thead>\n				<tr>\n					<th>产品名称</th>\n					<th>工单号</th>\n					<th>PCBA条码</th>\n                 	<th>产品条码</th>\n					<th>来源工序</th>\n					<th>原因</th>\n                  	<th>时间</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>PCBA天窗产品</td>\n					<td>Z10256102352</td>\n                  	<td>Z10256102352</td>\n					<td>NO017012</td>\n                  	<td>PCBA外壳组</td>\n					<td>检测</td>\n                  	<td>2017-08-08</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503653378946" containerid="node_1503652997802" style="left: 490px; top: 170px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 923px; height: 356px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">维修信息</span>\n	<div class="nodes isContainer" id="node_1503653416239" containerid="node_1503653378946" style="left: 20px; top: 42px; position: absolute;">\n	<div class="mes__formDesign_rect" style="width: 875px; height: 83px;"><div class="nodes" id="node_1503653535753" containerid="node_1503653416239" style="left: 46px; top: 18px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">良品</button>\n</div>\n<div class="nodes" id="node_1503653547669" containerid="node_1503653416239" style="left: 16px; top: 28px; position: absolute;">\n	<input class="mes__formDesign_checkbox" style="" type="checkbox">\n</div>\n<div class="nodes" id="node_1503653562901" containerid="node_1503653416239" style="left: 176px; top: 28px; position: absolute;">\n	<input class="mes__formDesign_checkbox" style="" type="checkbox">\n</div>\n<div class="nodes" id="node_1503653577156" containerid="node_1503653416239" style="left: 206px; top: 18px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_danger" style="">报废</button>\n</div>\n<div class="nodes" id="node_1503653691124" containerid="node_1503653416239" style="left: 810px; top: 102px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">删除</button>\n</div>\n<div class="nodes" id="node_1503653700474" containerid="node_1503653416239" style="left: 730px; top: 102px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">维修</button>\n</div>\n<div class="nodes" id="node_1503653709475" containerid="node_1503653416239" style="left: 650px; top: 102px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">添加</button>\n</div>\n<div class="nodes" id="node_1503653720915" containerid="node_1503653416239" style="left: 0px; top: 148px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 870px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes" id="node_1503653677628" containerid="node_1503653378946" style="left: 24px; top: 138px; position: absolute;">\n	<span class="mes__formDesign_word" style="">不良列表</span>\n</div>\n</div>\n</div>\n<div class="nodes" id="node_1503653646724" containerid="node_1503652997802" style="left: 832px; top: 232px; position: absolute;">\n	<div class="mes__formDesign_select_com" style="">\n		<span class="mes__formDesign_word" style="">转到工序</span>\n		<select class="mes__formDesign_select" style="">\n	   <option value="选项一">选项一</option>\n		 <option value="选项二">选项二</option>\n	</select>\n	</div>\n</div>\n<div class="nodes" id="node_1503653662012" containerid="node_1503652997802" style="left: 1262px; top: 232px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">确定</button>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503653295002" style="left: 10px; top: 310px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 480px; height: 355px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">测试记录</span>\n	<div class="nodes" id="node_1503653304890" containerid="node_1503653295002" style="left: 12px; top: 52px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="width: 444px;">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>\n</div>\n</div>', '683', '1438', '', '2017-08-24 18:38:37'),
	('H3CA30E87E19C485492896E160F6F818D', '组装-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, 'window.mes__tool = {\n	id:"mes__tool",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	/*\n	 * 获取产品编码值\n	 */\n	getPdCode: function(){\n		return this.getDom().querySelector(".mes__tool__pdCode").value\n	},\n	/*\n	 * 设置联板数量值\n	 */\n	setPlate: function(value){\n		this.getDom().querySelector(".mes__tool__plate").value = value\n	},\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n		console.log(this.getPdCode())\n	}\n}\n\n\nwindow.mes__logo = {\n	id:"mes__logo",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	init: function(){\n		if(!window.systemData){\n			window.systemData = {\n				pdLine:"暂无数据",\n				status:"暂无数据"\n			}\n		}\n		function getDateStr(nowDate){\n			var res = ""\n			var str = ""; \n			var week = nowDate.getDay(); \n			if (week == 0) { \n			    str = "星期日"; \n			} else if (week == 1) { \n			    str = "星期一"; \n			} else if (week == 2) { \n			    str = "星期二"; \n			} else if (week == 3) { \n			    str = "星期三"; \n			} else if (week == 4) { \n			    str = "星期四"; \n			} else if (week == 5) { \n			    str = "星期五"; \n			} else if (week == 6) { \n			    str = "星期六"; \n			}  \n			str = " "+str+" "\n			res = nowDate.toLocaleString(\'chinese\',{hour12:false}).replace(/ /,str)\n			return res\n		}\n		var dom = this.getDom()\n		dom.querySelector(".date").innerHTML = getDateStr(new Date())\n		dom.querySelector(".pdLine").innerHTML = window.systemData.pdLine\n		dom.querySelector(".status").innerHTML = window.systemData.status\n		window.setInterval(function(){\n			dom.querySelector(".date").innerHTML = getDateStr(new Date())\n		},1000)\n	}\n	\n}\nwindow.mes__logo.init()	\n\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\nwindow.mes__list = {\n	id:"mes__list",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n	     var htmlString = ""\n       arr.forEach(function(val){\n          htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n       })\n		  this.getDom().querySelector(".list").innerHTML = htmlString\n	}\n}', '<div class="nodes" id="node_1503655033154" style="left: 10px; top: 10px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1411px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503655054439" style="left: 10px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1409px;">\n    <span style="">提示：请输入产品条码！</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503655316012" style="left: 10px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 968px; height: 135px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">PCBA信息</span>\n	\n<div class="nodes isContainer" id="node_1503655415601" containerid="node_1503655316012" style="left: 10px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_rect" style="width: 945px; height: 77px;"><div class="nodes" id="node_1503655432833" containerid="node_1503655415601" style="left: 20px; top: 20px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">PCBA SN</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503655439384" containerid="node_1503655415601" style="left: 330px; top: 20px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">状态</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n</div>\n</div>\n</div>\n</div>\n\n\n<div class="nodes isContainer" id="node_1503655377163" style="left: 990px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 430px; height: 532px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">工单产品信息</span>\n	<div class="nodes" id="node_1503655732003" containerid="node_1503655377163" style="left: 20px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>\n</div>\n</div>\n\n<div class="nodes isContainer" id="node_1503655588864" style="left: 10px; top: 280px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 440px; height: 392px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">已绑定物料信息</span>\n	<div class="nodes" id="node_1503655615978" containerid="node_1503655588864" style="left: 10px; top: 40px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 411px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503655628222" style="left: 460px; top: 280px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 520px; height: 392px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">工位批次物料信息</span>\n	<div class="nodes" id="node_1503655676528" containerid="node_1503655628222" style="left: 10px; top: 40px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">上料</button>\n</div>\n<div class="nodes" id="node_1503655679907" containerid="node_1503655628222" style="left: 90px; top: 40px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_success" style="">移除</button>\n</div>\n<div class="nodes" id="node_1503655718345" containerid="node_1503655628222" style="left: 10px; top: 90px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 492px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>', '683', '1438', '', '2017-08-24 17:44:02'),
	('HA66E4DD1FFA7493BA87823490B43D3B3', '三防检验-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, 'window.mes__tool = {\n	id:"mes__tool",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	/*\n	 * 获取产品编码值\n	 */\n	getPdCode: function(){\n		return this.getDom().querySelector(".mes__tool__pdCode").value\n	},\n	/*\n	 * 设置联板数量值\n	 */\n	setPlate: function(value){\n		this.getDom().querySelector(".mes__tool__plate").value = value\n	},\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n		console.log(this.getPdCode())\n	}\n}\n\n\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}\nwindow.mes__list = {\n	id:"mes__list",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n	     var htmlString = ""\n       arr.forEach(function(val){\n          htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n       })\n		  this.getDom().querySelector(".list").innerHTML = htmlString\n	}\n}', '<div class="nodes" id="node_1503654961621" style="left: 10px; top: 10px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1410px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n		<div class="mes__formDesign_input_com" style="">\n			<span class="mes__formDesign_word small" style="">联板数量</span>\n			<div class="mes__formDesign_input tiny" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__plate" style="" disabled="">\n			</div>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654974485" style="left: 10px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1410px;">\n    <span style="">提示：请输入产品条码</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503654984236" style="left: 10px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 897px; height: 529px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">主操作区</span>\n	\n<div class="nodes" id="node_1503655685683" containerid="node_1503654984236" style="left: 20px; top: 40px; position: absolute;">\n	<span class="mes__formDesign_word" style="">产品信息</span>\n</div>\n<div class="nodes" id="node_1503655696131" containerid="node_1503654984236" style="left: 20px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 858px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503655001089" style="left: 920px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 499px; height: 526px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">工单产品信息</span>\n	</div>\n</div>\n\n\n\n\n<div class="nodes" id="node_1503655710553" style="left: 950px; top: 190px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="width: 441px;">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>', '683', '1438', '', '2017-08-24 13:16:28'),
	('HD8424F5298594A15BD8D5786D5110CF6', '标签打印-不要删', '0616B428C5A94A919C5BDF1396AD7051', NULL, 'window.mes__tool = {\n	id:"mes__tool",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n	/*\n	 * 获取产品编码值\n	 */\n	getPdCode: function(){\n		return this.getDom().querySelector(".mes__tool__pdCode").value\n	},\n	/*\n	 * 设置联板数量值\n	 */\n	setPlate: function(value){\n		this.getDom().querySelector(".mes__tool__plate").value = value\n	},\n	/*\n	 * 点击提交执行函数\n	 */\n	submit: function(){\n		console.log(this.getPdCode())\n	}\n}\n\n\nwindow.mes__list = {\n	id:"mes__list",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * loadData()方法实现加载list的数据列表\n	 * arr数组中数据格式为:[{name:\'key\',value:\'1\'},{name:\'key2\',value:\'2\'}]\n	 */\n	loadData: function(arr){\n	     var htmlString = ""\n       arr.forEach(function(val){\n          htmlString+= \'<li><div class="key">\'+val.name+\'</div><div class="value">\'+val.value+\'</div></li>\'\n       })\n		  this.getDom().querySelector(".list").innerHTML = htmlString\n	}\n}\n\nwindow.mes__table = {\n	id:"mes__table",\n	getDom: function(){\n		return document.querySelector("#"+this.id)\n	},\n    /*\n	 * 加载表格的数据列表\n	 * 参数:\n	 * option 表头中文与字段key对应数组 例:[{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}]\n	 * data 列表数据数组 例:[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}]\n	 * mes__table.loadData([{ prop: "name1",label: "字段名称一"},{ prop: "name2",label: "字段名称二"}],[{name1:\'1\',name2:1},{name1:\'2\',name2:2},{name1:\'3\',name2:3}])\n	 */\n	loadData: function(option,data){\n	    var headString = "<th>序号</th>";\n	    var bodyString = "";\n	    var head = [\'$index\']\n	    option.forEach(function(val){\n        	headString+= \'<th>\'+val.label+\'</th>\'\n        	head.push(val.prop)\n		})\n        data.forEach(function(val,index){\n        	bodyString+= (\'<tr>\'+\n        	(function(data){\n	            var string = "";\n	            head.forEach(function(val){\n	            	if(val == \'$index\'){\n	            		string+=\'<td class="mes__table__index">\'+(index+1)+\'</td>\'\n	            	}\n	            	else{\n	            		string+=\'<td>\'+(data[val]||"")+\'</td>\'\n	            	}\n	               \n	            })\n	            return string\n        	})(val)\n            +\'</tr>\')\n		})\n		this.getDom().querySelector("thead tr").innerHTML = headString;\n		this.getDom().querySelector("tbody").innerHTML = bodyString;\n	},\n	/*\n	 * 追加操作列并添加自定义模板\n	 * 参数:\n	 * template 自定义操作列模板 例:\'<span class="icon-eye-open"></span>\'\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	operate: function(template){\n	    var th = document.createElement("th")\n	    th.innerHTML = "操作";\n	    this.getDom().querySelector("thead tr").appendChild(th)\n	    this.getDom().querySelectorAll("tbody tr").forEach(function(val){\n	     	var td = document.createElement("td")\n	    	td.innerHTML = template;\n	    	val.appendChild(td)\n	    })\n	},\n	/*\n	 * 追加多选框\n	 * mes__table.operate(\'<span class="icon-eye-open"></span>\')\n	 */\n	checkbox:function(){\n	    this.getDom().querySelectorAll(".mes__table__index").forEach(function(val){\n	    	val.innerHTML = \'<input type="checkbox"/>\' + val.innerHTML\n	    })\n	},\n}', '<div class="nodes" id="node_1503654361990" style="left: 10px; top: 10px; position: absolute;">\n	<div class="mes__formDesign_tool" style="width: 1414px;" id="mes__tool">\n		<div class="mes__formDesign_input_com pd" style="">\n			<span class="mes__formDesign_word" style="">产品条码</span>\n			<div class="mes__formDesign_input" style="">\n			   <input class="mes__formDesign_input_inner mes__tool__pdCode" style="" placeholder="请输入关键字">\n			</div>\n		</div>\n		<div class="mes__formDesign_input_com button" style="">\n			<button class="mes__formDesign_button mes__formDesign_primary" style="" onclick="mes__tool.submit()">确定</button>\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654386509" style="left: 10px; top: 80px; position: absolute;">\n	<div class="mes__formDesign_alert mes__formDesign_warning" style="width: 1414px;">\n    <span style="">提示：请输入产品条码</span>\n	</div>\n</div>\n<div class="nodes isContainer" id="node_1503654398533" style="left: 10px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 971px; height: 531px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">抽检信息</span>\n	<div class="nodes isContainer" id="node_1503654495449" containerid="node_1503654398533" style="left: 12px; top: 42px; position: absolute;">\n	<div class="mes__formDesign_rect" style="width: 946px; height: 148px;"><div class="nodes" id="node_1503654522403" containerid="node_1503654495449" style="left: 8px; top: 18px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">抽检总量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner " style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654530155" containerid="node_1503654495449" style="left: 6px; top: 76px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">放行</button>\n</div>\n<div class="nodes" id="node_1503654537232" containerid="node_1503654495449" style="left: 126px; top: 76px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_danger" style="">批退</button>\n</div>\n<div class="nodes" id="node_1503654561587" containerid="node_1503654495449" style="left: 218px; top: 18px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">已抽数量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner " style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654588244" containerid="node_1503654495449" style="left: 436px; top: 16px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">良品数量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner " style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654681921" containerid="node_1503654495449" style="left: 634px; top: 14px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">不良数量</span>\n		<div class="mes__formDesign_input tiny" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503654734960" containerid="node_1503654398533" style="left: 10px; top: 200px; position: absolute;">\n	<div class="mes__formDesign_rect" style="width: 945px; height: 105px;"><div class="nodes" id="node_1503654816380" containerid="node_1503654734960" style="left: 8px; top: 28px; position: absolute;">\n	<div class="mes__formDesign_input_com" style="">\n		<span class="mes__formDesign_word" style="">条码回显</span>\n		<div class="mes__formDesign_input" style="">\n		   <input class="mes__formDesign_input_inner" style="" placeholder="请输入关键字">\n		</div>\n	</div>\n</div>\n<div class="nodes" id="node_1503654835582" containerid="node_1503654734960" style="left: 308px; top: 28px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_primary" style="">良品</button>\n</div>\n<div class="nodes" id="node_1503654842648" containerid="node_1503654734960" style="left: 410px; top: 30px; position: absolute;">\n	<button class="mes__formDesign_button mes__formDesign_danger" style="">不良品</button>\n</div>\n</div>\n</div>\n<div class="nodes" id="node_1503654878023" containerid="node_1503654398533" style="left: 10px; top: 320px; position: absolute;">\n	<div class="mes__formDesign_table" id="mes__table" style="width: 943px;">\n		<table>\n			<thead>\n				<tr>\n					<th>示例key1</th>\n					<th>示例key2</th>\n					<th>示例key3</th>\n				</tr>\n			</thead>\n			<tbody>\n				<tr>\n					<td>示例value1</td>\n					<td>示例value2</td>\n					<td>示例value3</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n</div>\n</div>\n</div>\n<div class="nodes isContainer" id="node_1503654416862" style="left: 990px; top: 140px; position: absolute;">\n	<div class="mes__formDesign_container" style="width: 435px; height: 527px;">\n		<div class="border" style=""></div>\n		<span class="mes__formDesign_label" style="">工单产品信息</span>\n	<div class="nodes" id="node_1503654441195" containerid="node_1503654416862" style="left: 16px; top: 46px; position: absolute;">\n	<div class="mes__formDesign_list" id="mes__list" style="">\n    	<ul class="list">\n    		<li>\n    			<div class="key">key1</div>\n    			<div class="value">value1</div>\n    		</li>\n    		<li>\n    			<div class="key">key2</div>\n    			<div class="value">value2</div>\n    		</li>\n    		<li>\n    			<div class="key">key3</div>\n    			<div class="value">value3</div>\n    		</li>\n    	</ul>\n	</div>\n</div>\n</div>\n</div>', '683', '1438', '标签打印-不要删', '2017-08-24 17:53:03');
/*!40000 ALTER TABLE `mes_dp_form` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_form_type 结构
DROP TABLE IF EXISTS `mes_dp_form_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_form_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_name` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `name` varchar(50) DEFAULT NULL COMMENT '表单类型名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-表单类型管理';

-- 正在导出表  mes_db_test.mes_dp_form_type 的数据：~1 rows (大约)
DELETE FROM `mes_dp_form_type`;
/*!40000 ALTER TABLE `mes_dp_form_type` DISABLE KEYS */;
INSERT INTO `mes_dp_form_type` (`id`, `pd_id`, `pd_name`, `name`, `create_date`) VALUES
	('0616B428C5A94A919C5BDF1396AD7051', '2FF476D80D924FE9A4D9D01128ED2CBB', NULL, '工作站表单-不要删', '2017-08-14 10:38:31');
/*!40000 ALTER TABLE `mes_dp_form_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_function 结构
DROP TABLE IF EXISTS `mes_dp_function`;
CREATE TABLE IF NOT EXISTS `mes_dp_function` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL,
  `function_type_id` varchar(50) DEFAULT NULL COMMENT '属所函数分类ID',
  `template_parameter_content` longtext COMMENT '接口参数模板内容',
  `template_result_content` longtext COMMENT '接口返回结果模板内容',
  `clazz` varchar(128) DEFAULT NULL,
  `script` longtext COMMENT '脚本',
  `description` longtext COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `file_path` varchar(1000) DEFAULT NULL,
  `jar_name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-脚本';

-- 正在导出表  mes_db_test.mes_dp_function 的数据：~0 rows (大约)
DELETE FROM `mes_dp_function`;
/*!40000 ALTER TABLE `mes_dp_function` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_function` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_function_type 结构
DROP TABLE IF EXISTS `mes_dp_function_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_function_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `type` varchar(50) DEFAULT NULL COMMENT 'type(groovy/java)',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-函数分类';

-- 正在导出表  mes_db_test.mes_dp_function_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_function_type`;
/*!40000 ALTER TABLE `mes_dp_function_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_function_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_label 结构
DROP TABLE IF EXISTS `mes_dp_label`;
CREATE TABLE IF NOT EXISTS `mes_dp_label` (
  `id` varchar(50) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `type_id` varchar(50) DEFAULT NULL,
  `generation` varchar(50) DEFAULT NULL,
  `template_order` longtext,
  `template_path` varchar(255) DEFAULT NULL,
  `function_type_id` varchar(50) DEFAULT NULL,
  `function_id` varchar(50) DEFAULT NULL,
  `instruction_path` varchar(255) DEFAULT NULL,
  `image` longblob,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_label 的数据：~0 rows (大约)
DELETE FROM `mes_dp_label`;
/*!40000 ALTER TABLE `mes_dp_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_label` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_label_type 结构
DROP TABLE IF EXISTS `mes_dp_label_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_label_type` (
  `id` varchar(50) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_label_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_label_type`;
/*!40000 ALTER TABLE `mes_dp_label_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_label_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_material 结构
DROP TABLE IF EXISTS `mes_dp_material`;
CREATE TABLE IF NOT EXISTS `mes_dp_material` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `file_name` varchar(50) DEFAULT NULL,
  `image` longblob,
  `path` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `material_type_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_material 的数据：~0 rows (大约)
DELETE FROM `mes_dp_material`;
/*!40000 ALTER TABLE `mes_dp_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_material` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_materials_info 结构
DROP TABLE IF EXISTS `mes_dp_materials_info`;
CREATE TABLE IF NOT EXISTS `mes_dp_materials_info` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `type` varchar(50) DEFAULT NULL COMMENT '类型（批次料，条码料）',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '属所产品生产工序ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-上料管理';

-- 正在导出表  mes_db_test.mes_dp_materials_info 的数据：~0 rows (大约)
DELETE FROM `mes_dp_materials_info`;
/*!40000 ALTER TABLE `mes_dp_materials_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_materials_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_materials_info_history 结构
DROP TABLE IF EXISTS `mes_dp_materials_info_history`;
CREATE TABLE IF NOT EXISTS `mes_dp_materials_info_history` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `type` varchar(50) DEFAULT NULL COMMENT '类型（批次料，条码料）',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '属所产品生产工序ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-上料管理-历史包';

-- 正在导出表  mes_db_test.mes_dp_materials_info_history 的数据：~0 rows (大约)
DELETE FROM `mes_dp_materials_info_history`;
/*!40000 ALTER TABLE `mes_dp_materials_info_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_materials_info_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_material_type 结构
DROP TABLE IF EXISTS `mes_dp_material_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_material_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_material_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_material_type`;
/*!40000 ALTER TABLE `mes_dp_material_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_material_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_pallet 结构
DROP TABLE IF EXISTS `mes_dp_pallet`;
CREATE TABLE IF NOT EXISTS `mes_dp_pallet` (
  `id` varchar(50) NOT NULL,
  `pallet_key` varchar(50) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  `capacity` varchar(50) DEFAULT NULL,
  `quantity` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_pallet 的数据：~0 rows (大约)
DELETE FROM `mes_dp_pallet`;
/*!40000 ALTER TABLE `mes_dp_pallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_pallet` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_process_base_config 结构
DROP TABLE IF EXISTS `mes_dp_process_base_config`;
CREATE TABLE IF NOT EXISTS `mes_dp_process_base_config` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `is_auto` varchar(1) DEFAULT NULL COMMENT '工序运行模式（人工:1,自动:0）',
  `data_dictionary_type_id` varchar(50) DEFAULT NULL COMMENT '字典分类ID',
  `data_dictionary_id` varchar(50) DEFAULT NULL COMMENT '类型字典ID(检查/组装、分板、包装)',
  `form_type_id` varchar(50) DEFAULT NULL COMMENT '表单分类ID',
  `form_id` varchar(50) DEFAULT NULL COMMENT '操作表单ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-工序基础配置';

-- 正在导出表  mes_db_test.mes_dp_process_base_config 的数据：~0 rows (大约)
DELETE FROM `mes_dp_process_base_config`;
/*!40000 ALTER TABLE `mes_dp_process_base_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_process_base_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_process_config 结构
DROP TABLE IF EXISTS `mes_dp_process_config`;
CREATE TABLE IF NOT EXISTS `mes_dp_process_config` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `type` varchar(50) DEFAULT NULL COMMENT '数据类型（文件，字符，数字）',
  `description` longtext COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `value` varchar(512) DEFAULT NULL,
  `dictionary_id` varchar(50) DEFAULT NULL,
  `dictionary_type_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-生产工序配置属性';

-- 正在导出表  mes_db_test.mes_dp_process_config 的数据：~0 rows (大约)
DELETE FROM `mes_dp_process_config`;
/*!40000 ALTER TABLE `mes_dp_process_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_process_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_chip 结构
DROP TABLE IF EXISTS `mes_dp_produce_chip`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_chip` (
  `id` varchar(50) NOT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `procedure_name` varchar(50) DEFAULT NULL,
  `serial_id` varchar(50) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `byte_num` varchar(50) DEFAULT NULL,
  `source_type_name` varchar(50) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `store_type_name` varchar(50) DEFAULT NULL,
  `oper_code_name` varchar(50) DEFAULT NULL,
  `chip_sequence` varchar(50) DEFAULT NULL,
  `programmer_type_name` varchar(50) DEFAULT NULL,
  `model_name` varchar(50) DEFAULT NULL,
  `delay_time` varchar(50) DEFAULT NULL,
  `oper_describe` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `order` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_produce_chip 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_chip`;
/*!40000 ALTER TABLE `mes_dp_produce_chip` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_chip` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_demarcate 结构
DROP TABLE IF EXISTS `mes_dp_produce_demarcate`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_demarcate` (
  `id` varchar(50) NOT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `sd_id` varchar(50) DEFAULT NULL,
  `sd_name` varchar(50) DEFAULT NULL,
  `sd_data` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `order` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_produce_demarcate 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_demarcate`;
/*!40000 ALTER TABLE `mes_dp_produce_demarcate` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_demarcate` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process 结构
DROP TABLE IF EXISTS `mes_dp_produce_process`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线id',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `project_id` varchar(50) DEFAULT NULL COMMENT '工程ID',
  `form_type_id` varchar(50) DEFAULT NULL COMMENT '表单分类ID',
  `form_id` varchar(50) DEFAULT NULL COMMENT '表单ID',
  `is_auto` varchar(50) DEFAULT NULL COMMENT '生产方式（自动、人工）',
  `is_bom_materials` varchar(50) DEFAULT NULL COMMENT '是否有物料（0,1）',
  `bom_produce_id` varchar(50) DEFAULT NULL COMMENT '生产BOM_ID',
  `is_init` char(1) DEFAULT NULL COMMENT '是否初始化工序',
  `init_fn_type_id` varchar(50) DEFAULT NULL COMMENT '初始化工序函数分类ID',
  `init_fn_id` varchar(50) DEFAULT NULL COMMENT '初始化工序函数ID',
  `is_custom` char(1) DEFAULT NULL COMMENT '是否自定义工序',
  `custom_fn_type_id` varchar(50) DEFAULT NULL COMMENT '自定义工序函数分类ID',
  `custom_fn_id` varchar(50) DEFAULT NULL COMMENT '自定义工序函数ID',
  `sort` int(11) DEFAULT NULL COMMENT '工序排序',
  `is_validate_last_process` char(1) DEFAULT NULL COMMENT '是否校验上道工序',
  `last_produce_process_id` varchar(255) DEFAULT NULL COMMENT '上道生产工序ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-产品生产工序';

-- 正在导出表  mes_db_test.mes_dp_produce_process 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process`;
/*!40000 ALTER TABLE `mes_dp_produce_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_config 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_config`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_config` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `type` varchar(50) DEFAULT NULL COMMENT '数据类型（文件，字符，数字）',
  `value` varchar(512) DEFAULT NULL COMMENT 'value',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `dictionary_type_id` varchar(50) DEFAULT NULL,
  `dictionary_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-生产工序配置属性';

-- 正在导出表  mes_db_test.mes_dp_produce_process_config 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_config`;
/*!40000 ALTER TABLE `mes_dp_produce_process_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_config_workorder 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_config_workorder`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_config_workorder` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `工单ID` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `type` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `cn_name` varchar(50) DEFAULT NULL COMMENT '中文名称',
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(50) DEFAULT NULL COMMENT 'value',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-设备配置信息-工单';

-- 正在导出表  mes_db_test.mes_dp_produce_process_config_workorder 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_config_workorder`;
/*!40000 ALTER TABLE `mes_dp_produce_process_config_workorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_config_workorder` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_date 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_date`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_date` (
  `id` varchar(50) NOT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `expression` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `data` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_produce_process_date 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_date`;
/*!40000 ALTER TABLE `mes_dp_produce_process_date` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_date` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_device 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_device`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_device` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `workstation_device_id` varchar(50) DEFAULT NULL COMMENT '工作站',
  `device_id` varchar(50) DEFAULT NULL COMMENT '设备ID',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '属所产品生产工序ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产工序-设备';

-- 正在导出表  mes_db_test.mes_dp_produce_process_device 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_device`;
/*!40000 ALTER TABLE `mes_dp_produce_process_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_device` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_device_annex 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_device_annex`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_device_annex` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `device_annex_id` varchar(50) DEFAULT NULL COMMENT '设备附件分类ID',
  `device_annex_info_id` varchar(50) DEFAULT NULL COMMENT '设备附件ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-设备配置-工序-设备附件';

-- 正在导出表  mes_db_test.mes_dp_produce_process_device_annex 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_device_annex`;
/*!40000 ALTER TABLE `mes_dp_produce_process_device_annex` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_device_annex` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_process_device_config 结构
DROP TABLE IF EXISTS `mes_dp_produce_process_device_config`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_process_device_config` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `name` varchar(50) DEFAULT NULL,
  `version` varchar(50) DEFAULT NULL,
  `device_config_id` varchar(50) DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `device_config_type_id` varchar(50) DEFAULT NULL COMMENT '属所设备配置分类ID',
  `data_type` varchar(50) DEFAULT NULL COMMENT '配置类型（文件、其他）',
  `file_name` varchar(50) DEFAULT NULL COMMENT '配置文件名称',
  `file_another_name` varchar(50) DEFAULT NULL COMMENT '配置文件别名',
  `file_path` varchar(255) DEFAULT NULL COMMENT '存储路径',
  `content` longtext COMMENT '配置参数内容',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-设备配置信息';

-- 正在导出表  mes_db_test.mes_dp_produce_process_device_config 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_process_device_config`;
/*!40000 ALTER TABLE `mes_dp_produce_process_device_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_process_device_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_standard_test 结构
DROP TABLE IF EXISTS `mes_dp_produce_standard_test`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_standard_test` (
  `id` varchar(50) NOT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `ti_name` varchar(50) DEFAULT NULL,
  `ti_standard` varchar(50) DEFAULT NULL,
  `ti_upper` varchar(50) DEFAULT NULL,
  `ti_lower` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `order` bigint(20) DEFAULT NULL,
  `ti_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_produce_standard_test 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_standard_test`;
/*!40000 ALTER TABLE `mes_dp_produce_standard_test` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_standard_test` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_produce_standard_test_order 结构
DROP TABLE IF EXISTS `mes_dp_produce_standard_test_order`;
CREATE TABLE IF NOT EXISTS `mes_dp_produce_standard_test_order` (
  `id` varchar(50) NOT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `order` varchar(50) DEFAULT NULL,
  `signal` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `data_order` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_produce_standard_test_order 的数据：~0 rows (大约)
DELETE FROM `mes_dp_produce_standard_test_order`;
/*!40000 ALTER TABLE `mes_dp_produce_standard_test_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_produce_standard_test_order` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_product_info_log 结构
DROP TABLE IF EXISTS `mes_dp_product_info_log`;
CREATE TABLE IF NOT EXISTS `mes_dp_product_info_log` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `dp_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `process_code` varchar(50) DEFAULT NULL COMMENT '工序编码',
  `process_name` varchar(50) DEFAULT NULL COMMENT '工序名称',
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `workstation_device_id` varchar(50) DEFAULT NULL COMMENT '工站',
  `is_success` varchar(50) DEFAULT NULL COMMENT '结果（成功:1、失败:0、未执行:2）',
  `start_time` datetime DEFAULT NULL COMMENT '开始生产时间',
  `end_time` datetime DEFAULT NULL COMMENT '完成时间',
  `user_id` varchar(50) DEFAULT NULL COMMENT '操作人员',
  `user_name` varchar(50) DEFAULT NULL COMMENT '操作人',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一码',
  `work_order_num` varchar(50) DEFAULT NULL COMMENT '工单号',
  `work_order_batch_num` varchar(50) DEFAULT NULL COMMENT '批次号',
  `order` int(11) DEFAULT NULL COMMENT '工序执行顺序',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品生产工序记录';

-- 正在导出表  mes_db_test.mes_dp_product_info_log 的数据：~0 rows (大约)
DELETE FROM `mes_dp_product_info_log`;
/*!40000 ALTER TABLE `mes_dp_product_info_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_product_info_log` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_product_info_log_history 结构
DROP TABLE IF EXISTS `mes_dp_product_info_log_history`;
CREATE TABLE IF NOT EXISTS `mes_dp_product_info_log_history` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `dp_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `process_code` varchar(50) DEFAULT NULL COMMENT '工序编码',
  `process_name` varchar(50) DEFAULT NULL COMMENT '工序名称',
  `workstation_device_id` varchar(50) DEFAULT NULL COMMENT '工站',
  `is_success` varchar(50) DEFAULT NULL COMMENT '结果（成功、失败）',
  `start_time` datetime DEFAULT NULL COMMENT '开始生产时间',
  `end_time` datetime DEFAULT NULL COMMENT '完成时间',
  `user_id` varchar(50) DEFAULT NULL COMMENT '操作人员',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一码',
  `work_order_num` varchar(50) DEFAULT NULL COMMENT '工单号',
  `work_order_batch_num` varchar(50) DEFAULT NULL COMMENT '批次号',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品生产工序记录-历史表';

-- 正在导出表  mes_db_test.mes_dp_product_info_log_history 的数据：~0 rows (大约)
DELETE FROM `mes_dp_product_info_log_history`;
/*!40000 ALTER TABLE `mes_dp_product_info_log_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_product_info_log_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_product_test_log 结构
DROP TABLE IF EXISTS `mes_dp_product_test_log`;
CREATE TABLE IF NOT EXISTS `mes_dp_product_test_log` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一编码',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `ti_name` varchar(50) DEFAULT NULL COMMENT 'ti_name',
  `item_data` varchar(50) DEFAULT NULL COMMENT 'item_data',
  `test_result` varchar(50) DEFAULT NULL COMMENT 'test_result',
  `ti_upper` varchar(50) DEFAULT NULL COMMENT 'ti_upper',
  `ti_lower` varchar(50) DEFAULT NULL COMMENT 'ti_lower',
  `channel` varchar(50) DEFAULT NULL COMMENT 'channel',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品测试项';

-- 正在导出表  mes_db_test.mes_dp_product_test_log 的数据：~0 rows (大约)
DELETE FROM `mes_dp_product_test_log`;
/*!40000 ALTER TABLE `mes_dp_product_test_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_product_test_log` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_product_test_log_history 结构
DROP TABLE IF EXISTS `mes_dp_product_test_log_history`;
CREATE TABLE IF NOT EXISTS `mes_dp_product_test_log_history` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一编码',
  `produce_process_id` varchar(50) DEFAULT NULL COMMENT '生产工序ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `ti_name` varchar(50) DEFAULT NULL COMMENT 'ti_name',
  `item_data` varchar(50) DEFAULT NULL COMMENT 'item_data',
  `test_result` varchar(50) DEFAULT NULL COMMENT 'test_result',
  `ti_upper` varchar(50) DEFAULT NULL COMMENT 'ti_upper',
  `ti_lower` varchar(50) DEFAULT NULL COMMENT 'ti_lower',
  `channel` varchar(50) DEFAULT NULL COMMENT 'channel',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品测试项-历史表';

-- 正在导出表  mes_db_test.mes_dp_product_test_log_history 的数据：~0 rows (大约)
DELETE FROM `mes_dp_product_test_log_history`;
/*!40000 ALTER TABLE `mes_dp_product_test_log_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_product_test_log_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_project 结构
DROP TABLE IF EXISTS `mes_dp_project`;
CREATE TABLE IF NOT EXISTS `mes_dp_project` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线id',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `name` varchar(50) DEFAULT NULL COMMENT '工程名称',
  `version` varchar(50) DEFAULT NULL COMMENT '版本',
  `is_enabled` int(11) DEFAULT NULL COMMENT '是否启用(0，1)',
  `is_release` int(11) DEFAULT NULL COMMENT '是发布（0,1）',
  `is_config_process` char(1) DEFAULT NULL COMMENT '是否配置工序(0:未配置, 1已配置)',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `release_time` datetime DEFAULT NULL COMMENT '发布日期',
  `enabled_time` datetime DEFAULT NULL COMMENT '启用日期',
  `wf_code` varchar(50) DEFAULT NULL,
  `workflow_run_xml` longtext COMMENT '执行的xml',
  `workflow_show_json` longtext COMMENT '展示的json',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-开发工程';

-- 正在导出表  mes_db_test.mes_dp_project 的数据：~0 rows (大约)
DELETE FROM `mes_dp_project`;
/*!40000 ALTER TABLE `mes_dp_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_project` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_repair_station 结构
DROP TABLE IF EXISTS `mes_dp_repair_station`;
CREATE TABLE IF NOT EXISTS `mes_dp_repair_station` (
  `id` varchar(50) NOT NULL,
  `dp_line_id` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `work_order_id` varchar(50) DEFAULT NULL,
  `produce_process_id` varchar(50) DEFAULT NULL,
  `process_code` varchar(50) DEFAULT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `workstation_device_id` varchar(50) DEFAULT NULL,
  `is_success` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `work_order_num` varchar(50) DEFAULT NULL,
  `work_order_batch_num` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_repair_station 的数据：~0 rows (大约)
DELETE FROM `mes_dp_repair_station`;
/*!40000 ALTER TABLE `mes_dp_repair_station` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_repair_station` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_repair_station_bad_info 结构
DROP TABLE IF EXISTS `mes_dp_repair_station_bad_info`;
CREATE TABLE IF NOT EXISTS `mes_dp_repair_station_bad_info` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `entry_person` varchar(50) DEFAULT NULL,
  `bad_description` varchar(50) DEFAULT NULL,
  `is_rework` varchar(50) DEFAULT NULL,
  `repair_person` varchar(50) DEFAULT NULL,
  `repair_description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_repair_station_bad_info 的数据：~0 rows (大约)
DELETE FROM `mes_dp_repair_station_bad_info`;
/*!40000 ALTER TABLE `mes_dp_repair_station_bad_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_repair_station_bad_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_routes 结构
DROP TABLE IF EXISTS `mes_dp_routes`;
CREATE TABLE IF NOT EXISTS `mes_dp_routes` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `project_id` varchar(50) DEFAULT NULL COMMENT '工程id',
  `wf_code` varchar(50) DEFAULT NULL,
  `workflow_run_xml` longtext COMMENT '执行的xml',
  `workflow_show_json` longtext COMMENT '展示的json',
  `deploy_id` varchar(50) DEFAULT NULL COMMENT '部署状态',
  `status` varchar(50) DEFAULT NULL COMMENT '流程运行状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `description` longtext COMMENT '描述',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `version` varchar(32) DEFAULT NULL COMMENT '版本',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-工艺路径管理（Routes）';

-- 正在导出表  mes_db_test.mes_dp_routes 的数据：~0 rows (大约)
DELETE FROM `mes_dp_routes`;
/*!40000 ALTER TABLE `mes_dp_routes` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_routes` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_service 结构
DROP TABLE IF EXISTS `mes_dp_service`;
CREATE TABLE IF NOT EXISTS `mes_dp_service` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '服务名称',
  `code` varchar(64) DEFAULT NULL COMMENT '服务编码',
  `url` varchar(200) DEFAULT NULL COMMENT '服务地址',
  `method_name` varchar(50) DEFAULT NULL COMMENT '接口方法名',
  `template_parameter_content` longtext COMMENT '接口参数模板内容',
  `template_result_content` longtext COMMENT '接口返回结果模板内容',
  `method` varchar(50) DEFAULT NULL COMMENT '接口调用方法（get、post）',
  `status` varchar(50) DEFAULT NULL COMMENT '发布状态（发布|未发布）',
  `service_type_id` varchar(50) DEFAULT NULL COMMENT '属所服务分类ID',
  `description` longtext COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `type` varchar(16) DEFAULT NULL COMMENT '接口请求数据类型，sql或script',
  `fn_type_id` varchar(50) DEFAULT NULL COMMENT '函数分类id',
  `fn_id` varchar(50) DEFAULT NULL COMMENT '函数id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-服务管理';

-- 正在导出表  mes_db_test.mes_dp_service 的数据：~0 rows (大约)
DELETE FROM `mes_dp_service`;
/*!40000 ALTER TABLE `mes_dp_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_service` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_service_log 结构
DROP TABLE IF EXISTS `mes_dp_service_log`;
CREATE TABLE IF NOT EXISTS `mes_dp_service_log` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `service_id` varchar(50) DEFAULT NULL COMMENT '服务ID',
  `status` varchar(50) DEFAULT NULL COMMENT '状态（成功、失败）',
  `invoke_time` varchar(50) DEFAULT NULL COMMENT '调用时间',
  `time_taken` varchar(50) DEFAULT NULL COMMENT '耗时',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-服务日志';

-- 正在导出表  mes_db_test.mes_dp_service_log 的数据：~0 rows (大约)
DELETE FROM `mes_dp_service_log`;
/*!40000 ALTER TABLE `mes_dp_service_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_service_log` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_service_monitor 结构
DROP TABLE IF EXISTS `mes_dp_service_monitor`;
CREATE TABLE IF NOT EXISTS `mes_dp_service_monitor` (
  `id` varchar(50) DEFAULT NULL,
  `service_id` varchar(50) DEFAULT NULL,
  `period_start` datetime DEFAULT NULL,
  `period_type` char(1) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `count` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_service_monitor 的数据：~0 rows (大约)
DELETE FROM `mes_dp_service_monitor`;
/*!40000 ALTER TABLE `mes_dp_service_monitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_service_monitor` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_service_type 结构
DROP TABLE IF EXISTS `mes_dp_service_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_service_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-服务分类';

-- 正在导出表  mes_db_test.mes_dp_service_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_service_type`;
/*!40000 ALTER TABLE `mes_dp_service_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_service_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_subassembly 结构
DROP TABLE IF EXISTS `mes_dp_subassembly`;
CREATE TABLE IF NOT EXISTS `mes_dp_subassembly` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `subassembly_type_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_subassembly 的数据：~0 rows (大约)
DELETE FROM `mes_dp_subassembly`;
/*!40000 ALTER TABLE `mes_dp_subassembly` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_subassembly` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_subassembly_type 结构
DROP TABLE IF EXISTS `mes_dp_subassembly_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_subassembly_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_subassembly_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_subassembly_type`;
/*!40000 ALTER TABLE `mes_dp_subassembly_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_subassembly_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_template 结构
DROP TABLE IF EXISTS `mes_dp_template`;
CREATE TABLE IF NOT EXISTS `mes_dp_template` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `template_type_id` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `html` longtext,
  `javascript` longtext,
  `description` varchar(500) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_template 的数据：~0 rows (大约)
DELETE FROM `mes_dp_template`;
/*!40000 ALTER TABLE `mes_dp_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_template` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_dp_template_type 结构
DROP TABLE IF EXISTS `mes_dp_template_type`;
CREATE TABLE IF NOT EXISTS `mes_dp_template_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_dp_template_type 的数据：~0 rows (大约)
DELETE FROM `mes_dp_template_type`;
/*!40000 ALTER TABLE `mes_dp_template_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_dp_template_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_expand_pd_bom_materials 结构
DROP TABLE IF EXISTS `mes_expand_pd_bom_materials`;
CREATE TABLE IF NOT EXISTS `mes_expand_pd_bom_materials` (
  `id` varchar(50) NOT NULL,
  `client_info` varchar(1024) DEFAULT NULL COMMENT '客户信息',
  `bom_item_no` varchar(128) DEFAULT NULL COMMENT 'BOM项目号',
  `description` varchar(1024) DEFAULT NULL COMMENT '物料描述',
  `replacement_group` varchar(256) DEFAULT NULL COMMENT '替代组',
  `replacement` varchar(1024) DEFAULT NULL COMMENT '替代物料',
  `unit` varchar(32) DEFAULT NULL COMMENT '基本单位',
  `design_point` text COMMENT '设计点位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_expand_pd_bom_materials 的数据：~0 rows (大约)
DELETE FROM `mes_expand_pd_bom_materials`;
/*!40000 ALTER TABLE `mes_expand_pd_bom_materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_expand_pd_bom_materials` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_expand_table_config 结构
DROP TABLE IF EXISTS `mes_expand_table_config`;
CREATE TABLE IF NOT EXISTS `mes_expand_table_config` (
  `id` varchar(50) NOT NULL,
  `table_id` varchar(50) DEFAULT NULL,
  `table_name` varchar(50) DEFAULT NULL,
  `is_history_table` varchar(50) DEFAULT NULL,
  `history_table_name` varchar(50) DEFAULT NULL,
  `fk_column_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_expand_table_config 的数据：~0 rows (大约)
DELETE FROM `mes_expand_table_config`;
/*!40000 ALTER TABLE `mes_expand_table_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_expand_table_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_area 结构
DROP TABLE IF EXISTS `mes_fty_area`;
CREATE TABLE IF NOT EXISTS `mes_fty_area` (
  `id` varchar(50) NOT NULL,
  `site_info_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `time_zone` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_area 的数据：~0 rows (大约)
DELETE FROM `mes_fty_area`;
/*!40000 ALTER TABLE `mes_fty_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_area` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device 结构
DROP TABLE IF EXISTS `mes_fty_device`;
CREATE TABLE IF NOT EXISTS `mes_fty_device` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `asset_code` varchar(50) DEFAULT NULL,
  `sn_num` varchar(50) DEFAULT NULL,
  `area_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `device_type_id` varchar(50) DEFAULT NULL COMMENT '设备分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device`;
/*!40000 ALTER TABLE `mes_fty_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_annex 结构
DROP TABLE IF EXISTS `mes_fty_device_annex`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_annex` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂管理-设备附件';

-- 正在导出表  mes_db_test.mes_fty_device_annex 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_annex`;
/*!40000 ALTER TABLE `mes_fty_device_annex` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_annex` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_annex_dictionary 结构
DROP TABLE IF EXISTS `mes_fty_device_annex_dictionary`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_annex_dictionary` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `data_dictionary_type_id` varchar(50) DEFAULT NULL,
  `data_dictionary_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_annex_dictionary 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_annex_dictionary`;
/*!40000 ALTER TABLE `mes_fty_device_annex_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_annex_dictionary` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_annex_info 结构
DROP TABLE IF EXISTS `mes_fty_device_annex_info`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_annex_info` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `number` varchar(50) DEFAULT NULL COMMENT '编号',
  `use_count` int(11) DEFAULT NULL COMMENT '使用次数',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `device_annex_id` varchar(50) DEFAULT NULL COMMENT '附件分类ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂管理-（治具/工装/其他）';

-- 正在导出表  mes_db_test.mes_fty_device_annex_info 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_annex_info`;
/*!40000 ALTER TABLE `mes_fty_device_annex_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_annex_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_config 结构
DROP TABLE IF EXISTS `mes_fty_device_config`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_config` (
  `id` varchar(50) NOT NULL,
  `device_config_type_id` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_config 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_config`;
/*!40000 ALTER TABLE `mes_fty_device_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_config` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_config_info 结构
DROP TABLE IF EXISTS `mes_fty_device_config_info`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_config_info` (
  `id` varchar(50) NOT NULL,
  `device_config_id` varchar(50) DEFAULT NULL,
  `device_config_type_id` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  `version` varchar(50) DEFAULT NULL,
  `file_path` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `content` longtext,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_config_info 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_config_info`;
/*!40000 ALTER TABLE `mes_fty_device_config_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_config_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_config_type 结构
DROP TABLE IF EXISTS `mes_fty_device_config_type`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_config_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_config_type 的数据：~8 rows (大约)
DELETE FROM `mes_fty_device_config_type`;
-- com组件接口使用，code字段不可修改为其他值
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('1','硬件配置','Hconfig','2017-09-06 10:41:36');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('2','通用配置','general','2017-09-06 10:42:18');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('3','设备时间间隔','device_time_period','2017-09-06 10:42:36');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('4','工序时间配置','process_time_config','2017-09-06 10:42:52');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H1E43E94C952246F9A6CCA91990B8EFDB','硬件通道','Hchannel','2017-08-28 18:34:27');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H283226FF0ED64315B8F3AEF888FF875C','硬件信号','Hsignal','2017-08-28 18:34:03');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H39E3542854E34C91931E64398851317D','自检标准','selfIS','2017-08-28 18:30:39');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H453D4B64AB6443A6B3E869CBDC84EDDC','硬件整体','Hwhole','2017-08-28 18:33:04');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H6EA3B811D7C64324855D66111A917ED4','远程配置','remote','2017-08-28 18:31:15');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('H99C72FC118B748849DA66D4EEE7D23B9','信号过程','signalProcess','2017-08-28 18:35:31');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('HA1D30AAC913B41E0AE26A474B020A7D2','环境参数','env','2017-08-28 18:26:56');
insert into `mes_fty_device_config_type` (`id`, `name`, `code`, `create_date`) values('HE3AFB25610A641AC97D3A6E0F14EED3A','信号故障','signalFault','2017-08-28 18:36:04');
/*!40000 ALTER TABLE `mes_fty_device_config_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_config_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_consumables 结构
DROP TABLE IF EXISTS `mes_fty_device_consumables`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_consumables` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `use_count` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `device_annex_id` varchar(50) CHARACTER SET tis620 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_consumables 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_consumables`;
/*!40000 ALTER TABLE `mes_fty_device_consumables` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_consumables` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_fault 结构
DROP TABLE IF EXISTS `mes_fty_device_fault`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_fault` (
  `id` varchar(50) NOT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `is_run` varchar(50) DEFAULT NULL,
  `device_fault_info_id` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `description` longtext,
  `maintenance_persion` varchar(50) DEFAULT NULL,
  `maintenance_phone` varchar(50) DEFAULT NULL,
  `operator` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_fault 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_fault`;
/*!40000 ALTER TABLE `mes_fty_device_fault` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_fault` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_fault_info 结构
DROP TABLE IF EXISTS `mes_fty_device_fault_info`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_fault_info` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_fault_info 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_fault_info`;
/*!40000 ALTER TABLE `mes_fty_device_fault_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_fault_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_fault_process 结构
DROP TABLE IF EXISTS `mes_fty_device_fault_process`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_fault_process` (
  `id` varchar(50) NOT NULL,
  `device_fault_info_id` varchar(50) DEFAULT NULL,
  `responsible_persion` varchar(50) DEFAULT NULL,
  `abnormal_problems` text,
  `abnormal_code` text,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_fault_process 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_fault_process`;
/*!40000 ALTER TABLE `mes_fty_device_fault_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_fault_process` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_fixture 结构
DROP TABLE IF EXISTS `mes_fty_device_fixture`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_fixture` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `use_count` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_fixture 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_fixture`;
/*!40000 ALTER TABLE `mes_fty_device_fixture` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_fixture` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_process 结构
DROP TABLE IF EXISTS `mes_fty_device_process`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_process` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `device_id` varchar(50) DEFAULT NULL COMMENT '设备ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂管理-工序-设备';

-- 正在导出表  mes_db_test.mes_fty_device_process 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_process`;
/*!40000 ALTER TABLE `mes_fty_device_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_process` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_process_annex 结构
DROP TABLE IF EXISTS `mes_fty_device_process_annex`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_process_annex` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `device_id` varchar(50) DEFAULT NULL COMMENT '设备ID',
  `device_process_id` varchar(50) DEFAULT NULL COMMENT '设备-工序ID',
  `process_id` varchar(50) DEFAULT NULL COMMENT '工序ID',
  `device_annex_id` varchar(50) DEFAULT NULL COMMENT '附件分类ID',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂管理-工序-设备-附件';

-- 正在导出表  mes_db_test.mes_fty_device_process_annex 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_process_annex`;
/*!40000 ALTER TABLE `mes_fty_device_process_annex` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_process_annex` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_process_annex_association 结构
DROP TABLE IF EXISTS `mes_fty_device_process_annex_association`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_process_annex_association` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `device_process_annex_id` varchar(50) DEFAULT NULL COMMENT '属所设备附件ID',
  `device_annex_info_id` varchar(50) DEFAULT NULL COMMENT '附件ID',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备管理-设备-工序-附件';

-- 正在导出表  mes_db_test.mes_fty_device_process_annex_association 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_process_annex_association`;
/*!40000 ALTER TABLE `mes_fty_device_process_annex_association` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_process_annex_association` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_process_dictionary 结构
DROP TABLE IF EXISTS `mes_fty_device_process_dictionary`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_process_dictionary` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `data_dictionary_type_id` varchar(50) DEFAULT NULL,
  `data_dictionary_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_process_dictionary 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_process_dictionary`;
/*!40000 ALTER TABLE `mes_fty_device_process_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_process_dictionary` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_tooling 结构
DROP TABLE IF EXISTS `mes_fty_device_tooling`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_tooling` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `use_count` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_tooling 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_tooling`;
/*!40000 ALTER TABLE `mes_fty_device_tooling` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_tooling` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_device_type 结构
DROP TABLE IF EXISTS `mes_fty_device_type`;
CREATE TABLE IF NOT EXISTS `mes_fty_device_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_device_type 的数据：~0 rows (大约)
DELETE FROM `mes_fty_device_type`;
/*!40000 ALTER TABLE `mes_fty_device_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_device_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_enterprise 结构
DROP TABLE IF EXISTS `mes_fty_enterprise`;
CREATE TABLE IF NOT EXISTS `mes_fty_enterprise` (
  `id` varchar(50) NOT NULL,
  `company` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_enterprise 的数据：~0 rows (大约)
DELETE FROM `mes_fty_enterprise`;
/*!40000 ALTER TABLE `mes_fty_enterprise` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_enterprise` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_process 结构
DROP TABLE IF EXISTS `mes_fty_process`;
CREATE TABLE IF NOT EXISTS `mes_fty_process` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `icon` longblob COMMENT '工序图标',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_process 的数据：~0 rows (大约)
DELETE FROM `mes_fty_process`;
/*!40000 ALTER TABLE `mes_fty_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_process` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_process_config_type 结构
DROP TABLE IF EXISTS `mes_fty_process_config_type`;
CREATE TABLE IF NOT EXISTS `mes_fty_process_config_type` (
  `id` varchar(50) NOT NULL,
  `process_id` varchar(50) DEFAULT NULL,
  `config_type_dict_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_process_config_type 的数据：~0 rows (大约)
DELETE FROM `mes_fty_process_config_type`;
/*!40000 ALTER TABLE `mes_fty_process_config_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_process_config_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_process_config_type_dict 结构
DROP TABLE IF EXISTS `mes_fty_process_config_type_dict`;
CREATE TABLE IF NOT EXISTS `mes_fty_process_config_type_dict` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_process_config_type_dict 的数据：~6 rows (大约)
DELETE FROM `mes_fty_process_config_type_dict`;
/*!40000 ALTER TABLE `mes_fty_process_config_type_dict` DISABLE KEYS */;
INSERT INTO `mes_fty_process_config_type_dict` (`id`, `name`, `code`, `create_date`) VALUES
	('H046188C72B8C4D83ADF015915BD5551A', '设备配置', NULL, '2017-08-24 11:27:48'),
	('H34AEBD7FFA9240F0897957472AD1E70E', '测试顺序', NULL, '2017-08-24 11:28:18'),
	('H391EC4979A7447A682C015307E733253', '产品芯片', NULL, '2017-08-24 11:28:02'),
	('H45D31929D59A42A899CBD92AB3B4BB0F', '时间设置', NULL, '2017-08-26 13:54:29'),
	('H56166946A7B940DFB980FD4F0EE0DB3A', '测试标准', NULL, '2017-08-24 11:28:12'),
	('H7550A7A42AF14F45A7D0EEF688F6CDA0', '产品标定', NULL, '2017-08-26 21:53:47');
/*!40000 ALTER TABLE `mes_fty_process_config_type_dict` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_production_line 结构
DROP TABLE IF EXISTS `mes_fty_production_line`;
CREATE TABLE IF NOT EXISTS `mes_fty_production_line` (
  `id` varchar(50) NOT NULL,
  `area_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_production_line 的数据：~0 rows (大约)
DELETE FROM `mes_fty_production_line`;
/*!40000 ALTER TABLE `mes_fty_production_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_production_line` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_site_info 结构
DROP TABLE IF EXISTS `mes_fty_site_info`;
CREATE TABLE IF NOT EXISTS `mes_fty_site_info` (
  `id` varchar(50) NOT NULL,
  `enterprise_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `time_zone` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_site_info 的数据：~0 rows (大约)
DELETE FROM `mes_fty_site_info`;
/*!40000 ALTER TABLE `mes_fty_site_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_site_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_workstation 结构
DROP TABLE IF EXISTS `mes_fty_workstation`;
CREATE TABLE IF NOT EXISTS `mes_fty_workstation` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `work_center_id` varchar(50) DEFAULT NULL,
  `device_id` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_workstation 的数据：~0 rows (大约)
DELETE FROM `mes_fty_workstation`;
/*!40000 ALTER TABLE `mes_fty_workstation` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_workstation` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_workstation_device 结构
DROP TABLE IF EXISTS `mes_fty_workstation_device`;
CREATE TABLE IF NOT EXISTS `mes_fty_workstation_device` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `device_id` varchar(50) DEFAULT NULL COMMENT '设备ID',
  `workstation_id` varchar(50) DEFAULT NULL COMMENT '工作站ID',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂管理-设备-工作站';

-- 正在导出表  mes_db_test.mes_fty_workstation_device 的数据：~0 rows (大约)
DELETE FROM `mes_fty_workstation_device`;
/*!40000 ALTER TABLE `mes_fty_workstation_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_workstation_device` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_fty_work_center 结构
DROP TABLE IF EXISTS `mes_fty_work_center`;
CREATE TABLE IF NOT EXISTS `mes_fty_work_center` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `production_line_id` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_fty_work_center 的数据：~0 rows (大约)
DELETE FROM `mes_fty_work_center`;
/*!40000 ALTER TABLE `mes_fty_work_center` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_fty_work_center` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_menu 结构
DROP TABLE IF EXISTS `mes_menu`;
CREATE TABLE IF NOT EXISTS `mes_menu` (
  `id` varchar(50) NOT NULL,
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父级菜单id',
  `level` int(11) DEFAULT NULL COMMENT '菜单级别',
  `name` varchar(256) DEFAULT NULL COMMENT '菜单显示名称',
  `url` varchar(128) DEFAULT NULL COMMENT '菜单对应页面url',
  `description` varchar(512) DEFAULT NULL COMMENT '菜单描述',
  `item_order` int(11) DEFAULT NULL COMMENT '菜单项顺序',
  `icon` varchar(128) DEFAULT NULL COMMENT '菜单项图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_menu 的数据：~94 rows (大约)
DELETE FROM `mes_menu`;
/*!40000 ALTER TABLE `mes_menu` DISABLE KEYS */;
INSERT INTO `mes_menu` (`id`, `parent_id`, `level`, `name`, `url`, `description`, `item_order`, `icon`) VALUES
	('1000', '0', 1, '平台管理', '/sysManage', '系统管理', 2, '2.png'),
	('1100', '1000', 2, '仪表盘', '/sysManage/dashBoard', '仪表盘', 1, 'sysManage/1.png'),
	('11C8868AEEBC4E2AB2A01E304CFFE958', '2620', 0, '用户日志', '/devPlatform/userLog', NULL, 0, ''),
	('1200', '1000', 2, '系统管理', '', '系统管理', 2, 'sysManage/2.png'),
	('1210', '1200', 3, '用户管理', '/sysManage/userManage', '用户管理', 2, ''),
	('1220', '1200', 3, '角色管理', '/sysManage/roleManage', '角色管理', 1, ''),
	('1230', '1200', 3, '用户组管理', '/sysManage/userGroup', '用户组', 3, ''),
	('1240', '1200', 3, '菜单管理', '/sysManage/menuManage', '菜单管理', 4, ''),
	('1250', '1200', 3, '菜单授权', '/sysManage/menuAuth', '菜单授权', 5, ''),
	('1300', '1000', 2, '工厂管理', '', '工厂管理', 3, 'sysManage/3.png'),
	('1310', '1300', 3, '工厂管理', '/sysManage/siteManage', '工厂管理', 1, ''),
	('1330', '1300', 3, '工作站管理', '/sysManage/workCenterManage', '工作中心', 4, ''),
	('1340', '1300', 3, '生产线管理', '/sysManage/productLineManage', '生产线管理', 3, ''),
	('1350', '1300', 3, '设备信息', '/sysManage/deviceManage', '设备信息', 5, ''),
	('1360', '1300', 3, '设备附件', '/sysManage/deviceAccessory', '设备附件', 6, ''),
	('1370', '1300', 3, '设备配置', '/sysManage/deviceConfig', '设备配置', 7, ''),
	('1380', 'E33BA6ADACE54618A3B57D924BF665E5', 3, '设备异常', '/sysManage/deviceException', '设备异常', 8, NULL),
	('1390', '1300', 3, '工序定义', '/sysManage/procedureDefinition', '工序定义', 9, NULL),
	('1400', '1000', 2, '产品管理', '', '产品管理', 5, 'sysManage/4.png'),
	('1410', '1400', 3, '产品线管理', '/sysManage/productLine', '产品信息', 1, ''),
	('1420', '1400', 3, '订单管理', '/sysManage/orderManage', '订单管理', 2, ''),
	('1430', '1500', 3, '生产BOM', '/sysManage/productBom', 'BOM管理', 3, NULL),
	('1440', '1500', 3, '工单BOM', '/sysManage/workOrderBom', '工单管理', 4, NULL),
	('1450', '1500', 3, 'BOM规则校验', '/sysManage/ruleBOM', '任务管理', 5, NULL),
	('1460', '1600', 3, '工单管理', '/sysManage/workOrderManage', '资源文件管理', 1, NULL),
	('1500', '1000', 2, 'BOM管理', '', '不良产品记录', 6, 'sysManage/5.png'),
	('1600', '1000', 2, '生产管理', '', '设备异常信息管理', 8, 'sysManage/6.png'),
	('1700', '1000', 2, '排班管理', '', '排班管理', 7, 'sysManage/8.png'),
	('1BB60C6A663045ACA218FC0078C36192', '2000', 0, '表单管理', '/devPlatform/formManage', NULL, 5, 'devPlatform/6.png'),
	('2000', '0', 1, '开发平台', '/devPlatform', '开发平台', 3, '3.png'),
	('2200', '2000', 2, '产品工艺', '/devPlatform/productCraft', '产品工艺设置', 3, 'devPlatform/2.png'),
	('2210', '2200', 3, '开发工程', '/devPlatform/prodLine', '产品产线', 1, NULL),
	('2220', '2200', 3, '工序配置', '/devPlatform/procedureConfig', '工序配置', 2, NULL),
	('2230', '2200', 3, '工艺路径', '/devPlatform/craftRoute', '工艺路径', 3, NULL),
	('2250', '1BB60C6A663045ACA218FC0078C36192', 3, '表单设计器', '/devPlatform/formDesigner', '表单设计器', 6, NULL),
	('2260', '2200', 3, '条码管理', '/devPlatform/barCode', '条码管理', 5, NULL),
	('2300', '2000', 2, '服务管理', '/devPlatform/service', '服务管理', 7, 'devPlatform/3.png'),
	('2310', '2300', 3, '服务定义', '/devPlatform/serviceDev', '服务定义', 1, NULL),
	('2320', '2300', 3, '服务监控', '/devPlatform/serviceMonitor', '服务监控', 2, NULL),
	('2400', '2000', 2, '函数管理', '/devPlatform/function', '函数', 6, 'devPlatform/4.png'),
	('2410', '2400', 3, 'Groovy管理', '/devPlatform/groovyManage', 'Groovy管理', 1, NULL),
	('2420', '2400', 3, 'Java管理', '/devPlatform/javaManage', 'Java管理', 2, NULL),
	('2500', '2000', 2, '对象管理', '/devPlatform/object', '对象管理', 2, 'devPlatform/5.png'),
	('2600', '2000', 2, '平台管理', '/devPlatform/platform', '平台管理', 8, 'devPlatform/6.png'),
	('2610', '2600', 3, '数据字典', '/devPlatform/dictionary', '数据字典', 1, NULL),
	('2620', '2000', 3, '日志管理', '/devPlatform/logManage', '日志管理', 9, 'devPlatform/6.png'),
	('3000', '0', 1, '查询系统', '/querySys', '查询系统', 4, '4.png'),
	('3100', '3000', 2, '产品查询', '/querySys/prodQuery', '产品查询', 1, 'querySys/1.png'),
	('3110', '3100', 3, '产品生产日报', '/querySys/prodDailyReport', '产品生产日报', 1, NULL),
	('3120', '3100', 3, '产品条码查询', '/querySys/prodBarCode', '产品条码查询', 2, NULL),
	('3130', '3100', 3, '产品不良信息查询', '/querySys/prodDefectiveInfo', '产品不良信息查询', 3, NULL),
	('3140', '3100', 3, '产品测试结果查询', '/querySys/prodTestQuery', '产品测试结果查询', 4, NULL),
	('3200', '3000', 2, '设备信息查询', '/querySys/deviceInfo', '设备信息查询', 2, 'querySys/2.png'),
	('3210', '3200', 3, '设备总台账', '/querySys/deviceLedger', '设备总台账', 1, NULL),
	('3220', '3200', 3, '工装总台账', '/querySys/frockLedger', '工装总台账', 2, NULL),
	('3230', '3200', 3, '设备使用情况', '/querySys/deviceUsage', '设备使用情况', 3, NULL),
	('3240', '3200', 3, '工装使用情况', '/querySys/frockUsage', '工装使用情况', 4, NULL),
	('3300', '3000', 2, '工单查询', '/querySys/workOrder', '工单查询', 3, 'querySys/3.png'),
	('3310', '3300', 3, '工单生产信息', '/querySys/workOrderProduct', '工单生产信息', 3, NULL),
	('3320', '3300', 3, '未关结工单查询', '/querySys/nonFinishedWorkOrder', '未关结工单查询', 4, NULL),
	('3330', '3300', 3, '关结工单查询', '/querySys/finishedWorkOrder', '关结工单查询', 1, NULL),
	('3340', '3300', 3, '工单合格率查询', '/querySys/passedWorkOrder', '工单合格率查询', 2, NULL),
	('3400', '3000', 2, '工具集', '/querySys/tools', '工具集', 4, 'querySys/4.png'),
	('3410', '3400', 3, '包装信息查询', '/querySys/packInfo', '包装信息查询', 1, NULL),
	('3420', '3400', 3, '匹配关系查询', '/querySys/matchQuery', '匹配关系查询', 2, NULL),
	('3430', '3400', 3, '物料使用范围', '/querySys/materialUsage', '物料使用范围', 4, NULL),
	('3440', '3400', 3, '产品批次查询', '/querySys/prodLot', '产品批次查询', 3, NULL),
	('3450', '3400', 3, 'SVN相关信息查询', '/querySys/svnInfo', 'SVN相关信息查询', 5, NULL),
	('3500', '3000', 2, 'ERP数据查询', '/querySys/erpQuery', 'ERP数据查询', 5, 'querySys/5.png'),
	('3510', '3500', 3, '原材料库存查询', '/querySys/rawMaterialQuery', '原材料库存查询', 2, NULL),
	('3520', '3500', 3, 'ERP物料编码查询', '/querySys/erpMaterialCode', 'ERP物料编码查询', 1, NULL),
	('3600', '3000', 2, '售后质量管理', '/querySys/postSaleManage', '售后质量管理', 6, 'querySys/6.png'),
	('4000', '0', 1, '数据分析', '/dataAnalysis', '数据分析', 5, '5.png'),
	('500', '0', 1, '首页', '/home', '首页', 1, '1.png'),
	('66C60EAA43DD4A50A58B96BB43F99EFC', '1BB60C6A663045ACA218FC0078C36192', 0, '组件管理', '/devPlatform/assemblyManager', NULL, 0, ''),
	('892D6DE1B3B948F8A38503FED0C02849', '1700', 3, '作业排班', '/sysManage/jobScheduling', NULL, 2, ''),
	('A4B1E9742E994FEA933F66374CC73AEC', '1BB60C6A663045ACA218FC0078C36192', 0, '素材管理', '/devPlatform/sourceMaterial', NULL, 0, ''),
	('A7D770F506564850B3B930381B0A5AD6', '2200', 0, '标签管理', '/devPlatform/label', '标签管理', 4, NULL),
	('B197C1EF60DF4F1D8E6E0849F7F24D7C', 'E33BA6ADACE54618A3B57D924BF665E5', 0, '异常分类', '/sysManage/deviceFaultProcess', NULL, 0, ''),
	('B5F31868538C4546AD0871DF8907F19F', '1700', 3, '班次管理', '/sysManage/shiftManage', NULL, 1, ''),
	('B86F1721065F44AA963CEBC905382B69', '2620', 0, '系统日志', '/devPlatform/systemLog', NULL, 0, ''),
	('B9FEE893454046D1B0D7499BF34E7CE9', '1500', 0, '产品单项配置', '/sysManage/productAttribute', NULL, 0, ''),
	('D3CE42E78F6D4BFE9BF62D4744CF61A7', '1600', 3, '资源文件管理', '/sysManage/resourceDocument', NULL, 2, ''),
	('D6A4CE63A1D14947871DEA616EAD30D9', '2000', 0, '基础工序', '/devPlatform/processConfig', NULL, 1, 'devPlatform/1.png'),
	('E33BA6ADACE54618A3B57D924BF665E5', '1000', 2, '设备异常', '', '设备异常', 4, 'sysManage/9.png'),
	('EF471C3E94BE47D68E1DB4DABBF30DE6', '1BB60C6A663045ACA218FC0078C36192', 0, '模板管理', '/devPlatform/templateManager', NULL, 0, ''),
	('F00ED7D6AD764406AA8D99ECEBB99061', '1600', 3, '工艺文件管理', '/sysManage/technologyDocument', NULL, 3, ''),
	('H31F84FFA4B5B467C8355B0F4B582AD3D', '2600', NULL, 'Agent管理', '/devPlatform/agentManager', NULL, NULL, ''),
	('H41CFBB44FD024AC9ADF09E6A8AE70B37', '2000', NULL, '包装管理', '/devPlatform/packConfig', NULL, 4, 'devPlatform/1.png'),
	('H743C750391B2452DB99EBFAAA3479C66', 'H41CFBB44FD024AC9ADF09E6A8AE70B37', NULL, '产品包装管理', '/devPlatform/productPackage', NULL, 1, ''),
	('H944F681E40AD4A28B36F0C6951EE588F', 'H41CFBB44FD024AC9ADF09E6A8AE70B37', NULL, '栈板配置管理', '/devPlatform/palletManager', NULL, 3, ''),
	('HC04D6079B9354229A6FF50FA0D1AA191', '2200', NULL, '维修站', '/devPlatform/repairStation', NULL, 6, ''),
	('HF68BC425D0524EFAB523517F70F282E8', 'H41CFBB44FD024AC9ADF09E6A8AE70B37', NULL, '栈板包装管理', '/devPlatform/palletPackageManager', NULL, 4, ''),
	('HFB374E696865488199FE5EE05351277C', 'H41CFBB44FD024AC9ADF09E6A8AE70B37', NULL, '包装箱配置管理', '/devPlatform/packBoxManager', NULL, 2, '');
/*!40000 ALTER TABLE `mes_menu` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_menu_auth 结构
DROP TABLE IF EXISTS `mes_menu_auth`;
CREATE TABLE IF NOT EXISTS `mes_menu_auth` (
  `id` varchar(50) NOT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_menu_auth 的数据：~92 rows (大约)
DELETE FROM `mes_menu_auth`;
/*!40000 ALTER TABLE `mes_menu_auth` DISABLE KEYS */;
INSERT INTO `mes_menu_auth` (`id`, `menu_id`, `role_id`) VALUES
	('H00250CA9C6864698BEE0CE335D821C55', '3130', '096ED5F1B65748A6976778E15973855A'),
	('H01AC51B60694439CA71E331CF5CAE44C', '3450', '096ED5F1B65748A6976778E15973855A'),
	('H0364C18F8F1046C0A10DEC4E5423F8CC', 'A4B1E9742E994FEA933F66374CC73AEC', '096ED5F1B65748A6976778E15973855A'),
	('H097B0EC2483748E19031EC6257A6CD3E', '1700', '096ED5F1B65748A6976778E15973855A'),
	('H0B96F4A3C78E470A889FFD1907C60DF5', '3430', '096ED5F1B65748A6976778E15973855A'),
	('H0DEC99E85C364C919A9C75CC2CEAC0B5', '3210', '096ED5F1B65748A6976778E15973855A'),
	('H0F1FA83AAC844D28949736F3BC9CD962', '1210', '096ED5F1B65748A6976778E15973855A'),
	('H13E71F9B741443E19732ACFBCB32E1F6', '3220', '096ED5F1B65748A6976778E15973855A'),
	('H17311FD019A54DCC877C668FBF6214C3', '1500', '096ED5F1B65748A6976778E15973855A'),
	('H17BA203AC9D14114813B5FD7A8E35F48', '2250', '096ED5F1B65748A6976778E15973855A'),
	('H19CB8FCAC0B9428290ADCF095E4947E7', '1220', '096ED5F1B65748A6976778E15973855A'),
	('H1D291B6543274A14A0A3E7B2A60588E6', '3510', '096ED5F1B65748A6976778E15973855A'),
	('H1D9E88ECC67A41769238538C28A51953', '1360', '096ED5F1B65748A6976778E15973855A'),
	('H20AFA8852DCC4C3DA14D7905BBF033C7', '3600', '096ED5F1B65748A6976778E15973855A'),
	('H23CE7BA2A0084AECA436FCFC40BFD8F7', '3300', '096ED5F1B65748A6976778E15973855A'),
	('H24FDB01244DA44669D64C31BD9794F22', '1600', '096ED5F1B65748A6976778E15973855A'),
	('H2530C22BBC5A4B67B53D50328AF20EEE', '2500', '096ED5F1B65748A6976778E15973855A'),
	('H2B0B01E520BB4D2B99021EED2F7AF249', '1000', '096ED5F1B65748A6976778E15973855A'),
	('H2CCF4B3EA0C444E081E73EDBA0A910BD', '1300', '096ED5F1B65748A6976778E15973855A'),
	('H2E5E6D45DB734036B5001A11D91F440E', 'H944F681E40AD4A28B36F0C6951EE588F', '096ED5F1B65748A6976778E15973855A'),
	('H2EF2C628A7F54FD69B30B53FF84BE9AA', '2260', '096ED5F1B65748A6976778E15973855A'),
	('H2FF03C37384140128F07761550040893', '1410', '096ED5F1B65748A6976778E15973855A'),
	('H3202DF4C14DB4B7C93840E7E60BC254D', '3340', '096ED5F1B65748A6976778E15973855A'),
	('H34E7E086B60D4A4C8ACED63932320492', 'H31F84FFA4B5B467C8355B0F4B582AD3D', '096ED5F1B65748A6976778E15973855A'),
	('H36EE3A840C9B4A6B84CA54CE4F098743', '3320', '096ED5F1B65748A6976778E15973855A'),
	('H3AC5EAA6CBC34177875009FF8EDD8CF0', '2420', '096ED5F1B65748A6976778E15973855A'),
	('H3FF2BF35249D4C809284C1496ABC96EC', '3240', '096ED5F1B65748A6976778E15973855A'),
	('H4216F8D98D24484B8B24CBDCA8227BE6', '1310', '096ED5F1B65748A6976778E15973855A'),
	('H42C82A523BD94672A363E6690F01CC5D', '3230', '096ED5F1B65748A6976778E15973855A'),
	('H43F438026FD644A19ADE8EDE13141474', 'B197C1EF60DF4F1D8E6E0849F7F24D7C', '096ED5F1B65748A6976778E15973855A'),
	('H44EC10F5F47841A9A56F0E84FEB4AB4A', 'E33BA6ADACE54618A3B57D924BF665E5', '096ED5F1B65748A6976778E15973855A'),
	('H48FEAE0AA773427EB3A329EA17E7801D', '2610', '096ED5F1B65748A6976778E15973855A'),
	('H49498E8F27C14EE6BD73CCB3E47893C2', '2600', '096ED5F1B65748A6976778E15973855A'),
	('H4A9031EE641B45FABE541DC34701EB90', '3400', '096ED5F1B65748A6976778E15973855A'),
	('H4AE8ED47ADB446BEA5617519D2D6018C', '2310', '096ED5F1B65748A6976778E15973855A'),
	('H4CDA615D93144A18BB059738B5ABAF0E', '2000', '096ED5F1B65748A6976778E15973855A'),
	('H4DEC9F4BEFBB4E90A4EDA690B7BB7C4B', '2230', '096ED5F1B65748A6976778E15973855A'),
	('H52039EB1D69E4E42B6E412B3B417F51B', '3100', '096ED5F1B65748A6976778E15973855A'),
	('H522BC9DA8896486C9E97592392C2FE05', '3500', '096ED5F1B65748A6976778E15973855A'),
	('H538E20CFA9CD4D31BBAFE87A1C33E906', '3200', '096ED5F1B65748A6976778E15973855A'),
	('H563084C6F80445BDA0502C0E9349F6A5', '3000', '096ED5F1B65748A6976778E15973855A'),
	('H5E2814D874984077876E72373A5BD12A', '1390', '096ED5F1B65748A6976778E15973855A'),
	('H64ADC72C979E4BDF9875AEE1A5459EF9', 'B5F31868538C4546AD0871DF8907F19F', '096ED5F1B65748A6976778E15973855A'),
	('H64B220541C21493F884F2BFDC29B230F', '1350', '096ED5F1B65748A6976778E15973855A'),
	('H684B58D442ED4D359F9777AC3D5C2F47', '1250', '096ED5F1B65748A6976778E15973855A'),
	('H74ECE0D940AA481B905DE39F3768FC22', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', '096ED5F1B65748A6976778E15973855A'),
	('H7D9B0FCF499C4B3B99E7D4F52D60BB0A', '1430', '096ED5F1B65748A6976778E15973855A'),
	('H803747B230FF4E90B049CABDAA1D6781', 'HC04D6079B9354229A6FF50FA0D1AA191', '096ED5F1B65748A6976778E15973855A'),
	('H81963512AB0A485AABBDEEEA2A6B2CB0', '1330', '096ED5F1B65748A6976778E15973855A'),
	('H831885325168471A90531726F7E11443', '3310', '096ED5F1B65748A6976778E15973855A'),
	('H8534ED8E75D14F09A69BC631B3B0AE4C', 'HFB374E696865488199FE5EE05351277C', '096ED5F1B65748A6976778E15973855A'),
	('H85464E3A3E7542DEBBA970D7B880D048', '2300', '096ED5F1B65748A6976778E15973855A'),
	('H8C787B6B41654262A2590065FA5BAB36', '1440', '096ED5F1B65748A6976778E15973855A'),
	('H90A2B1B0B21F487F9A58B8B3955B633F', '1370', '096ED5F1B65748A6976778E15973855A'),
	('H962FD6B4056D406EBA614A94B5DF636A', '11C8868AEEBC4E2AB2A01E304CFFE958', '096ED5F1B65748A6976778E15973855A'),
	('H978EA1FB67DC4E07BB2FD846952CDCCF', 'F00ED7D6AD764406AA8D99ECEBB99061', '096ED5F1B65748A6976778E15973855A'),
	('H986FCBF3030D42BAA4CCB054ED73DBBB', 'B9FEE893454046D1B0D7499BF34E7CE9', '096ED5F1B65748A6976778E15973855A'),
	('H9A38FA018E2140779F801BBAE312D2A7', '3120', '096ED5F1B65748A6976778E15973855A'),
	('H9B0E637DEAE748ECB2AF5322A861967B', 'H41CFBB44FD024AC9ADF09E6A8AE70B37', '096ED5F1B65748A6976778E15973855A'),
	('H9F2D8A2C70124B18B1C926F11F35C9FA', '3410', '096ED5F1B65748A6976778E15973855A'),
	('H9F6D4CE2BAAC4C66BF0A7174C87CCC69', '3420', '096ED5F1B65748A6976778E15973855A'),
	('HA7E807E7EB5147F6BA382C96F7BEAD98', '2410', '096ED5F1B65748A6976778E15973855A'),
	('HA90889955A4441F9A91E5BAFE9F13F06', '66C60EAA43DD4A50A58B96BB43F99EFC', '096ED5F1B65748A6976778E15973855A'),
	('HAC10EC3315EF40E78D294665BEF0531D', '1100', '096ED5F1B65748A6976778E15973855A'),
	('HB14DAB32E2C04C0DA892F44BE8995726', '1240', '096ED5F1B65748A6976778E15973855A'),
	('HB1620AFA25FA4808835BC5A4D70D9CC3', 'HF68BC425D0524EFAB523517F70F282E8', '096ED5F1B65748A6976778E15973855A'),
	('HB2BF078DFC3D43DBA8B4D8CEA31194CE', 'B86F1721065F44AA963CEBC905382B69', '096ED5F1B65748A6976778E15973855A'),
	('HC1B80EC3BD8E4FA3BCC98DDCB00857E4', '1460', '096ED5F1B65748A6976778E15973855A'),
	('HCAE68F49CB284DED81A06D3F17D74680', '2200', '096ED5F1B65748A6976778E15973855A'),
	('HCF6755CECA8F49ABA6140AD047AB4960', '2210', '096ED5F1B65748A6976778E15973855A'),
	('HD084251B41CD49978971FDFB468FBB71', '3330', '096ED5F1B65748A6976778E15973855A'),
	('HD439B97A4CFE4C9AB8D44C695104A306', '2400', '096ED5F1B65748A6976778E15973855A'),
	('HD72BA9A19FF04E118A6B6304A661923B', '2320', '096ED5F1B65748A6976778E15973855A'),
	('HD74A6A9073234CDFB6591D459E22E42D', '1400', '096ED5F1B65748A6976778E15973855A'),
	('HDCC5EA262E344BA6AC61A5078CFEE39F', '1380', '096ED5F1B65748A6976778E15973855A'),
	('HDEEDB93C24574CB89FC7445961BA94C8', '892D6DE1B3B948F8A38503FED0C02849', '096ED5F1B65748A6976778E15973855A'),
	('HE21D4187CB7344CDB94E41E40E27F728', '3140', '096ED5F1B65748A6976778E15973855A'),
	('HE42E60FCB09F488CBFB4D80A931A065D', '2620', '096ED5F1B65748A6976778E15973855A'),
	('HE59B5D4896CC48519E27396CA9F3E4CA', '3440', '096ED5F1B65748A6976778E15973855A'),
	('HE819A37BA0B343D78646F36DD05DDF77', 'D6A4CE63A1D14947871DEA616EAD30D9', '096ED5F1B65748A6976778E15973855A'),
	('HE9762BEBF0FD4ACF8E72F83B63FF2E3C', '500', '096ED5F1B65748A6976778E15973855A'),
	('HEBBD56C5B90D4817997914F4267E3098', '1200', '096ED5F1B65748A6976778E15973855A'),
	('HECB731AEFE764E70B604FEE05B6FD45D', '1BB60C6A663045ACA218FC0078C36192', '096ED5F1B65748A6976778E15973855A'),
	('HECC944BCBF6C44FA9BB8105ADDBE656C', 'H743C750391B2452DB99EBFAAA3479C66', '096ED5F1B65748A6976778E15973855A'),
	('HEEB409E03698447096AE2BC5DE1376F7', 'A7D770F506564850B3B930381B0A5AD6', '096ED5F1B65748A6976778E15973855A'),
	('HEFC5BEC3BCED4DA39DFD7176899A0D59', '2220', '096ED5F1B65748A6976778E15973855A'),
	('HEFEB8219B3204FBAB2345B70BAD6B10B', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '096ED5F1B65748A6976778E15973855A'),
	('HF009D769E7C545E9B98F07EBA527F2DC', '4000', '096ED5F1B65748A6976778E15973855A'),
	('HF8F2B63B968242F7865AF27474923A51', '3110', '096ED5F1B65748A6976778E15973855A'),
	('HFB6289116718413B8236D3BD32DBE7BC', '3520', '096ED5F1B65748A6976778E15973855A'),
	('HFB8D87F3911A45E5B2D2EB2317FF9A20', '1340', '096ED5F1B65748A6976778E15973855A'),
	('HFF3A5F79B1814B6FB3C361CD6B0CEC3E', '1420', '096ED5F1B65748A6976778E15973855A');
/*!40000 ALTER TABLE `mes_menu_auth` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_menu_rest_api 结构
DROP TABLE IF EXISTS `mes_menu_rest_api`;
CREATE TABLE IF NOT EXISTS `mes_menu_rest_api` (
  `id` varchar(50) NOT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `param` text,
  `name` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_menu_rest_api 的数据：~281 rows (大约)
DELETE FROM `mes_menu_rest_api`;
/*!40000 ALTER TABLE `mes_menu_rest_api` DISABLE KEYS */;
INSERT INTO `mes_menu_rest_api` (`id`, `menu_id`, `url`, `type`, `param`, `name`, `create_date`, `update_date`) VALUES
	('000AB1F0EF314375999471D6630D7E4E', '2260', '/dpbarcode/byAll', 'GET', '', '查询所有记录--条码', '2017-07-26 17:58:25', '2017-07-26 17:58:52'),
	('008860935577490DAAC484A8383D4E15', '1210', '/user/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:03', NULL),
	('00A307A74FFB478BA5F2C451617D6022', '2250', '/dpform/deleting', 'GET', '{"ids":"6,7"}', '根据多个id删除记录--表单', '2017-07-27 09:14:21', '2017-07-27 09:14:46'),
	('03B6EA6D67F54036B611ABFB3AD0A0B8', '2310', '/dpservicetype/creating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "expandMap": {\n    "additionalProp1": {},\n    "additionalProp2": {},\n    "additionalProp3": {}\n  },\n  "parentId": "1",\n  "name": "ceshi"\n}', '新建记录', '2017-07-26 13:52:58', NULL),
	('04227A6C8D6C4AB99E28928BCDFAA7BE', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', '/pdfiletype/creating', 'POST', '{\n  "name": "string",\n  "type": "string"\n}', '新建文件分类', '2017-07-26 09:15:36', NULL),
	('043DB6F11B604E238C3636DDD0022B9A', '1240', '/menu/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:04', NULL),
	('04FB5C9C269247A988B6D8638D5CA131', '1310', '/ftyarea/creating', 'POST', '{"name":"test"}', '车间信息-添加', '2017-07-31 17:04:47', NULL),
	('059F87F776954DDD832A5293B167AC3B', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/1', 'GET', '{"id":"1"}', '根据id查询记录--标签', '2017-07-27 14:33:28', '2017-07-27 14:33:53'),
	('0641FC5151024CB9B6B6F84D7826C503', '1360', '/ftydeviceannex/1', 'GET', '{"id":"7"}', '附件分类--根据id查询记录', '2017-07-31 16:49:29', '2017-07-31 16:49:46'),
	('08ECAB26071F435CB1161B2D8B06E266', '1350', '/ftydevicetype/1', 'GET', '', '根据id查询记录', '2017-07-20 20:19:34', NULL),
	('09805936C692406DAEF87F280446FBED', '1440', '/pdbomwork/getMaterialTree', 'GET', '{"bomId":"FB50991A12E0420AB624F71ADAC6052E"}', '根据bom id查询bom物料清单树', '2017-07-24 18:15:38', NULL),
	('09B314348A304ADF9A30F75AD49AAD87', '1240', '/menu/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:04', NULL),
	('09F2C94CE74A42BABD38308A2EE7712C', '1360', '/ftydeviceannex/byAll', 'GET', '', '附件分类--查询所有记录', '2017-07-31 16:47:31', '2017-07-31 16:47:48'),
	('0A22341866F04C98BA6ADB0AEB3F184F', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterialtype/creating', 'POST', '{\n \n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "name": "图片素材",\n  "description": "测试图片"\n}', '素材分类-新建记录', '2017-08-11 16:19:08', '2017-08-11 16:19:05'),
	('0B1BCA64566B4B75AF575C5BFBD0ED8D', '2410', '/dpfunctiontype/updating', 'POST', '{\n  "id": "string",\n  "parentId": "string",\n  "name": "string",\n  "type": "string"\n}', '编辑函数分类', '2017-07-26 09:47:14', NULL),
	('0B374AC96AF840C38B4186157DCF9888', '1220', '/role/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:03', NULL),
	('0CA69D7712374F879C279118D45CF1D5', '2500', '/table/creating', 'POST', '{\n  "id": "string",\n  "name": "string",\n  "cnName": "string",\n  "entityClass": "string",\n  "type": "string",\n  "tableTypeId": "string",\n  "isInternal": "string",\n  "isCreate": "string"\n}', '指定分类新建表（开发平台-主表）', '2017-07-26 09:36:54', NULL),
	('0E1ED8F3B68F4BF6B3AC6C618F1E6385', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterialtype/deleting', 'GET', '{"ids":""}', '素材分类-根据多个id删除记录', '2017-08-11 16:18:55', '2017-08-11 16:18:52'),
	('0EEF7874BD5D44B49DA0F8DD7B51A1DE', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/updating', 'POST', '{"id":"2","name":"a","startTime":"08:00:00","endTime":"16:00:00"}', '更新记录', '2017-07-24 18:19:18', '2017-07-24 18:17:36'),
	('0FD92BE618854B90ACDC86A7F1F353AA', '1310', '/ftysiteinfo/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:19:34', NULL),
	('1069F86A0F7B43398CBDFAD2475EDFF2', '1310', '/ftyenterprise/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:04', NULL),
	('10BC53EB33BA4D80B90499F20FC32EF9', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', '/pdfileresources/saveMaterialResourceFile', 'POST', '{\n  "materialIds": [\n    "4","5"\n  ],\n  "resourceFileId": "2"\n}', '关联资源文件和物料列表', '2017-07-31 15:17:43', '2017-07-31 15:18:00'),
	('11DAD72A094B48368A68C0356176743B', '1240', '/menu/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:04', NULL),
	('121B21215BF649DD829326A91522A8FE', '1210', '/user/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:03', NULL),
	('12801975A6EB453C99823133EE47260F', '2310', '/dpservicetype/deleting', 'GET', '{"ids":"4"}', '根据多个id删除记录', '2017-07-26 13:51:43', NULL),
	('12E9383A146541FAAD5691299828C42E', '1320', '/ftyarea/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:04', NULL),
	('144ECD3445914A67B9E3EEB461BB627D', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"type":"文件"},\n  "rows": [\n    {}\n  ]\n}', '配置属性根据条件分页查询', '2017-07-28 17:50:52', NULL),
	('14C35428C67F43A49569E356044660A1', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingdevice/saveWorkstations', 'POST', '{\n  "id": "",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "enterpriseId": "1",\n  "siteId": "1",\n  "areaId": "1",\n  "productionLineId": "1",\n  "workCenterId": "1",\n  "workstationId": "",\n  "schedulingId": "E38B6B334E4A497C8C34DE4107B1C6B0",\n  "enterpriseName": "",\n  "siteName": "",\n  "areaName": "",\n  "productionLineName": "",\n  "workstationName": "",\n  "workCenterName": "",\n  "workstationIds": "3"\n}', '新建记录--班次--设备', '2017-08-02 14:17:43', '2017-08-02 14:17:57'),
	('14FC148B9B2E4E5B8553F69E0416489B', '2310', '/dpservice/creating', 'POST', '{\n  "id": "11",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "高温测试服务",\n  "url": "/HTest",\n  "methodName": "高温测试工序验证",\n  "templateParameterContent": "string",\n  "templateResultContent": "string",\n  "type": "GET",\n  "status": "1",\n  "serviceTypeId": "3",\n  "description": "工序验证"\n}', '新建记录', '2017-07-26 11:14:56', NULL),
	('1594DCAAD71A4D7EB1D15685D3388C0A', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingpersonnel/savePersonnels', 'POST', '{\n  "id": "",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n \n  "userId": "",\n  "userGroupId": "2",\n  "schedulingId": "8DD5551E3B65478696AE42F1A20D2F8E",\n  "userName": "",\n  "groupName": "",\n  "userIds": "1,2"\n}', '新建记录--班次--人员', '2017-08-02 10:07:47', '2017-08-02 10:08:01'),
	('18AD613506D14984B7B9F14F0DC42C6E', '1330', '/ftydevice/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '设备--根据条件分页查询', '2017-07-31 18:19:14', '2017-07-31 18:19:31'),
	('1A9B8A2CFE084C76A25F2328041A064D', '1440', '/pdbomwork/getMaterialAmount', 'GET', '{\n"bomId":"FB50991A12E0420AB624F71ADAC6052E",\n"code":"801300190"\n}', '查询bom下物料不同版本数量相关信息列表', '2017-07-24 18:18:20', NULL),
	('1C5D8924B77D46699336464E854C96C7', '1340', '/ftyproductionline/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:05', NULL),
	('1D74A8117DC94BAA944DD4FEEA7EA467', '1310', '/ftyenterprise/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:04', NULL),
	('1F0692513AE54F638B31E33699509EA9', '2320', '/dpservicetype/getAllServiceByServiceType', 'GET', '', '根据接口服务类型查询接口服务', '2017-07-26 15:26:16', '2017-07-26 15:26:42'),
	('1FB198ED492E4D39928894885D445D03', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingpersonnel/getRestUser', 'POST', '{"userGroupId":"1",\n"schedulingId":"9745B50914DB41B4BBE98E09C766E8FB"}', '查询未添加的人员', '2017-08-02 18:20:08', NULL),
	('20A8F748AA974FF4A067B9D21B15922E', '1310', '/ftysiteinfo/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:19:34', NULL),
	('210128DA81D94886A247C30E8B17B234', '1340', '/ftyworkcenter/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '工作中心--根据条件分页查询', '2017-07-31 17:52:40', '2017-07-31 17:52:58'),
	('2167BD78E1B641DFAC86A29EF0DBB0BB', '1330', '/ftyworkcenter/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:04', NULL),
	('2374A83559084C3CB8C8D9EEAA2BD82B', '2250', '/dpformtype/byAll', 'GET', '', '查询所有记录--表单类型', '2017-07-27 09:13:47', NULL),
	('25BB2395569F4834809E66B6A82DCC00', '2250', '/dpformtype/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "pdId": "1",\n  "pdName": "test",\n  "name": "生产表单"\n}', '更新记录--表单类型', '2017-07-27 09:12:59', NULL),
	('265654008B244AA782F87D9B901E4798', '1310', '/ftyenterprise/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:04', NULL),
	('266B9E2DDD344322B1958689F40C4DE5', '1340', '/ftyworkcenter/deleting', 'GET', '{"ids":"1,2,3"}', '工作中心--根据多个id删除记录', '2017-07-31 17:53:40', NULL),
	('2784B89EE15D4527A2506BF62C85C759', '1330', '/ftyworkcenter/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:05', NULL),
	('2A6799504F6A4DD5AE9183F6682770B3', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterial/updating', 'POST', '{\n  "id": "7C0BF90360414FD88E6775584F41EA8A",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "素材3",\n  "fileName": "素材3.docx",\n  "path": "//1.1.1.1"\n}', '素材-更新记录', '2017-08-11 16:26:42', '2017-08-11 16:26:40'),
	('2B90BDBE30DB490080872F875102DDB0', '2310', '/dpservice/invoke/methodName', 'POST', '{ "code": "test2", "params": { "name":"Jack" }}', '统一服务接口调用', '2017-08-14 15:26:54', '2017-08-14 15:26:46'),
	('2D4D2EE8CECE4BBDAD2BF90B5DBEF6CF', '2260', '/dpbarcodetype/byAll', 'GET', '', '查询所有记录--条码类型', '2017-07-26 17:29:22', NULL),
	('2FFE49CD475444ABAEE09D8EB2CBD4B2', 'A7D770F506564850B3B930381B0A5AD6', '/dplabeltype/deleting', 'GET', '{"ids":"1"}', '根据多个id删除记录--标签类型', '2017-07-27 14:17:46', '2017-07-27 14:18:11'),
	('31E63B0157C9445CBD65F7E3D6874489', 'B197C1EF60DF4F1D8E6E0849F7F24D7C', '/ftydevicefaultprocess/deleting', 'GET', '', '根据多个id删除记录', '2017-07-31 14:38:09', NULL),
	('32691A3171304D5CABE587ADE0BF828C', '1460', '/pdworkorder/getUsers/byWorkOrder', 'GET', '{\n"workOrderId":"77AD75A7D5FA4C5D99EF1ED3E2C45F0D"\n}', '根据工单id查询对应的人员列表', '2017-07-25 17:55:09', NULL),
	('3274B52DBD914BAFB80C672B1CFFC47C', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplatetype/byAll', 'GET', '', '模板分类-查询所有记录', '2017-08-08 16:13:18', NULL),
	('3406D1B584F64138AE8A9526257D3FD0', '2210', '/dpproject/3', 'GET', '{"id":"3"}', '根据id查询记录', '2017-07-27 16:57:16', NULL),
	('34D110E5FB284365A3D3F93C33B8EF48', '2320', '/dpservicelog/byAll', '', '', '查询所有记录', '2017-07-26 16:32:54', NULL),
	('35CAE1351B2040DD8399A96DA4608BCE', 'A4B1E9742E994FEA933F66374CC73AEC', ' /dpmaterial/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {},\n\n}', '素材-根据条件分页查询记录', '2017-08-11 16:26:26', '2017-08-11 16:26:24'),
	('360473AE14164E9E8305A1EA750F8116', '1310', '/ftysiteinfo/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:19:34', NULL),
	('363CF7E4F5B04DF186AFFECD516BC6F2', '2310', '/dpservice/byAll', 'GET', '', '查询所有记录', '2017-07-26 10:01:53', '2017-07-26 10:02:19'),
	('36803BBC42E84C019C0A9A86911347F9', '2310', '/dpservice/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"serviceTypeId":"1"},\n  "rows": [\n    {}\n  ]\n}\n', '根据条件分页查询记录', '2017-07-26 10:10:27', NULL),
	('37D2FDF174FA426AA4C475251FFB508B', '1330', '/ftyworkstation/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {}\n}', '工作站--根据条件分页查询记录', '2017-07-31 18:06:45', '2017-07-31 18:07:02'),
	('37D9B5B4BB2D4992A3447D6251A37B2D', '1340', '/ftyproductionline/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:05', NULL),
	('3911BEA7F2B740DBA07987B5EC059A03', '2500', '/tabletype/deleting', 'GET', '', '删除对象分类', '2017-07-26 09:35:01', NULL),
	('394FCF3132F34FF68B0E2B346E9FB7C2', '1380', '/ftydevicefault/deleting', 'GET', '', '根据多个id删除记录', '2017-07-31 14:43:44', NULL),
	('3A756CA2C8AE4812B08B73DC7071C099', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassemblytype/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {}\n}', '组件分类-根据条件分页查询记录', '2017-08-11 17:09:06', NULL),
	('3BFED38F9CF74F74A59496725EFF6603', '1210', '/user/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:03', NULL),
	('3ED49D70EEE84D3B93736568F02655A3', '2310', '/dpservice/byCondition', 'POST', '{\n "serviceTypeId": "3"\n}', '根据条件查询记录', '2017-07-26 11:18:23', NULL),
	('3EFDAFEBFDC846E3B2384373AEFD78C6', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/byAll', 'GET', '', '工序基础配置查询所有', '2017-07-28 17:32:53', NULL),
	('428EF366CECD4F758B451676CA871C9D', '2220', '/dpproduceprocessconfig/updating', 'POST', '{ "id": "A6A50366D63646788E7D009BFB5A95CD", "type": "1", "cnName": "qqq", "key": "abc", "value": "def", "description": "111"}', '更新工序属性配置', '2017-07-27 10:02:43', NULL),
	('42F3E338186041BFB4BF0C5554B8D703', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/updating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "processId": "5",\n  "dataDictionaryTypeId": "5",\n  "dataDictionaryId": "5",\n  "formTypeId": "5",\n  "formId": "Frm_STOCK_IN"\n}', '工序基础配置更新记录', '2017-07-28 17:44:59', '2017-07-28 17:45:21'),
	('4303C5A2402840758F0E9FB1593D9EDE', '892D6DE1B3B948F8A38503FED0C02849', '/pdscheduling/deleteScheduling', 'GET', '{"ids":"1,2"}', '根据多个id删除记录--班次', '2017-08-02 14:12:45', '2017-08-02 14:12:59'),
	('4314A8953AFC48F2905E54EF5CAA768F', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/baseConfig', 'POST', '{ "pdLineId": "1", "pdId": "1", "processId": "1", "projectId": "1", "formTypeId": "1", "formId": "1", "isAuto": "1", "isBomMaterials": "1", "bomProduceId": "1", "processName": "abc", "processCode": "def", "processDescription": "ddd", "extendProperties": [ { "id": "1", "value": "sss" } ]}', '保存当前工序的属性配置（基础、扩展）', '2017-08-07 12:01:11', NULL),
	('43C15C00DDA241B1970778459D551B21', 'B197C1EF60DF4F1D8E6E0849F7F24D7C', '/ftydevicefaultprocess/updating', 'POST', '{\n  "id": "string",\n  "deviceFaultInfoId": "string",\n  "responsiblePersion": "string",\n  "abnormalProblems": "string",\n  "abnormalCode": "string"\n}', '更新记录', '2017-07-31 14:37:29', NULL),
	('46CFF7CA7E7C48C3917CC43C92E10B52', '2220', '/dpproduceprocessconfig/creating', 'POST', '{ "produceProcessId": "1", "type": "1", "cnName": "ddd", "key": "eee", "value": "fff", "description": "www"}', '添加工序属性配置', '2017-07-26 17:57:36', NULL),
	('49A0E27D8C8B4B85B406DF9EEE083463', '1350', '/ftydevice/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:05', NULL),
	('49EDCB2D9592452F9110B7FCEE37D61B', '2210', '/dpproject/byAll', 'GET', '', '查询所有记录', '2017-07-27 15:02:42', NULL),
	('4A3144C9827D4AF0A573A1D0E7EFF6AA', '1240', '/menu/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:04', NULL),
	('4C393D193BD4464A925B0C02D6078BAE', '1210', '/user/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:03', NULL),
	('4C703802C7D64E8B956FC067F919943F', '1330', '/ftyworkcenter/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:05', NULL),
	('4E0249CBC3AA4F058FFCBD7BA8EB18B4', '2260', '/dpbarcode/byCondition', 'POST', '{\n  "pdId": "1",\n  "typeId": "1"  \n}', '根据条件查询记录--条码', '2017-07-26 18:03:53', '2017-07-26 18:04:19'),
	('4E86F6D3B1854D21A7A4929C9C4A97D1', '1320', '/ftyarea/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:04', NULL),
	('4EE62B22F28C4504B5EEDD8657DA7C01', '1440', '/pdbomwork/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {"pdId":"1","search":"te"}\n}', '根据产品分页查询工单bom', '2017-07-24 18:14:45', NULL),
	('4F1853DE46484A30BAD0FF65503622BE', '892D6DE1B3B948F8A38503FED0C02849', '/pdscheduling/getSchedulingPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"schedulingTypeId":"1"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--班次', '2017-08-02 14:11:11', '2017-08-02 14:11:25'),
	('4FD264B9530E4449A257FAD157842305', '1460', '/pdorder/byCondition', 'POST', '{ "pdId": "E7FBF14B588249D59DE048B72EA2259D"}', '根据产品查询所有订单', '2017-07-25 15:07:25', NULL),
	('51248BD34C8F42B9AD00E3F659E2C84F', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/byPage', 'POST', '{"name":"1"}', '根据条件分页查询记录', '2017-07-24 16:55:19', '2017-07-24 16:53:37'),
	('51743873BE0E4541924E9BEF2DE31F8D', '1360', '/ftydeviceannexinfo/creating', 'POST', '{\n  "id": "13",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "CreateTest",\n  "description": "增加测试",\n  "number": "00123456",\n  "useCount": 0,\n  "startTime": "2017-07-26 05:35:04.448",\n  "endTime": "2017-07-26 05:35:04.448",\n  "deviceAnnexId": "2"\n}', '附件详细信息--新建记录', '2017-07-31 16:51:53', '2017-07-31 16:52:10'),
	('53D73ABF9DD44C8E896E0B1CC84F27B5', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/1', 'GET', '', '根据id查询记录', '2017-07-24 16:58:00', '2017-07-24 16:56:18'),
	('541C13A068184223A503C66BC183B5CF', '1460', '/pdworkorder/op/start', 'GET', '{\n"ids":"77AD75A7D5FA4C5D99EF1ED3E2C45F0D"\n}', '启动工单的生产', '2017-07-25 15:12:59', '2017-07-25 15:13:27'),
	('55AC5E9C04014681B16B066458ABCED2', '2210', '/dpproject/deleting', 'GET', '{"ids":"6"}', '根据多个id删除记录', '2017-07-27 16:31:34', '2017-07-27 16:31:59'),
	('568351592A254D89B57FD70A26246A7A', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/byCondition', 'POST', '{\n "processId":"3"\n}', '工序基础配置根据条件查询', '2017-07-28 17:34:37', '2017-07-28 17:35:00'),
	('57604BD1A37C4811ADB580D83346586E', '2500', '/tabletype/creating', 'POST', '{\n  "name": "string",\n  "isInternal": "string"\n}', '添加对象分类', '2017-07-26 09:32:55', NULL),
	('58A93F2CB928442BA2E61E73169D4C10', '2610', '/dpdatadictionary/creating', 'POST', '{\n\n  "mesDpDataDictionaryTypeId": "string",\n  "cnName": "string",\n  "keyk": "string",\n  "valuev": "string",\n  "description": "string"\n}', '添加数据字典记录', '2017-07-26 09:30:08', NULL),
	('58CB17EA6B104252B76F9D7067FB9A30', '1330', '/ftydevice/creating', 'POST', '{\n  "createDate": "2016-08-01 12:24:36",\n  "name": "LZ设备",\n  "ip": "10.10.0.110",\n  "location": "21区",\n  "description": "EOL-01",\n  "capacity": 1,\n  "priority": 1,\n  "category": "1",\n  "assetCode": "1",\n  "snNum": "84013112701265A",\n  "areaId": "3",\n  "deviceTypeId": "3"\n}', '设备--增加记录', '2017-07-31 18:12:08', '2017-07-31 18:12:25'),
	('5A8446854E024BC6AC86C55A79A70D3C', '1320', '/ftyarea/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:04', NULL),
	('5AF5E7939E154D15AF47CECED8B126D0', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/deleting', 'GET', '{"ids":"5"}', '根据多个id删除记录--标签', '2017-07-27 14:30:03', NULL),
	('5D54484597274B9BA5685D99AB97E5FA', '2230', '/dproutes/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {"pdId":"E7FBF14B588249D59DE048B72EA2259D","search":""}\n}', '根据产品分页查询工艺路径', '2017-07-27 13:40:11', NULL),
	('5EB553E3A8FD467AB610E127B37D8610', '1350', '/ftydevice/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:05', NULL),
	('5F00C29CEF3643DA9690917B38475FA9', '2220', '/pdline/byAll', 'GET', '', '查询所有产品线', '2017-07-26 16:00:40', NULL),
	('60EDEA1355044E3588B1BB718CC64D15', '2310', '/dpservice/updating', 'POST', '{\n  "id": "12",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "updateTest",\n  "url": "/test",\n  "methodName": "测试更新",\n  "templateParameterContent": "string",\n  "templateResultContent": "string",\n  "type": "POST",\n  "status": "0",\n  "serviceTypeId": "3",\n  "description": "测试测试"\n}', '更新记录', '2017-07-26 11:16:45', NULL),
	('6285B4B4CDE9433FA0DAD24DCC3BD375', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassembly/deleting', 'GET', '{"ids":""}', '组件管理-根据多个id删除记录', '2017-08-11 16:33:59', NULL),
	('632F4EA49C4F4020A8B23ADE2D29F898', '1340', '/ftyproductionline/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:05', NULL),
	('64D0FF29F5624C4AA8D8108247F6B9C8', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingpersonnel/deleting', 'GET', '{"ids":"1,2"}', '根据多个id删除记录--班次--人员', '2017-07-31 19:43:56', '2017-07-31 19:44:14'),
	('65FFA2B2DE7D465092664040A344F1BA', '1310', '/ftysiteinfo/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:19:34', NULL),
	('67D3C0C87CEC4DAA91BF65D82956C688', '1360', '/ftydeviceannexinfo/updating', 'POST', '{\n  "id": "13",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "测试",\n  "description": "UpdateTest",\n  "number": "1",\n  "useCount": 1,\n  "startTime": "2017-07-26 05:38:57.977",\n  "endTime": "2017-07-26 05:38:57.977",\n  "deviceAnnexId": "4"\n}', '附件详细信息--更新记录', '2017-07-31 16:51:19', '2017-07-31 16:51:36'),
	('693213EFABE54BB483DE742541975FC4', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpproduceprocess/creating', '', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "pdLineId": "T-Box",\n  "pdId": "2",\n  "processId": "103",\n  "projectId": "2",\n  "formTypeId": "3",\n  "formId": "4",\n  "isAuto": "1",\n  "isBomMaterials": "1",\n  "bomProduceId": "1"\n}', '工序新建记录', '2017-07-29 10:03:08', NULL),
	('694FAB6EF6354E828C64DB7372528682', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/byCondition', 'POST', '{"piId":"1",\n"typeId":"1"}', '根据条件查询记录--标签', '2017-07-27 14:35:17', NULL),
	('69575DBECA8C4853A9B1D9B08A72739F', '2210', '/dpproject/updating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "expandMap": {\n    "additionalProp1": {},\n    "additionalProp2": {},\n    "additionalProp3": {}\n  },\n  "pdLineId": "3",\n  "pdId": "2",\n  "name": "一汽尾灯控制器开发工艺",\n  "version": "4.0",\n  "isEnabled": 0,\n  "isRelease": 0,\n  "releaseTime": "2017-07-27 08:52:22.344",\n  "enabledTime": "2017-07-27 08:52:22.344"\n}', '更新记录', '2017-07-27 16:56:31', NULL),
	('695F5369446E4CCF952FF6DB1D6F2AED', '1220', '/role/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:03', NULL),
	('6B89866387344BD4B4A782A91167A2B1', '1350', '/ftydevicetype/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:19:34', NULL),
	('6BA000BBCF4F46C787423A3606193C7C', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterial/upload', 'POST', '', '素材上传', '2017-08-11 18:08:14', NULL),
	('6C1E909DA6B941BBB9683A507062EB90', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/deleting', 'GET', '{"ids":"6"}', '配置属性根据id删除记录', '2017-07-28 17:56:38', NULL),
	('6D17BF8FF47942B2806789C77465F23C', '1210', '/dept/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:19:33', NULL),
	('6D7249B2F5A14FF8A18205C41B91555B', '1350', '/ftydevicetype/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:19:34', NULL),
	('6E3835525178420FB217D53811D1A909', '1210', '/user/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:03', NULL),
	('70B40C6FE3E7417B864A2CF4E0691EDB', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', '/pdfiletype/updating', 'POST', '{\n  "id": "string",\n  "name": "string",\n}', '文件分类编辑', '2017-07-26 09:21:52', NULL),
	('70D1CE6D438746A2B899A04872A5345C', '1430', '/pdbomaffiliated/creating', 'POST', '{\n"bomProduceId":"C8AF3AE04DAC48CF80F824B9A54C76C8",\n"key":"test-key",\n"value":"test-value"\n}', '设置bom属性', '2017-07-25 14:40:47', '2017-07-25 14:41:15'),
	('719DE1E4A39A476BBFAF36B96A383F7D', '2250', '/dpform/getFormTypedTree', 'GET', '{"pdId":"1"}', '根据产品Id查询以表单类型分类的表单列表--表单', '2017-07-27 09:14:14', '2017-07-27 09:14:39'),
	('72709DCCD4FC4ECC97E27EFDA4D04253', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingdevice/deleting', 'GET', '{"ids":"1,2"}', '根据多个id删除记录--班次--设备', '2017-07-31 18:48:46', '2017-07-31 18:49:03'),
	('72AF270AFB16429EBD109D534464633F', '1210', '/dept/1', 'GET', '', '根据id查询记录', '2017-07-20 20:19:34', NULL),
	('731745CFD2134A219BB612E10353EA68', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/uploadInstruction', 'POST', '', '上传说明文档', '2017-08-15 13:55:51', '2017-08-15 13:55:41'),
	('737FB23262DB43DA8E4AB310B609322C', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassembly/creating', 'POST', '{\n\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "组件3",\n  "fileName": "组件3.jar",\n  "path": "//192.168.1.255"\n}', '组件管理-新建记录', '2017-08-11 16:32:57', NULL),
	('743D3C612040403FB11657494A8D5CDA', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"pdId":"1","typeId":"1"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--标签', '2017-07-27 14:37:19', NULL),
	('751F2B63CF284F938BF7BE40432B957F', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/updating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "template": "test1",\n  "image": "test1",\n  "pdId": "1",\n  "typeId": "1",\n  "name": "T-Box产品标签",\n  "description": "T-Box的产品标签"\n}', '更新记录--标签', '2017-07-27 14:31:14', NULL),
	('75307EDF59AB4A17A85443200FBDF14F', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/byAll', 'GET', '', '配置属性查询所有记录', '2017-07-28 17:48:44', '2017-07-28 17:49:06'),
	('77A399A79F2C40B4BD3E6EA8CA952D6B', '2250', '/dpform/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"formTypeId":"1"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--表单', '2017-07-27 09:14:44', '2017-07-27 09:15:09'),
	('7818C505DA1D436093AFAE4B8D66BEF0', '2500', '/tabletype/updating', 'POST', '{\n  "id": "string",\n  "name": "string",\n  "isInternal": "string"\n}', '编辑对象分类', '2017-07-26 09:33:45', NULL),
	('78216E4606654D22BD8898C5FE3C752D', '2320', '/dpservicelog/creating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "expandMap": {\n    "additionalProp1": {},\n    "additionalProp2": {},\n    "additionalProp3": {}\n  },\n  "serviceId": "2",\n  "status": "1",\n  "invokeTime": "3s",\n  "timeTaken": "4s"\n}', '新建记录', '2017-07-26 17:14:25', NULL),
	('78470E89B95E4ECFAE0EA9818E0C42B0', '1330', '/ftyworkcenter/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:05', NULL),
	('78745E011A9944D09FF15E9A56449F9D', '1330', '/ftyworkstation/deleting', 'GET', '{"ids":""}', '工作站--根据多个id删除记录', '2017-07-31 18:01:05', NULL),
	('78C1190C02F045FA8A2A8E51C7248204', 'B197C1EF60DF4F1D8E6E0849F7F24D7C', '/ftydevicefaultprocess/creating', 'POST', '{\n  "deviceFaultInfoId": "85D1CFF2E1E643C68B7132B34FAA2B39",\n  "responsiblePersion": "le",\n  "abnormalProblems": "sdsdasdasdsd",\n  "abnormalCode": "sdsdsdsd"\n}', '新建记录', '2017-07-31 14:32:14', NULL),
	('79F89C5668DE432686D1B7BCC52C5170', '2610', '/dpdatadictionary/updating', 'POST', '{\n  "id": "A162B8343DE4423EBEBCDBB3A51F1BAD",\n  "mesDpDataDictionaryTypeId": "B3275391C7614E8C9420D1D828EF631B",\n  "cnName": "string",\n  "keyk": "sdsd",\n  "valuev": "sdssdsdsd",\n  "description": "sdsdsdsdsdsd"\n}', '编辑数据字典记录', '2017-07-26 14:37:40', '2017-07-26 14:38:07'),
	('7A084BB45F904946BE250EE453F76841', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassemblytype/creating', 'POST', '{\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "组件分类1",\n  "description": "组件分类11111"\n}', '组件分类-新建记录', '2017-08-11 16:43:26', NULL),
	('7A49FBADA4F04ED8A051D8CE9B3633DD', '1460', '/pdworkorder/getProcesses/byPd', 'GET', '{\n"pdId":"1"\n}', '根据产品id查询工序列表', '2017-07-25 16:46:18', '2017-07-25 16:46:46'),
	('7A62026DBB4144C8BFDEF05D112FDF33', '1360', '/ftydeviceannex/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"name":"耗品"},\n  "rows": [\n    {}\n  ]\n}', '附件分类--根据条件分页查询记录', '2017-07-31 16:47:23', '2017-07-31 16:47:40'),
	('7B431B07D1744A46B213EAA57A30E7D4', '1350', '/ftydevicetype/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:19:34', NULL),
	('7BDA0A7636714DD5B90D6AF915B0FF24', '2250', '/dpform/creating', 'POST', '{\n  "id": "6",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n \n  "name": "设备类型",\n  "formTypeId": "2",\n  "url": "192.168.2.3",\n  "content": "设备类型",\n  "description": "测试表单"\n}', '新建记录--表单', '2017-07-27 09:14:38', '2017-07-27 09:15:03'),
	('7BF19EE725E449B8BD287D33C870B334', '1320', '/ftyarea/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:04', NULL),
	('7C32275478944931ABFF9B6C1A2661F0', '1310', '/ftysiteinfo/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:19:34', NULL),
	('7C5BBDF9A58448E8BE526CC6F9AD6563', '1440', '/pdbommaterials/byAll', 'GET', '', '查询所有物料', '2017-07-31 14:16:18', NULL),
	('7C79997586CB43C38CF450CE3F5E47A6', '1340', '/ftyproductionline/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:05', NULL),
	('7D7164A8B8AB4852BAD128C1D67D9621', '1310', '/ftyarea/deleting', 'GET', '{"ids":"1,2,3"}', '车间信息--根据多个id删除记录', '2017-07-31 17:40:46', '2017-07-31 17:41:03'),
	('7F110FD892044712967C1BFFED4C3D28', '1230', '/usergroup/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:43:14', '2017-07-20 20:43:51'),
	('7FD1952F391144C78061AC1594BC5D83', '2610', '/dpdatadictionarytype/creating', 'POST', '{\n  "id": "string",\n  "name": "string"\n}', '数据字典类型添加', '2017-07-26 09:25:23', NULL),
	('808311F59E17407C92B41C22AFBF006B', '1330', '/ftydevice/deleting', 'GET', '{"ids":"1CAD85275CFA4C858F33E3EC9D592560"}', '设备--根据多个id删除', '2017-07-31 18:13:50', NULL),
	('80C7E5EA843843E8B847970285971923', 'A7D770F506564850B3B930381B0A5AD6', '/dplabeltype/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "name": "产品标签",\n  "description": "产品标签"\n}', '更新记录--标签类型', '2017-07-27 14:21:35', '2017-07-27 14:22:00'),
	('80F962E5115B4923B508330C3A076C45', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/creating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "template": "test1",\n  "image": "test1",\n  "pdId": "1",\n  "typeId": "1",\n  "name": "T-Box产品标签",\n  "description": "T-Box产品标签"\n}', '新建记录--标签', '2017-07-27 14:25:17', NULL),
	('83375FEF3503444D99F2B609DDA965FE', '1230', '/usergroup/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:43:34', '2017-07-20 20:44:11'),
	('83DB9688E8E042D5B3F288F6DC56CB62', '1310', '/ftysiteinfo/1', 'GET', '', '根据id查询记录', '2017-07-20 20:19:34', NULL),
	('84FD4F9C94974BE786716914192BB19B', '2220', '/pd/byCondition', 'POST', '{ "pdLineId":"1"}', '根据产品线查询所有产品', '2017-07-26 16:06:15', NULL),
	('863D6C5497814202A90E69981B663B18', '1340', '/ftyproductionline/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:05', NULL),
	('870AD401644F4C058BF06312F502E7A9', '1220', '/role/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:03', NULL),
	('8795966C8901425E883509A17FB53D05', '1230', '/usergroup/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:43:41', '2017-07-20 20:44:18'),
	('881CFB08D9194A44802DF92DD77D284F', '2310', '/dpservice/1', 'GET', '{"id":"1"}', '根据id查询记录', '2017-07-26 10:11:22', '2017-07-26 10:11:49'),
	('890E71DA043B4D3EAA7186E16E600F2E', '2220', '/dpproduceprocess/updateConfig', 'POST', '{\n  "id": "F59E287CC71D40A1AEC17C8A157E2A51",\n  "formTypeId": "0616B428C5A94A919C5BDF1396AD7051",\n  "formId": "cB30C1589ACF4A069E91D87FF8CE9117",\n  "extendProperties": [\n    {\n      "id": "C08F125CD3E44FFDAC3B79BC5E36BC5C",\n      "value": "9999"\n    }\n  ]\n}', '生产工序配置', '2017-08-15 17:13:03', NULL),
	('895491FFE48644AEB9435A3E5B895066', '2220', '/dpproduceprocess/saveDpProduceProcess', 'POST', '{\n  "processIds": [\n    "1","2"\n  ],\n  "bomProduceId": "12"\n}', '批量添加生产工序', '2017-08-16 17:42:46', NULL),
	('8B8599D6B83E498B9365543E06AC5BC6', '1350', '/ftydevice/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:05', NULL),
	('94402307573242E4A90886623B0A0C70', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/updating', 'POST', '{\n  "id": "8",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "processId": "6",\n  "cnName": "打标",\n  "key": "123",\n  "type": "文件",\n  "description": "打标配置文件"\n}', '配置属性更新记录', '2017-07-28 17:55:31', NULL),
	('94831F1E10EA4958ADBB99E8E55B2EBE', '11C8868AEEBC4E2AB2A01E304CFFE958', '/useroplog/query', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {"description":"户管"}\n}', '分页查询用户操作日志（http://192.168.5.3:8600/head/）', '2017-08-04 14:56:11', NULL),
	('955148D38A44426ABE0D1DDE6A9A0DCC', '1310', '/ftyarea/updating', 'POST', '{\n  "id": "E0BF074D744C4CFABE4688BE3BDCC924",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "siteInfoId": "string",\n  "name": "组装车间",\n  "phone": "010-843854388",\n  "location": "上海工厂三层C区",\n  "description": "组装线",\n  "category": "1",\n  "timeZone": "Sh"\n}', '车间信息--编辑修改', '2017-07-31 17:08:32', NULL),
	('967317FF944346BFB9985262C4FC04D9', '2260', '/dpbarcode/creating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "pdId": "1",\n  "typeId": "1",\n  "name": "T-Box产品条码",\n  "description": "T-Box产品条码",\n  "processId": "1BC6573D4FB34FCC89B2AE17E89EA73D",\n  "ruleId": "1"\n}', '新建记录--条码', '2017-07-26 17:34:07', NULL),
	('97272F11483D4C5C9DB6E625F2768C13', '2260', '/dpbarcode/1', 'GET', '{"id":"1"}', '根据id查询记录--条码', '2017-07-26 17:58:17', '2017-07-26 17:58:44'),
	('9830E99DB59444F4AA4642BFB432CC0F', '1360', '/ftydeviceannexinfo/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"deviceAnnexId":"1"},\n  "rows": [\n    {}\n  ]\n}', '附件详细信息--根据条件分页查询记录', '2017-07-31 16:50:30', '2017-07-31 16:50:47'),
	('98825FE896F045A3AA95EC5890DB7C34', '2220', '/dpproduceprocess/byPage', 'POST', '{ "pageSize": 10, "pageNum": 1, "condition": {"projectId":"1","search":""}}', '根据开发工程分页查询工序', '2017-07-26 16:37:44', '2017-07-26 16:38:10'),
	('99C99222ECE448679094D5D09CC7C248', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingdevice/getRestWorkstation', 'POST', '{\n  "workCenterId":"3",\n"schedulingId":"9745B50914DB41B4BBE98E09C766E8FB"\n}', '查询未添加的工作站', '2017-08-02 18:21:01', NULL),
	('9A0035E757214BA78F17FD5A0C930C2C', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassembly/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {}\n}', '组件管理-根据条件分页查询记录', '2017-08-11 16:41:11', NULL),
	('9A09A674B27743ADBAD3D25E27551BA7', '1210', '/dept/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:19:34', NULL),
	('9A9A26A4377F4B26B06D06B289948E93', '1350', '/ftydevice/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:05', NULL),
	('9B3018C047BD492C9EEFB476122B1FE3', '2310', '/dpservice/generateCode', 'GET', '', '生成服务编码', '2017-08-14 16:39:20', NULL),
	('9B6760EFBB2B48568C3EFC4C72C5FCBD', '2260', '/dpbarcodetype/creating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "name": "产品条码",\n  "description": "产品条码"\n}', '新建记录-条码类型', '2017-07-26 16:41:14', NULL),
	('9CE480C79D0841DCB235F2672B6A17DB', '1210', '/user/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:03', NULL),
	('9D091320929C479689654327E05D87C6', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/uploadTemplate', 'POST', '', '上传模板文档', '2017-08-15 13:56:20', NULL),
	('9D0BF6DDBBAF42AAA41B646AE84631C1', '1360', '/ftydeviceannex/creating', 'POST', '{\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "测试09"\n}', '附件分类--新建记录', '2017-07-31 16:54:41', '2017-07-31 16:54:58'),
	('9E214BFDC94A4B73B1474A6124953633', '1430', '/pdbomproduce/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {"pdId":"1","search":"te"}\n}', '根据产品分页查询生产BOM', '2017-07-24 18:11:54', '2017-07-24 18:12:24'),
	('9E312E2A83B64C61B91A939FFBAF54F5', '1460', '/pdworkorder/op/stop', 'GET', '{\n"ids":"77AD75A7D5FA4C5D99EF1ED3E2C45F0D"\n}', '停止工单的生产', '2017-07-25 15:13:59', NULL),
	('A095142643294D0F8BC6DEFF097AD6C9', '1350', '/ftydevice/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:05', NULL),
	('A0D735F874474226B2C0F0D25A20E4E0', 'A7D770F506564850B3B930381B0A5AD6', '/dplabeltype/byAll', 'GET', '', '查询所有记录--标签类型', '2017-07-27 14:21:45', NULL),
	('A1359DA8C0C3408DA0D93B243E467FBF', '1320', '/ftyarea/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:04', NULL),
	('A2A0E455FA2F4CC1AEC4262D4783ACA0', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/creating', 'POST', '{"id":"1","name":"a","startTime":"08:00:00","endTime":"16:00:00"}', '新建记录', '2017-07-24 18:19:49', '2017-07-24 18:18:07'),
	('A2CFC371CBB44D81ADF18A5EF4231C65', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassemblytype/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36"\n}', '组件分类-更新记录', '2017-08-11 17:07:59', NULL),
	('A46F7B596FC44534A3C8C763FC79B17E', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplate/byAll', 'GET', '', '模板-查询所有记录', '2017-08-08 16:10:45', '2017-08-08 16:10:48'),
	('A5E431E451894B25998FEFFF9E5D0D36', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingdevice/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"schedulingId":"E38B6B334E4A497C8C34DE4107B1C6B0"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--班次--设备', '2017-08-02 14:24:20', '2017-08-02 14:24:34'),
	('A68BC8927D5848C9BE7AB84B89B458CB', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterial/deleting', 'GET', '{"ids":""}', '素材-根据多个id删除记录', '2017-08-11 16:26:52', '2017-08-11 16:26:50'),
	('A6F77C97FBB24F26BF0301FF4C3411B9', '2260', '/dpbarcode/deleting', 'GET', '{"ids":"1,2"}', '根据多个id删除记录--条码', '2017-07-26 17:35:23', NULL),
	('A7C6F4C6642D4ECB86E524A0FE8BFD06', '2250', '/dpformtype/deleting', 'GET', '{"ids":"1"}', '根据多个id删除记录--表单类型', '2017-07-27 09:11:33', NULL),
	('A7F123A96CCB4AE2A5D2CE7047F34954', '1430', '/pdbomproduce/getMaterialAmount', 'GET', '{\n"bomId":"C8AF3AE04DAC48CF80F824B9A54C76C8",\n"code":"802301270"\n}', '查询bom下物料不同版本数量等信息列表', '2017-07-24 18:05:27', NULL),
	('A80E997158924014B0DC75FC22F54367', '2310', '/dpservice/deleting', 'GET', '{"id":"10"}', '根据多个id删除记录', '2017-07-26 10:19:54', NULL),
	('A81339FBE4F34347931E0CAE58AA91F4', '2310', '/dpservicetype/byAll', 'GET', '', '查询所有记录', '2017-07-26 13:48:41', NULL),
	('A87C108B5E16463DA3C0833299AB9B08', '1460', '/pdworkorder/getDevices/byWorkOrder', 'GET', '{\n"workOrderId":"77AD75A7D5FA4C5D99EF1ED3E2C45F0D"\n}', '根据工单id查询对应的设备列表', '2017-07-25 17:54:19', NULL),
	('AA183B68F1C34CF396F7012E02758FDF', '2410', '/dpfunction/creating', 'POST', '{\n  "functionTypeId": "string",\n  "templateParameterContent": "string",\n  "templateResultContent": "string",\n  "script": "string",\n  "filePath": "string",\n  "jarName": "string",\n  "description": "string"\n}', '新建一个脚本管理', '2017-07-26 09:50:24', NULL),
	('AA32B17FB31A4E649B62C8E968C7496C', '1430', '/pdbomproduce/getMaterialTree', 'GET', '{\n    "bomId":"C8AF3AE04DAC48CF80F824B9A54C76C8"\n}', '根据bom id查询bom物料清单树', '2017-07-24 17:59:50', '2017-07-24 18:00:20'),
	('AA75BDAC5EAA4CFC9BAC08ED7E21C020', '2250', '/dpformtype/creating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "pdId": "1",\n  "pdName": "test",\n  "name": "生产表单"\n}', '新建记录--表单类型', '2017-07-27 09:10:39', NULL),
	('AB61F533EC2047BC97D642BA6001108F', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplatetype/creating', 'POST', '{\n \n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "条码模板111"\n}', '模板分类-新建记录', '2017-08-08 16:14:47', NULL),
	('AC91F32CF56F4C2D968A3FC9B52747A8', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplate/byPage', '', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"search":"产品"},\n  "rows": [\n    {}\n  ]\n}', '模板-根据条件分页查询（模糊查询）', '2017-08-08 16:10:20', '2017-08-08 16:10:22'),
	('AD2DFF7604C447CC994D9A53C737B827', '2250', '/dpform/byAll', 'GET', '', '查询所有记录--表单', '2017-07-27 09:14:57', '2017-07-27 09:15:22'),
	('AE08E3E2056E4B7894B64B1394EDA90B', '1350', '/ftydevicetype/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:19:34', NULL),
	('AE2E2950F79A489EB84348B626A04F02', '2220', '/dpproject/byCondition', 'POST', '{ "pdId":"1"}', '根据产品查询所有开发工程', '2017-07-26 16:34:45', '2017-07-26 16:35:11'),
	('AED50EEE75FF4816A6A71ED5C5E8C0E3', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/byCondition', 'POST', '{ "processId": "3"}', '获取当前工序所有的扩展属性', '2017-08-07 11:33:11', NULL),
	('B2A6AB1565454DD3A9DD54F90E34277E', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterialtype/byPage', 'POST', '{\n  "pageSize":10,\n  "pageNum":1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {},\n  "rows": [\n    {}\n  ]\n}', '素材分类-根据条件分页查询记录', '2017-08-11 16:18:25', '2017-08-11 16:18:22'),
	('B620176515414ED8AEB6315F2F1CC676', '2320', '/dpservicelog/1', 'GET', '{"id":"1"}', '根据id查询记录', '2017-07-27 16:35:48', '2017-07-27 16:36:12'),
	('B671CD35F39C42D18B06C760ADB1F638', '1320', '/ftyarea/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:04', NULL),
	('B6E2741E001C4DFC8F379EE3CF1A936E', '1330', '/ftyworkcenter/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:13:05', NULL),
	('B7B354DE7F044735B420B8846D249E45', '2220', '/dpproject/saveProduceProcess', 'POST', '{ "pdLineId": "1", "pdId": "1", "processId": "1", "projectId": "1", "formTypeId": "1", "formId": "1", "isAuto": "1", "isBomMaterials": "1", "bomProduceId": "1"}', '添加新工序', '2017-07-27 15:53:58', '2017-07-27 15:54:22'),
	('B87E5052E20E41B682F67C4124724519', '1210', '/dept/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:19:34', NULL),
	('B8C610760A45475FB82C55BDAB5C5019', '2310', '/dpservicetype/updating', 'POST', '{\n  "id": "4",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "parentId": "1",\n  "name": "测试结果回传"\n}', '更新记录', '2017-07-26 13:50:28', NULL),
	('B9256F76F1084B689C8328C4C7E56046', '2410', '/dpfunctiontype/creating', 'POST', '{\n  "id": "string",\n  "parentId": "string",\n  "name": "string",\n  "type": "string"\n}', '新建函数分类', '2017-07-26 09:46:09', NULL),
	('B94F3B06FB3945198D0FEDF6108599A8', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassemblytype/deleting', 'GET', '{"ids":""}', '组件分类-根据多个id删除记录', '2017-08-11 17:01:55', NULL),
	('BA2C48793A26424CA728F8E7A24F33E7', '2250', '/dpform/byCondition', 'POST', '{\n  "name": "生产表单1"\n}', '根据条件查询记录--表单', '2017-07-27 09:14:52', '2017-07-27 09:15:17'),
	('BA8CE962F2F94F0A8F5FD0B43CD9CB5F', '1330', '/ftyworkstation/creating', 'POST', '{"name":"低温测试工作站"}', '工作站--新建记录', '2017-07-31 17:59:07', '2017-07-31 17:59:24'),
	('BAE17D29363E4936B16F4C77E705CEFD', '1210', '/userprocess/creating', 'POST', '{\n\n  "userId": "CE56452BB1F347588EF80BBBD25CB878",\n  "processId": "2F19C322F1E14D99AD87557217929AC5"\n}', '配置用户的技能', '2017-08-01 14:58:30', NULL),
	('BC246093CAA6415B886110D2C6A1428C', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/deleting', 'GET', '{"ids":"1,2"}', '根据多个id删除记录', '2017-07-24 17:55:25', '2017-07-24 17:53:43'),
	('BC8E0DB57B32445A8C7C03F283EFCA3E', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/byCondition', 'POST', '{"name":"1"}', '根据条件查询记录', '2017-07-24 16:56:33', '2017-07-24 16:54:51'),
	('BD0FC0365600413E94C0503A9CFA77C2', '1230', '/usergroup/1', 'GET', '', '根据id查询记录', '2017-07-20 20:43:19', '2017-07-20 20:43:56'),
	('BE2DA81E45F34F0EBBF6A682601E3305', '2210', ' /dpproject/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"pdLineId":"1"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录', '2017-07-27 16:28:55', '2017-07-27 16:29:20'),
	('BE313B7EA6E449698DEAB174C6FF93C8', '1360', '/ftydeviceannex/updating', 'POST', '{\n  "id": "7",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "update"\n}', '附件分类--更新记录', '2017-07-31 16:48:17', '2017-07-31 16:48:34'),
	('BEBF803405C14D9D9DF1BC4E6699A78A', '1450', '/pdbomproducerules/byPage/pd', 'POST', '{"pageSize":10,"pageNum":1,"condition":{"pdId":"1","search":""}}', '根据产品分页查询bom校验规则列表', '2017-07-26 14:06:39', NULL),
	('C05CE4890E4245C5B4AAD241B64C8BE4', '2260', '/dpbarcodetype/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n \n  "name": "产品条码",\n  "description": "产品的条码"\n}', '更新记录--条码类型', '2017-07-26 17:28:03', NULL),
	('C0E010C8428C4C49912D0D29AD7C0BA2', '1330', '/ftydevice/updating', 'POST', '{\n  "id": "string",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "string",\n  "ip": "string",\n  "location": "string",\n  "description": "string",\n  "capacity": 0,\n  "priority": 0,\n  "category": "string",\n  "assetCode": "string",\n  "snNum": "string",\n  "areaId": "string",\n  "deviceTypeId": "string"\n}', '设备--更新记录', '2017-07-31 18:16:34', NULL),
	('C139299227F2422885839B724949DAD6', '2220', '/dpproduceprocess/updating', 'POST', '{ "id": "477C81F8D7FD407EA82E476D91A5417A", "pdLineId": "1", "pdId": "1", "processId": "1", "projectId": "1", "formTypeId": "1", "formId": "1", "isAuto": "0", "isBomMaterials": "1", "bomProduceId": "2"}', '更新工序配置', '2017-07-27 15:53:47', '2017-07-27 15:54:12'),
	('C230EA78E3CB4A07AAAE511EBEF64E06', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/6', 'GET', '', '配置属性根据id查询', '2017-07-28 17:57:29', NULL),
	('C3B76D7430214D5492F71BB04B574102', '1230', '/usergroup/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:43:02', '2017-07-20 20:43:39'),
	('C3C3E946B69945149E0253CF290598C7', '1210', '/dept/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:19:34', NULL),
	('C4B9964DE2B042A4AF60466E8A7B2652', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', '/pdfileresources/getResourceFileMaterials', 'GET', '{"resourceFileId":"2"}', '根据资源文件id查询已关联的物料列表', '2017-07-31 15:18:38', NULL),
	('C63E9841ABA94074AF2B618A5C40F878', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplate/updating', 'POST', '{\n  "id": "4",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "模板4",\n  "fileName": "模板4.excel",\n \n  "path": "1.1.1.2"\n}', '模板-更新记录', '2017-08-08 16:10:38', '2017-08-08 16:10:41'),
	('C7F04325AA8A43A686B863FB87E9957E', '2260', '/dpbarcode/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {\n  "pdId": "1",\n  "typeId": "1"  \n},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--条码', '2017-07-26 18:03:55', NULL),
	('C9782D8DC9294D678AF95D5416224405', '2260', '/dpbarcode/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "pdId": "1",\n  "typeId": "1",\n  "name": "T-Box产品条码",\n  "description": "T-Box的产品条码",\n  "processId": "1BC6573D4FB34FCC89B2AE17E89EA73D",\n  "ruleId": "1"\n}', '更新记录--条码', '2017-07-26 17:37:00', '2017-07-26 17:37:27'),
	('CA4B1C15193E47C4A60B0B1C61F48202', '1310', '/ftyenterprise/1', 'GET', '', '根据id查询记录', '2017-07-20 20:13:04', NULL),
	('CABC8997F8EC4387889981025D83AFF1', '2250', '/dpform/updating', 'POST', '{\n  "id": "6",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n \n  "name": "设备类型",\n  "formTypeId": "2",\n  "url": "192.168.2.3",\n  "content": "设备类型内容",\n  "description": "测试表单"\n}', '更新记录--表单', '2017-07-27 09:14:33', '2017-07-27 09:14:58'),
	('CAC95E8B86184B81930DDE65A10A0E54', '1380', '/ftydevicefault/creating', 'POST', '{\n  "deviceId": "4",\n  "isRun": "0",\n  "deviceFaultInfoId": "E7528BC6D2DD4396846C26A9216ABB0E",\n  "email": "dengyn@hirain.com",\n  "status": "0",\n  "description": "添加测试",\n  "maintenancePersion": "乐登云",\n  "maintenancePhone": "1891078787",\n  "operator": "周博"\n}', '新建记录', '2017-07-31 14:41:26', NULL),
	('CC4D3410CE7A491DAC6ED62A20B3A705', '1330', '/ftyworkstation/updating', 'POST', '{\n  "id": "1",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "AOI工作站",\n  "workCenterId": "2",\n  "location": "工厂Z区",\n  "description": "AOI测试工作站",\n  "category": "1",\n  "deviceId": "3",\n  "workCenterName": "2"\n}', '工作站--修改记录', '2017-07-31 18:04:10', NULL),
	('CC6649BD5AC54BB684A02689E0F6EF57', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplate/{id}', 'GET', '{"ids":"1,2"}', '模板-根据id删除记录', '2017-08-08 16:10:30', '2017-08-08 16:10:33'),
	('CDA8EC8689174A20B8FFE7E5B4AA2584', '2230', '/pdline/getPdLineTree', 'GET', '', '获取产品线及对应产品列表树形结构数据', '2017-07-27 10:20:45', NULL),
	('CE4D2F35AB7D4715B03EDF61DFB6121C', '2500', '/metadata/findByTableId', 'GET', '', '查询字段信息', '2017-08-14 15:39:21', NULL),
	('CEBE90BC97534390885C0574C08DA9C0', '1360', '/ftydeviceannex/deleting', 'GET', '{"ids":"8,9"}', '附件分类--根据多个id删除记录', '2017-07-31 16:48:39', '2017-07-31 16:48:57'),
	('D0091AA391A24CF7B624EB64FDA8C607', '1350', '/ftydevicetype/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:19:34', NULL),
	('D078798178444C81B6BCFCEC3BCCDB37', '2230', '/pdworkorder/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "condition": {"routesId":"1","search":""}\n}', '根据工艺路径分页查询工单列表', '2017-07-27 14:11:18', NULL),
	('D09852E884E44396B91DCA9E2838344D', '66C60EAA43DD4A50A58B96BB43F99EFC', '/dpsubassembly/updating', 'POST', '{\n  "id": "62F9FF755F7443EFB3963ED77C9A529B",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "组件4",\n  "fileName": "组件4.jar",\n  "path": "//10.10.1.119"\n}', '组件管理-更新记录', '2017-08-11 16:36:19', NULL),
	('D1DDEA81032B490797B58AEFC8A63E05', '2210', '/dpproject/creating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "expandMap": {\n    "additionalProp1": {},\n    "additionalProp2": {},\n    "additionalProp3": {}\n  },\n  "pdLineId": "2",\n  "pdId": "2",\n  "name": "一汽大灯转向控制器开发工艺",\n  "version": "3.0",\n  "isEnabled": 1,\n  "isRelease": 0,\n  "releaseTime": "2017-07-27 07:39:59.329",\n  "enabledTime": "2017-07-27 07:39:59.329"\n}', '新建记录', '2017-07-27 16:29:12', NULL),
	('D229DF634C8E4779BCA27EB8FFD21A60', 'A7D770F506564850B3B930381B0A5AD6', '/dplabel/byAll', 'GET', '', '查询所有记录--标签', '2017-07-27 14:32:14', NULL),
	('D295CEF36F1548DC9735BE551025FF54', '1210', '/dept/creating', 'POST', '{"name":"test"}', '新建记录', '2017-07-20 20:19:33', NULL),
	('D2D778278E09454FA050ED7673DBCBC1', '2250', '/dpform/1', 'GET', '{"id":"1"}', '根据id查询记录--表单', '2017-07-27 09:14:04', '2017-07-27 09:14:29'),
	('D4C7A57ABAA24DE7B5DCE5F512A2603B', '2320', '/dpservicelog/updating', 'POST', '{\n  "id": "4",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "expandMap": {\n    "additionalProp1": {},\n    "additionalProp2": {},\n    "additionalProp3": {}\n  },\n  "serviceId": "3",\n  "status": "0",\n  "invokeTime": "13s",\n  "timeTaken": "2s"\n}', '更新记录', '2017-07-26 17:23:33', NULL),
	('D55E6CDF014B47E6BD3B40C7B54A4A68', 'EF471C3E94BE47D68E1DB4DABBF30DE6', ' /dptemplatetype/byPage', '', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {},\n  "rows": [\n    {}\n  ]\n}', '模板分类-根据条件分页查询', '2017-08-08 16:11:07', '2017-08-08 16:11:10'),
	('D683250232774724BF5E82B1A62E4052', 'B5F31868538C4546AD0871DF8907F19F', '/pdschedulingtype/byAll', 'GET', '', '查询所有记录', '2017-07-24 16:45:06', NULL),
	('D76C3AF2A0314824A863B8DD435F7379', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessconfig/creating', 'POST', '{\n  "id": "7",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "processId": "3",\n  "cnName": "激光打印速度配置",\n  "key": "speed_1",\n  "type": "string",\n  "description": "激光打印速度"\n}', '配置属性新建记录', '2017-07-28 17:53:47', NULL),
	('D7C0B77DDCF84FE4AF578339AD449F8E', '892D6DE1B3B948F8A38503FED0C02849', '/pdscheduling/saveScheduling', 'POST', '{\n  "id": "",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "schedulingTypeId": "1",\n  "schedulingTypeName": "1",\n  "isStart": "0",\n  "pdId": "1",\n  "pdName": "1",\n  "userGroupId": "1",\n  "userIds": "1,2",\n  "userNames": "1",\n  "groupName": "1",\n  "enterpriseId": "1",\n  "siteId": "1",\n  "areaId": "1",\n  "productionLineId": "1",\n  "workCenterId": "1",\n  "workstationIds": "1,2",\n  "enterpriseName": "1",\n  "siteName": "1",\n  "areaName": "1",\n  "productionLineName": "1",\n  "workCenterName": "1",\n  "workstationNames": "1"\n}', '新建记录', '2017-08-02 13:40:42', '2017-08-02 13:40:56'),
	('DB53DF32F1FC49A2B4526CFAF98F67ED', '1220', '/role/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:03', NULL),
	('DCE1E714988B4745A6942DEBDD88D86D', '2260', '/dpbarcodetype/deleting', 'GET', '{"ids":"1"}', '根据多个id删除记录--条码类型', '2017-07-26 17:26:06', NULL),
	('DD15E6214DAD4738B5E3996D45265A5A', 'F00ED7D6AD764406AA8D99ECEBB99061', '/pdfiletype/creating', 'POST', '{ "name": "string", "type": "string" }', '新建文件分类', '2017-07-26 09:16:50', '2017-07-26 09:17:17'),
	('DE305E099600483894F4710B4369E384', 'F00ED7D6AD764406AA8D99ECEBB99061', '/pdfiletype/updating', '', '{\n  "id": "string",\n  "name": "string",\n}', '文件分类编辑', '2017-07-26 09:22:57', NULL),
	('E0EC6A95FA7540DDBE1A480719D1E358', 'D3CE42E78F6D4BFE9BF62D4744CF61A7', ' /pdfileresources/uploadPdFileResource', 'POST', '', ' 资源管理文件上传', '2017-07-26 09:20:19', NULL),
	('E22D115931554643B2828A7AF2463016', '1240', '/menu/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '根据条件分页查询记录', '2017-07-20 20:13:04', NULL),
	('E2AD672DA7724541B6920A96C27F8A02', '1460', '/pdworkorder/byPage', 'POST', '{ "pageSize": 10, "pageNum": 1, "condition": {"orderId":"1E28C0DE0F3A44D1823D6BED6A560FB7","search":""}}', '根据订单分页查询工单', '2017-07-25 15:10:15', NULL),
	('E2EE9548E97B47DB8E1749F8B3DCA960', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/deleting', 'GET', '{"ids":"6"}', '工序基础配置根据ID删除', '2017-07-28 17:46:05', '2017-07-28 17:46:27'),
	('E47FB330DE5D4FE7A3978A2E82B9FF48', '1330', '/ftyworkcenter/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:05', NULL),
	('E4E587C87024427E99AE3CEE8EC738AA', 'A7D770F506564850B3B930381B0A5AD6', '/dplabeltype/creating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  \n  "name": "产品标签",\n  "description": "产品标签"\n}', '新建记录--标签类型', '2017-07-27 14:17:13', NULL),
	('E70694F7624D450D8C9AAD599763E460', '1340', '/ftyworkcenter/updating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "string",\n  "productionLineId": "string",\n  "location": "string",\n  "description": "string",\n  "category": "string",\n  "capacity": 0,\n  "priority": 0\n}', '工作中心--修改记录', '2017-07-31 17:55:26', NULL),
	('E759A6B51C9548A589A9765D41FCE33A', '1360', '/ftydeviceannexinfo/deleting', 'GET', '{"ids":"12"}', '附件详细信息--根据多个id删除记录', '2017-07-31 16:51:39', '2017-07-31 16:51:57'),
	('E7757E2A84F8434F839172B64B349555', '1310', '/ftyarea/byPage', 'POST', '{"pageSize": 10,"pageNum": 1,"condition": {}}', '车间信息查询-根据条件分页查询车间信息', '2017-07-31 17:03:13', '2017-07-31 17:03:30'),
	('E87AD88F0234453997F097F4559D1278', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/creating', 'POST', '{\n  "id": "5",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "processId": "4",\n  "dataDictionaryTypeId": "3",\n  "dataDictionaryId": "2",\n  "formTypeId": "1",\n  "formId": "Frm_VISUAL_TEST"\n}', '工序基础配置新建', '2017-07-28 17:43:27', '2017-07-28 17:43:50'),
	('E8DF7D585EC940DFAB812060F20F2AE9', '1440', '/pdbommaterialsreplace/creating', 'POST', '{ "bomWorkAmountId": "009157A3A5334547BF909687A9C7CA29", "bomMaterialsId": "CA35E7C230A14B5A9101E2A8CF5DA904"}', '工单bom添加替换料', '2017-07-31 14:12:33', NULL),
	('E95FB67934D648D8A40974EB2167B2B3', '1340', '/ftyproductionline/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:05', NULL),
	('E9F6262CADFF449B85AB47A4D7CE85A9', '2500', '/table/updating', 'POST', '{\n  "id": "string",\n  "name": "string",\n  "entityClass": "string",\n  "type": "string",\n  "tableTypeId": "string",\n  "isInternal": "string"\n}', '编辑表信息', '2017-07-26 09:38:15', NULL),
	('EA12FFCB1392427FA800470F5512DF75', '1310', '/ftyenterprise/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:04', NULL),
	('EC46DF2C768645C5A8C9B84264C261B5', '2610', '/dpdatadictionarytype/updating', 'POST', '{\n  "id": "string",\n  "name": "string"\n}', '数据字典类型编辑', '2017-07-26 14:27:16', '2017-07-26 14:27:43'),
	('EC90DE11F7E44C63BCAB5AB9C1343725', '1240', '/menu/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:04', NULL),
	('F062079ED6C943A98AF4CEF0753DF360', '2420', '/dpfunction/uploadFile', 'POST', '{"funtionTypeId"："string",\n"name":"string",\n"description":"string",\n"file":""}', 'jar包上传', '2017-07-28 11:46:56', '2017-07-28 11:47:20'),
	('F19E84EE253E4986B529D7A77596B860', '1310', '/ftyenterprise/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:13:04', NULL),
	('F1E48858C8AA4CAEB48FD3C20E20DCDC', '892D6DE1B3B948F8A38503FED0C02849', '/pdschedulingpersonnel/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"schedulingId":"E38B6B334E4A497C8C34DE4107B1C6B0"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录--班次--人员', '2017-07-31 18:42:34', '2017-07-31 18:42:52'),
	('F2E59E3113F84F83A2EF216F2CAD511F', 'D6A4CE63A1D14947871DEA616EAD30D9', '/dpprocessbaseconfig/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {\n "processId":"3"\n},\n  "rows": [\n    {}\n  ]\n}', '工序基础配置根据条件分页查询', '2017-08-02 16:07:51', '2017-08-02 16:08:04'),
	('F336318B817147CC9636D69AEC563EF0', '2320', '/dpservicelog/byPage', 'POST', '{\n  "pageSize": 10,\n  "pageNum": 1,\n  "total": 0,\n  "totalPageNum": 0,\n  "startRowNum": 0,\n  "pageNumber": 0,\n  "endRowNum": 0,\n  "orderBy": "string",\n  "desc": "string",\n  "condition": {"serviceId":"1"},\n  "rows": [\n    {}\n  ]\n}', '根据条件分页查询记录', '2017-07-26 17:05:31', '2017-07-26 17:05:57'),
	('F612F00F74224636A0947BCA68E42355', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterial/creating', 'POST', '{\n \n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "素材文件1",\n  "fileName": "素材1.doc",\n  "path": "//192.168.1.1"\n}', '素材-新建记录', '2017-08-11 16:27:05', '2017-08-11 16:27:02'),
	('F6613B569299445FAF8A8078FF26C605', '1220', '/role/deleting', 'GET', '{"ids":"1,2,3"}', '根据多个id删除记录', '2017-07-20 20:13:03', NULL),
	('F6A00EB883DC4543AAAE98B814BE4D2C', '1230', '/usergroup/byCondition', 'POST', '{"username":"admin"}', '根据条件查询记录', '2017-07-20 20:43:46', '2017-07-20 20:44:23'),
	('F6C33E89685E409497398ECDB46BB6BE', '2500', '/metadata/saveFieldList', 'POST', '{\n  "tableId": "string",\n  "columnList": [{\n      "name": "string",\n      "column": "string",\n      "type": "string",\n      "length": "string",\n      "isNull": "string",\n      "isPk": "string",\n      "defaultValue": "string",\n      "tableId": "string"\n    }\n  ]\n}', ' 字段信息保存', '2017-08-11 17:39:36', '2017-08-11 17:39:34'),
	('FA019A4996684BDEBE96F2BD4EE740C2', '1350', '/ftydevice/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:05', NULL),
	('FAAEA30784CE4BD0A2142DBC33397C9C', '2500', '/expandtableconfig/saveExpandField', 'POST', '{\n  "tableId": "string",\n  "columnList": [\n    {\n      "id": "string",\n      "createDate": "2016-08-01 12:24:36",\n      "updateDate": "2016-08-01 12:24:36",\n      "expandMap": {\n        "additionalProp1": {},\n        "additionalProp2": {},\n        "additionalProp3": {}\n      },\n      "name": "string",\n      "column": "string",\n      "type": "string",\n      "length": "string",\n      "isNull": "string",\n      "isPk": "string",\n      "defaultValue": "string",\n      "tableId": "string"\n    }\n  ]\n}', '扩展对象添加', '2017-07-28 16:51:30', NULL),
	('FB21784CAFC04C6294F2BAEBC7328A2E', 'A4B1E9742E994FEA933F66374CC73AEC', '/dpmaterialtype/updating', 'POST', '{\n  "id": "1",\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "更新素材",\n  "description": "string"\n}', '素材分类-更新记录', '2017-08-11 16:18:38', '2017-08-11 16:18:35'),
	('FC655750712C4C0BAC78C90FABAD5714', 'EF471C3E94BE47D68E1DB4DABBF30DE6', '/dptemplate/creating', 'POST', '{\n  "createDate": "2016-08-01 12:24:36",\n  "updateDate": "2016-08-01 12:24:36",\n  "name": "标签模板",\n  "fileName": "标签模板.txt",\n  "path": "//2.2.2.2"\n}', '模板-新建记录', '2017-08-08 16:09:56', '2017-08-08 16:09:59'),
	('FCC3BFDF0003421F8042E404ED3B142A', '1380', '/ftydevicefault/updating', 'POST', '{\n  "id": "412A03D83E214DACB10EA7594D6A4254",\n  "maintenancePersion": "上大家是开",\n  "maintenancePhone": "1191090",\n  "operator": "看手机肯定就"\n}', '更新记录', '2017-07-31 14:43:21', NULL),
	('FD151C9001824748937FCF849A5798F6', '1220', '/role/byAll', 'GET', '', '查询所有记录', '2017-07-20 20:13:03', NULL),
	('FFC8EBCF4E4040709B6B7D8A311CC128', '1340', '/ftyworkcenter/creating', 'POST', '{"name":"ICT检验工作中心"}', '工作中心--新建记录', '2017-07-31 17:52:34', '2017-07-31 17:52:51'),
	('H499B6CD8A49E4C1695BC093CFB38A537', '1210', '/user/validate', 'GET', '', '用户Session验证', '2017-08-29 10:10:12', NULL),
	('H57BE437B3B244341887ED5682AB3CC04', '1250', '/menu/updateSort', 'POST', '[\n  {\n    "id": "3100",\n    "itemOrder": 2\n  },{\n    "id": "3200",\n    "itemOrder": 1\n  }\n]', '更新菜单排序', '2017-08-28 09:24:45', NULL),
	('HCFCE2ADD846B45198BA5EE8127F18083', '1210', '/user/logout', 'GET', '', '用户登出', '2017-08-29 10:09:35', NULL);
/*!40000 ALTER TABLE `mes_menu_rest_api` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_metadata 结构
DROP TABLE IF EXISTS `mes_metadata`;
CREATE TABLE IF NOT EXISTS `mes_metadata` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '中文名',
  `column` varchar(50) DEFAULT NULL COMMENT '英文名',
  `type` varchar(50) DEFAULT NULL,
  `length` varchar(50) DEFAULT NULL,
  `is_null` varchar(50) DEFAULT NULL,
  `is_pk` varchar(50) DEFAULT NULL,
  `default_value` varchar(50) DEFAULT NULL,
  `table_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_metadata 的数据：~0 rows (大约)
DELETE FROM `mes_metadata`;
/*!40000 ALTER TABLE `mes_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_metadata` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd 结构
DROP TABLE IF EXISTS `mes_pd`;
CREATE TABLE IF NOT EXISTS `mes_pd` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `pd_line_id` varchar(50) DEFAULT NULL COMMENT '产品线ID',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-产品';

-- 正在导出表  mes_db_test.mes_pd 的数据：~0 rows (大约)
DELETE FROM `mes_pd`;
/*!40000 ALTER TABLE `mes_pd` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_attribute 结构
DROP TABLE IF EXISTS `mes_pd_attribute`;
CREATE TABLE IF NOT EXISTS `mes_pd_attribute` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `key` varchar(50) DEFAULT NULL,
  `pd_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_attribute 的数据：~0 rows (大约)
DELETE FROM `mes_pd_attribute`;
-- com组件接口使用
insert into `mes_pd_attribute` (`id`, `name`, `key`, `pd_id`, `create_date`) values('H841AE26A606C48569CAB62D1E4DE4CE8','产品零件号','pl_client_number','H03CD9FCAF8384456A8AB94E5C8349B72','2017-09-11 11:16:40');
-- com组件接口使用
insert into `mes_pd_attribute` (`id`, `name`, `key`, `pd_id`, `create_date`) values('HA74D55CF784D4F44BAA653254289D0A7','实现方式','implement_mode','H03CD9FCAF8384456A8AB94E5C8349B72','2017-09-07 15:33:27');
/*!40000 ALTER TABLE `mes_pd_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_attribute` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_barcode_rule 结构
DROP TABLE IF EXISTS `mes_pd_barcode_rule`;
CREATE TABLE IF NOT EXISTS `mes_pd_barcode_rule` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `barcode_rule_type_id` varchar(50) DEFAULT NULL,
  `function_type_id` varchar(50) DEFAULT NULL,
  `function_id` varchar(50) DEFAULT NULL,
  `description` longtext COMMENT '描述',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-条码规则设置';

-- 正在导出表  mes_db_test.mes_pd_barcode_rule 的数据：~0 rows (大约)
DELETE FROM `mes_pd_barcode_rule`;
/*!40000 ALTER TABLE `mes_pd_barcode_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_barcode_rule` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_barcode_rule_type 结构
DROP TABLE IF EXISTS `mes_pd_barcode_rule_type`;
CREATE TABLE IF NOT EXISTS `mes_pd_barcode_rule_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_barcode_rule_type 的数据：~0 rows (大约)
DELETE FROM `mes_pd_barcode_rule_type`;
/*!40000 ALTER TABLE `mes_pd_barcode_rule_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_barcode_rule_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_affiliated 结构
DROP TABLE IF EXISTS `mes_pd_bom_affiliated`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_affiliated` (
  `id` varchar(50) NOT NULL,
  `attribute_id` varchar(50) DEFAULT NULL,
  `value` varchar(50) DEFAULT NULL,
  `bom_produce_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_bom_affiliated 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_affiliated`;
/*!40000 ALTER TABLE `mes_pd_bom_affiliated` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_affiliated` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_materials 结构
DROP TABLE IF EXISTS `mes_pd_bom_materials`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_materials` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `in_veraion` varchar(50) DEFAULT NULL COMMENT '物料内部版本',
  `out_veaion` varchar(50) DEFAULT NULL COMMENT '物料客户版本',
  `type` varchar(50) DEFAULT NULL COMMENT '物料类型（0软件）',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-物料清单';

-- 正在导出表  mes_db_test.mes_pd_bom_materials 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_materials`;
/*!40000 ALTER TABLE `mes_pd_bom_materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_materials` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_materials_replace 结构
DROP TABLE IF EXISTS `mes_pd_bom_materials_replace`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_materials_replace` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `bom_work_amount_id` varchar(50) DEFAULT NULL COMMENT '主料ID',
  `bom_materials_id` varchar(50) DEFAULT NULL COMMENT '物料ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-BOM替换料';

-- 正在导出表  mes_db_test.mes_pd_bom_materials_replace 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_materials_replace`;
/*!40000 ALTER TABLE `mes_pd_bom_materials_replace` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_materials_replace` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_produce 结构
DROP TABLE IF EXISTS `mes_pd_bom_produce`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_produce` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `version` varchar(50) DEFAULT NULL COMMENT '版本',
  `status` varchar(50) DEFAULT NULL COMMENT 'BOM状态（审核通过，未通过）',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `pd_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `type` varchar(50) DEFAULT NULL COMMENT '物料类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `file_path` varchar(256) DEFAULT NULL COMMENT 'bom文件路径',
  `name` varchar(128) DEFAULT NULL,
  `fn_id` varchar(50) DEFAULT NULL COMMENT '解析bom的函数id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-生产BOM管理';

-- 正在导出表  mes_db_test.mes_pd_bom_produce 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_produce`;
/*!40000 ALTER TABLE `mes_pd_bom_produce` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_produce` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_produce_amount 结构
DROP TABLE IF EXISTS `mes_pd_bom_produce_amount`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_produce_amount` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父ID',
  `amount_num` varchar(50) DEFAULT NULL COMMENT '用量',
  `attrition_rate` varchar(50) DEFAULT NULL COMMENT '损耗率',
  `materials_id` varchar(50) DEFAULT NULL COMMENT '物料清单ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `bom_produce_id` varchar(50) DEFAULT NULL COMMENT 'BOM_ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-生产BOM管理用量';

-- 正在导出表  mes_db_test.mes_pd_bom_produce_amount 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_produce_amount`;
/*!40000 ALTER TABLE `mes_pd_bom_produce_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_produce_amount` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_produce_rules 结构
DROP TABLE IF EXISTS `mes_pd_bom_produce_rules`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_produce_rules` (
  `id` varchar(50) NOT NULL,
  `name` varchar(256) DEFAULT NULL COMMENT '规则名称',
  `bom_id` varchar(50) DEFAULT NULL COMMENT 'bom id',
  `rule_regex` varchar(512) DEFAULT NULL COMMENT '校验规则正则表达式',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_bom_produce_rules 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_produce_rules`;
/*!40000 ALTER TABLE `mes_pd_bom_produce_rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_produce_rules` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_work 结构
DROP TABLE IF EXISTS `mes_pd_bom_work`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_work` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `version` varchar(50) DEFAULT NULL COMMENT 'BOM版本',
  `status` varchar(50) DEFAULT NULL COMMENT 'BOM状态（审核通过，未通过）',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `pd_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `type` varchar(50) DEFAULT NULL COMMENT '物料类型',
  `bom_produce_id` varchar(50) DEFAULT NULL COMMENT '来源生产BOM_id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-工单BOM管理';

-- 正在导出表  mes_db_test.mes_pd_bom_work 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_work`;
/*!40000 ALTER TABLE `mes_pd_bom_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_work` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_bom_work_amount 结构
DROP TABLE IF EXISTS `mes_pd_bom_work_amount`;
CREATE TABLE IF NOT EXISTS `mes_pd_bom_work_amount` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父ID',
  `amount_num` varchar(50) DEFAULT NULL COMMENT '用量',
  `attrition_rate` varchar(50) DEFAULT NULL COMMENT '损耗率',
  `is_replace` varchar(50) DEFAULT NULL COMMENT '是否有替换料',
  `materials_id` varchar(50) DEFAULT NULL COMMENT '物料清单ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `bom_work_id` varchar(50) DEFAULT NULL COMMENT 'BOM_ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-工单BOM管理用量';

-- 正在导出表  mes_db_test.mes_pd_bom_work_amount 的数据：~0 rows (大约)
DELETE FROM `mes_pd_bom_work_amount`;
/*!40000 ALTER TABLE `mes_pd_bom_work_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_bom_work_amount` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_file_resources 结构
DROP TABLE IF EXISTS `mes_pd_file_resources`;
CREATE TABLE IF NOT EXISTS `mes_pd_file_resources` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `other_file_name` varchar(50) DEFAULT NULL COMMENT '文件别名',
  `file_path` varchar(1000) DEFAULT NULL COMMENT '文件路径',
  `file_type_id` varchar(50) DEFAULT NULL COMMENT '分类ID',
  `version` varchar(50) DEFAULT NULL COMMENT '版本',
  `code` varchar(50) DEFAULT NULL COMMENT 'erp编码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源文件管理';

-- 正在导出表  mes_db_test.mes_pd_file_resources 的数据：~0 rows (大约)
DELETE FROM `mes_pd_file_resources`;
/*!40000 ALTER TABLE `mes_pd_file_resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_file_resources` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_file_type 结构
DROP TABLE IF EXISTS `mes_pd_file_type`;
CREATE TABLE IF NOT EXISTS `mes_pd_file_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT NULL COMMENT 'type（资源文件:1，工艺文件:2）',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件分类管理';

-- 正在导出表  mes_db_test.mes_pd_file_type 的数据：~0 rows (大约)
DELETE FROM `mes_pd_file_type`;
/*!40000 ALTER TABLE `mes_pd_file_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_file_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_journal_number 结构
DROP TABLE IF EXISTS `mes_pd_journal_number`;
CREATE TABLE IF NOT EXISTS `mes_pd_journal_number` (
  `id` varchar(50) NOT NULL,
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单id',
  `total` bigint(20) DEFAULT NULL COMMENT '工单包含产品总数',
  `current` bigint(20) DEFAULT NULL COMMENT '当前流水号',
  `step` bigint(20) DEFAULT NULL COMMENT '流水号增长步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_journal_number 的数据：~0 rows (大约)
DELETE FROM `mes_pd_journal_number`;
/*!40000 ALTER TABLE `mes_pd_journal_number` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_journal_number` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_line 结构
DROP TABLE IF EXISTS `mes_pd_line`;
CREATE TABLE IF NOT EXISTS `mes_pd_line` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品线名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-产品线';

-- 正在导出表  mes_db_test.mes_pd_line 的数据：~0 rows (大约)
DELETE FROM `mes_pd_line`;
/*!40000 ALTER TABLE `mes_pd_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_line` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_material_resource_file 结构
DROP TABLE IF EXISTS `mes_pd_material_resource_file`;
CREATE TABLE IF NOT EXISTS `mes_pd_material_resource_file` (
  `material_id` varchar(50) DEFAULT NULL,
  `resource_file_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_material_resource_file 的数据：~0 rows (大约)
DELETE FROM `mes_pd_material_resource_file`;
/*!40000 ALTER TABLE `mes_pd_material_resource_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_material_resource_file` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_order 结构
DROP TABLE IF EXISTS `mes_pd_order`;
CREATE TABLE IF NOT EXISTS `mes_pd_order` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `order_num` varchar(50) DEFAULT NULL COMMENT '订单号',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品数据量',
  `customer` varchar(50) DEFAULT NULL COMMENT '客户',
  `name` varchar(200) DEFAULT NULL,
  `warehouse` varchar(50) DEFAULT NULL COMMENT '仓储',
  `delivery_time` datetime DEFAULT NULL COMMENT '交货时间',
  `status` varchar(50) DEFAULT NULL COMMENT '状态（未开始，生产中、完成）',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `start_time` datetime DEFAULT NULL COMMENT '生产计划开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '生产计划完工时间',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-产品订单管理';

-- 正在导出表  mes_db_test.mes_pd_order 的数据：~0 rows (大约)
DELETE FROM `mes_pd_order`;
/*!40000 ALTER TABLE `mes_pd_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_order` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info 结构
DROP TABLE IF EXISTS `mes_pd_product_info`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一条码',
  `pd_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `soft_version` varchar(500) DEFAULT NULL COMMENT '软件信息',
  `hard_version` varchar(50) DEFAULT NULL COMMENT '硬件版本',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '属所产品ID',
  `work_order_batch_num` varchar(50) DEFAULT NULL COMMENT '批次号',
  `pd_line_id` varchar(50) DEFAULT NULL,
  `instance_id` varchar(50) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '产品生产状态(0:已投产,1:正在生产,2:维修站,3:完成)',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品明细（按工单移）';

-- 正在导出表  mes_db_test.mes_pd_product_info 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info`;
/*!40000 ALTER TABLE `mes_pd_product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info_history 结构
DROP TABLE IF EXISTS `mes_pd_product_info_history`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info_history` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `pd_num` varchar(50) DEFAULT NULL COMMENT '产品唯一条码',
  `pd_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `soft_version` varchar(500) DEFAULT NULL COMMENT '软件信息',
  `hard_version` varchar(50) DEFAULT NULL COMMENT '硬件版本',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '属所产品ID',
  `work_order_batch_num` varchar(50) DEFAULT NULL COMMENT '批次号',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发平台-产品明细（按工单移）历史表';

-- 正在导出表  mes_db_test.mes_pd_product_info_history 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info_history`;
/*!40000 ALTER TABLE `mes_pd_product_info_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info_materials 结构
DROP TABLE IF EXISTS `mes_pd_product_info_materials`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info_materials` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `pd_bom_materials_id` varchar(50) DEFAULT NULL,
  `batch_num` varchar(50) DEFAULT NULL,
  `sn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_product_info_materials 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info_materials`;
/*!40000 ALTER TABLE `mes_pd_product_info_materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info_materials` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info_materials_history 结构
DROP TABLE IF EXISTS `mes_pd_product_info_materials_history`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info_materials_history` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `pd_bom_materials_id` varchar(50) DEFAULT NULL,
  `batch_num` varchar(50) DEFAULT NULL,
  `sn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_product_info_materials_history 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info_materials_history`;
/*!40000 ALTER TABLE `mes_pd_product_info_materials_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info_materials_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info_number 结构
DROP TABLE IF EXISTS `mes_pd_product_info_number`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info_number` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_product_info_number 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info_number`;
/*!40000 ALTER TABLE `mes_pd_product_info_number` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info_number` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_product_info_number_history 结构
DROP TABLE IF EXISTS `mes_pd_product_info_number_history`;
CREATE TABLE IF NOT EXISTS `mes_pd_product_info_number_history` (
  `id` varchar(50) NOT NULL,
  `pd_product_info_id` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_product_info_number_history 的数据：~0 rows (大约)
DELETE FROM `mes_pd_product_info_number_history`;
/*!40000 ALTER TABLE `mes_pd_product_info_number_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_product_info_number_history` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_scheduling 结构
DROP TABLE IF EXISTS `mes_pd_scheduling`;
CREATE TABLE IF NOT EXISTS `mes_pd_scheduling` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `scheduling_type_id` varchar(50) DEFAULT NULL COMMENT '班次类型ID',
  `is_start` varchar(50) DEFAULT NULL COMMENT '是否启动',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-排班-人员';

-- 正在导出表  mes_db_test.mes_pd_scheduling 的数据：~0 rows (大约)
DELETE FROM `mes_pd_scheduling`;
/*!40000 ALTER TABLE `mes_pd_scheduling` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_scheduling` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_scheduling_device 结构
DROP TABLE IF EXISTS `mes_pd_scheduling_device`;
CREATE TABLE IF NOT EXISTS `mes_pd_scheduling_device` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `enterprise_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  `area_id` varchar(50) DEFAULT NULL COMMENT '车间ID',
  `production_line_id` varchar(50) DEFAULT NULL COMMENT '生产线ID',
  `work_center_id` varchar(50) DEFAULT NULL COMMENT '工作中心ID',
  `workstation_id` varchar(50) DEFAULT NULL COMMENT '工作站id',
  `scheduling_id` varchar(50) DEFAULT NULL COMMENT '属所排班ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理--排班-设备';

-- 正在导出表  mes_db_test.mes_pd_scheduling_device 的数据：~0 rows (大约)
DELETE FROM `mes_pd_scheduling_device`;
/*!40000 ALTER TABLE `mes_pd_scheduling_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_scheduling_device` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_scheduling_personnel 结构
DROP TABLE IF EXISTS `mes_pd_scheduling_personnel`;
CREATE TABLE IF NOT EXISTS `mes_pd_scheduling_personnel` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `user_group_id` varchar(50) DEFAULT NULL COMMENT '用户组ID',
  `scheduling_id` varchar(50) DEFAULT NULL COMMENT '所属班次ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='排班管理-班次人员';

-- 正在导出表  mes_db_test.mes_pd_scheduling_personnel 的数据：~0 rows (大约)
DELETE FROM `mes_pd_scheduling_personnel`;
/*!40000 ALTER TABLE `mes_pd_scheduling_personnel` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_scheduling_personnel` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_scheduling_type 结构
DROP TABLE IF EXISTS `mes_pd_scheduling_type`;
CREATE TABLE IF NOT EXISTS `mes_pd_scheduling_type` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '班次类型名称（早、中、晚）',
  `start_time` time DEFAULT NULL COMMENT '班次开始时间',
  `end_time` time DEFAULT NULL COMMENT '班次结束时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-班次类型';

-- 正在导出表  mes_db_test.mes_pd_scheduling_type 的数据：~0 rows (大约)
DELETE FROM `mes_pd_scheduling_type`;
/*!40000 ALTER TABLE `mes_pd_scheduling_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_scheduling_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_scheduling_work_order 结构
DROP TABLE IF EXISTS `mes_pd_scheduling_work_order`;
CREATE TABLE IF NOT EXISTS `mes_pd_scheduling_work_order` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `scheduling_id` varchar(50) DEFAULT NULL COMMENT '班次人员',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-工单班次';

-- 正在导出表  mes_db_test.mes_pd_scheduling_work_order 的数据：~0 rows (大约)
DELETE FROM `mes_pd_scheduling_work_order`;
/*!40000 ALTER TABLE `mes_pd_scheduling_work_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_scheduling_work_order` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_trx_box 结构
DROP TABLE IF EXISTS `mes_pd_trx_box`;
CREATE TABLE IF NOT EXISTS `mes_pd_trx_box` (
  `id` varchar(50) NOT NULL,
  `box_id` varchar(50) DEFAULT NULL,
  `unit_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `lot_id` varchar(50) DEFAULT NULL,
  `promise_id` datetime DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_pd_trx_box 的数据：~0 rows (大约)
DELETE FROM `mes_pd_trx_box`;
/*!40000 ALTER TABLE `mes_pd_trx_box` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_trx_box` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_work_order 结构
DROP TABLE IF EXISTS `mes_pd_work_order`;
CREATE TABLE IF NOT EXISTS `mes_pd_work_order` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `pd_id` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父工单',
  `work_order_total` bigint(20) DEFAULT NULL COMMENT '开工单数量',
  `plan_start_time` datetime DEFAULT NULL COMMENT '工单计划开始时间',
  `plan_end_time` datetime DEFAULT NULL COMMENT '工单计划完结时间',
  `real_start_time` datetime DEFAULT NULL COMMENT '工单实际开始时间（手动）',
  `real_end_time` datetime DEFAULT NULL COMMENT '工单实际完结时间（手动）',
  `status` varchar(50) DEFAULT NULL COMMENT '工单状态（未启动、正在生产、完结）',
  `barcode_rules_id` varchar(50) DEFAULT NULL COMMENT '批次规则ID（选择条码规则）',
  `bom_work_id` varchar(50) DEFAULT NULL COMMENT 'BOM_ID',
  `work_order_rules_id` varchar(50) DEFAULT NULL COMMENT '工单号(生产规则ID)',
  `work_order_num` varchar(50) DEFAULT NULL COMMENT '工单号',
  `project_id` varchar(50) DEFAULT NULL COMMENT '工艺路径ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `trace_code_rules_id` varchar(50) DEFAULT NULL COMMENT '追溯码规则ID（选择条码规则）',
  `num` bigint(8) DEFAULT NULL,
  `barcode_rules_type_id` varchar(50) DEFAULT NULL,
  `work_order_rules_type_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-工单管理';

-- 正在导出表  mes_db_test.mes_pd_work_order 的数据：~0 rows (大约)
DELETE FROM `mes_pd_work_order`;
/*!40000 ALTER TABLE `mes_pd_work_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_work_order` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_pd_work_order_batch 结构
DROP TABLE IF EXISTS `mes_pd_work_order_batch`;
CREATE TABLE IF NOT EXISTS `mes_pd_work_order_batch` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `work_order_id` varchar(50) DEFAULT NULL COMMENT '工单ID',
  `batch_num` varchar(50) DEFAULT NULL COMMENT '批号',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品管理-工单批次';

-- 正在导出表  mes_db_test.mes_pd_work_order_batch 的数据：~0 rows (大约)
DELETE FROM `mes_pd_work_order_batch`;
/*!40000 ALTER TABLE `mes_pd_work_order_batch` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_pd_work_order_batch` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_role 结构
DROP TABLE IF EXISTS `mes_role`;
CREATE TABLE IF NOT EXISTS `mes_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_role 的数据：~1 rows (大约)
DELETE FROM `mes_role`;
/*!40000 ALTER TABLE `mes_role` DISABLE KEYS */;
INSERT INTO `mes_role` (`id`, `name`, `description`, `create_date`, `update_date`) VALUES
	('096ED5F1B65748A6976778E15973855A', '管理员', '管理员', '2017-07-04 18:47:44', '2017-09-01 11:23:14');
/*!40000 ALTER TABLE `mes_role` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_serial_rule 结构
DROP TABLE IF EXISTS `mes_serial_rule`;
CREATE TABLE IF NOT EXISTS `mes_serial_rule` (
  `id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `order_num` varchar(50) DEFAULT NULL,
  `current_value` int(11) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `start_value` int(11) DEFAULT NULL,
  `max_value` bigint(20) DEFAULT NULL,
  `currentValue` int(11) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流水号';

-- 正在导出表  mes_db_test.mes_serial_rule 的数据：~0 rows (大约)
DELETE FROM `mes_serial_rule`;
/*!40000 ALTER TABLE `mes_serial_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_serial_rule` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_table 结构
DROP TABLE IF EXISTS `mes_table`;
CREATE TABLE IF NOT EXISTS `mes_table` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `entity_class` varchar(100) DEFAULT NULL,
  `cn_name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `table_type_id` varchar(50) DEFAULT NULL,
  `is_internal` varchar(50) DEFAULT NULL,
  `is_create` varchar(50) DEFAULT NULL,
  `is_create_expand` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_table 的数据：~0 rows (大约)
DELETE FROM `mes_table`;
/*!40000 ALTER TABLE `mes_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_table` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_table_type 结构
DROP TABLE IF EXISTS `mes_table_type`;
CREATE TABLE IF NOT EXISTS `mes_table_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `is_internal` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_table_type 的数据：~0 rows (大约)
DELETE FROM `mes_table_type`;
/*!40000 ALTER TABLE `mes_table_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_table_type` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_user 结构
DROP TABLE IF EXISTS `mes_user`;
CREATE TABLE IF NOT EXISTS `mes_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `job_number` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile_phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_user 的数据：~1 rows (大约)
DELETE FROM `mes_user`;
/*!40000 ALTER TABLE `mes_user` DISABLE KEYS */;
INSERT INTO `mes_user` (`id`, `username`, `password`, `name`, `job_number`, `title`, `role_id`, `sex`, `phone`, `mobile_phone`, `email`, `create_date`, `update_date`, `is_delete`) VALUES
	('HA1B868A050BC41EFB88A45A64F47F1D9', 'admin', '123456', '管理员', '001', 'admin', '096ED5F1B65748A6976778E15973855A', '男', '66666666', '13666666666', 'admin@hirain.com', '2017-07-04 17:52:02', '2017-07-17 17:45:27', '0');
/*!40000 ALTER TABLE `mes_user` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_user_dept_auth 结构
DROP TABLE IF EXISTS `mes_user_dept_auth`;
CREATE TABLE IF NOT EXISTS `mes_user_dept_auth` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `dept_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_user_dept_auth 的数据：~1 rows (大约)
DELETE FROM `mes_user_dept_auth`;
/*!40000 ALTER TABLE `mes_user_dept_auth` DISABLE KEYS */;
INSERT INTO `mes_user_dept_auth` (`id`, `user_id`, `dept_id`) VALUES
	('HC9392FC124664B5E8B94FC54EE5A7C19', 'HA1B868A050BC41EFB88A45A64F47F1D9', 'HD68D16B21F3D4D2D80A4283CF0CF4F75');
/*!40000 ALTER TABLE `mes_user_dept_auth` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_user_group 结构
DROP TABLE IF EXISTS `mes_user_group`;
CREATE TABLE IF NOT EXISTS `mes_user_group` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_user_group 的数据：~7 rows (大约)
DELETE FROM `mes_user_group`;
/*!40000 ALTER TABLE `mes_user_group` DISABLE KEYS */;
INSERT INTO `mes_user_group` (`id`, `name`, `description`, `create_date`, `update_date`) VALUES
	('0173FB848D994B8B97501605CE003F9E', 'TBOX生产组', '生产组', '2017-07-29 10:17:08', NULL),
	('1', '销售组', NULL, NULL, NULL),
	('2', '市场组', NULL, NULL, NULL),
	('3', '技术组', NULL, NULL, NULL),
	('4', '售后组', NULL, NULL, NULL),
	('6CF8A90BDBF24353A187183AE869ACEE', '测试组', '', '2017-08-08 11:19:52', NULL),
	('H0BD86BA50D7F45CB94217D04A6D2545A', '测试用户分组', '测试用户分组11', '2017-08-24 14:41:21', '2017-08-24 14:41:37');
/*!40000 ALTER TABLE `mes_user_group` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_user_group_auth 结构
DROP TABLE IF EXISTS `mes_user_group_auth`;
CREATE TABLE IF NOT EXISTS `mes_user_group_auth` (
  `id` varchar(50) NOT NULL,
  `user_group_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_user_group_auth 的数据：~9 rows (大约)
DELETE FROM `mes_user_group_auth`;
/*!40000 ALTER TABLE `mes_user_group_auth` DISABLE KEYS */;
INSERT INTO `mes_user_group_auth` (`id`, `user_group_id`, `user_id`) VALUES
	('0CADA2A2EAC94EAC8BE574A5D4A576FF', '1', 'C6D4C9E862694D48A8FD92A5471A69B2'),
	('298E544092AB43C2AE49E755AA13A3FA', '3', '2'),
	('74B99BC8F0204E3DA5BDCB3E662D2D77', '1', '1'),
	('8F912ACBF86E47F7A9977397CFC505AF', '0173FB848D994B8B97501605CE003F9E', '5'),
	('B4BC215D549C4718A91A0B48A27B38C1', '0173FB848D994B8B97501605CE003F9E', '2'),
	('E71990E7DC6B45958885DEE7D35E795F', '1', '2'),
	('E94D1E2EEEE145479DE7423C38CFD1DD', '6CF8A90BDBF24353A187183AE869ACEE', '792714FB6A404E86B3228C18996C782F'),
	('EF25040C32F34FF4B569F5A296953BF7', '0173FB848D994B8B97501605CE003F9E', 'CE56452BB1F347588EF80BBBD25CB878'),
	('H69D60C2362C048F0B08C14DAD894A172', 'H0BD86BA50D7F45CB94217D04A6D2545A', 'HA1B868A050BC41EFB88A45A64F47F1D9');
/*!40000 ALTER TABLE `mes_user_group_auth` ENABLE KEYS */;

-- 导出  表 mes_db_test.mes_user_process 结构
DROP TABLE IF EXISTS `mes_user_process`;
CREATE TABLE IF NOT EXISTS `mes_user_process` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `process_id` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '所有工序权限期限开始时间',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '所有工序权限期限过期时间',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mes_db_test.mes_user_process 的数据：~0 rows (大约)
DELETE FROM `mes_user_process`;
/*!40000 ALTER TABLE `mes_user_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes_user_process` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


DROP TABLE IF EXISTS `mes_pd_pre_code_wildcard_tb`;
CREATE TABLE IF NOT EXISTS `mes_pd_pre_code_wildcard_tb` (
  `code_rule` int(11) NOT NULL,
  `wildcard` char(225) CHARACTER SET latin1 NOT NULL,
  `operator_time` datetime DEFAULT NULL,
  `remark` char(50) DEFAULT NULL,
  PRIMARY KEY (`code_rule`)
);

DROP TABLE IF EXISTS `mes_pd_base_replace_tb`;
CREATE TABLE IF NOT EXISTS `mes_pd_base_replace_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` char(45) DEFAULT NULL,
  `original_value` char(45) DEFAULT NULL,
  `new_value` char(45) DEFAULT NULL,
  `operator_time` datetime DEFAULT NULL,
  `remark` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (2,'YEARS','15','F','2015-11-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (3,'YEARS','16','G','2015-11-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (4,'YEARS','17','H','2015-11-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (5,'YEARS','18','J','2015-11-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (6,'YEARS','19','K','2015-11-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (7,'YEARS','20','L','2016-04-20 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (8,'NEWYEARS','16','A','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (9,'NEWYEARS','17','B','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (10,'NEWYEARS','18','C','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (11,'NEWYEARS','19','D','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (12,'NEWYEARS','20','E','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (13,'Month','01','A','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (14,'Month','02','B','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (15,'Month','03','C','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (16,'Month','04','D','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (17,'Month','05','E','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (18,'Month','06','F','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (19,'Month','07','G','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (20,'Month','08','H','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (21,'Month','09','J','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (22,'Month','10','K','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (23,'Month','11','L','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (24,'Month','12','M','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (25,'Day','01','1','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (26,'Day','02','2','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (27,'Day','03','3','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (28,'Day','04','4','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (29,'Day','05','5','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (30,'Day','06','6','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (31,'Day','07','7','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (32,'Day','08','8','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (33,'Day','09','9','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (34,'Day','10','A','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (35,'Day','11','B','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (36,'Day','12','C','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (37,'Day','13','D','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (38,'Day','14','E','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (39,'Day','15','F','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (40,'Day','16','G','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (41,'Day','17','H','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (42,'Day','18','J','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (43,'Day','19','K','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (44,'Day','20','L','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (45,'Day','21','M','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (46,'Day','22','N','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (47,'Day','23','P','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (48,'Day','24','R','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (49,'Day','25','S','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (50,'Day','26','T','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (51,'Day','27','V','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (52,'Day','28','W','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (53,'Day','29','X','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (54,'Day','30','Y','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (55,'Day','31','Z','2016-04-19 00:00:00',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (56,'YEARSNEW','17','7','2017-01-10 15:29:47',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (57,'YEARSNEW','18','8','2017-01-10 15:30:16',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (58,'YEARSNEW','19','9','2017-01-10 15:30:44',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (59,'YEARSNEW','20','A','2017-01-10 15:31:09',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (60,'YEARSNEW','21','B','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (61,'NEWMonth','01','1','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (62,'NEWMonth','02','2','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (63,'NEWMonth','03','3','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (64,'NEWMonth','04','4','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (65,'NEWMonth','05','5','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (66,'NEWMonth','06','6','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (67,'NEWMonth','07','7','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (68,'NEWMonth','08','8','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (69,'NEWMonth','09','9','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (70,'NEWMonth','10','S','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (71,'NEWMonth','11','Y','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (72,'NEWMonth','12','E','2017-01-10 15:31:32',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (73,'Shift','1','0','2017-06-09 09:38:45',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (74,'Shift','2','1','2017-06-09 09:38:45',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (75,'Shift','3','2','2017-06-09 09:38:45',NULL);
insert  into `mes_pd_base_replace_tb`(`id`,`table_name`,`original_value`,`new_value`,`operator_time`,`remark`) values (76,'Shift','4','3','2017-06-09 09:38:45',NULL);


DROP TABLE IF EXISTS `mes_pd_barcode_wildcard`;
CREATE TABLE IF NOT EXISTS `mes_pd_barcode_wildcard` (
  `id` varchar(50) COLLATE utf8_bin NOT NULL,
  `wildcard` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '通配',
  `note` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '通配符意义',
  `description` longtext COLLATE utf8_bin COMMENT '备注',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) COMMENT='条码通配符列表';

insert into `mes_pd_barcode_wildcard` values ('1','#001','RS','Godex特定命令',now());
insert into `mes_pd_barcode_wildcard` values ('2','#002','GS','Godex特定命令',now());
insert into `mes_pd_barcode_wildcard` values ('3','#003','EOT','Godex打印机特定命令',now());
insert into `mes_pd_barcode_wildcard` values ('4','#004','<','Godex 替换特殊字符<',now());
insert into `mes_pd_barcode_wildcard` values ('5','#005','>','Godex 替换特殊字符>',now());
insert into `mes_pd_barcode_wildcard` values ('6','#006','&','Godex 替换特殊字符&',now());
insert into `mes_pd_barcode_wildcard` values ('7','#007','(','Godex 替换特殊字符(',now());
insert into `mes_pd_barcode_wildcard` values ('8','#008',')','Godex 替换特殊字符)',now());
insert into `mes_pd_barcode_wildcard` values ('9','#009','%','Godex 替换特殊字符%',now());
insert into `mes_pd_barcode_wildcard` values ('10','#010','~','Godex 替换特殊字符~',now());
insert into `mes_pd_barcode_wildcard` values ('11','#000','','Godex 附表起始符',now());
insert into `mes_pd_barcode_wildcard` values ('12','@000','@','@',now());
insert into `mes_pd_barcode_wildcard` values ('13','@001','DeltX','水平方向调节量',now());
insert into `mes_pd_barcode_wildcard` values ('14','@002','DeltY','垂直方向调节量',now());
insert into `mes_pd_barcode_wildcard` values ('15','@003','PrintProt','端口，0-并口、1-串口1、2-串口2',now());
insert into `mes_pd_barcode_wildcard` values ('16','@005','NewBar','条码打印和包装使用，条码不含（4位或6位）流水号部分',now());
insert into `mes_pd_barcode_wildcard` values ('17','@006','起始序号','流水号打印的起始序号',now());
insert into `mes_pd_barcode_wildcard` values ('18','@007','打印数量','流水号打印的的打印数量',now());
insert into `mes_pd_barcode_wildcard` values ('19','@008','拷贝数量','流水号打印的的拷贝数量',now());
insert into `mes_pd_barcode_wildcard` values ('20','@009','是否混批','包装箱号是否混批标志',now());
insert into `mes_pd_barcode_wildcard` values ('21','@012','日期','例如20121204',now());
insert into `mes_pd_barcode_wildcard` values ('22','@013','箱总重量','计算整箱重量',now());
insert into `mes_pd_barcode_wildcard` values ('23','@014','客户零件号','产品配置中的PART_NO',now());
insert into `mes_pd_barcode_wildcard` values ('24','@015','SoftVersion(软件版本)','取产品配置“SOFT_ERP_CODE”中对应物料版本的前3位，如1.0',now());
insert into `mes_pd_barcode_wildcard` values ('25','@016','硬件版本','取产品配置“HARD_ERP_CODE”中对应物料版本前3位，如1.0',now());
insert into `mes_pd_barcode_wildcard` values ('26','@017','细线宽','用于打印批次条码规格',now());
insert into `mes_pd_barcode_wildcard` values ('27','@018','粗线宽','用于打印批次条码规格',now());
insert into `mes_pd_barcode_wildcard` values ('28','@019','箱容量','获取箱中产品总数量',now());
insert into `mes_pd_barcode_wildcard` values ('29','@020','批次内容','最多适应3个批次',now());
insert into `mes_pd_barcode_wildcard` values ('30','@022','Year(2位年)','例如2013年通配为13',now());
insert into `mes_pd_barcode_wildcard` values ('31','@023','Month(2位月)','例如6月通配为06',now());
insert into `mes_pd_barcode_wildcard` values ('32','@024','Date(2位日期)','例如30号通配为30',now());
insert into `mes_pd_barcode_wildcard` values ('33','@036','产品ERP编码','9位产品ERP编码',now());
insert into `mes_pd_barcode_wildcard` values ('34','@040 ','四位流水号','当前工序输入条码的后四位流水号',now());
insert into `mes_pd_barcode_wildcard` values ('35','@041','四位流水号+1','当前工序输入条码的后四位流水号，用于配置多列打印,(产品配置 LINE_NUM 相关)',now());
insert into `mes_pd_barcode_wildcard` values ('36','@042','四位流水号+2','当前工序输入条码后四位流水号，用于配置多列打印(产品配置 LINE_NUM 相关)',now());
insert into `mes_pd_barcode_wildcard` values ('37','@044','eg:20140102','根据包装箱中产品批次生成',now());
insert into `mes_pd_barcode_wildcard` values ('38','@045','eg:2014/1/2','根据包装箱中产品批次生成',now());
insert into `mes_pd_barcode_wildcard` values ('39','@046','eg:02/01/2014','根据包装箱中产品批次生成',now());
insert into `mes_pd_barcode_wildcard` values ('40','@047','eg:140102','根据包装箱中产品批次生成',now());
insert into `mes_pd_barcode_wildcard` values ('41','@048','包装箱号','包装箱号',now());
insert into `mes_pd_barcode_wildcard` values ('42','@049','Day(3位天)','按批次计算出三位天',now());
insert into `mes_pd_barcode_wildcard` values ('43','@050','BOM版本','产品BOM版本',now());
insert into `mes_pd_barcode_wildcard` values ('44','@051','当天日期','打印时间，例如：150520',now());
insert into `mes_pd_barcode_wildcard` values ('45','@052','整个任务批次信息','例如：600120146HR150520AA',now());
insert into `mes_pd_barcode_wildcard` values ('46','@053','班次','批次信息，倒数第1位,例如：A ',now());
insert into `mes_pd_barcode_wildcard` values ('47','@054','线别','批次信息，倒数第2位,例如：A',now());
insert into `mes_pd_barcode_wildcard` values ('48','@055 ','物理线别','工作站对于的物理线别信息，取产品第一道工序对应工作站的最后一位，eg：3',now());
insert into `mes_pd_barcode_wildcard` values ('49','@056','一汽校验码','调用一汽提供的restAPI，输入条码，生成对应的校验码',now());
insert into `mes_pd_barcode_wildcard` values ('50','@800','生成的位流水号','不能配置在打印命令中,在条码生产的数据表中配置使用。后台生成',now());
insert into `mes_pd_barcode_wildcard` values ('51','@901(ERP)','版本信息通配','通配函数，获取ERP编码对应的版本信息',now());
insert into `mes_pd_barcode_wildcard` values ('52','@902(类型ID)','条码通配','通配函数，获取类型ID对应的条码,当前类型的条码不存在时，根据条码配置生成',now());
insert into `mes_pd_barcode_wildcard` values ('53','@903(配置名)','单项配置通配','通配函数，获取产品配置中对应的配置值',now());
insert into `mes_pd_barcode_wildcard` values ('54','@904(类型ID)','条码通配','通过条码类型取条码,.当该类型当前产品版本的条码不存在时，根据条码配置生成',now());
insert into `mes_pd_barcode_wildcard` values ('55','@905(ERP)','版本信息通配','通配函数，获取ERP编码对应的版本信息，过滤‘.’,例如1.1.1，会得到111',now());
insert into `mes_pd_barcode_wildcard` values ('56','@905(ERP)','版本信息通配','通配函数，获取ERP编码对应的版本信息，过滤‘.’,例如1.01.1，会得到010101',now());
insert into `mes_pd_barcode_wildcard` values ('57','@907(配置名)','特殊版本信息通配','通配函数，获取产品配置中对应的配置值ERP编码,获取ERP编码对应的版本信息，',now());
