package jiyun.ytp.com.a20170629demo.User;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 因天鹏 on 2017/6/29.
 */
@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "image")
    private int image;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "age")
    private int age;
    @Property(nameInDb = "address")
    private String address;
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return this.image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1791426788)
    public User(Long id, int image, String name, int age, String address) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    
}
