package com.edexsoft.framework.security;

import java.util.HashSet;
import java.util.Set;

import com.edexsoft.data.BaseEntity;

public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String account;
	private String password;
	
	private String trueName;
	private String email;
	private String idCardNo;
	
	private String state=EnumUserState.ACTIVE.getState();
	
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "APP_USER_USER_PROFILE", 
//             joinColumns = { @JoinColumn(name = "USER_ID") }, 
//             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
    
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + id;
//        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
//        return result;
//    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (getId() != other.getId())
            return false;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + getId() + ", account=" + account + ", password=" + password
                + ", trueName=" + trueName + ", email=" + email
                + ", idCardNo=" + idCardNo + ", state=" + state + ", userProfiles=" + userProfiles +"]";
    }
 
}
