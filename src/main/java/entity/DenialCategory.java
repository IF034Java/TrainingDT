package entity;

public class DenialCategory {

    private int Id;
    private int categoryCode;
    private String categoryDescription;
    private int classCode;
    private int priority;

    public DenialCategory() {
    }

    public DenialCategory(int id, int categoryCode, String categoryDescription, int classCode, int priority) {
        Id = id;
        this.categoryCode = categoryCode;
        this.categoryDescription = categoryDescription;
        this.classCode = classCode;
        this.priority = priority;
    }

    public int getId() {
        return Id;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public int getClassCode() {
        return classCode;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
