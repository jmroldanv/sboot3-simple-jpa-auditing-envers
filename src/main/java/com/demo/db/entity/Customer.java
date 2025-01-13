package com.demo.db.entity;

import com.demo.db.audit.Audit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Audited
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name="customers")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotAudited
    private Audit audit = new Audit();
}
