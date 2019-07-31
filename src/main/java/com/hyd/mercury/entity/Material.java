package com.hyd.mercury.entity;

public class Material {
    private String uuid;

    private String code;

    private String name;

    private String mnemonicCode;

    private Byte materialType;

    private Byte isStop;

    private String quantityUnit;

    private String executionStandard;

    private Byte isHidden;

    private String remark;

    private Integer createTime;

    private String type;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }

    public Byte getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Byte materialType) {
        this.materialType = materialType;
    }

    public Byte getIsStop() {
        return isStop;
    }

    public void setIsStop(Byte isStop) {
        this.isStop = isStop;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit == null ? null : quantityUnit.trim();
    }

    public String getExecutionStandard() {
        return executionStandard;
    }

    public void setExecutionStandard(String executionStandard) {
        this.executionStandard = executionStandard == null ? null : executionStandard.trim();
    }

    public Byte getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Byte isHidden) {
        this.isHidden = isHidden;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}