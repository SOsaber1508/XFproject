package com.fec.epreport.entity;
//评价
public class Evaluate {
    private Integer evaluate_id;
    private Integer evaluate_user_id;
    private Integer evaluate_user_ids;
    private String evaluate_type;
    private String evaluate_content;
    private String evaluate_time;

    public Evaluate() {
    }

    public Evaluate(Integer evaluate_id, Integer evaluate_user_id, Integer evaluate_user_ids, String evaluate_type, String evaluate_content, String evaluate_time) {
        this.evaluate_id = evaluate_id;
        this.evaluate_user_id = evaluate_user_id;
        this.evaluate_user_ids = evaluate_user_ids;
        this.evaluate_type = evaluate_type;
        this.evaluate_content = evaluate_content;
        this.evaluate_time = evaluate_time;
    }

    public Integer getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Integer evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public Integer getEvaluate_user_id() {
        return evaluate_user_id;
    }

    public void setEvaluate_user_id(Integer evaluate_user_id) {
        this.evaluate_user_id = evaluate_user_id;
    }

    public Integer getEvaluate_user_ids() {
        return evaluate_user_ids;
    }

    public void setEvaluate_user_ids(Integer evaluate_user_ids) {
        this.evaluate_user_ids = evaluate_user_ids;
    }

    public String getEvaluate_type() {
        return evaluate_type;
    }

    public void setEvaluate_type(String evaluate_type) {
        this.evaluate_type = evaluate_type;
    }

    public String getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(String evaluate_content) {
        this.evaluate_content = evaluate_content;
    }

    public String getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluate_id=" + evaluate_id +
                ", evaluate_user_id=" + evaluate_user_id +
                ", evaluate_user_ids=" + evaluate_user_ids +
                ", evaluate_type='" + evaluate_type + '\'' +
                ", evaluate_content='" + evaluate_content + '\'' +
                ", evaluate_time='" + evaluate_time + '\'' +
                '}';
    }
}
