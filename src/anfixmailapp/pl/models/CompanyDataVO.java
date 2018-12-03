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
@Table(name = "companys_data")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CompanysDataVO.findAll", query = "SELECT c FROM CompanysDataVO c")
//    , @NamedQuery(name = "CompanysDataVO.findById", query = "SELECT c FROM CompanysDataVO c WHERE c.id = :id")
//    , @NamedQuery(name = "CompanysDataVO.findByAbbr", query = "SELECT c FROM CompanysDataVO c WHERE c.abbr = :abbr")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditDc", query = "SELECT c FROM CompanysDataVO c WHERE c.auditDc = :auditDc")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditDm", query = "SELECT c FROM CompanysDataVO c WHERE c.auditDm = :auditDm")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditUc", query = "SELECT c FROM CompanysDataVO c WHERE c.auditUc = :auditUc")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditUm", query = "SELECT c FROM CompanysDataVO c WHERE c.auditUm = :auditUm")
//    , @NamedQuery(name = "CompanysDataVO.findByBranchId", query = "SELECT c FROM CompanysDataVO c WHERE c.branchId = :branchId")
//    , @NamedQuery(name = "CompanysDataVO.findByComment", query = "SELECT c FROM CompanysDataVO c WHERE c.comment = :comment")
//    , @NamedQuery(name = "CompanysDataVO.findByName", query = "SELECT c FROM CompanysDataVO c WHERE c.name = :name")
//    , @NamedQuery(name = "CompanysDataVO.findByNip", query = "SELECT c FROM CompanysDataVO c WHERE c.nip = :nip")
//    , @NamedQuery(name = "CompanysDataVO.findByRegon", query = "SELECT c FROM CompanysDataVO c WHERE c.regon = :regon")
//    , @NamedQuery(name = "CompanysDataVO.findBySalesUserId", query = "SELECT c FROM CompanysDataVO c WHERE c.salesUserId = :salesUserId")
//    , @NamedQuery(name = "CompanysDataVO.findByTmUserId", query = "SELECT c FROM CompanysDataVO c WHERE c.tmUserId = :tmUserId")
//    , @NamedQuery(name = "CompanysDataVO.findByStatus", query = "SELECT c FROM CompanysDataVO c WHERE c.status = :status")
//    , @NamedQuery(name = "CompanysDataVO.findByQFleetTodayId", query = "SELECT c FROM CompanysDataVO c WHERE c.qFleetTodayId = :qFleetTodayId")
//    , @NamedQuery(name = "CompanysDataVO.findByQCompetitorTill", query = "SELECT c FROM CompanysDataVO c WHERE c.qCompetitorTill = :qCompetitorTill")
//    , @NamedQuery(name = "CompanysDataVO.findByImportedId", query = "SELECT c FROM CompanysDataVO c WHERE c.importedId = :importedId")
//    , @NamedQuery(name = "CompanysDataVO.findByIsCompetition", query = "SELECT c FROM CompanysDataVO c WHERE c.isCompetition = :isCompetition")
//    , @NamedQuery(name = "CompanysDataVO.findByCamsContractStart", query = "SELECT c FROM CompanysDataVO c WHERE c.camsContractStart = :camsContractStart")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditCreatedSessionId", query = "SELECT c FROM CompanysDataVO c WHERE c.auditCreatedSessionId = :auditCreatedSessionId")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditCreatedSystemName", query = "SELECT c FROM CompanysDataVO c WHERE c.auditCreatedSystemName = :auditCreatedSystemName")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditModifiedSessionId", query = "SELECT c FROM CompanysDataVO c WHERE c.auditModifiedSessionId = :auditModifiedSessionId")
//    , @NamedQuery(name = "CompanysDataVO.findByAuditModifiedSystemName", query = "SELECT c FROM CompanysDataVO c WHERE c.auditModifiedSystemName = :auditModifiedSystemName")
//    , @NamedQuery(name = "CompanysDataVO.findByDeleted", query = "SELECT c FROM CompanysDataVO c WHERE c.deleted = :deleted")
//    , @NamedQuery(name = "CompanysDataVO.findByOrganizationUnit", query = "SELECT c FROM CompanysDataVO c WHERE c.organizationUnit = :organizationUnit")
//    , @NamedQuery(name = "CompanysDataVO.findByStatus2", query = "SELECT c FROM CompanysDataVO c WHERE c.status2 = :status2")
//    , @NamedQuery(name = "CompanysDataVO.findByPriority", query = "SELECT c FROM CompanysDataVO c WHERE c.priority = :priority")
//    , @NamedQuery(name = "CompanysDataVO.findByQualificationCode", query = "SELECT c FROM CompanysDataVO c WHERE c.qualificationCode = :qualificationCode")
//    , @NamedQuery(name = "CompanysDataVO.findByPostcodeUpdated", query = "SELECT c FROM CompanysDataVO c WHERE c.postcodeUpdated = :postcodeUpdated")
//    , @NamedQuery(name = "CompanysDataVO.findByDateNipUpdated", query = "SELECT c FROM CompanysDataVO c WHERE c.dateNipUpdated = :dateNipUpdated")
//    , @NamedQuery(name = "CompanysDataVO.findByPostcodeAlg", query = "SELECT c FROM CompanysDataVO c WHERE c.postcodeAlg = :postcodeAlg")
//    , @NamedQuery(name = "CompanysDataVO.findByAddrStreetPrefix", query = "SELECT c FROM CompanysDataVO c WHERE c.addrStreetPrefix = :addrStreetPrefix")
//    , @NamedQuery(name = "CompanysDataVO.findByObjectVersion", query = "SELECT c FROM CompanysDataVO c WHERE c.objectVersion = :objectVersion")
//    , @NamedQuery(name = "CompanysDataVO.findBySystemVersion", query = "SELECT c FROM CompanysDataVO c WHERE c.systemVersion = :systemVersion")
//    , @NamedQuery(name = "CompanysDataVO.findByCommentForSorter", query = "SELECT c FROM CompanysDataVO c WHERE c.commentForSorter = :commentForSorter")
//    , @NamedQuery(name = "CompanysDataVO.findByOldSalesInitials", query = "SELECT c FROM CompanysDataVO c WHERE c.oldSalesInitials = :oldSalesInitials")
//    , @NamedQuery(name = "CompanysDataVO.findByOldSalesId", query = "SELECT c FROM CompanysDataVO c WHERE c.oldSalesId = :oldSalesId")
//    , @NamedQuery(name = "CompanysDataVO.findByOldTmId", query = "SELECT c FROM CompanysDataVO c WHERE c.oldTmId = :oldTmId")
//    , @NamedQuery(name = "CompanysDataVO.findByDateReminder", query = "SELECT c FROM CompanysDataVO c WHERE c.dateReminder = :dateReminder")
//    , @NamedQuery(name = "CompanysDataVO.findByDealerLastId", query = "SELECT c FROM CompanysDataVO c WHERE c.dealerLastId = :dealerLastId")
//    , @NamedQuery(name = "CompanysDataVO.findByAccessGroup", query = "SELECT c FROM CompanysDataVO c WHERE c.accessGroup = :accessGroup")
//    , @NamedQuery(name = "CompanysDataVO.findByTags", query = "SELECT c FROM CompanysDataVO c WHERE c.tags = :tags")
//    , @NamedQuery(name = "CompanysDataVO.findByProvinceId", query = "SELECT c FROM CompanysDataVO c WHERE c.provinceId = :provinceId")
//    , @NamedQuery(name = "CompanysDataVO.findByDateNextQualification", query = "SELECT c FROM CompanysDataVO c WHERE c.dateNextQualification = :dateNextQualification")
//    , @NamedQuery(name = "CompanysDataVO.findByCompetitorCompanyId", query = "SELECT c FROM CompanysDataVO c WHERE c.competitorCompanyId = :competitorCompanyId")
//    , @NamedQuery(name = "CompanysDataVO.findByRegistrationNumber", query = "SELECT c FROM CompanysDataVO c WHERE c.registrationNumber = :registrationNumber")
//    , @NamedQuery(name = "CompanysDataVO.findByIndustryCode", query = "SELECT c FROM CompanysDataVO c WHERE c.industryCode = :industryCode")
//    , @NamedQuery(name = "CompanysDataVO.findByTerritoryCode", query = "SELECT c FROM CompanysDataVO c WHERE c.territoryCode = :territoryCode")
//    , @NamedQuery(name = "CompanysDataVO.findBySourceType", query = "SELECT c FROM CompanysDataVO c WHERE c.sourceType = :sourceType")
//    , @NamedQuery(name = "CompanysDataVO.findByCountryCode", query = "SELECT c FROM CompanysDataVO c WHERE c.countryCode = :countryCode")
//    , @NamedQuery(name = "CompanysDataVO.findByInstanceId", query = "SELECT c FROM CompanysDataVO c WHERE c.instanceId = :instanceId")
//    , @NamedQuery(name = "CompanysDataVO.findByCcNextContactTime", query = "SELECT c FROM CompanysDataVO c WHERE c.ccNextContactTime = :ccNextContactTime")
//    , @NamedQuery(name = "CompanysDataVO.findByCcNextContactIsHourImportant", query = "SELECT c FROM CompanysDataVO c WHERE c.ccNextContactIsHourImportant = :ccNextContactIsHourImportant")
//    , @NamedQuery(name = "CompanysDataVO.findByCcNextContactPriority", query = "SELECT c FROM CompanysDataVO c WHERE c.ccNextContactPriority = :ccNextContactPriority")
//    , @NamedQuery(name = "CompanysDataVO.findByDepartmentCode", query = "SELECT c FROM CompanysDataVO c WHERE c.departmentCode = :departmentCode")
//    , @NamedQuery(name = "CompanysDataVO.findByCartrackClientNumber", query = "SELECT c FROM CompanysDataVO c WHERE c.cartrackClientNumber = :cartrackClientNumber")
//    , @NamedQuery(name = "CompanysDataVO.findByFleetSizeV", query = "SELECT c FROM CompanysDataVO c WHERE c.fleetSizeV = :fleetSizeV")
//    , @NamedQuery(name = "CompanysDataVO.findByCompetitor", query = "SELECT c FROM CompanysDataVO c WHERE c.competitor = :competitor")
//    , @NamedQuery(name = "CompanysDataVO.findByManually", query = "SELECT c FROM CompanysDataVO c WHERE c.manually = :manually")})
public class CompanyDataVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "abbr")
    private String abbr;
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
    @Column(name = "branch_id")
    private BigInteger branchId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "name")
    private String name;
    @Column(name = "nip")
    private String nip;
    @Column(name = "regon")
    private String regon;
    @Column(name = "sales_user_id")
    private BigInteger salesUserId;
    @Column(name = "tm_user_id")
    private BigInteger tmUserId;
    @Column(name = "status")
    private String status;
    @Column(name = "q_fleet_today_id")
    private BigInteger qFleetTodayId;
    @Column(name = "q_competitor_till")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qCompetitorTill;
    @Column(name = "imported_id")
    private BigInteger importedId;
    @Column(name = "is_competition")
    private String isCompetition;
    @Column(name = "cams_contract_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date camsContractStart;
    @Column(name = "audit_created_session_id")
    private BigInteger auditCreatedSessionId;
    @Column(name = "audit_created_system_name")
    private String auditCreatedSystemName;
    @Column(name = "audit_modified_session_id")
    private BigInteger auditModifiedSessionId;
    @Column(name = "audit_modified_system_name")
    private String auditModifiedSystemName;
    @Column(name = "deleted")
    private String deleted;
    @Column(name = "organization_unit")
    private String organizationUnit;
    @Column(name = "status2")
    private String status2;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "qualification_code")
    private String qualificationCode;
    @Column(name = "postcode_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postcodeUpdated;
    @Column(name = "date_nip_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNipUpdated;
    @Column(name = "postcode_alg")
    private Integer postcodeAlg;
    @Column(name = "addr_street_prefix")
    private String addrStreetPrefix;
    @Column(name = "object_version")
    private Integer objectVersion;
    @Column(name = "system_version")
    private Integer systemVersion;
    @Column(name = "comment_for_sorter")
    private String commentForSorter;
    @Column(name = "old_sales_initials")
    private String oldSalesInitials;
    @Column(name = "old_sales_id")
    private Integer oldSalesId;
    @Column(name = "old_tm_id")
    private Integer oldTmId;
    @Column(name = "date_reminder")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReminder;
    @Column(name = "dealer_last_id")
    private Integer dealerLastId;
    @Column(name = "access_group")
    private String accessGroup;
    @Column(name = "tags")
    private String tags;
    @Column(name = "province_id")
    private Integer provinceId;
    @Column(name = "date_next_qualification")
    @Temporal(TemporalType.DATE)
    private Date dateNextQualification;
    @Column(name = "competitor_company_id")
    private Integer competitorCompanyId;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "industry_code")
    private String industryCode;
    @Column(name = "territory_code")
    private String territoryCode;
    @Column(name = "source_type")
    private String sourceType;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "instance_id")
    private Integer instanceId;
    @Column(name = "cc_next_contact_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccNextContactTime;
    @Column(name = "cc_next_contact_is_hour_important")
    private Boolean ccNextContactIsHourImportant;
    @Column(name = "cc_next_contact_priority")
    private Integer ccNextContactPriority;
    @Column(name = "department_code")
    private String departmentCode;
    @Column(name = "cartrack_client_number")
    private String cartrackClientNumber;
    @Column(name = "fleet_size_v")
    private Integer fleetSizeV;
    @Column(name = "competitor")
    private Boolean competitor;
    @Column(name = "manually")
    private String manually;

    public CompanyDataVO() {
    }

    public CompanyDataVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
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

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public BigInteger getSalesUserId() {
        return salesUserId;
    }

    public void setSalesUserId(BigInteger salesUserId) {
        this.salesUserId = salesUserId;
    }

    public BigInteger getTmUserId() {
        return tmUserId;
    }

    public void setTmUserId(BigInteger tmUserId) {
        this.tmUserId = tmUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getQFleetTodayId() {
        return qFleetTodayId;
    }

    public void setQFleetTodayId(BigInteger qFleetTodayId) {
        this.qFleetTodayId = qFleetTodayId;
    }

    public Date getQCompetitorTill() {
        return qCompetitorTill;
    }

    public void setQCompetitorTill(Date qCompetitorTill) {
        this.qCompetitorTill = qCompetitorTill;
    }

    public BigInteger getImportedId() {
        return importedId;
    }

    public void setImportedId(BigInteger importedId) {
        this.importedId = importedId;
    }

    public String getIsCompetition() {
        return isCompetition;
    }

    public void setIsCompetition(String isCompetition) {
        this.isCompetition = isCompetition;
    }

    public Date getCamsContractStart() {
        return camsContractStart;
    }

    public void setCamsContractStart(Date camsContractStart) {
        this.camsContractStart = camsContractStart;
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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public Date getPostcodeUpdated() {
        return postcodeUpdated;
    }

    public void setPostcodeUpdated(Date postcodeUpdated) {
        this.postcodeUpdated = postcodeUpdated;
    }

    public Date getDateNipUpdated() {
        return dateNipUpdated;
    }

    public void setDateNipUpdated(Date dateNipUpdated) {
        this.dateNipUpdated = dateNipUpdated;
    }

    public Integer getPostcodeAlg() {
        return postcodeAlg;
    }

    public void setPostcodeAlg(Integer postcodeAlg) {
        this.postcodeAlg = postcodeAlg;
    }

    public String getAddrStreetPrefix() {
        return addrStreetPrefix;
    }

    public void setAddrStreetPrefix(String addrStreetPrefix) {
        this.addrStreetPrefix = addrStreetPrefix;
    }

    public Integer getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(Integer objectVersion) {
        this.objectVersion = objectVersion;
    }

    public Integer getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(Integer systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getCommentForSorter() {
        return commentForSorter;
    }

    public void setCommentForSorter(String commentForSorter) {
        this.commentForSorter = commentForSorter;
    }

    public String getOldSalesInitials() {
        return oldSalesInitials;
    }

    public void setOldSalesInitials(String oldSalesInitials) {
        this.oldSalesInitials = oldSalesInitials;
    }

    public Integer getOldSalesId() {
        return oldSalesId;
    }

    public void setOldSalesId(Integer oldSalesId) {
        this.oldSalesId = oldSalesId;
    }

    public Integer getOldTmId() {
        return oldTmId;
    }

    public void setOldTmId(Integer oldTmId) {
        this.oldTmId = oldTmId;
    }

    public Date getDateReminder() {
        return dateReminder;
    }

    public void setDateReminder(Date dateReminder) {
        this.dateReminder = dateReminder;
    }

    public Integer getDealerLastId() {
        return dealerLastId;
    }

    public void setDealerLastId(Integer dealerLastId) {
        this.dealerLastId = dealerLastId;
    }

    public String getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(String accessGroup) {
        this.accessGroup = accessGroup;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Date getDateNextQualification() {
        return dateNextQualification;
    }

    public void setDateNextQualification(Date dateNextQualification) {
        this.dateNextQualification = dateNextQualification;
    }

    public Integer getCompetitorCompanyId() {
        return competitorCompanyId;
    }

    public void setCompetitorCompanyId(Integer competitorCompanyId) {
        this.competitorCompanyId = competitorCompanyId;
    }
    
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getTerritoryCode() {
        return territoryCode;
    }

    public void setTerritoryCode(String territoryCode) {
        this.territoryCode = territoryCode;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Date getCcNextContactTime() {
        return ccNextContactTime;
    }

    public void setCcNextContactTime(Date ccNextContactTime) {
        this.ccNextContactTime = ccNextContactTime;
    }

    public Boolean getCcNextContactIsHourImportant() {
        return ccNextContactIsHourImportant;
    }

    public void setCcNextContactIsHourImportant(Boolean ccNextContactIsHourImportant) {
        this.ccNextContactIsHourImportant = ccNextContactIsHourImportant;
    }

    public Integer getCcNextContactPriority() {
        return ccNextContactPriority;
    }

    public void setCcNextContactPriority(Integer ccNextContactPriority) {
        this.ccNextContactPriority = ccNextContactPriority;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCartrackClientNumber() {
        return cartrackClientNumber;
    }

    public void setCartrackClientNumber(String cartrackClientNumber) {
        this.cartrackClientNumber = cartrackClientNumber;
    }

    public Integer getFleetSizeV() {
        return fleetSizeV;
    }

    public void setFleetSizeV(Integer fleetSizeV) {
        this.fleetSizeV = fleetSizeV;
    }

    public Boolean getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Boolean competitor) {
        this.competitor = competitor;
    }

    public String getManually() {
        return manually;
    }

    public void setManually(String manually) {
        this.manually = manually;
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
        if (!(object instanceof CompanyDataVO)) {
            return false;
        }
        CompanyDataVO other = (CompanyDataVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anfixmailapp.pl.models.CompanysDataVO[ id=" + id + " ]";
    }
    
}
