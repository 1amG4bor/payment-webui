package com.g4bor.payment.webui.model;

import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;

//@Entity
//@Table(name = "privileges")
@Data
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
