package com.example.myfirst.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.myfirst.entity.Inquiry;

//@Repositoryアノテーションを付与することで、データベースを操作するクラスということをDIコンテナに伝える
@Repository
public class InquiryDaoImpl implements InquiryDao {

    // DB操作用クラス
    private final JdbcTemplate jdbcTemplate;

    // @Autowiredアノテーションを付与することで、DIコンテナで生成されたjdbcインスタンスが渡される
    @Autowired
    public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertInquiry(Inquiry inquiry) {

        jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUES(?,?,?,?)",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());

    }

    @Override
    public List<Inquiry> getAll() {

        String sql = "SELECT id, name, email, contents, created FROM Inquiry";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Inquiry> list = new ArrayList<>();

        for (Map<String, Object> result : resultList) {
            Inquiry inquiry = new Inquiry();
            inquiry.setId((int) result.get("id"));
            inquiry.setName((String) result.get("name"));
            inquiry.setEmail((String) result.get("email"));
            inquiry.setContents((String) result.get("contents"));
            inquiry.setCreated((Timestamp) result.get("created"));
            list.add(inquiry);
        }

        return list;

    }
}
