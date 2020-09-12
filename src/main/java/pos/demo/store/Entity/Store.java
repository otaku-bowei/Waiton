package pos.demo.store.Entity;

import java.util.Date;

public class Store {

    private String storeCode ;
    private String storeName ;
    private String owerEmail ;
    private String owerUsername ;
    private String storeType ;
    private Date buildDatetime ;
    private String instructions ;

    public Store(String storeCode, String storeName, String owerEmail, String owerUsername, String storeType, Date buildDatetime, String instructions) {
        this.storeCode = storeCode;
        this.storeName = storeName;
        this.owerEmail = owerEmail;
        this.owerUsername = owerUsername;
        this.storeType = storeType;
        this.buildDatetime = buildDatetime;
        this.instructions = instructions;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOwerEmail() {
        return owerEmail;
    }

    public void setOwerEmail(String owerEmail) {
        this.owerEmail = owerEmail;
    }

    public String getOwerUsername() {
        return owerUsername;
    }

    public void setOwerUsername(String owerUsername) {
        this.owerUsername = owerUsername;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public Date getBuildDatetime() {
        return buildDatetime;
    }

    public void setBuildDatetime(Date buildDatetime) {
        this.buildDatetime = buildDatetime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
