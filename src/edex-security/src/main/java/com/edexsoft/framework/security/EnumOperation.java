package com.edexsoft.framework.security;

public enum EnumOperation {
	All(0, "全部"), Access(1, "访问"), Create(2, "新增"), Modify(3, "修改"), Delete(4, "删除"), Setting(5, "设置"), Authorize(100, "授权"); // Permissioned仅用于权限授权

	private int _value;
	private String _name;

	private EnumOperation(int value, String name) {
		_value = value;
		_name = name;
	}

	public int value() {
		return _value;
	}

	public String getName() {
		return _name;
	}
}
