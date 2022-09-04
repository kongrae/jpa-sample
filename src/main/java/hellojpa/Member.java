package hellojpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// USER 테이블로 매핑
//@Table(name="USER")
public class Member {
    @Id
    private Long id;
//    DB테이블 컬럼명이 username에 매핑
//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}