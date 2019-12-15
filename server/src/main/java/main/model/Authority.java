package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Authority implements GrantedAuthority{
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @Column

    private String uloga;



    @Override

    public String getAuthority() {

        return uloga;

    }



    @JsonIgnore

    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    @JsonIgnore

    public String getUloga() {

        return uloga;

    }



    public void setUloga(String uloga) {

        this.uloga = uloga;

    }
}
