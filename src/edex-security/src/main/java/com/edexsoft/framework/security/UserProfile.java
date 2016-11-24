package com.edexsoft.framework.security;

import com.edexsoft.data.BaseEntity;

public class UserProfile extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type = EnumUserProfileType.USER.getUserProfileType();
	
//	public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + id;
//        result = prime * result + ((type == null) ? 0 : type.hashCode());
//        return result;
//    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (getId() != other.getId())
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id=" + getId() + ",  type=" + type  + "]";
    }
}
