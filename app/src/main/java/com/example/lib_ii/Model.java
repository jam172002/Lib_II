package com.example.lib_ii;

public class Model {
    String m_name, m_author, m_page;
    int m_id;

    public Model(int m_id, String m_name, String m_author, String m_page) {

        this.m_id = m_id;
        this.m_name = m_name;
        this.m_author = m_author;
        this.m_page = m_page;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_author() {
        return m_author;
    }

    public void setM_author(String m_author) {
        this.m_author = m_author;
    }

    public String getM_page() {
        return m_page;
    }

    public void setM_page(String m_page) {
        this.m_page = m_page;
    }
}
