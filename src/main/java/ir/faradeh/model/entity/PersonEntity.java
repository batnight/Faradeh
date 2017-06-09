/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author sorena
 */
@Entity("person")
public class PersonEntity {

    @Id
    private ObjectId _id;
    @Property("DefaultInstitution")
    private boolean defaultInstitution;
    @Property("PersonalId")
    private String personalId;
    @Property("NationalId")
    private String nationalId;
    @Property("CabinetNumber")
    private String cabinetNumber;
    @Property("FirstName")
    private String firstName;
    @Property("LastName")
    private String lastName;
    @Property("FatherName")
    private String fatherName;
    @Property("Gender")
    private String gender;
    @Property("StudyProgram")
    private String studyProgram;//رشته تحصیلی
    @Property("MobileNumber")
    private String mobileNumber;
    @Property("HomeNumber")
    private String homeNumber;
    @Property("State")
    private String state;
    @Property("Nationals")
    private String nationals;//اتباع
    @Property("PassportNumber")
    private String passportNumber;
    @Property("IdentityCardNumber")
    private String identityCardNumber;
    @Property("PlaceOfBirth")
    private String placeOfBirth;
    @Property("BirthDay")
    private String birthDay;
    @Property("BirthMonth")
    private String birthMonth;
    @Property("BirthYear")
    private String birthYear;
    @Property("BirthCertificate")
    private String birthCertificate;// شماره شناسنامه
    @Property("IssuePlace")
    private String issuePlace;
    @Property("IssueDate")
    private String issueDate;
    @Property("Nationality")
    private String nationality;//تابعیت
    @Property("Religion")
    private String religion;
    @Property("MaritalState")
    private String maritalState;//وضعیت تاهل
    @Property("Province")
    private String province;//استان
    @Property("City")
    private String city;
    @Property("ZipCode")
    private String zipCode;
    @Property("Address")
    private String address;
    @Property("Email")
    private String email;
    @Property("PreviousCertificate")
    private String previousCertificate;
    @Property("PreviousStudyProgram")
    private String previousStudyProgram;
    @Property("Specialization")
    private String specialization;//گرایش
    @Property("PreviousInstitution")
    private String previousInstitution;
    @Property("PreviousStudyProvince")
    private String previousStudyProvince;
    @Property("PreviousStudyCounty")
    private String previousStudyCounty;// شهرستان
    @Property("DateReceivedPreviousStudy")
    private String dateReceivedPreviousStudy;
    @Property("PreviousStudyAverage")
    private String previousStudyAverage;//معدل آخریت مدرک
    @Property("EmploymentState")
    private String employmentState;
    @Property("EmploymentCode")
    private String employmentCode;
    @Property("QuotaVeterans")
    private boolean quotaVeterans;//سهمیه ایثار گری
    @Property("VeteransCode")
    private String veteransCode;//کد ایثارگری
    @Property("MilitaryServiceId")
    private boolean MilitaryServiceId;// کارت پایان خدمت
    @Property("ExcemptionSheet")
    private boolean excemptionSheet;//برگه معافیت موقت بدون غیبت و دارای اعتبار
    @Property("ClergyExcemption")
    private boolean clergyExcemption;//طلاب علوم دینی دارای معافیت تحصیلی
    @Property("PermanentExcemption")
    private boolean premanentExcemption;//کارت معافیت دايم
    @Property("StudyExcemption")
    private boolean studyExcemption;//معافیت تحصیلی
    @Property("ArmedForcesPersonnel")
    private boolean armedForcesPersonnel;//پرسنل پایور شاغل در نیروهای مسلح
    @Property("MilitaryAndStudyNoInterference")
    private boolean militaryAndStudyNoInterference;//عدم تداخل خدمت با تحصیل
    @Reference
    private RoleEntity role;
    @Reference
    private InstitutionEntity institution;
    @Reference
    private AccountEntity account;
    @Embedded
    private StudentProgramEntity program;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public boolean isDefaultInstitution() {
        return defaultInstitution;
    }

    public void setDefaultInstitution(boolean defaultInstitution) {
        this.defaultInstitution = defaultInstitution;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNationals() {
        return nationals;
    }

    public void setNationals(String nationals) {
        this.nationals = nationals;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMaritalState() {
        return maritalState;
    }

    public void setMaritalState(String maritalState) {
        this.maritalState = maritalState;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreviousCertificate() {
        return previousCertificate;
    }

    public void setPreviousCertificate(String previousCertificate) {
        this.previousCertificate = previousCertificate;
    }

    public String getPreviousStudyProgram() {
        return previousStudyProgram;
    }

    public void setPreviousStudyProgram(String previousStudyProgram) {
        this.previousStudyProgram = previousStudyProgram;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPreviousInstitution() {
        return previousInstitution;
    }

    public void setPreviousInstitution(String previousInstitution) {
        this.previousInstitution = previousInstitution;
    }

    public String getPreviousStudyProvince() {
        return previousStudyProvince;
    }

    public void setPreviousStudyProvince(String previousStudyProvince) {
        this.previousStudyProvince = previousStudyProvince;
    }

    public String getPreviousStudyCounty() {
        return previousStudyCounty;
    }

    public void setPreviousStudyCounty(String previousStudyCounty) {
        this.previousStudyCounty = previousStudyCounty;
    }

    public String getDateReceivedPreviousStudy() {
        return dateReceivedPreviousStudy;
    }

    public void setDateReceivedPreviousStudy(String dateReceivedPreviousStudy) {
        this.dateReceivedPreviousStudy = dateReceivedPreviousStudy;
    }

    public String getPreviousStudyAverage() {
        return previousStudyAverage;
    }

    public void setPreviousStudyAverage(String previousStudyAverage) {
        this.previousStudyAverage = previousStudyAverage;
    }

    public String getEmploymentState() {
        return employmentState;
    }

    public void setEmploymentState(String employmentState) {
        this.employmentState = employmentState;
    }

    public String getEmploymentCode() {
        return employmentCode;
    }

    public void setEmploymentCode(String employmentCode) {
        this.employmentCode = employmentCode;
    }

    public boolean isQuotaVeterans() {
        return quotaVeterans;
    }

    public void setQuotaVeterans(boolean quotaVeterans) {
        this.quotaVeterans = quotaVeterans;
    }

    public String getVeteransCode() {
        return veteransCode;
    }

    public void setVeteransCode(String veteransCode) {
        this.veteransCode = veteransCode;
    }

    public boolean isMilitaryServiceId() {
        return MilitaryServiceId;
    }

    public void setMilitaryServiceId(boolean MilitaryServiceId) {
        this.MilitaryServiceId = MilitaryServiceId;
    }

    public boolean isExcemptionSheet() {
        return excemptionSheet;
    }

    public void setExcemptionSheet(boolean excemptionSheet) {
        this.excemptionSheet = excemptionSheet;
    }

    public boolean isClergyExcemption() {
        return clergyExcemption;
    }

    public void setClergyExcemption(boolean clergyExcemption) {
        this.clergyExcemption = clergyExcemption;
    }

    public boolean isPremanentExcemption() {
        return premanentExcemption;
    }

    public void setPremanentExcemption(boolean premanentExcemption) {
        this.premanentExcemption = premanentExcemption;
    }

    public boolean isStudyExcemption() {
        return studyExcemption;
    }

    public void setStudyExcemption(boolean studyExcemption) {
        this.studyExcemption = studyExcemption;
    }

    public boolean isArmedForcesPersonnel() {
        return armedForcesPersonnel;
    }

    public void setArmedForcesPersonnel(boolean armedForcesPersonnel) {
        this.armedForcesPersonnel = armedForcesPersonnel;
    }

    public boolean isMilitaryAndStudyNoInterference() {
        return militaryAndStudyNoInterference;
    }

    public void setMilitaryAndStudyNoInterference(boolean militaryAndStudyNoInterference) {
        this.militaryAndStudyNoInterference = militaryAndStudyNoInterference;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public InstitutionEntity getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionEntity institution) {
        this.institution = institution;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public void setPrograms(StudentProgramEntity program) {
        this.program = program;
    }

    public StudentProgramEntity getPrograms() {
        return program;
    }

}
