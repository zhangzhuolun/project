Ext.onReady(function () {
    var searchPanel = new Ext.form.Panel({
    	id:'searchPanel',
    	renderTo:'searchPanel',
    	buttonAlign:'right',
    	layout:'formtable',
    	autoWidth:true,
    	frame:true,
    	columns:3,
    	layoutConfig:{
    		border:0,
    		cellspacing:3,
    		labelSeparator:':'//分隔符
    	},
    	defaults:{
    		labelStyle:'font-weight:bold;',
    		disabledClass:'customer-item-disabled',
    		width:200
    	},
    	defaultType:'textfield',
    	items:[{xtype:'textfield',
    		    name:'orgname',
    		    fieldLabel: '组织名称',
    		    allowBlank: false
    		    }],
		buttons:[
			{cls : 'x-btn-text-icon blist'//,icon:'/style/default/images/search_02.png'
				,text:'查询',id:'search',handler:function(){search();}},
			{text:'导出',id:'derive',handler:function(){derive();}}
		]
    	
    });
   	var orgDS = new Ext.data.Store({
   		data:data,
   		reader:new Ext.data.JsonReader({
			fields : ['orgId','orgName','orgBrithTime','createTime','updateTime']
   		})
   	});
   	orgDS.on('load',function(){
   		if(orgDS.getCount()>0){
   			grid.render('grid');
   			grid.reconfigure(orgDS,orgCM);
   			Ext.get('grid').show();
   		}else{
   			Ext.Msg.alert('提示','该部门加载不出数据！');
   			Ext.get('grid').show();
   		}
   	});
   	orgDS.load();
   	var orgCM = new Ext.grid.ColumnModel([
   	     {header:'编号',width:40,dataIndex:'orgId'},
   	     {header:'部门名称',width:220,dataIndex:'orgName'},
   	     {header:'成立时间',width:220,dataIndex:'orgBrithTime'},
   	     {header:'变更时间',width:220,dataIndex:'updateTime'}
   	]);
   	var grid = new Ext.grid.GridPanel({
   		id : 'grid',
   		renderTo : 'grid',
   		height : document.body.clientHeight*0.7,
   		buttonAlign : 'center',
   		border : true,
   		autoWidth  :true,
   		autoScroll : true,
   		cm : orgCM,
   		ds : orgDS,
   		viewConfig : {
   			forceFit : true
   		},
   		loadMask:{msg:'正在加载数据，请稍后！'}
   	});
   	window.search = function (){
		if(searchPanel.getForm().isValid()){
			grid.getStore().removeAll();
			
		}
   	};
});