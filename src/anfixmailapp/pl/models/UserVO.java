/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author k.skowronski
 */
@Entity
@Table(name = "users")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
//    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
//    , @NamedQuery(name = "Users.findByInitials", query = "SELECT u FROM Users u WHERE u.initials = :initials")
//    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
//    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
//    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")})
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "audit_dc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditDc;
    @Column(name = "audit_dm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditDm;
    @Column(name = "audit_uc")
    private String auditUc;
    @Column(name = "audit_um")
    private String auditUm;
    @Column(name = "initials")
    private String initials;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "f_dealer")
    private String fDealer;
    @Column(name = "f_sorter")
    private String fSorter;
    @Column(name = "f_superuser")
    private String fSuperuser;
    @Column(name = "f_tm")
    private String fTm;
    @Column(name = "is_active")
    private String isActive;
    @Column(name = "color")
    private String color;
    @Column(name = "imported_id")
    private BigInteger importedId;
    @Column(name = "f_show_calendar")
    private String fShowCalendar;
    @Column(name = "audit_created_session_id")
    private BigInteger auditCreatedSessionId;
    @Column(name = "audit_created_system_name")
    private String auditCreatedSystemName;
    @Column(name = "audit_modified_session_id")
    private BigInteger auditModifiedSessionId;
    @Column(name = "audit_modified_system_name")
    private String auditModifiedSystemName;
    @Column(name = "last_password_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChangeDate;
    @Column(name = "login_token")
    private String loginToken;
    @Column(name = "login_token_valid_till")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTokenValidTill;
    @Column(name = "function")
    private String function;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_manager")
    private String isManager;
    @Column(name = "oranization_unit")
    private String oranizationUnit;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "login")
    private String login;
    @Column(name = "newpwd")
    private String newpwd;
    @Column(name = "roles")
    private String roles;
    @Column(name = "access_groups")
    private String accessGroups;
    @Column(name = "tags")
    private String tags;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "factive")
    private String factive;
    @Column(name = "importedid")
    private BigInteger importedid;
    @Column(name = "user_initials")
    private String userInitials;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "replacementuserinitials")
    private String replacementuserinitials;
    @Column(name = "profile_code")
    private String profileCode;
    @Column(name = "supervisor_id")
    private Integer supervisorId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "department")
    private String department;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "country_code")
    private String countryCode;

    public UserVO() {
    }

    public UserVO(Integer id) {
        this.id = id;
    }

    public UserVO(Integer id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAuditDc() {
        return auditDc;
    }

    public void setAuditDc(Date auditDc) {
        this.auditDc = auditDc;
    }

    public Date getAuditDm() {
        return auditDm;
    }

    public void setAuditDm(Date auditDm) {
        this.auditDm = auditDm;
    }

    public String getAuditUc() {
        return auditUc;
    }

    public void setAuditUc(String auditUc) {
        this.auditUc = auditUc;
    }

    public String getAuditUm() {
        return auditUm;
    }

    public void setAuditUm(String auditUm) {
        this.auditUm = auditUm;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFDealer() {
        return fDealer;
    }

    public void setFDealer(String fDealer) {
        this.fDealer = fDealer;
    }

    public String getFSorter() {
        return fSorter;
    }

    public void setFSorter(String fSorter) {
        this.fSorter = fSorter;
    }

    public String getFSuperuser() {
        return fSuperuser;
    }

    public void setFSuperuser(String fSuperuser) {
        this.fSuperuser = fSuperuser;
    }

    public String getFTm() {
        return fTm;
    }

    public void setFTm(String fTm) {
        this.fTm = fTm;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigInteger getImportedId() {
        return importedId;
    }

    public void setImportedId(BigInteger importedId) {
        this.importedId = importedId;
    }

    public String getFShowCalendar() {
        return fShowCalendar;
    }

    public void setFShowCalendar(String fShowCalendar) {
        this.fShowCalendar = fShowCalendar;
    }

    public BigInteger getAuditCreatedSessionId() {
        return auditCreatedSessionId;
    }

    public void setAuditCreatedSessionId(BigInteger auditCreatedSessionId) {
        this.auditCreatedSessionId = auditCreatedSessionId;
    }

    public String getAuditCreatedSystemName() {
        return auditCreatedSystemName;
    }

    public void setAuditCreatedSystemName(String auditCreatedSystemName) {
        this.auditCreatedSystemName = auditCreatedSystemName;
    }

    public BigInteger getAuditModifiedSessionId() {
        return auditModifiedSessionId;
    }

    public void setAuditModifiedSessionId(BigInteger auditModifiedSessionId) {
        this.auditModifiedSessionId = auditModifiedSessionId;
    }

    public String getAuditModifiedSystemName() {
        return auditModifiedSystemName;
    }

    public void setAuditModifiedSystemName(String auditModifiedSystemName) {
        this.auditModifiedSystemName = auditModifiedSystemName;
    }

    public Date getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getLoginTokenValidTill() {
        return loginTokenValidTill;
    }

    public void setLoginTokenValidTill(Date loginTokenValidTill) {
        this.loginTokenValidTill = loginTokenValidTill;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getOranizationUnit() {
        return oranizationUnit;
    }

    public void setOranizationUnit(String oranizationUnit) {
        this.oranizationUnit = oranizationUnit;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAccessGroups() {
        return accessGroups;
    }

    public void setAccessGroups(String accessGroups) {
        this.accessGroups = accessGroups;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFactive() {
        return factive;
    }

    public void setFactive(String factive) {
        this.factive = factive;
    }

    public BigInteger getImportedid() {
        return importedid;
    }

    public void setImportedid(BigInteger importedid) {
        this.importedid = importedid;
    }

    public String getUserInitials() {
        return userInitials;
    }

    public void setUserInitials(String userInitials) {
        this.userInitials = userInitials;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getReplacementuserinitials() {
        return replacementuserinitials;
    }

    public void setReplacementuserinitials(String replacementuserinitials) {
        this.replacementuserinitials = replacementuserinitials;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserVO)) {
            return false;
        }
        UserVO other = (UserVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anfixmailapp.pl.models.Users[ id=" + id + " ]";
    }
    
}
