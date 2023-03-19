package org.zeroxthree;

import javax.persistence.*;


@Entity
@Table(name = "players")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nickname")
    private String nickname;
    @Column(name = "password")
    private String password;
    @Column(name = "record")
    private int record;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Players() {
    }


    public String getNickname(){
        return nickname;
    }

    public int getRecord(){
        return record;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Players(String nickname, String password, int record) {
        this.nickname = nickname;
        this.password = password;
        this.record = record;

    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    @Override
    public String toString(){
        return getNickname();
    }


}
